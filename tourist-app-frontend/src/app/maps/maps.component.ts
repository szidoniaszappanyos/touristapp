import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {GooglePlaceDirective} from "ngx-google-places-autocomplete/ngx-google-places-autocomplete.directive";
import {MapsAPILoader} from "@agm/core";
import {Address} from "ngx-google-places-autocomplete/objects/address";


@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.scss']
})

export class MapsComponent implements OnInit {

  @ViewChild("placesRef") placesRef: GooglePlaceDirective;

  constructor(private mapsAPILoader: MapsAPILoader, private ngZone: NgZone) {
  }

  origin: any;
  destination: any;
  destination2: any;

  ngOnInit() {
    this.getDirection()
  }

  lat: number = 46.7712;
  lng: number = 23.6236;

  getDirection() {
    this.origin = {lat: 46.7712, lng: 23.6236};
    this.destination = {lat: 46.1573, lng: 24.3472};
    this.destination2 = {lat: 46.9573, lng: 22.3472};
  }

  public handleAddressChange(address: Address) {
    console.log(address.geometry.location.lng());
    console.log(address.geometry.location.lat());
    console.log(address.geometry.location.toJSON());
    console.log(address.geometry.viewport.getNorthEast());
    this.lng = address.geometry.location.lng();
    this.lat  = address.geometry.location.lat();
  }

}
