package animals.Domestic;

import animals.Animal;

public class Cat extends Animal {
    public Cat(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Кошка";
    }
}
