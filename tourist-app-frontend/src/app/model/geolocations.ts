import {Geoloc} from "./geoloc";

export class Geolocations {
  private _geolocations: Geoloc[];

  constructor(geolocations: Geoloc[]) {
    this._geolocations = geolocations;
  }


  get geolocations(): Geoloc[] {
    return this._geolocations;
  }
}
