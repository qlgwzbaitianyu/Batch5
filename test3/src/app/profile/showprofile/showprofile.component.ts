import { Component, OnInit } from '@angular/core';
import {UploadprofileService} from '../uploadprofile.service';
import {AbstractControl, FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-showprofile',
  templateUrl: './showprofile.component.html',
  styleUrls: ['./showprofile.component.css']
})
export class ShowprofileComponent implements OnInit {

  firstname1;
  lastname;
  email;
  notification;
  phone;
  updatepassword;
  myprofile;
  sendnotification;

  city;
  street1;
  street2;
  zipcode;
  state;
  AddObj: object;
  customerForm: FormGroup;


  constructor(private formservice: UploadprofileService,
              private fb: FormBuilder,
              private router: Router) { }

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


    this.formservice.downlloadProfile().subscribe(
      (data) => {
        this.myprofile = data;
        console.log(this.myprofile);
        //onsole.log(data['prof']['firstname']);
        this.firstname1 = this.myprofile['prof']['firstname'];
        this.lastname = this.myprofile['prof']['lastname'];
        this.email = this.myprofile['prof']['email'];
        this.phone = this.myprofile['prof']['phone'];
        this.updatepassword = this.myprofile['prof']['updatepassword'];
        this.sendnotification = this.myprofile['prof']['notification'];
        this.city = this.myprofile['prof']['addresses']['0']['city'];
        this.street1 = this.myprofile['prof']['addresses']['0']['street1'];
        this.street2 = this.myprofile['prof']['addresses']['0']['street2'];
        this.zipcode = this.myprofile['prof']['addresses']['0']['zip'];
        this.state = this.myprofile['prof']['addresses']['0']['state'];
        this.populateTestData();
        this.setAddressData();
      }
    );

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

  get addressesarray(): FormArray {
    return <FormArray>this.customerForm.get('addresses');
  }

  addAddress(): void {
    this.addresses.push(this.buildAddress());
  }

  buildAddress2(s1, s2, c, s, z): FormGroup {
    return this.fb.group({
      street1: c,
      street2: s,
      city: s1,
      state: s2,
      zip: z
    });
  }

  get addresses(): FormArray {
    return <FormArray>this.customerForm.get('addresses');
  }

  populateTestData(): void {
    this.customerForm.patchValue({
      firstname: this.myprofile['prof']['firstname'],
      lastname: this.myprofile['prof']['lastname'],
      email: this.email,
      phone: this.phone,
      updatepassword: this.updatepassword,
      notification: this.notification,
    });
  }

  setAddressData(): void {
      //console.log(this.buildAddress2(this.street1, this.street2, this.city, this.state, this.zipcode));
      this.addressesarray.push(this.buildAddress2(this.city, this.state, this.street1, this.street2, this.zipcode));
      this.addressesarray.removeAt(0);
  }

  goBack() {
    this.router.navigate(['/profile']);
  }


}
