import {Facility} from '../models/facility';

export class FacilityService {
  public  getFacilityList(){
    let facilityList: Facility[];
    facilityList = [
      new Facility(1, 2, 'DV-001', 'Phòng Superior hướng hồ', 40.1, 300, 4, 'Vip', 'View hồ, tivi 40 inch' , 3 , 15 , 0 , 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-F-370x239.jpg'),
      new Facility(2, 1, 'DV-002', 'Phòng Deluxe hướng vườn', 43.7, 189, 2, 'Normal', 'View Vườn' , 3 , 20 , 2 , 'https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Garden-Deluxe-twin-bed-F-370x239.jpg'),
      new Facility(3, 2, 'DV-003', 'Phòng Deluxe hướng biển', 43.7, 219, 2, 'Normal', 'View Biển' , 2 , 0 , 1 , 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Deluxe-double-bed-F-370x239.jpg'),
      new Facility(4, 3, 'DV-004', 'Phòng Suite hướng biển', 85.5, 500, 4, 'Vip', 'View biển' , 3 , 20 , 3 , 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg'),
      new Facility(5, 1, 'DV-004', 'Phòng Studio Suite hướng biển', 40.1, 350, 2, 'Vip', 'View biển, tivi 40 inch' , 3  , 20 , 2 , 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg'),
      new Facility(6, 1, 'DV-005', 'Phòng Superior hướng Vườn', 40.1, 200, 2, 'Normal', 'View vườn' , 3 , 10 , 0 , 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-F-370x239.jpg'),
    ];
    return facilityList;
  }
}
