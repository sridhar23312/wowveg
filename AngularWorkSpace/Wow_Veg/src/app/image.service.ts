
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs'; // Import Observable from 'rxjs' module



@Injectable({
  providedIn: 'root'
})
export class ImageService {
  
  constructor(private http:HttpClient) { }


  apiUrl="http://localhost:8080/product";

  uploadProduct(imageFile: File, price: number|undefined, type: string|undefined, name: string|undefined) {
    const formData: FormData = new FormData();
    formData.append('image', imageFile);
  if(price && type && name){
    formData.append('price', price.toString());
    formData.append('type', type);
    formData.append('name', name);
  }

    return this.http.post(`${this.apiUrl}/uplodedata`, formData);
  }
  private baseUrl = 'http://your-spring-boot-api-url';



  getImageById(id: number): Observable<Blob> {
    return this.http.get(`${this.apiUrl}/getbyid/${id}`, { responseType: 'blob' });
  }

  // getImageById(imageId: number): Observable<any> {
  //   const url = `${this.apiUrl}/getbyid/${imageId}`;
  // console.log( this.http.get(url));
  // return this.http.get(url);
  // }

}
  
