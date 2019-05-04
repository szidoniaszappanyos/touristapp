export class Attraction {
  id:number;
  name:String;
  details:String;
  pictureFileName:String;

  constructor(id: number, name: String, details: String, pictureFileName: String) {
    this.id = id;
    this.name = name;
    this.details = details;
    this.pictureFileName = pictureFileName;
  }
}
