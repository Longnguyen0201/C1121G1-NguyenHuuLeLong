package ss21_design_patterns.thuc_hanh.factoryMethod;

public class AnimalFactory {
    public Animals getAnimal(String type){
        if ("Canine".equals(type)){
            return new Dog();
        }else {
            return new Cat();
        }
    }
}
