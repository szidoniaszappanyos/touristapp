import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {Preferences} from "../model/Preferences";

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  constructor(private http: HttpClient,
              private apiService: ApiService) {
  }

  setInterests(preferences: Preferences): void {
    this.apiService.postRequest('api/preferences/interests', preferences);
  }
}
