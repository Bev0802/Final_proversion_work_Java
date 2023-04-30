package  Java.Toy_shop;
import Java.Toy_shop.Methods;

/**
 * ToyClass - Класс игрушки.
 */
public class ToyClass {
    @Override
    public String toString() {
        return name + ", id: " + id + ", количество: " + quantity + ", вероятноть: " + probability;
    }

    public String name;          // - название игрушки
    public int id;               // - id игрушки
    public int quantity;         // - колличество игрушек
    public float probability;    // - вероятность выпадения игрушки.
    
    /**
     * Контруктор Игрушки
     * @param name
     * @param id
     * @param quantity
     * @param probability
     */

    //int id = Methods.acssigningIdentifier();

    public ToyClass(String name, int id, int quantity, float probability) {
        this.name = name;       
        this.quantity = quantity;
        this.id = id;
        this.probability = probability;
    }    

    // probability = Methods.acssigningProbability();
    // id = Methods.acssigningIdentifier();
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }
}
