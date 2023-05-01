package Java.Toy_shop;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.Format;
public class FileExportImport {
public static File filetoylist = new File("ToysList.txt");
public static ArrayList<ToyClass> toys = new ArrayList<>();
public static String toyStr = "";

    /**
     * @return метод проверяет есть ли файл и есть ли в нем данные и возравщает true, если есть.
     */
    public static boolean checkingFile(){
        boolean checkingFile = true;
        if ((!filetoylist.exists()) || ((filetoylist.length()==0))){             
            checkingFile = false;        
        }
        return checkingFile;
    }

    /**
     * Создание и запись нового файла, если его еще нет.
     */
    public static void CreateFileToys ()
    {
        toys = Methods.creatingListToys();
        String toyStr = "";

        try{
        filetoylist.createNewFile();
        FileWriter toyWriter = new FileWriter (filetoylist);        
        for (int i = 0; i < toys.size(); i++) {
            toyStr = toys.get(i).toString();            
            toyWriter.write(toyStr);            
            toyWriter.flush();
        }

        toyWriter.close();

        } catch(Exception e){
            System.out.println("Ошибка!");
        }          
    }

    /**обновляет данные в файле.
     * @param ToyClass toy 
     */
    public static void AddFileToy(ArrayList<ToyClass> toys){ 
        try{
        FileWriter toyWriter = new FileWriter (filetoylist);
        //BufferedWriter toyBufWr = new BufferedWriter(toyWriter);
        for (int i = 0; i < toys.size(); i++) {
            toyStr = toys.get(i).toString();            
            toyWriter.write(toyStr);
            toyWriter.flush();
        }

        toyWriter.close();

        }catch(Exception e){
            System.out.println("Ошибка!");
        }
    }    

    /**
     * @return метод читает данные из файла и возвращает строку.
     */
    public static String ReadFileToy(){
        String toysStr = "";        
        try{
            FileReader fileReader = new FileReader(filetoylist);
            BufferedReader toyBufRead = new BufferedReader(fileReader);                                
            while (toyBufRead.ready()){                
                toysStr = toyBufRead.readLine();                                
            }            
            toyBufRead.close();
        }catch(Exception e){            
            System.out.println("Ошибка!");
        }       
        return toysStr;
    }  

}