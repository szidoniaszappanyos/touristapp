import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Picture} from "../model/Picture";

@Injectable({
  providedIn: 'root'
})
export class GetGalleryOfAttractionServiceService {

  constructor(private http: HttpClient,
              private apiService: ApiService) {
  }

  getGalleryOfAttraction(id: number): Observable<Picture[]> {
    return this.apiService.getRequest('api/attractions/gallery/' + id);
  }
}
