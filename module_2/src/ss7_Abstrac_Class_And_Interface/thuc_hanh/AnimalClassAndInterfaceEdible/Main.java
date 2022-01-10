package ss7_Abstrac_Class_And_Interface.thuc_hanh.AnimalClassAndInterfaceEdible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] =new Tiger();
        animals[1] =new Chicken();

        for (Animal animal: animals){
            System.out.println( animal.makeSound());

            if( animal instanceof Chicken){
                Editable editable = (Chicken) animal;
                System.out.println(editable.howToEat());
            }
        }

        Fruit[] fruit =new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit fruit1: fruit ){
            System.out.println(fruit1.howToEat());
        }

    }
}
