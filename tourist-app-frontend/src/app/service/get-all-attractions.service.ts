import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Attraction} from "../model/Attraction";

@Injectable({
  providedIn: 'root'
})
export class GetAllAttractionsService {

  constructor(private http: HttpClient,
              private apiService: ApiService) { }

  getAttractions(): Observable<Attraction[]> {
    return this.apiService.getRequest('api/attractions/all');
  }

}
