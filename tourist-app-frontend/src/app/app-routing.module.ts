import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from "./pages/register/register.component";
import {LoginComponent} from "./pages/login/login.component";
import {SightsToSeeComponent} from "./pages/sights-to-see/sights-to-see.component";
import {DetailsComponent} from "./pages/details/details.component";
import {AboutClujComponent} from "./pages/about-cluj/about-cluj.component";
import {TripRecommendationsComponent} from "./pages/trip-recommendations/trip-recommendations.component";
import {DetailsTourComponent} from "./pages/details-tour/details-tour.component";

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},
  { path: 'sights', component: SightsToSeeComponent},
  { path: 'details/:id', component: DetailsComponent},
  { path: 'about', component: AboutClujComponent},
  { path: 'trips', component: TripRecommendationsComponent},
  { path: 'details-tour/:id1/:id2/:id3/:id4/:id5', component: DetailsTourComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
