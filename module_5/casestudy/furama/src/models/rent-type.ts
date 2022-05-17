export class RentType {
  id: number;
  name: string;


  constructor(rentTypeId: number, rentTypeName: string) {
    this.id = rentTypeId;
    this.name = rentTypeName;
  }
}
