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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			System.out.println("  ----:" +  product.getCategory_name());
		}
		System.out.println("----productService-----2");
		Stream<Path> fileTree = storageService.loadAll();
		//fileTree.forEach(System.out::println);
		System.out.println("----productService---,--2.5");
		Iterator itr = fileTree.iterator();
		//List <String> li = (List) fileTree.toArray();
		//for( int i=0; i< li.size(); i++) {
		//		System.out.println("__"+i+li.get(i));
		//}
		System.out.println("----productService---,,--2.6");
		while(itr.hasNext()) {
			String fname = (String) itr.next();
			//Path path = storageService.load(fname);
			//System.out.println(itr.next() + ", " + path.toString());
			//System.out.println(itr.next());
			System.out.println(fname);
		}
		System.out.println("----productService----,+3");
		
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		System.out.println("-----=:" );
		//model.addAttribute("vfile", "/videos/411.mp4");//ssj - test - only
		
		//return "thymeleaf/upload/uploadForm";//ssj
		return "upload/uploadForm";//ssj
	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		System.out.println("==========serveFile:" + filename);
		Resource file = storageService.loadAsResource(filename);
		System.out.println("==========Resource file:" + file.toString());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/upload/fileUpload")//ssj
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		System.out.println("==========file.getName:"+file.getName());
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/upload/list";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
