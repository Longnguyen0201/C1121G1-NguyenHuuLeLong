import {CustomerType} from '../models/customer-type';

export class CustomerTypeService {
  private customerTypes: CustomerType[] = [
    new CustomerType(1, 'Diamond'),
    new CustomerType(2, 'Platinium'),
    new CustomerType(3, 'Gold'),
    new CustomerType(4, 'Silver'),
    new CustomerType(5, 'Member'),
  ];
  public getCustomerTypeList(){
    return this.customerTypes;
  }
}
