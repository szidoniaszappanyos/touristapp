import {Component, OnInit} from '@angular/core';
import {ErrorStateMatcher, MatDatepickerInputEvent} from "@angular/material";
import {FormBuilder, FormControl, FormGroupDirective, NgForm, Validators} from "@angular/forms";


/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

export const PasswordValidation = [
  Validators.required,
  Validators.minLength(6),
  Validators.maxLength(24),
];

export const NameValidation = [
  Validators.required,
  Validators.pattern('([A-Za-z ]+)')

];

export const DateValidation = [
  Validators.required
];

export const UserNameValidation = [
  Validators.required,
  Validators.pattern('^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$')
];

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  form: any;
  events: string[] = [];
  date = '';
  month: number;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      password: new FormControl('', PasswordValidation),
      name: new FormControl('', NameValidation),
      date: new FormControl('', DateValidation),
      username: new FormControl('', UserNameValidation)
    });
  }

  ngOnInit() {
  }

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  addDate(type: string, event: MatDatepickerInputEvent<Date>) {
    if (event.value != null) {
      this.events.push(`${type}: ${event.value}`);
      this.month = event.value.getMonth() + 1;
      this.date = event.value.getDate() + '/' + this.month + '/' + event.value.getFullYear();
      console.log(this.date);
    }
  }

  matcher = new MyErrorStateMatcher();

  hide = true;
}
