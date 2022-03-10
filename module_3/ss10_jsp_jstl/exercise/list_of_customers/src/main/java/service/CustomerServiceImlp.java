package service;

import Model.Customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImlp {
    static Map<Integer, Customers> customersMap = new HashMap<>();

    static {
        customersMap.put(1, new Customers("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://d9i9nmwzijaw9.cloudfront.net/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"));
        customersMap.put(2, new Customers("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://d9i9nmwzijaw9.cloudfront.net/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"));
        customersMap.put(3, new Customers("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://d9i9nmwzijaw9.cloudfront.net/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"));
        customersMap.put(4, new Customers("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://d9i9nmwzijaw9.cloudfront.net/450/774/576/-29996968-1tfd7tc-gpggmmc5d0og3a0/original/image.jpg"));
    }

    public ArrayList<Customers> findAll() {
        return new ArrayList<>(customersMap.values());
    }
}
