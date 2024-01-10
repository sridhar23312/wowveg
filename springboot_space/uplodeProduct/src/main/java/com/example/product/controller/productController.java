package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.product.entity.Product;
import com.example.product.service.productService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class productController {
	@Autowired
	productService productser;
	@PostMapping("/uplodedata")
	public Product uplodeproduct(@RequestParam("image") MultipartFile imageFile,@RequestParam("price") int price,@RequestParam("type")String type,@RequestParam("name")String name)
	{
		return productser.uplodeproduct(imageFile,price,type,name);
	}
	@GetMapping("/serve/{imageName}")
    public ResponseEntity<Resource> serveImage(@PathVariable String imageName) {
        Resource resource = productser.getImageResource(imageName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }  
	@GetMapping("/getid/{id}")
	public String getImage(Long id)
	{
		return productser.getImage(id) ;
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Resource> getimage(@PathVariable Long id){
		Resource resource=productser.getImagebyid(id);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
		 
	}

}
