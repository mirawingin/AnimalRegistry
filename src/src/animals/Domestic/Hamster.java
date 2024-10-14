package animals.Domestic;

import animals.Animal;

public class Hamster extends Animal {
    public Hamster(String name, String birthDate, String commands) {
        super(name, birthDate, commands);
    }

    @Override
    public String getType() {
        return "Хомяк";
    }
}
