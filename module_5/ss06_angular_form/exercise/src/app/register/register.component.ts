import {Component, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  FormGroupDirective, NgForm,
  ValidationErrors,
  ValidatorFn,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  fromRegister: FormGroup;
  constructor() {
    this.fromRegister = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }

  get email() {
    return this.fromRegister.get('email');
  }

  get password() {
    return this.fromRegister.get('password');
  }

  get confirmPassword() {
    return this.fromRegister.get('confirmPassword');
  }

  get country() {
    return this.fromRegister.get('country');
  }

  get age() {
    return this.fromRegister.get('age');
  }

  get gender() {
    return this.fromRegister.get('gender');
  }

  get phone() {
    return this.fromRegister.get('phone');
  }
  checkPasswords(){
    if (this.password.value !== this.confirmPassword.value) {
      this.fromRegister.get('confirmPassword')?.setErrors({notSame: 'Xác nhận mật khẩu không chính xác'});
    }
    return this.fromRegister.get('confirmPassword');
  }

  ngOnInit(): void {
  }


  onSubmit() {
    console.log(this.fromRegister);
  }
}




