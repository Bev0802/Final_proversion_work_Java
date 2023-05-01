package Java.Toy_shop;

import java.text.Format;
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

        return toys;
    }

    /**
     * @nameListToys - метод возравщает и распечатывает спискок названий игрушек и их количество.
     */
    public static void nameListToys(ArrayList<ToyClass> toys) {        
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getQuantity()<=0){
                System.out.printf("Игрушка '%s' закончилась.",toys.get(i).getName());
                System.out.println("Вы хотие добавить количество?");                
                if (ConsoleView.YesNo()){
                    toys.get(i).setQuantity(ConsoleView.quantityToy());                    
                    FileExportImport.AddFileToy(toys);                                   }
                else System.out.println("Тогда она не будет участвовать в розыгрыше.");
            }
            toys = probability(toys);
            System.out.printf("%d. %s - %d\n" , toys.get(i).getId(), toys.get(i).getName(), toys.get(i).getQuantity());            
        }
          
    }   


    /**
     * @param toys - принимает список игрушек.
     * @toys - возврадает список игрушек в котором расчитан процент вероятности
     *         выпадения в зависимости от количества элементво и количетва каждой
     *         игрушки.
     */
    public static ArrayList<ToyClass> probability(ArrayList<ToyClass> toys) {        
        int id = toys.size();
        int totalQuantity = 0;
        int probability = 0;
        // расчитаем общее количество всех игрушек.
        for (int i = 0; i < id; i++) {
            totalQuantity = totalQuantity + toys.get(i).getQuantity();
        }
        // пересичтаем и перезапишем вероятность выпадения.
        for (int j = 0; j < id; j++) {
            int quantity = toys.get(j).getQuantity(); // извлелчение количества каждой игрушки

            probability = calculationРrobability(totalQuantity, quantity);
            ToyClass t = toys.get(j);

            t.setProbability(probability);
            toys.set(j, t);
        }

        // printToys(toys);

        return toys;
    }

    /**
     * @param totalQuantity - общее количестов всех игрушек
     * @param quantity      - количестов каждой игрушки
     * @return процент вероятности выпадения
     */
    private static int calculationРrobability(int totalQuantity, int quantity) {
        return (int)((((float) quantity) / (float) totalQuantity) * 100);
    }

    /**
     * @return toys возвращает список игрушек с добаленной новой игрушкой.
     */
    public static ArrayList<ToyClass> addToy(ArrayList<ToyClass> toys) {
        ToyClass toyNew;
        String name = ConsoleView.nameToy();
        int id = toys.size() + 1;
        int quantity = ConsoleView.quantityToy();
        int probability = 0;
        toyNew = new ToyClass(name, id, quantity, probability);

        System.out.printf("Вы добавии игрушку: %s\n", toyNew.name);
        toys.add(toyNew);
        
        toys = probability(toys);
        FileExportImport.AddFileToy(toys);

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
            int probability = toys.get(index).getProbability();
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
        
        int q = toys.get(lottery-1).getQuantity();
        ToyClass t = toys.get(lottery-1);        
        t.setQuantity((q-1)); 
        toys.set(lottery-1, t);
        FileExportImport.AddFileToy(toys);

        String nameToy = toys.get((lottery-1)).getName();     
        return nameToy;
    }

    /**
     * получение данных из файла.
     */
    public static ArrayList <ToyClass> DataVerification(){
        if (!FileExportImport.checkingFile()){
            FileExportImport.CreateFileToys ();
        }
        ArrayList <ToyClass> toys = convertingFromFile(FileExportImport.ReadFileToy());
        return toys;
    }
    
    /**
     * Метод конвертирует данные из String полученной из файла в  ArrayList <ToyClass>.
     * @param toysStr
     * @return
     */
    public static  ArrayList <ToyClass> convertingFromFile (String toysStr){        
        String[] strSplit = toysStr.split(";");
        String[] temp;
        ArrayList <ToyClass> toyss = new ArrayList<>();
        
        for (int i = 0; i < strSplit.length; i++) {
            toysStr = strSplit[i];
            temp = toysStr.split(", ");
            
            String name = temp[0];            
            int id = Integer.parseInt(temp[1]);
            int quantity = Integer.parseInt(temp[2]);
            int probability = (Integer.parseInt(temp[3]));
            
            toyss.add(new ToyClass(name, id, quantity, probability));
        }
        return toyss;        
    }        
}
