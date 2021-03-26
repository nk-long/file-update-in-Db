import { formatDate } from '@angular/common';
import { Component } from '@angular/core';
import { UploaindfileService } from './uploaindfile.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dataupload';
  imageId:number;
  file:File;
  uploadData= new FormData();

  responsedata:any;
  imageData:any;
  imagereceived:any;


  constructor(private uploadservice:UploaindfileService){

  }
//hello
  getFileData(event)
  {
    console.log(event.target.files[0]);
    this.file=event.target.files[0];
    this.uploadData.append("file",this.file);
    console.log(this.uploadData);
  }


  uploadFile(){

    this.uploadservice.upload(this.uploadData).subscribe(
      (res)=>{
          console.log(res);
          
      },error =>console.log(error)
    )    

  }

  getimage()
  {
    this.uploadservice.getImgFromDb(this.imageId).subscribe(
      (data)=>{
        this.responsedata=data;
        this.imageData=this.responsedata.imgdata;
        this.imagereceived="data:image/jpeg;base64,"+this.imageData;

      }
    )

  }



}
