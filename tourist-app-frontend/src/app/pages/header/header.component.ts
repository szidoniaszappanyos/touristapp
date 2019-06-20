import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
  }

  logout(): void {
    this.tokenStorageService.signOut();
  }

  isAuthenticated() {
    if (this.tokenStorageService.getAuthorities().length === 0) {
      return false;
    }
    return true;
  }
}
