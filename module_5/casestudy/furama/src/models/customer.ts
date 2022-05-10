export class Customer {
  customerId: number;
  customerCode: string;
  customerName: string;
  customerBirthday: string;
  customerGender: string;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  customerTypeId: number;


  // tslint:disable-next-line:max-line-length
  constructor(customerId: number, customerCode: string, customerName: string, customerBirthday: string, customerGender: string, customerIdCard: string, customerPhone: string, customerEmail: string, customerAddress: string, customerTypeId: number) {
    this.customerId = customerId;
    this.customerCode = customerCode;
    this.customerName = customerName;
    this.customerBirthday = customerBirthday;
    this.customerGender = customerGender;
    this.customerIdCard = customerIdCard;
    this.customerPhone = customerPhone;
    this.customerEmail = customerEmail;
    this.customerAddress = customerAddress;
    this.customerTypeId = customerTypeId;
  }
}
