import {RentType} from './rent-type';
import {ServiceType} from './service-type';

export class Facility {
  id: number;
  serviceType: ServiceType;
  serviceCode: string;
  serviceName: string;
  serviceArea: number;
  servicePrice: number;
  serviceMaxPeople: number;
  serviceStandRoom: string;
  serviceDescribe: string;
  serviceRentType: RentType;
  serviceAreaPool: number;
  serviceFloor: number;
  serviceImg: string;


  constructor(id: number, serviceType: ServiceType, serviceCode: string, serviceName: string, serviceArea: number, servicePrice: number, serviceMaxPeople: number, serviceStandRoom: string, serviceDescribe: string, serviceRentType: RentType, serviceAreaPool: number, serviceFloor: number, serviceImg: string) {
    this.id = id;
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
