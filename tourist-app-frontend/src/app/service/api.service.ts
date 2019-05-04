import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {share} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  apiEndpoint: string;

  constructor(private http: HttpClient) {
    this.apiEndpoint = environment.apiEndpoint;
  }

  checkResponse($response: Observable<any>, showSuccess = null) {
    $response.subscribe((resp) => {
      if (showSuccess) {
        console.log(resp);
      }
    }, (err) => {
      console.error(err);
      const {error: respError} = err;
    });
  }

  getRequest(path: string, params?, options?): Observable<any> {
    const $response = this.http.get(`${this.apiEndpoint}/${path}`, params)
      .pipe(share());
    this.checkResponse($response);
    return $response;
  }

  postRequest(path: string, params, options?): Observable<any> {
    const $response = this.http.post(`${this.apiEndpoint}/${path}`, params)
      .pipe(share());
    this.checkResponse($response);
    return $response;
  }

  putRequest(path: string, params, options?): Observable<any> {
    const $response = this.http.put(`${this.apiEndpoint}/${path}`, params)
      .pipe(share());
    this.checkResponse($response);
    return $response;
  }

  deleteRequest(path: string, params?, options?): Observable<any> {
    const $response = this.http.delete(`${this.apiEndpoint}/${path}`, params)
      .pipe(share());
    this.checkResponse($response);
    return $response;
  }


}
