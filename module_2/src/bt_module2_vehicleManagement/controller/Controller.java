package vehicleManagement.controller;



import vehicleManagement.service.iml.VehicleService;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VehicleService vehicleArrayList = new VehicleService();
        int choose;
        do {

            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG:\n" +
                    "Chọn chức năng: \n" +
                    "1. Thêm phương tiện \n" +
                    "2. Hiển thị phương tiện \n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát \n");
            System.out.print("Mời bạn chọn:  ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    vehicleArrayList.add();
                    break;
                case 2:
                    vehicleArrayList.showList();
                    break;
                case 3:
                    vehicleArrayList.delete();
                    break;
                case 4:
 break;
                default:

            }
        }while (choose !=4);
    }


}
