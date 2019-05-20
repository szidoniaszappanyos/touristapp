import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Location} from "../model/Location";

@Injectable({
  providedIn: 'root'
})
export class GetLocationOfAttractionService {

  constructor(private http: HttpClient,
              private apiService: ApiService) {
  }

  getLocationOfAttraction(id: number): Observable<Location> {
    return this.apiService.getRequest('api/attractions/location/' + id);
  }
}
