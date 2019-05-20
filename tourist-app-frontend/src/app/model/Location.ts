export class Location {
  id: number;
  name: string;
  address: string;
  latitude: number;
  longitude: number;

  constructor(id: number, name: string, address: string, latitude: number, longitude: number) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
  }


}
