package animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDate;
    protected List<String> commands;

    public Animal(String name, String birthDate, String commandList) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.commands = new ArrayList<>(List.of(commandList.split(", ")));
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void learnCommand(String newCommand) {
        commands.add(newCommand);
    }

    public abstract String getType(); // Для возвращения типа животного

    public void displayCommands() {
        System.out.println("Commands: " + String.join(", ", commands));
    }
}
