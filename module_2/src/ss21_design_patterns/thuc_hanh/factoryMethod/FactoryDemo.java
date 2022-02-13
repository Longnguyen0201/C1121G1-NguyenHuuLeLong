package ss21_design_patterns.thuc_hanh.factoryMethod;

public class FactoryDemo {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animals a1 = animalFactory.getAnimal("feline");
        System.out.println("a1 sound: " + a1.makeSound());

        Animals a2 = animalFactory.getAnimal("Canine");
        System.out.println("a2 sound: "+ a2.makeSound());
    }
}
