export class Details {
  name:string;
  details:String;
  attractionType:string;
  schedule:String[];

  constructor(name: string, details: String, attractionType: string, schedule: String[]) {
    this.name = name;
    this.details = details;
    this.attractionType = attractionType;
    this.schedule = schedule;
  }
}
