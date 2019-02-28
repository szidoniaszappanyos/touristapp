import { Component, OnInit } from '@angular/core';
import {MAT_TOOLTIP_DEFAULT_OPTIONS, MatTooltipDefaultOptions} from '@angular/material';


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

  constructor() { }

  ngOnInit() {
  }

}
