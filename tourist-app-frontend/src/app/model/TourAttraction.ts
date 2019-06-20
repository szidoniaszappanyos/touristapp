export class TourAttraction {
  id: number;
  name: string;
  latitude: number;
  longitude: number;
  details:string;


  constructor(id: number, name:string, latitude: number, longitude: number, details: string) {
    this.id = id;
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
    this.details = details;
  }
}
