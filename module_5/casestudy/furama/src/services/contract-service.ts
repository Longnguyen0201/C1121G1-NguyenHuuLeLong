import {Contract} from '../models/contract';

export class ContractService {
  public getContractList(){
    let contractList: Contract[];
    contractList = [
      new Contract(1, 'HD-0001', 'Ngô Bá Khá', 'Nguyễn Văn Bê',  'Phòng Deluxe hướng vườn' , '09-05-2022', '10-05-2022', 50, 189),
      new Contract(2, 'HD-0002', 'Dương Minh Tuyền', 'Nguyễn Văn Bê',  'Phòng Suite hướng biển' , '12-05-2022', '13-05-2022', 200, 500),
      new Contract(3, 'HD-0003', 'Trương Văn Cam', 'Phạm Băng Băng',  'Phòng Deluxe hướng vườn' , '01-05-2022', '02-05-2022', 50, 189)
    ];
    return contractList;
  }

}
