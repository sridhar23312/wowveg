import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ImageService } from './image.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'wowveg';
  constructor(private router:Router,private imageService:ImageService){}
  
  selectedFile: File | null = null;
  uplodeform = new FormGroup({
    name: new FormControl('',Validators.required),
    image:new FormControl('',Validators.required),
    price:new FormControl('',Validators.required),
    type:new FormControl('',Validators.required)
  });
  display='none';
  displayoffcan='block';

  openmodel(){
   this.display='block';
   this.displayoffcan='none';
  }
  onCloseHandled(){
    this.display='none';
    this.displayoffcan='block';
  }
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  uploadProduct() {
    const { price, type, name } = this.uplodeform?.value;
//  const price =this.uplodeform.controls['price'].value;
    if (this.selectedFile) {
      this.imageService.uploadProduct(this.selectedFile, Number(price), type?.toString(), name?.toString())
        .subscribe(
          response => {
            console.log('Upload successful', response);
          },
          error => {
            console.error('Error uploading product', error);
          }
        );
    } else {
      console.error('No file selected');
    }
  }


}
 
  // onFileSelected(event: any) {
  //   const file = event.target.files[0];
  //  this.imageService.uploadFile(file);
  // }
  // }
    // uploadImage(){
    //   const formData = new FormData();
    //   formData.append('name', this.uplodeform.get('name')?.value||''); // Handle potential null
    //   formData.append('image', this.uplodeform.get('image')?.value||''); // Handle potential null
    //   formData.append('price', this.uplodeform.get('price')?.value||'');
    //   formData.append('type', this.uplodeform.get('type')?.value||'');
  
    //   this.imageService.uploadImage(formData).subscribe((response: any) => {
    //     console.log('Image uploaded successfully', response);
    //     // Additional success handling or navigation logic
    //   },
    //   (error: any) => {
    //     console.error('Error uploading image: ', error);
    //     // Handle error and provide user feedback
    //   });

      
    
  


