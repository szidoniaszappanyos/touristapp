export class Attraction {
  id:number;
  name:string;
  details:string;
  pictureFileName:string;

  constructor(id: number, name: string, details: string, pictureFileName: string) {
    this.id = id;
    this.name = name;
    this.details = details;
    this.pictureFileName = pictureFileName;
  }
}
