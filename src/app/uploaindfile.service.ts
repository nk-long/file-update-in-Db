import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploaindfileService {

  bseurl="http://localhost:8080/";

  constructor(private http:HttpClient) { }

  upload(data:any):Observable<any>
  {
    return this.http.post(`${this.bseurl+'upload'}`,data);
  }

  getImgFromDb(id:any):Observable<any>{
    return this.http.get(`${this.bseurl+'getimg'}${id}`);
  }

}
