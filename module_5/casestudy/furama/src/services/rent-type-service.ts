import {RentType} from '../models/rent-type';

export class RentTypeService {
  private rentTypes: RentType[] = [
    new RentType(1, 'Year'),
    new RentType(2, 'Month'),
    new RentType(3, 'Day'),
    new RentType(4, 'Hour'),
  ];

  getRentTypeList() {
    return this.rentTypes;
  }
}
