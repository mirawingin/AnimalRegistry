package animals.Domestic;

import animals.Animal;

public class Hamster extends Animal {
    public Hamster(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Hamster commands: Run, Hide, Eat");
    }
}
