import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {GetTourService} from "../service/get-tour.service";
import {TourAttraction} from "../model/TourAttraction";
import {GetLocationOfAttractionService} from "../service/get-location-of-attraction.service";
import {Observable} from "rxjs";
import {Location} from "../model/Location";
import {AttractionFromTour} from "../model/attraction-from-tour";


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
  attractionGet1: any;
  attraction1: TourAttraction = null;
  private locationGet1: Observable<Location>;
  private lng1: number;
  private lat1: number;
  private name1: string;
  private address1: string;
  attractionGet2: any;
  attraction2: TourAttraction = null;
  private locationGet2: Observable<Location>;
  private lng2: number;
  private lat2: number;
  private name2: string;
  private address2: string;
  attractionGet3: any;
  attraction3: TourAttraction = null;
  private locationGet3: Observable<Location>;
  private lng3: number;
  private lat3: number;
  private name3: string;
  private address3: string;
  attractionGet4: any;
  attraction4: TourAttraction = null;
  private locationGet4: Observable<Location>;
  private lng4: number;
  private lat4: number;
  private name4: string;
  private address4: string;
  attractionGet5: any;
  attraction5: TourAttraction = null;
  private locationGet5: Observable<Location>;
  private lng5: number;
  private lat5: number;
  private name5: string;
  private address5: string;
  attractions: any[]=[];

  constructor(private route: ActivatedRoute, private getTourService: GetTourService,
              private locationService: GetLocationOfAttractionService) {
    this.sub = this.route.params.subscribe(params => {
      this.id1 = +params['id1'];
      this.id2 = +params['id2'];
      this.id3 = +params['id3'];
      this.id4 = +params['id4'];
      this.id5 = +params['id5'];
    });
    this.attractionGet1 = this.getTourService.getAttraction(this.id1);
    this.attractionGet1.forEach(attraction => this.attraction1 = attraction).then((r) => {
      this.locationGet1 = this.locationService.getLocationOfAttraction(this.id1);
      this.locationGet1.forEach(location => {
        this.lng1 = location.longitude;
        this.lat1 = location.latitude;
        this.name1 = location.name;
        this.address1 = location.address;
      }).then((result) => this.attractions.push(new AttractionFromTour(this.attraction1.name, this.attraction1.details, this.name1, this.address1, this.attraction1.latitude, this.attraction1.longitude)));
    });

    this.attractionGet2 = this.getTourService.getAttraction(this.id2);
    this.attractionGet2.forEach(attraction => this.attraction2 = attraction).then((r) => {
      this.locationGet2 = this.locationService.getLocationOfAttraction(this.id2);
      this.locationGet2.forEach(location => {
        this.lng2 = location.longitude;
        this.lat2 = location.latitude;
        this.name2 = location.name;
        this.address2 = location.address;
      }).then((result) => this.attractions.push(new AttractionFromTour(this.attraction2.name, this.attraction2.details, this.name2, this.address2, this.attraction2.latitude, this.attraction2.longitude)));
    });

    this.attractionGet3 = this.getTourService.getAttraction(this.id3);
    this.attractionGet3.forEach(attraction => this.attraction3 = attraction).then((r) => {
      this.locationGet3 = this.locationService.getLocationOfAttraction(this.id3);
      this.locationGet3.forEach(location => {
        this.lng3 = location.longitude;
        this.lat3 = location.latitude;
        this.name3 = location.name;
        this.address3 = location.address;
      }).then((result) => this.attractions.push(new AttractionFromTour(this.attraction3.name, this.attraction3.details, this.name3, this.address3, this.attraction3.latitude, this.attraction3.longitude)));
    });

    this.attractionGet4 = this.getTourService.getAttraction(this.id4);
    this.attractionGet4.forEach(attraction => this.attraction4 = attraction).then((r) => {
      this.locationGet4 = this.locationService.getLocationOfAttraction(this.id4);
      this.locationGet4.forEach(location => {
        this.lng4 = location.longitude;
        this.lat4 = location.latitude;
        this.name4 = location.name;
        this.address4 = location.address;
      }).then((result) => this.attractions.push(new AttractionFromTour(this.attraction4.name, this.attraction4.details, this.name4, this.address4, this.attraction4.latitude, this.attraction4.longitude)));
    });

    this.attractionGet5 = this.getTourService.getAttraction(this.id5);
    this.attractionGet5.forEach(attraction => this.attraction5 = attraction).then((r) => {
      this.locationGet5 = this.locationService.getLocationOfAttraction(this.id5);
      this.locationGet5.forEach(location => {
        this.lng5 = location.longitude;
        this.lat5 = location.latitude;
        this.name5 = location.name;
        this.address5 = location.address;
      }).then((result) => this.attractions.push(new AttractionFromTour(this.attraction5.name, this.attraction5.details, this.name5, this.address5, this.attraction5.latitude, this.attraction5.longitude)));
    });
  }

  ngOnInit() {
  }

}
