package com.example.product.entity;

//ImageInfo.java
public class ImageInfo {

 private String name;
 private double price;
 private String type;
 private String imagePath;

 public ImageInfo() {
     // Default constructor
 }

 public ImageInfo(String name, double price, String type, String imagePath) {
     this.name = name;
     this.price = price;
     this.type = type;
     this.imagePath = imagePath;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public double getPrice() {
     return price;
 }

 public void setPrice(double price) {
     this.price = price;
 }

 public String getType() {
     return type;
 }

 public void setType(String type) {
     this.type = type;
 }

 public String getImagePath() {
     return imagePath;
 }

 public void setImagePath(String imagePath) {
     this.imagePath = imagePath;
 }
}

