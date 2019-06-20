import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './pages/header/header.component';
import {FooterComponent} from './pages/footer/footer.component';
import {MaterialModule} from "./material.module";
import {PreferencesComponent} from './pages/preferences/preferences.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SightsToSeeComponent} from "./pages/sights-to-see/sights-to-see.component";
import {MapsComponent} from './pages/maps/maps.component';
import {AgmCoreModule, GoogleMapsAPIWrapper, PolylineManager} from '@agm/core';
import {CommonModule} from "@angular/common";
import {AgmDirectionModule} from "agm-direction";
import {GooglePlaceModule} from "ngx-google-places-autocomplete";
import {LoginComponent} from './pages/login/login.component';
import {ErrorStateMatcher, ShowOnDirtyErrorStateMatcher} from "@angular/material";
import {RegisterComponent} from './pages/register/register.component';
import {HttpClientModule} from '@angular/common/http';
import {httpInterceptorProviders} from "./auth/auth-interceptor";
import {DetailsComponent} from './pages/details/details.component';
import {SpecificMapComponent} from './pages/specific-map/specific-map.component';
import {AboutClujComponent} from './pages/about-cluj/about-cluj.component';
import {TripRecommendationsComponent} from './pages/trip-recommendations/trip-recommendations.component';
import { DetailsTourComponent } from './pages/details-tour/details-tour.component';


@NgModule(
  {
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PreferencesComponent,
    SightsToSeeComponent,
    MapsComponent,
    LoginComponent,
    RegisterComponent,
    DetailsComponent,
    SpecificMapComponent,
    AboutClujComponent,
    TripRecommendationsComponent,
    DetailsTourComponent,


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
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBJtyozSdp3v_CzYFz28I26Ay7mwii8dBU',
      libraries: ["places"]
    }),
    AgmDirectionModule,
    GooglePlaceModule,
    AgmCoreModule,


  ],
  providers: [
    PolylineManager,GoogleMapsAPIWrapper,
    {provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher}, httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
