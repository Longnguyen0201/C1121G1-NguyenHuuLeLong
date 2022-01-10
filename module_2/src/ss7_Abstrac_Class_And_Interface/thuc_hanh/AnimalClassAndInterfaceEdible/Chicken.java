package ss7_Abstrac_Class_And_Interface.thuc_hanh.AnimalClassAndInterfaceEdible;

public class Chicken extends Animal implements Editable{

    @Override
    public String makeSound() {
        return "Chicken: Cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}
