import { Component, OnInit } from '@angular/core';
import {ErrorStateMatcher, MatSnackBar} from "@angular/material";
import {FormBuilder, FormControl, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {AuthService} from "../auth/auth.service";
import {TokenStorageService} from "../auth/token-storage.service";
import {AuthLoginInfo} from "../auth/login-info";


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

export const UserNameValidation = [
  Validators.required,
  Validators.pattern('^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$')
];

export const PasswordValidation = [
  Validators.required,
  Validators.minLength(6),
  Validators.maxLength(24),
];

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form: any;
  username: string;
  password: string;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: AuthLoginInfo;


  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group (
      {password: new FormControl('', PasswordValidation),
        username: new FormControl('', UserNameValidation)}
      )
    ;
  }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  getUsrname(event){
    console.log(event.target.value);
    this.username = event.target.value;
  }

  getPassword(event){
    this.password = event.target.value;
  }

  matcher = new MyErrorStateMatcher();

  hide = true;

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.username,
      this.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        this.showSnackbar('Login successful!');
        this.reloadPage();
      },
      error => {
        console.log(error);
        this.isLoginFailed = true;
        this.showSnackbar('Login unsuccessful!');
      }
    );
  }

  showSnackbar(message: string) {
    this.snackBar.open(message, '', {
      duration: 5000,
      panelClass: ['snackbar'],
    });
  }

  reloadPage() {
    window.location.reload();
  }
}
