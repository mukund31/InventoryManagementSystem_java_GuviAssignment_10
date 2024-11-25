public class Item implements Comparable<Item> {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private String category;
    private int quantity;

    public Item(String name, String category, int quantity) {
        this.id = idCounter++;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(other.quantity, this.quantity);
    }

    @Override
    public String toString() {
        return "Item{ID='" + id + "', Name='" + name + "', Category='" + category + "', Quantity=" + quantity + '}';
    }
}
