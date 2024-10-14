package animals.Pack;

import animals.Animal;

public class Donkey extends Animal {
    public Donkey(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Осел";
    }
}
