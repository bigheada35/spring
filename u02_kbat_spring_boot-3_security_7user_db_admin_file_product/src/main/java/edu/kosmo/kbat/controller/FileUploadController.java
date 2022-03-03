package edu.kosmo.kbat.controller;

import java.io.IOException;
import java.util.stream.Collectors;

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
		
		
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		
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
		System.out.println("==========handleFileUpload");
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
