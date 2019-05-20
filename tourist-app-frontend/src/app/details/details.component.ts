import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {GetGalleryOfAttractionServiceService} from "../service/get-gallery-of-attraction-service.service";
import {Picture} from "../model/Picture";
import {Observable} from "rxjs";
import {NgbCarouselConfig} from "@ng-bootstrap/ng-bootstrap";
import {GetLocationOfAttractionService} from "../service/get-location-of-attraction.service";
import {Location} from "../model/Location";
import {GetDetailsOfAttractionServiceService} from "../service/get-details-of-attraction-service.service";
import {Details} from "../model/Details";
import {Geolocations} from "../model/geolocations";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
  providers: [NgbCarouselConfig]
})
export class DetailsComponent implements OnInit {

  id: number;
  private sub: any;
  private galleryGet: Observable<Picture[]>;
  private gallery: Picture[];
  private locationGet: Observable<Location>;
  private detailsGet: Observable<Details>;
  private lat: number;
  private lng: number;
  private name: String;
  private address: String;
  nameOfAttraction:string;
  details:String;
  attractionType:string;
  schedule:String[] = [];

  constructor(private route: ActivatedRoute, private galleryService: GetGalleryOfAttractionServiceService,
              private locationService: GetLocationOfAttractionService, private detailService: GetDetailsOfAttractionServiceService) {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number

      // In a real app: dispatch action to load the details here.
    });

    this.galleryGet = this.galleryService.getGalleryOfAttraction(this.id);
    this.gallery = [];
    this.galleryGet.forEach(picture => picture.forEach(r => this.gallery.push(r)));
    this.locationGet = this.locationService.getLocationOfAttraction(this.id);
    this.locationGet.forEach(location => {
      this.lng = location.longitude;
      this.lat = location.latitude; this.name = location.name; this.address = location.address;
    });
    this.detailsGet = this.detailService.getDetailsOfAttraction(this.id);
    this.detailsGet.forEach(details => {
      this.nameOfAttraction = details.name;
      this.details = details.details; this.attractionType = details.attractionType; this.schedule = details.schedule;
    });
  }

  ngOnInit() {
  }

  isEmpty(): boolean {
    if (this.gallery.length != 0) {
      return false;
    } else {
      return true;
    }
  }

  dailySchedule(i:number): String{
    if(this.schedule.length!=0){
      return this.schedule[i];
    }else{
      return "-" ;
    }
  }

}
