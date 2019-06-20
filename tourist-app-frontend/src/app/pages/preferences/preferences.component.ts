import { Component } from '@angular/core';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material';
import {PreferencesService} from "../../service/preferences.service";
import {Preferences} from "../../model/Preferences";

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.scss']
})
export class PreferencesComponent  {
  constructor( private prefService:PreferencesService){

  }
  ratings:number[]=[];
  value1 = 0;
  value2 = 0;
  value3 = 0;
  value4 = 0;
  value5 = 0;
  value6 = 0;
  value7 = 0;
  value8 = 0;
  value9 = 0;

  continue(): void{
    this.ratings.push(this.value1);
    this.ratings.push(this.value2);
    this.ratings.push(this.value3);
    this.ratings.push(this.value4);
    this.ratings.push(this.value5);
    this.ratings.push(this.value6);
    this.ratings.push(this.value7);
    this.ratings.push(this.value8);
    this.ratings.push(this.value9);
    this.prefService.setInterests(new Preferences(this.ratings));
    console.log(this.ratings)
  }
}
