import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AbstractControl, Form, FormBuilder, FormArray, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import {UploadprofileService} from './uploadprofile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  customerForm: FormGroup;
  myprofile: object;
  myfirstname: string;
  username: String;
  address;

  constructor(private fb: FormBuilder,
              private formservice: UploadprofileService) {}

  ngOnInit() {
    this.customerForm = this.fb.group({
      firstname: ['', [Validators.required,  Validators.minLength(3)]],
      lastname: ['', [Validators.required, Validators.maxLength(5)]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+')]],
      phone: ['', [Validators.pattern('^([()\\- x+]*\\d[()\\- x+]*){4,16}$')]],
      updatepassword: ['', [Validators.required]],
      notification: 'email',
      addresses: this.fb.array([ this.buildAddress() ])
    });
  }



  buildAddress(): FormGroup {
    return this.fb.group({
      street1: '',
      street2: '',
      city: '',
      state: '',
      zip: ''
    });
  }

  get addresses(): FormArray {
    return <FormArray>this.customerForm.get('addresses');
  }

  addAddress(): void {
    this.addresses.push(this.buildAddress());
  }

  deleteAddress(i: number): void {
    if (i !== 0) {
      this.addresses.removeAt(i);
    } else {
      alert('Minimum One address required');
    }
  }

  save() {
    console.log(this.customerForm['value']);
    this.formservice.uploadProfile(this.customerForm['value']);

    //console.log(JSON.stringify(this.customerForm));
  }

  view() {
    this.myprofile = this.formservice.downlloadProfile().subscribe(
      (data) => {
        console.log(data['prof']['firstname']);
        this.myprofile = data;
      }
    );
   // console.log(this.myprofile);
    //localStorage.setItem('profile', this.myprofile);
  }


  setNotification(notifyVia: string): void {
    const phoneControl = this.customerForm.get('phone');
    const emailContro = this.customerForm.get('email');
    if (notifyVia === 'text') {
      phoneControl.setValidators(Validators.required);
      emailContro.clearValidators();
    } else {
      phoneControl.clearValidators();
    }
    phoneControl.updateValueAndValidity();
    emailContro.updateValueAndValidity();
  }

}
