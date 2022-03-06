package edu.kosmo.kbat.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.kosmo.kbat.service.ProductService;
import edu.kosmo.kbat.service.StorageFileNotFoundException;
import edu.kosmo.kbat.service.StorageService;
import edu.kosmo.kbat.vo.ProductVO;

@Controller
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	private	ProductService productService;//ssj
	
	
	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/upload/list")//ssj
	public String listUploadedFiles(Model model) throws IOException {
		
		System.out.println("==========listUploadedFiles");
		
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "thymeleaf/upload/uploadForm";//ssj
		//return "upload/uploadForm";//ssj
	}

	@GetMapping("/upload/list2")//ssj
	public String listUploadedFiles2(Model model) throws IOException {

		
		System.out.println("==========listUploadedFiles");
		System.out.println("----productService:");
		
		List <ProductVO> productVO = productService.getList();
		for (ProductVO product : productVO) {
			System.out.println("  ----category:" +  product.getCategory_name() + ", vidoe:" + product.getVideo_name());
		}
		System.out.println("----productService-----2");
		Stream<Path> fileTree = storageService.loadAll();
		System.out.println("----productService---,--2.5");
		Iterator itr = fileTree.iterator();
		System.out.println("----productService---,,--2.6");
		while(itr.hasNext()) {
			//String fname = (String) itr.next();
			String fname = itr.next().toString();
			System.out.println(fname);
			
			String uri = MvcUriComponentsBuilder.fromMethodName(
					FileUploadController.class,
					"serveFile", 
					fname)
			.build()
			.toUri()
			.toString();
			System.out.println(uri);
			
		}
		System.out.println("----productService----,+3");
	
		storageService.loadAll().map(
									path -> MvcUriComponentsBuilder.fromMethodName(
											FileUploadController.class,
											"serveFile", 
											path.getFileName().toString())
									.build()
									.toUri()
									.toString()
									)
				.collect(Collectors.toList());
				
		System.out.println("----productService----,+3.1");
		
/*		
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));
*/		
		model.addAttribute("products", productVO);
		
		
		//return "thymeleaf/upload/uploadForm";//ssj
		return "upload/uploadForm";//ssj
	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		//System.out.println("==========serveFile:" + filename);
		Resource file = storageService.loadAsResource(filename);
		//System.out.println("==========Resource file:" + file.toString());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/upload/fileUpload")//ssj
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes,
			@ModelAttribute ProductVO productVO) {
		
		System.out.println("-------2-----------getCategory_name    		:" + productVO.getCategory_name());
		System.out.println("-------2-----------getProduct_name     		:" + productVO.getProduct_name());
		System.out.println("-------2-----------getProduct_price    		:" + productVO.getProduct_price());
		System.out.println("-------2-----------getProduct_enable   		:" + productVO.getProduct_enable());
		System.out.println("-------2-----------getProduct_stock  		:" + productVO.getProduct_stock());
		System.out.println("-------2-----------getProduct_description   :" + productVO.getProduct_description());
		System.out.println("-------2-----------getVideo_name  			:" + productVO.getVideo_name());
		
		storageService.store(file);
		
		System.out.println("==========file.getName:" + file.getOriginalFilename());

		//ssj 0305 convert file to uri
		String uri = MvcUriComponentsBuilder.fromMethodName(
				FileUploadController.class,
				"serveFile", 
				file.getOriginalFilename())
		.build()
		.toUri()
		.toString();
		System.out.println(uri);
		
		productVO.setProduct_name(file.getOriginalFilename());
		productVO.setProduct_enable("1");
		productVO.setProduct_stock(1);
		productVO.setVideo_name(uri);
		productVO.setImage_name("noimage.jpg");
		
		System.out.println("-------3.1-----------");
		productService.write(productVO);
		System.out.println("-------3.2-----------");
		
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/upload/list2";
	}

	@GetMapping("/upload/delete")//ssj
	public String delete(@ModelAttribute ProductVO productVO) throws IOException {
		System.out.println("-------del4.1-----------");
		productService.delete(productVO.getProduct_id());
		System.out.println("-------del4.2-----------");
		return "redirect:/upload/list2";
	}
	
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
