package animals.Pack;

import animals.Animal;

public class Horse extends Animal {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Horse commands: Gallop, Jump, Stand");
    }
}
