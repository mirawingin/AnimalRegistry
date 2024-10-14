package animals.Pack;

import animals.Animal;

public class Camel extends Animal {
    public Camel(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Верблюд";
    }
}

