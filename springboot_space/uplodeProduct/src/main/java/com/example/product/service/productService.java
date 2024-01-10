package com.example.product.service;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.example.product.entity.Product;
import com.example.product.repository.productRepo;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class productService {
@Autowired
productRepo productrepo;
	public Product uplodeproduct(MultipartFile imageFile,int price,String type,String name) {
		String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        String filePath = "./src/main/resources/uplodeimages/" + fileName; // Configure your desired file path
        String[] names=fileName.split("\\.");;
        try {
            // Using NIO for efficient file handling
            Path destinationFilePath = Paths.get(filePath);
            Files.copy(imageFile.getInputStream(), destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

            Product product = new Product();
            product.setName(name);
            product.setPath(filePath);
            product.setPrice(price);
            product.setType(type);
            // Store the image URL
            // ... set other fields

            return productrepo.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Error saving image", e);
        }
        
        
		
		
	}
	
	private String uploadsPath = "./src/main/resources/uplodeimages/";
    //get image method
    public Resource getImageResource(String imageName) {
        // Implement logic to load image resource from the specified folder
        // You can use ResourceLoader or FileSystemResource
        // Example using FileSystemResource:
        Path imagePath = Paths.get(uploadsPath).resolve(imageName);
        try {
            Resource resource = new FileSystemResource(imagePath);
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Image not found: " + imageName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading image: " + imageName, e);
        }
    }
	public String getImage(Long id) {
		
		return productrepo.getImage(id);
	}
	public Resource getImagebyid(Long id) {
		 String imagePath =this.getImage(id);
	        try {
	            Resource resource = new FileSystemResource(imagePath);
	            if (resource.exists() && resource.isReadable()) {
	                return resource;
	            } else {
	                throw new FileNotFoundException("Image not found: " + id);
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Error loading image: " + id, e);
	        }
		
	}


}
