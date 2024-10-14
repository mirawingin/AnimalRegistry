package animals.Pack;

import animals.Animal;

public class Donkey extends Animal {
    public Donkey(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Donkey commands: Carry, Pull, Stand");
    }
}
