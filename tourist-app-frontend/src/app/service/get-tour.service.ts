import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {TourAttraction} from "../model/TourAttraction";

@Injectable({
  providedIn: 'root'
})
export class GetTourService {

  constructor(private http: HttpClient,
              private apiService: ApiService) {
  }

  getTour(): Observable<TourAttraction[]> {
    return this.apiService.getRequest('api/tour/random/');
  }

  getAttraction(id:number): Observable<TourAttraction>{
    return this.apiService.getRequest("api/attractions/tour/details/"+ id);
  }
}
