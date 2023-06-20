import java.util.*;

public class Homework {

    /**
     * Реализовать консольное приложение - телефонный справочник.
     * У одной фамилии может быть несколько номеров.
     * Пользователь может вводить команды:
     * 1. ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
     * 2. GET Ivanov - получить список всех номеров по фамилии
     * 3. REMOVE Ivanov - удалить все номера по фамилии
     * 4. LIST - Посмотреть все записи
     * 5. EXIT - Завершить программу
     * Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
     * <p>
     * Пример взаимодействия (=> - это вывод на консоль):
     * ADD Ivanov 8 800 555 35 35
     * ADD Ivanov 8 800 100 10 10
     * GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
     * ADD Petrov 8 555 12 34
     * LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
     * REMOVE Ivanov
     * LIST => Petrov = [8 555 12 34]
     * GET NoName => Не найдена запись с фамилией "NoName"
     * REMOVE NoName => Не найдена запись с фамилией "NoName"
     */

    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            System.out.print("> ");
            String input = in.nextLine();
            String[] splitInput = input.split(" ");
            try {
                if (splitInput[0].equals("ADD")) {
                    List<String> testList = phoneBook.get(splitInput[1]);
                    if (testList == null) {
                        List<String> phoneList = new ArrayList<>();
                        phoneList.add(splitInput[2]);
                        phoneBook.put(splitInput[1], phoneList);
                    } else {
                        if (testList.contains(splitInput[2])) {
                            System.out.println("Этот номер уже есть в списке!");
                        } else {
                            testList.add(splitInput[2]);
                            phoneBook.put(splitInput[1], testList);
                        }
                    }
                } else if (splitInput[0].equals("GET")) {

                    List<String> testList = phoneBook.get(splitInput[1]);
                    if (testList == null) {
                        System.out.println("Не найдена запись с фамилией " + splitInput[1]);
                    } else {
                        System.out.println(testList);
                    }
                } else if (splitInput[0].equals("REMOVE")) {
                    List<String> testList = phoneBook.get(splitInput[1]);
                    if (testList == null) {
                        System.out.println("Не найдена запись с фамилией " + splitInput[1]);
                    } else {
                        phoneBook.remove(splitInput[1]);
                    }
                } else if (splitInput[0].equals("LIST")) {
                    if (phoneBook.keySet().size() == 0) {
                        System.out.println("Справочник пуст!");
                    } else {
                        phoneBook.forEach((name, nums) ->
                                System.out.println("Фамилия: " + name + ", Номера тел.: " + nums));
                    }
                } else if (splitInput[0].equals("EXIT")) {
                    break;
                } else {
                    System.out.println("Неизвестная команда!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некрректный ввод данных!");
            }
        }
    }

}