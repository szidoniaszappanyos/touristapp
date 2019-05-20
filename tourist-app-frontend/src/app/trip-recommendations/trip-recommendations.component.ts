import {Component, NgZone, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {TourAttraction} from "../model/TourAttraction";
import {GetTourService} from "../service/get-tour.service";
import {Geolocations} from "../model/geolocations";
import {Geoloc} from "../model/geoloc";
import {MapsAPILoader} from "@agm/core";

@Component({
  selector: 'app-trip-recommendations',
  templateUrl: './trip-recommendations.component.html',
  styleUrls: ['./trip-recommendations.component.scss']
})
export class TripRecommendationsComponent implements OnInit {

  private tourGet: Observable<TourAttraction[]>;
  private tour: TourAttraction[];
  private names: String[] = [];
  private ids1: number[] = [];

  private tourGet2: Observable<TourAttraction[]>;
  private tour2: TourAttraction[];
  private names2: String[] = [];
  private ids2: number[] = [];

  private tourGet3: Observable<TourAttraction[]>;
  private tour3: TourAttraction[];
  private names3: String[] = [];
  private ids3: number[] = [];

  geolocs1: Geoloc[] = [];
  geolocs2: Geoloc[] = [];
  geolocs3: Geoloc[] = [];
  public markerOptions = {
    origin: {
      icon: 'https://i.imgur.com/7teZKif.png'
    },
    destination: {
      icon: 'https://i.imgur.com/7teZKif.png'
    },
  }
  public renderOptions = {
    suppressMarkers: true,
  }

  constructor(private tourService: GetTourService, private mapsAPILoader: MapsAPILoader, private ngZone: NgZone) {
    this.tourGet = this.tourService.getTour();
    this.tour = [];
    this.tourGet.forEach(t => t.forEach(r => this.tour.push(r)));
    this.tourGet.forEach(t => t.forEach(r => this.geolocs1.push(new Geoloc(r.latitude, r.longitude))));
    this.tourGet.forEach(t => t.forEach(r => this.ids1.push(r.id)));
    this.tourGet2 = this.tourService.getTour();
    this.tour2 = [];
    this.tourGet2.forEach(t => t.forEach(r => this.tour2.push(r)));
    this.tourGet2.forEach(t => t.forEach(r => this.geolocs2.push(new Geoloc(r.latitude, r.longitude))));
    this.tourGet2.forEach(t => t.forEach(r => this.ids2.push(r.id)));
    this.tourGet3 = this.tourService.getTour();
    this.tour3 = [];
    this.tourGet3.forEach(t => t.forEach(r => this.tour3.push(r)));
    this.tourGet3.forEach(t => t.forEach(r => this.geolocs3.push(new Geoloc(r.latitude, r.longitude))));
    this.tourGet3.forEach(t => t.forEach(r => this.ids3.push(r.id)));
  }

  ngOnInit() {

  }

  getNames(): String[] {
    this.names = []
    for (let i = 0; i < this.tour.length; i++) {
      this.names.push(this.tour[i].name);
    }
    return this.names;
  }

  getNames2(): String[] {
    this.names2 = [];
    for (let i = 0; i < this.tour2.length; i++) {
      this.names2.push(this.tour2[i].name);
    }
    return this.names2;
  }


  getNames3(): String[] {
    this.names3 = [];
    for (let i = 0; i < this.tour3.length; i++) {
      this.names3.push(this.tour3[i].name);
    }
    return this.names3;
  }

}
