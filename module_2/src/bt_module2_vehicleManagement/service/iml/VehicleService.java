package vehicleManagement.service.iml;

import org.jetbrains.annotations.NotNull;
import vehicleManagement.model.Car;
import vehicleManagement.model.Motorcycle;
import vehicleManagement.model.Truck;
import vehicleManagement.model.Vehicle;
import vehicleManagement.service.IVehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleService implements IVehicleService {
    Scanner input = new Scanner(System.in);
    private static vehicleManagement.service.iml.BrandService brandService = new vehicleManagement.service.iml.BrandService();
    private static List<Car> carArrayList = new ArrayList<>();
    private static List<Truck> deletedList = new ArrayList<>();

    static {
        Car car1 = new Car("43A-212.56", "Toyota", 2019, "Dulich", "Nguyễn Văn A", 5);
        Car car2 = new Car("43A-535.88", "Huyndai", 2020, "Xe khách", "Nguyễn Văn B", 45);
        Car car3 = new Car("43A-535.99", "Toyota", 2020, "Xe khách", "Nguyễn Văn C", 16);
        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);
    }

    private static List<Truck> truckArrayList = new ArrayList<>();

    static {
        Truck truck1 = new Truck("43C-012.34", "Huyndai", 2019, "Nguyễn Văn A", 3);
        Truck truck2 = new Truck("43C-47.678", "Dongfeng", 2020, "Nguyễn Văn B", 9);
        Truck truck3 = new Truck("43C-45.235", "Hino", 2021, "Nguyễn Văn C", 12);
        truckArrayList.add(truck1);
        truckArrayList.add(truck2);
        truckArrayList.add(truck3);
    }

    private static List<Motorcycle> motorcycleArrayList = new ArrayList<>();

    static {
        Motorcycle motorcycle1 = new Motorcycle("43-K1-678.56", "Yamaha", 2019, "Nguyễn Văn A", 100);
        Motorcycle motorcycle2 = new Motorcycle("43-H1-345.89", "Honda", 2019, "Nguyễn Văn B", 150);
        Motorcycle motorcycle3 = new Motorcycle("43-AK-765.23", "Yamaha", 2019, "Nguyễn Văn C", 50);
        motorcycleArrayList.add(motorcycle1);
        motorcycleArrayList.add(motorcycle2);
        motorcycleArrayList.add(motorcycle3);
    }


    @Override
    public void add() {
        int choose;
        do {
            System.out.println(" Thêm mới phương tiện\n" +
                    "1. Thêm xe tải.\n" +
                    "2. Thêm xe oto.\n" +
                    "3. Thêm xe máy.\n" +
                    "4. Thoát.\n");
            System.out.print("Mời bạn chọn:  ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    addTruck();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addMotorbycle();
                    break;
                case 4:
                    break;
                default:
            }
        } while (choose != 4);
    }


    @Override
    public void showList() {
        int choose;
        do {
            System.out.println(" Hiển thị phương tiện \n" +
                    "1. Hiển thị xe tải.\n" +
                    "2. Hiển thị xe oto.\n" +
                    "3. Hiển thị xe máy.\n" +
                    "4. Thoát.\n");
            System.out.print("Mời bạn chọn:  ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println(" Danh sách xe tải:");
                    for (Vehicle truck : truckArrayList) {
                        System.out.println(truck);
                    }
                    break;
                case 2:
                    System.out.println(" Danh sách xe oto:");
                    for (Vehicle car : carArrayList) {
                        System.out.println(car);

                    }
                    break;
                case 3:
                    System.out.println(" Danh sách xe máy:");
                    for (Vehicle motorcycle : motorcycleArrayList) {
                        System.out.println(motorcycle);

                    }
                    break;
                case 4:
                    break;
                default:
            }
        } while (choose != 4);
    }

    @Override
    public void delete() {
        System.out.print("Nhập biển kiểm soát xe bạn muốn xóa: ");
        String namePlate = input.nextLine();
        checkDelete(namePlate,carArrayList);
        checkDelete(namePlate,truckArrayList);
        checkDelete(namePlate,motorcycleArrayList);
        if (!checkDelete(namePlate, carArrayList) && !checkDelete(namePlate, truckArrayList) && !checkDelete(namePlate, motorcycleArrayList)){
            System.out.println("Không tìm thấy phương tiện trong danh sách");
        }
    }

    private void addTruck() {
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = input.nextLine();
        brandService.displayList();
        String brand = brandService.chooseBrand();
        System.out.print("Nhập năm sản xuât:");
        int yearManufacture = Integer.parseInt(input.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = input.nextLine();
        System.out.println(" Nhập tải trọng của xe: ");
        int tonnage = Integer.parseInt(input.nextLine());

        Truck newTruck = new Truck(numberPlate, brand, yearManufacture, owner, tonnage);
        truckArrayList.add(newTruck);
    }

    private void addCar() {
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = input.nextLine();
        brandService.displayList();
        String brand = brandService.chooseBrand();
        System.out.print("Nhập năm sản xuât:");
        int yearManufacture = Integer.parseInt(input.nextLine());
        System.out.print("Nhập loại xe (du lịch, xe khách: ");
        String tyeCar = input.nextLine();
        System.out.print("Nhập chủ sở hữu: ");
        String owner = input.nextLine();
        System.out.print("Nhập số ghế ngồi:");
        int numberSeats = Integer.parseInt(input.nextLine());

        Car newCar = new Car(numberPlate, brand, yearManufacture, tyeCar, owner, numberSeats);
        carArrayList.add(newCar);
    }

    private void addMotorbycle() {
        System.out.print("Nhập biển kiểm soát: ");
        String numberPlate = input.nextLine();
        brandService.displayList();
        String brand = brandService.chooseBrand();
        System.out.print("Nhập năm sản xuât:");
        int yearManufacture = Integer.parseInt(input.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String owner = input.nextLine();
        System.out.println(" Nhập công suât của xe: ");
        int capacity = Integer.parseInt(input.nextLine());

        Motorcycle newMotorcycle = new Motorcycle(numberPlate, brand, yearManufacture, owner, capacity);
        motorcycleArrayList.add(newMotorcycle);
    }
    private boolean checkDelete(String namePlate, List<Vehicle> array) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            if (namePlate.equals(array.get(i).getNumberPlate())) {
                System.out.println(array.get(i));
                flag = true;
                System.out.println("Bạn có muốn xóa phương tiện này ( chọn Y / N)");
                String choose = input.nextLine();
                choose = choose.toUpperCase();
                if (choose.equals("Y")) {
                    array.remove(i);
                    System.out.println("Xóa phương tiện thành công");
                    break;
                }
            }
        }
        return flag;
    }
}
