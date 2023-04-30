package Java.Toy_shop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Methods {

    /**
     * @toys - метод возращает начальный список игрушек для розыгрыша.
     */
    public static ArrayList<ToyClass> creatingListToys() {
        ArrayList<ToyClass> toys = new ArrayList<>();
        toys.add(new ToyClass("Плюшевй медведь", 1, 5, 26));
        toys.add(new ToyClass("Кукла барби", 2, 7, 37));
        toys.add(new ToyClass("Машинка радиоуправляемая", 3, 4, 16));
        toys.add(new ToyClass("Квадракоптер", 4, 2, 11));
        toys.add(new ToyClass("Дом барби", 5, 2, 11));
        // printToys(toys);

        return toys;
    }

    /**
     * @nameListToys - метод возравщает и распечатывает спискок названий игрушек.
     */
    public static ArrayList<String> nameListToys(ArrayList<ToyClass> toys) {
        ArrayList<String> nameListToys = new ArrayList<>();
        for (int i = 0; i < toys.size(); i++) {
            nameListToys.add(toys.get(i).getName());
            System.out.printf("%d. %s\n", toys.get(i).getId(), nameListToys.get(i));

        }
        return nameListToys;
    }

    /**
     * @param toys - принимает список игрушек.
     * @probab - возврадает список игрушек в котором расчитан процент вероятности
     *         выпадения в зависимости от количества элементво и количетва каждогой
     *         игрушки.
     */
    public static ArrayList<ToyClass> probability(ArrayList<ToyClass> toys) {
        ArrayList<ToyClass> probab = toys;
        int id = probab.size();
        int totalQuantity = 0;
        float probability = 0;
        // расчитаем общее количество всех игрушек.
        for (int i = 0; i < id; i++) {
            totalQuantity = totalQuantity + probab.get(i).getQuantity();
        }
        // пересичтаем и перезапишем вероятность выпадения.
        for (int j = 0; j < id; j++) {
            int quantity = probab.get(j).getQuantity(); // извлелчение количества каждой игрушки

            probability = calculationРrobability(totalQuantity, quantity);
            ToyClass t = probab.get(j);

            t.setProbability(probability);
            probab.set(j, t);
        }

        // printToys(probab);

        return probab;
    }

    /**
     * @param totalQuantity - общее количестов всех игрушек
     * @param quantity      - количестов каждой игрушки
     * @return процент вероятности выпадения
     */
    private static float calculationРrobability(int totalQuantity, int quantity) {
        return (((float) quantity) / (float) totalQuantity) * 100;
    }

    /**
     * @return toys возвращает список игрушек с добаленной новой игрушкой.
     */
    public static ArrayList<ToyClass> addToy(ArrayList<ToyClass> toys) {
        ToyClass toyNew;
        String name = ConsoleView.nameToy();
        int id = toys.size() + 1;
        int quantity = ConsoleView.quantityToy();
        float probability = 0;
        toyNew = new ToyClass(name, id, quantity, probability);

        System.out.printf("Вы добавии игрушку: %s\n", toyNew.name);
        toys.add(toyNew);

        toys = probability(toys);

        return toys;
    }

    /**
     * @param toys печатает полный лист игрушек со свеми пораметрами.// для тестов
     */
    public static void printToys(ArrayList<ToyClass> toys) {
        for (int i = 0; i < toys.size(); i++) {
            System.out.println(toys.get(i));
        }
    }

    /**
     * Список игрушек для розыгрыша по id и вероятности выпадения.
     */
    public static ArrayList<Integer> ListToysIdProbability(ArrayList<ToyClass> toys) {
        ArrayList<Integer> ListToysIdProbability = new ArrayList<>();
        for (int index = 0; index < toys.size(); index++) {
            int id = toys.get(index).getId();
            float probability = toys.get(index).getProbability();
            for (int i = 0; i < probability; i++) {
                ListToysIdProbability.add(id);
            }
        }
        Collections.shuffle(ListToysIdProbability, new Random());

        System.out.println(ListToysIdProbability);
        return ListToysIdProbability;
    }

    /**
     * 
     * @param ListToysIdProbability
     * @return Возвращает id случно выбранное в списке и находит название выигранной
     *         игрушки.
     */
    public static String lotteryToy(ArrayList<Integer> ListToysIdProbability, ArrayList<ToyClass> toys) {
        int index = new Random().nextInt(ListToysIdProbability.size());
        Integer lottery = ListToysIdProbability.get(index);
        String nameToy = toys.get((lottery - 1)).getName();
        //System.out.printf(lottery);
        return nameToy;
    }
}
