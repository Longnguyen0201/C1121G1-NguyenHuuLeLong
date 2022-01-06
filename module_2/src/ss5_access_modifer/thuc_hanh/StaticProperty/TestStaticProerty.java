package ss5_access_modifer.thuc_hanh.StaticProperty;

public class TestStaticProerty {
    public static void main(String[] args) {
        Car car1 =new Car("Mazda 3","Skyactic 3");
        System.out.println(Car.numberOfCars);
        System.out.println(car1.toString());
        Car car2 =new Car("Mazda 6","Skyactic 6");
        System.out.println(Car.numberOfCars);
        System.out.println(car2.toString());

    }
}
