import { Component, OnInit } from '@angular/core';
import {MAT_TOOLTIP_DEFAULT_OPTIONS, MatTooltipDefaultOptions} from '@angular/material';
import {GetAllAttractionsService} from "../service/get-all-attractions.service";
import {Attraction} from "../model/Attraction";
import {Observable} from "rxjs";


export const myCustomTooltipDefaults: MatTooltipDefaultOptions = {
  showDelay: 1000,
  hideDelay: 10,
  touchendHideDelay: 1000,
};


@Component({
  selector: 'app-sights-to-see',
  templateUrl: './sights-to-see.component.html',
  styleUrls: ['./sights-to-see.component.scss'],
  providers: [
    {provide: MAT_TOOLTIP_DEFAULT_OPTIONS, useValue: myCustomTooltipDefaults}
  ],
})
export class SightsToSeeComponent implements OnInit {
  private attractionsGet: Observable<Attraction[]>;
  private attractions: Attraction[];


  constructor(private attractionService: GetAllAttractionsService) { }

  ngOnInit() {
    this.attractionsGet = this.attractionService.getAttractions();
    this.attractions = [];
    this.attractionsGet.forEach(attr => attr.forEach(r => this.attractions.push(r)));
  }

}
