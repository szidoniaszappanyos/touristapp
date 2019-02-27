import { Component } from '@angular/core';
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material';

export interface Interest {
  name: string;
}

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.scss']
})
export class PreferencesComponent  {
  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  interests: Interest[] = [
    {name: 'Galleries'},
    {name: 'Museums'},
    {name: 'Parks'},
    {name: 'Churches'},
    {name: 'Old Buildings'},
    {name: 'Statues, Monuments'},
    {name: 'Shopping Centers'},
  ];



  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our fruit
    if ((value || '').trim()) {
      this.interests.push({name: value.trim()});
    }


    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove(interest: Interest): void {
    const index = this.interests.indexOf(interest);

    if (index >= 0) {
      this.interests.splice(index, 1);
    }
  }
}
