import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    private static final Map<String, Inventory> inventories = new HashMap<>();
    private static Inventory currentInventory = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---------------------------");
            System.out.println("Inventory Management System");
            System.out.println("---------------------------");
            System.out.println("1. Create New Inventory");
            System.out.println("2. Switch Inventory");
            System.out.println("3. Add Item");
            System.out.println("4. Update Item");
            System.out.println("5. Search Item");
            System.out.println("6. Delete Item");
            System.out.println("7. View Items by Category");
            System.out.println("8. View Top k Items");
            System.out.println("9. Merge Inventories");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createNewInventory(sc);
                case 2 -> switchInventory(sc);
                case 3 -> handleIfCurrent(() -> addItem(currentInventory, sc));
                case 4 -> handleIfCurrent(() -> updateItem(currentInventory, sc));
                case 5 -> handleIfCurrent(() -> searchItem(currentInventory, sc));
                case 6 -> handleIfCurrent(() -> deleteItem(currentInventory, sc));
                case 7 -> handleIfCurrent(() -> viewItemsByCategory(currentInventory, sc));
                case 8 -> handleIfCurrent(() -> viewTopKItems(currentInventory, sc));
                case 9 -> mergeInventories(sc);
                case 10 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createNewInventory(Scanner sc) {
        System.out.print("\nEnter name for the new inventory: ");
        String name = sc.nextLine();
        if (inventories.containsKey(name)) {
            System.out.println("An inventory with this name already exists.");
            return;
        }
        System.out.print("Enter restock threshold for this inventory: ");
        int restockThreshold = sc.nextInt();
        sc.nextLine();

        Inventory newInventory = new Inventory(restockThreshold);
        inventories.put(name, newInventory);
        currentInventory = newInventory;
        System.out.println("Inventory '" + name + "' created and set as the current inventory.");
    }

    private static void switchInventory(Scanner sc) {
        System.out.print("\nAvailable inventories: " + inventories.keySet());
        System.out.print("\nEnter the name of the inventory to switch to: ");
        String name = sc.nextLine();
        Inventory selectedInventory = inventories.get(name);

        if (selectedInventory == null) {
            System.out.println("No inventory found with the name '" + name + "'.");
        } else {
            currentInventory = selectedInventory;
            System.out.println("Switched to inventory: '" + name + "'.");
        }
    }

    private static void handleIfCurrent(Runnable task) {
        if (currentInventory == null) {
            System.out.println("No inventory selected. Please create or switch to an inventory first.");
        } else {
            task.run();
        }
    }

    private static void addItem(Inventory manager, Scanner sc) {
        System.out.print("\nEnter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Item Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Item Quantity: ");
        int quantity = sc.nextInt();

        Item item = new Item(name, category, quantity);
        manager.addItem(item);
        System.out.println("Item added successfully! Generated ID: " + item.getId());
    }


    private static void updateItem(Inventory manager, Scanner sc) {
        System.out.print("\nEnter Item ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = sc.nextInt();

        manager.updateItem(id, quantity);
    }

    private static void searchItem(Inventory manager, Scanner sc) {
        System.out.print("\nEnter Item ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        Item item = manager.searchItemById(id);
        if (item != null) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("Item with ID " + id + " does not exist.");
        }
    }

    private static void deleteItem(Inventory manager, Scanner sc) {
        System.out.print("\nEnter Item ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if(manager.deleteItem(id)==1)
            System.out.println("Item deleted successfully");
        else
            System.out.printf("Item with id %d does not exist\n",id);
    }

    private static void viewItemsByCategory(Inventory manager, Scanner sc) {
        System.out.print("\nEnter Category Name: ");
        String category = sc.nextLine();

        System.out.println("Items in category '" + category + "':");
        for (Item item : manager.getCategoryItems(category)) {
            System.out.println(item);
        }
    }

    private static void viewTopKItems(Inventory manager, Scanner sc) {
        System.out.print("\nEnter the value of k: ");
        int k = sc.nextInt();

        System.out.println("Top " + k + " items by quantity:");
        for (Item item : manager.getTopKItems(k)) {
            System.out.println(item);
        }
    }

    private static void mergeInventories(Scanner sc) {
        System.out.print("\nAvailable inventories: " + inventories.keySet());
        System.out.print("\nEnter the name of the first inventory to merge: ");
        String firstInventoryName = sc.nextLine();
        Inventory firstInventory = inventories.get(firstInventoryName);

        System.out.print("Enter the name of the second inventory to merge: ");
        String secondInventoryName = sc.nextLine();
        Inventory secondInventory = inventories.get(secondInventoryName);

        if (firstInventory == null || secondInventory == null) {
            System.out.println("One or both inventories not found. Merge operation aborted.");
            return;
        }

        firstInventory.mergeInventory(secondInventory.getInventory());
        System.out.println("Merged inventory '" + secondInventoryName + "' into '" + firstInventoryName + "'.");
    }
}
