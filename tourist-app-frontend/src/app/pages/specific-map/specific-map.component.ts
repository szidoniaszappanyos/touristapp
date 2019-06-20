import {Component, Input, NgZone, OnInit, ViewChild} from '@angular/core';
import {MapsAPILoader} from "@agm/core";
import {GooglePlaceDirective} from "ngx-google-places-autocomplete";

@Component({
  selector: 'app-specific-map',
  templateUrl: './specific-map.component.html',
  styleUrls: ['./specific-map.component.scss']
})
export class SpecificMapComponent implements OnInit {

  @ViewChild("placesRef") placesRef: GooglePlaceDirective;

  constructor(private mapsAPILoader: MapsAPILoader, private ngZone: NgZone) { }
  @Input()
  lat: number;
  @Input()
  lng: number;
  mapType = 'hybrid';
  ngOnInit() {
  }

}
