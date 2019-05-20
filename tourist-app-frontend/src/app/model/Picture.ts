export class Picture {
  id:number;
  fileName:String;
  description:String;


  constructor(id: number, fileName: String, description: String) {
    this.id = id;
    this.fileName = fileName;
    this.description = description;
  }
}
