package animals.Domestic;

import animals.Animal;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void displayCommands() {
        System.out.println("Dog commands: Sit, Stay, Fetch");
    }
}
