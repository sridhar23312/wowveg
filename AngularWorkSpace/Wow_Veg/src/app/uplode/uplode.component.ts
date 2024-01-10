import { OnInit } from '@angular/core';
import { Component} from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ImageService } from '../image.service';

@Component({
  
  selector: 'app-uplode',
  templateUrl: './uplode.component.html',
  styleUrls: ['./uplode.component.css'],

})
export class UplodeComponent{

  imageUrl: string | undefined;
  constructor(private imageService: ImageService) { }

  getImage(): void {
    const id = 10; // Replace with the actual image ID
    this.imageService.getImageById(id).subscribe((data: Blob) => {
      const url = window.URL.createObjectURL(data);
      this.imageUrl = url;
    });
  }


  // imageid:number;
  // imageUrl: string;
  // constructor(    private route: ActivatedRoute, private imageservice: ImageService  ) { }


  // ngOnInit(): void {
    // this.route.paramMap.subscribe(params => {
      // this.imageId =8;
      // this.loadImage();});  }
      // loadImage() {
      //   this.imageservice.getImageById(this.imageId).subscribe(
      //     (data: any) => {
      //       // Assuming your backend returns a data URL for the image
      //       this.imageUrl = 'data:image/jpeg;base64,' + data; // Adjust the MIME type accordingly
      //     },
      //     (error:any) => {
      //       console.error('Error loading image:', error);
      //       // Handle the error appropriately, e.g., show a placeholder image
      //     }
      //   );
      // }
  

}
