import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {GetTourService} from "../../service/get-tour.service";
import {TourAttraction} from "../../model/TourAttraction";
import {GetLocationOfAttractionService} from "../../service/get-location-of-attraction.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-details-tour',
  templateUrl: './details-tour.component.html',
  styleUrls: ['./details-tour.component.scss']
})
export class DetailsTourComponent implements OnInit {
  id1: number;
  id2: number;
  id3: number;
  id4: number;
  id5: number;
  private sub: any;
  attractions: TourAttraction[] = [];
  private attractionsGet: Observable<TourAttraction[]>;

  constructor(private route: ActivatedRoute, private getTourService: GetTourService,
              private locationService: GetLocationOfAttractionService) {
    this.sub = this.route.params.subscribe(params => {
      this.id1 = +params['id1'];
      this.id2 = +params['id2'];
      this.id3 = +params['id3'];
      this.id4 = +params['id4'];
      this.id5 = +params['id5'];
    });
    this.attractionsGet = this.getTourService.getAttraction(this.id1, this.id2, this.id3, this.id4, this.id5);
    this.attractions = [];
    this.attractionsGet.forEach(attr => attr.forEach(r => this.attractions.push(r)));
  }

  ngOnInit() {
  }

}
