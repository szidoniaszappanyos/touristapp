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
  getPersonalTour(username: string, i: number): Observable<TourAttraction[]> {
    return this.apiService.getRequest('api/tour/' + username + '/personal/' + i );
  }

  clearPersonalTour(username: string): Observable<void> {
    return this.apiService.getRequest('api/tour/' + username + '/clear/');
  }

  getAttraction(id1: number, id2: number, id3: number, id4: number, id5: number): Observable<TourAttraction[]> {
    return this.apiService.getRequest("api/attractions/tour/details/"+id1+"/"+id2+"/"+id3+"/"+id4+"/"+id5);
  }
}
