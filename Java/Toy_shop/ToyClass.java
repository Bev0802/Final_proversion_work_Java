package Java.Toy_shop;

/**
 * ToyClass - Класс игрушки.
 */
public class ToyClass {
    @Override
    public String toString() {
        return name+", "+ id +", "+ quantity +", "+ probability+";";
    }

    public String name; // - название игрушки
    public int id; // - id игрушки
    public int quantity; // - колличество игрушек
    public int probability; // - вероятность выпадения игрушки.

    /**
     * Контруктор Игрушки
     * 
     * @param name
     * @param id
     * @param quantity
     * @param probability
     */

    // int id = Methods.acssigningIdentifier();

    public ToyClass(String name, int id, int quantity, int probability) {
        this.name = name;
        this.quantity = quantity;
        this.id = id;
        this.probability = probability;
    }

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

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
