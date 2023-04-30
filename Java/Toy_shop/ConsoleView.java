package Java.Toy_shop;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import Java.Toy_shop.Methods;

public class ConsoleView {   
   
    public static Scanner sc = new Scanner(System.in, "cp866");
    
    public static void view(){      
        ArrayList<ToyClass> toys = new ArrayList<ToyClass>();
        toys = Methods.creatingListToys();

        System.out.println("\nЭТО ПРОГРАММА РОЗЫГРЫША ИГРУШЕК\n\nЕсли вы хотите поучаствовать нажмите Enter. \nДля выхода нажниме любой символ.");
        String command = sc.nextLine();
        if (command.equalsIgnoreCase("")){
            System.out.println("Розыгрываются следующие игрушки: \n");
            Methods.nameListToys(toys);
            System.out.println("Вы можете добавить еще игрушки для розыгрыша. Если хотите добавить еще игрушки нажмите Enter.\n Для продолжения розыгрыша введите любой символ.");
            command = sc.nextLine();
            if (command.equalsIgnoreCase("")){
                toys = Methods.addToy(toys);
                System.out.println("Теперь розыгрываются следующие игрушки: \n");
                Methods.nameListToys(toys);
            }
        System.out.println("\nУДАЧИ!");

        ArrayList<Integer> id = Methods.ListToysIdProbability(toys);
        String lottery = Methods.lotteryToy(id, toys);

        System.out.printf("\nПОЗДРАВЛЯЕМ!!!!\n ВЫ ВЫИГРАЛИ: %s", lottery);            
        }        
    }

    public static String nameToy(){                       
        System.out.println("Введите название игрушки: ");
        String name = sc.nextLine();    
        
        return name;
    }

    public static int quantityToy(){
        System.out.println("Введите количестов игрушек: ");
        int quantity = Integer.parseInt(sc.nextLine());    
        
        return quantity;
    }



    
}
