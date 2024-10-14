package animals.Pack;

import animals.Animal;

public class Horse extends Animal {
    public Horse(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Лошадь";
    }
}
