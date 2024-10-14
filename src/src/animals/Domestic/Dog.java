package animals.Domestic;

import animals.Animal;

public class Dog extends Animal {
    public Dog(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Собака";
    }
}
