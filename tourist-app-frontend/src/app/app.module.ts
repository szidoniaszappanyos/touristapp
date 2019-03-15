import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {MaterialModule} from "./material.module";
import { PreferencesComponent } from './preferences/preferences.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SightsToSeeComponent} from "./sights-to-see/sights-to-see.component";
import { MapsComponent } from './maps/maps.component';
import { AgmCoreModule } from '@agm/core';
import {CommonModule} from "@angular/common";
import {AgmDirectionModule} from "agm-direction";
import {GooglePlaceModule} from "ngx-google-places-autocomplete";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PreferencesComponent,
    SightsToSeeComponent,
    MapsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBJtyozSdp3v_CzYFz28I26Ay7mwii8dBU',
      libraries: ["places"]
    }),
    AgmDirectionModule,
    GooglePlaceModule,
    AgmCoreModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
