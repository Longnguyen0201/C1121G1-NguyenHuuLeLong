package vehicleManagement.service.iml;

import vehicleManagement.model.Brand;
import vehicleManagement.service.IBrand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandService implements IBrand {
    Scanner input = new Scanner(System.in);
    private static List<Brand> brandList= new ArrayList<>();
    static {
        Brand brand1 = new Brand("HSX-001","Yamaha","Nhật Bản");
        Brand brand2 = new Brand("HSX-002","Honda","Nhật Bản");
        Brand brand3 = new Brand("HSX-003","Dongfeng","Trung Quoc");
        Brand brand4 = new Brand("HSX-004","Huyndai","Hàn Quốc");
        Brand brand5 = new Brand("HSX-005","Ford","Mỹ");
        Brand brand6 = new Brand("HSX-006","Toyota","Nhật Bản");
        Brand brand7 = new Brand("HSX-007","Hino","Nhật Bản");
        brandList.add(brand1);
        brandList.add(brand2);
        brandList.add(brand3);
        brandList.add(brand4);
        brandList.add(brand5);
        brandList.add(brand6);
        brandList.add(brand7);
    }

    @Override
    public void displayList() {
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println((i+1)+ ". " + brandList.get(i));

        }
    }

    @Override
    public String chooseBrand() {
        System.out.println("Nhập hãng muốn chọn theo list (1,2,3,...)");
        int index = Integer.parseInt(input.nextLine());
        String brandChoose="";
        for (int i = 0; i < brandList.size(); i++) {
            if (i == index-1){
                brandChoose = brandList.get(i).getBrandName();
                break;
            }
        }
        return brandChoose;
    }
}
