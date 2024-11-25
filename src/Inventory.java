import java.util.*;

public class Inventory {
    private Map<Integer, Item> inventory;
    private Map<String, TreeSet<Item>> categoryMap;
    private int restockThreshold;

    public Inventory(int restockThreshold) {
        this.inventory = new HashMap<>();
        this.categoryMap = new HashMap<>();
        this.restockThreshold = restockThreshold;
    }

    public Map<Integer, Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        if (inventory.containsKey(item.getId())) {
            System.out.println("Item with ID " + item.getId() + " already exists. Use updateItem instead.");
            return;
        }
        inventory.put(item.getId(), item);
        categoryMap.computeIfAbsent(item.getCategory(), k -> new TreeSet<>()).add(item);
        checkRestock(item);
    }

    public void updateItem(int id, int newQuantity) {
        Item item = inventory.get(id);
        if (item == null) {
            System.out.println("Item with ID " + id + " does not exist.");
            return;
        }
        categoryMap.get(item.getCategory()).remove(item);
        item.setQuantity(newQuantity);
        categoryMap.get(item.getCategory()).add(item);
        checkRestock(item);
        System.out.println("Item updated successfully!");
        if(newQuantity<restockThreshold)
            System.out.println("!! Item restock alert !!");
    }

    public Item searchItemById(int id) {
        return inventory.get(id);
    }

    public int deleteItem(int id) {
        Item item = inventory.remove(id);
        if (item != null) {
            categoryMap.get(item.getCategory()).remove(item);
            return 1;
        }
        return 0;
    }

    public List<Item> getCategoryItems(String category) {
        TreeSet<Item> items = categoryMap.get(category);
        return (items == null) ? Collections.emptyList() : new ArrayList<>(items);
    }

    public List<Item> getTopKItems(int k) {
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(Item::getQuantity).reversed());
        pq.addAll(inventory.values());
        List<Item> topItems = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            topItems.add(pq.poll());
        }
        return topItems;
    }

    private void checkRestock(Item item) {
        if (item.getQuantity() < restockThreshold) {
            System.out.println("Restock needed for item: " + item);
        }
    }

    public void mergeInventory(Map<Integer, Item> otherInventory) {
        for (Map.Entry<Integer, Item> entry : otherInventory.entrySet()) {
            int id = entry.getKey();
            Item otherItem = entry.getValue();

            if (this.inventory.containsKey(id)) {
                // If duplicate ID exists, retain the item with the higher quantity
                Item existingItem = this.inventory.get(id);
                if (otherItem.getQuantity() > existingItem.getQuantity()) {
                    this.inventory.put(id, otherItem); // Replace with the higher quantity item
                }
            } else {
                // Add the item if ID does not exist
                this.inventory.put(id, otherItem);
            }
        }
        System.out.println("Inventories merged successfully!");
    }

}
