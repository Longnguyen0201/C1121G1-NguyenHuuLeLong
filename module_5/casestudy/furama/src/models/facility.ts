export class Facility {
  serviceId: number;
  serviceType: number;
  serviceCode: string;
  serviceName: string;
  serviceArea: number;
  servicePrice: number;
  serviceMaxPeople: number;
  serviceStandRoom: string;
  serviceDescribe: string;
  serviceRentType: number;
  serviceAreaPool: number;
  serviceFloor: number;
  serviceImg: string;


  // tslint:disable-next-line:max-line-length
  constructor(serviceId: number, serviceType: number, serviceCode: string, serviceName: string, serviceArea: number, servicePrice: number, serviceMaxPeople: number, serviceStandRoom: string, serviceDescribe: string, serviceRentType: number, serviceAreaPool: number, serviceFloor: number, serviceImg: string) {
    this.serviceId = serviceId;
    this.serviceType = serviceType;
    this.serviceCode = serviceCode;
    this.serviceName = serviceName;
    this.serviceArea = serviceArea;
    this.servicePrice = servicePrice;
    this.serviceMaxPeople = serviceMaxPeople;
    this.serviceStandRoom = serviceStandRoom;
    this.serviceDescribe = serviceDescribe;
    this.serviceRentType = serviceRentType;
    this.serviceAreaPool = serviceAreaPool;
    this.serviceFloor = serviceFloor;
    this.serviceImg = serviceImg;
  }
}
