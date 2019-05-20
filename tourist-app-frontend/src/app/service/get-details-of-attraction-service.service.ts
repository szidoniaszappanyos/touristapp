import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Details} from "../model/Details";

@Injectable({
  providedIn: 'root'
})
export class GetDetailsOfAttractionServiceService {

  constructor(private http: HttpClient,
              private apiService: ApiService) {
  }

  getDetailsOfAttraction(id: number): Observable<Details> {
    return this.apiService.getRequest('api/attractions/details/' + id);
  }
}
