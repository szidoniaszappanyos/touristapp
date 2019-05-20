export class AttractionFromTour {
  name: string;
  details: string;
  nameAddress: string;
  numberAddress: string;
  lat: number;
  lng:number;

  constructor(name: string, details: string, nameAddress: string, numberAddress: string, lat: number, lng: number) {
    this.name = name;
    this.details = details;
    this.nameAddress = nameAddress;
    this.numberAddress = numberAddress;
    this.lat = lat;
    this.lng = lng;
  }
}
