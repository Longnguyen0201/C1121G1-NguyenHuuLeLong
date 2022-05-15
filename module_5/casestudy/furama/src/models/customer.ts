import {CustomerType} from './customer-type';

export class Customer {
  customerId: number;
  customerCode: string;
  customerName: string;
  customerBirthday: string;
  customerGender: number;
  customerIDCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  customerType: CustomerType;


  // tslint:disable-next-line:max-line-length
  constructor(customerId: number, customerCode: string, customerName: string, customerBirthday: string,
              customerGender: number, customerIDCard: string, customerPhone: string, customerEmail: string,
              customerAddress: string, customerType: CustomerType) {
    this.customerId = customerId;
    this.customerCode = customerCode;
    this.customerName = customerName;
    this.customerBirthday = customerBirthday;
    this.customerGender = customerGender;
    this.customerIDCard = customerIDCard;
    this.customerPhone = customerPhone;
    this.customerEmail = customerEmail;
    this.customerAddress = customerAddress;
    this.customerType = customerType;
  }
}
