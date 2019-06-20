import {Component, NgZone, OnInit, ViewChild} from '@angular/core';
import {Address} from "ngx-google-places-autocomplete/objects/address";
import {GooglePlaceDirective} from "ngx-google-places-autocomplete";
import {MapsAPILoader} from "@agm/core";

@Component({
  selector: 'app-about-cluj',
  templateUrl: './about-cluj.component.html',
  styleUrls: ['./about-cluj.component.scss']
})
export class AboutClujComponent implements OnInit {
  origin: any;
  destination: any;
  destination2: any;
  lat:number = 46.770920;
  lng:number = 23.589920;

  @ViewChild("placesRef") placesRef: GooglePlaceDirective;

  constructor(private mapsAPILoader: MapsAPILoader, private ngZone: NgZone) {
  }

  ngOnInit() {
  }

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
