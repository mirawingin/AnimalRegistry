package menu;

import animals.Animal;
import animals.Domestic.Dog;
import animals.Domestic.Cat;
import animals.Domestic.Hamster;
import animals.Pack.Horse;
import animals.Pack.Camel;
import animals.Pack.Donkey;
import utils.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static List<Animal> domesticAnimals = new ArrayList<>();
    private static List<Animal> packAnimals = new ArrayList<>();

    static {
        // Добавляем всех животных из списка, который вы предоставили
        domesticAnimals.add(new Dog("Рекс", "2019-09-15", "Голос, Сидеть, Лежать"));
        domesticAnimals.add(new Dog("Барс", "2021-12-01", "Апорт, Лежать, Место"));
        domesticAnimals.add(new Dog("Бим", "2020-05-30", "Фас, Ко мне, Сидеть"));
        domesticAnimals.add(new Cat("Симба", "2020-04-05", "Спать, Прыгать, Ловить"));
        domesticAnimals.add(new Cat("Багира", "2022-02-18", "Шипеть, Лазить, Спать"));
        domesticAnimals.add(new Cat("Феня", "2019-11-22", "Играть, Прыгать, Ловить"));
        domesticAnimals.add(new Hamster("Снежок", "2021-03-15", "Крутиться, Хранить, Рыть"));
        domesticAnimals.add(new Hamster("Пушок", "2022-06-10", "Бегать, Хранить, Лазить"));
        domesticAnimals.add(new Hamster("Топтыжка", "2021-08-24", "Прятаться, Лазить, Кушать"));

        packAnimals.add(new Horse("Буцефал", "2019-07-12", "Рысь, Шагом, Стоп"));
        packAnimals.add(new Horse("Зефир", "2021-02-10", "Галоп, Прыгать, Стой"));
        packAnimals.add(new Horse("Гром", "2017-03-25", "Шагом, Вперёд, Встать"));
        packAnimals.add(new Camel("Камиль", "2018-05-22", "Вниз, Стоять, Право, Лево"));
        packAnimals.add(new Camel("Султан", "2020-06-18", "Сидеть, Идти, Стоп"));
        packAnimals.add(new Camel("Сахар", "2019-09-09", "Вверх, Влево, Назад"));
        packAnimals.add(new Donkey("Иван", "2020-11-30", "Шагать, Остановиться"));
        packAnimals.add(new Donkey("Ганс", "2018-12-15", "Вперёд, Стоять, Стой"));
        packAnimals.add(new Donkey("Джек", "2019-01-10", "Налево, Направо, Идти"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Counter counter = new Counter()) {
            while (true) {
                System.out.println("\n1. Домашние животные\n2. Вьючные животные\n3. Завести новое животное\n4. Обучить животное новой команде\n5. Удалить животное\n6. Выход");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    showAnimals(domesticAnimals, scanner);
                } else if (choice == 2) {
                    showAnimals(packAnimals, scanner);
                } else if (choice == 3) {
                    addNewAnimal(scanner, counter);
                } else if (choice == 4) {
                    teachNewCommand(scanner);
                } else if (choice == 5) {
                    removeAnimal(scanner);
                } else if (choice == 6) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Показать список животных и их команды
    private static void showAnimals(List<Animal> animals, Scanner scanner) {
        System.out.println("Выберите животное:");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).getType() + " - " + animals.get(i).getName());
        }

        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= animals.size()) {
            Animal selectedAnimal = animals.get(choice - 1);
            System.out.println("Имя: " + selectedAnimal.getName());
            System.out.println("Дата рождения: " + selectedAnimal.getBirthDate());
            System.out.println("Команды: ");
            selectedAnimal.displayCommands();
        }
    }

    // Добавление нового животного
    private static void addNewAnimal(Scanner scanner, Counter counter) throws Exception {
        System.out.println("Выберите тип животного:\n1. Домашнее\n2. Вьючное");
        int typeChoice = scanner.nextInt();

        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        String birthDate = scanner.next();
        System.out.println("Введите команды через пробел:");
        scanner.nextLine();  // Прочитать оставшуюся строку
        String commands = scanner.nextLine();

        Animal newAnimal = null;
        if (typeChoice == 1) {
            System.out.println("1. Собака  2. Кошка  3. Хомяк");
            int animalChoice = scanner.nextInt();
            if (animalChoice == 1) newAnimal = new Dog(name, birthDate, commands);
            else if (animalChoice == 2) newAnimal = new Cat(name, birthDate, commands);
            else if (animalChoice == 3) newAnimal = new Hamster(name, birthDate, commands);
            domesticAnimals.add(newAnimal);
        } else if (typeChoice == 2) {
            System.out.println("1. Лошадь  2. Верблюд  3. Осел");
            int animalChoice = scanner.nextInt();
            if (animalChoice == 1) newAnimal = new Horse(name, birthDate, commands);
            else if (animalChoice == 2) newAnimal = new Camel(name, birthDate, commands);
            else if (animalChoice == 3) newAnimal = new Donkey(name, birthDate, commands);
            packAnimals.add(newAnimal);
        }

        if (newAnimal != null) {
            counter.add(); // Увеличиваем счетчик при добавлении нового животного
            System.out.println("Новое животное добавлено: " + newAnimal.getName());
        }
    }

    // Обучение животного новой команде
    private static void teachNewCommand(Scanner scanner) {
        System.out.println("1. Домашние животные\n2. Вьючные животные");
        int typeChoice = scanner.nextInt();

        List<Animal> selectedList = (typeChoice == 1) ? domesticAnimals : packAnimals;

        System.out.println("Выберите животное для обучения:");
        for (int i = 0; i < selectedList.size(); i++) {
            System.out.println((i + 1) + ". " + selectedList.get(i).getType() + " - " + selectedList.get(i).getName());
        }

        int animalChoice = scanner.nextInt();
        if (animalChoice >= 1 && animalChoice <= selectedList.size()) {
            Animal animal = selectedList.get(animalChoice - 1);
            System.out.println("Введите новую команду для " + animal.getName() + ":");
            scanner.nextLine();  // Прочитать оставшуюся строку
            String newCommand = scanner.nextLine();
            animal.learnCommand(newCommand);
            System.out.println("Команда \"" + newCommand + "\" добавлена для " + animal.getName());
        }
    }

    // Удаление животного
    private static void removeAnimal(Scanner scanner) {
        System.out.println("1. Домашние животные\n2. Вьючные животные");
        int typeChoice = scanner.nextInt();

        List<Animal> selectedList = (typeChoice == 1) ? domesticAnimals : packAnimals;

        System.out.println("Выберите животное для удаления:");
        for (int i = 0; i < selectedList.size(); i++) {
            System.out.println((i + 1) + ". " + selectedList.get(i).getType() + " - " + selectedList.get(i).getName());
        }

        int animalChoice = scanner.nextInt();
        if (animalChoice >= 1 && animalChoice <= selectedList.size()) {
            Animal animal = selectedList.get(animalChoice - 1);
            selectedList.remove(animal);
            System.out.println("Животное " + animal.getName() + " удалено.");
        }
    }
}
