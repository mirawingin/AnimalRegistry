package animals.Pack;

import animals.Animal;

public class Camel extends Animal {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Camel commands: Walk, Carry, Kneel");
    }
}
