package animals.Domestic;

import animals.Animal;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Cat commands: Jump, Catch, Sleep");
    }
}
