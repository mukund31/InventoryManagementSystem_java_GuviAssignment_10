# InventoryManagementSystem_java_GuviAssignment_10

---

## Features

- **Create New Inventory**: Create and configure new inventories with unique names and restock thresholds.
- **Switch Inventory**: Manage multiple inventories by switching between them.
- **Add Item**: Add items to the current inventory with a unique ID.
- **Update Item**: Update the quantity of existing items.
- **Search Item**: Search for items by their ID.
- **Delete Item**: Remove items from the inventory.
- **View Items by Category**: List all items in a specific category.
- **View Top k Items**: Display the top `k` items based on their quantity.
- **Merge Inventories**: Combine two inventories into one.
- **Multiple Inventory Management**: Seamlessly handle multiple inventories.

---

## Sample Output
```
---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 1

Enter name for the new inventory: Inventory-1
Enter restock threshold for this inventory: 14
Inventory 'Inventory-1' created and set as the current inventory.

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: Asus Laptop
Enter Item Category: electronics
Enter Item Quantity: 24
Item added successfully! Generated ID: 1

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: charger
Enter Item Category: electronics
Enter Item Quantity: 45
Item added successfully! Generated ID: 2

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: table
Enter Item Category: furniture
Enter Item Quantity: 34
Item added successfully! Generated ID: 3

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 8

Enter the value of k: 3
Top 3 items by quantity:
Item{ID='2', Name='charger', Category='electronics', Quantity=45}
Item{ID='3', Name='table', Category='furniture', Quantity=34}
Item{ID='1', Name='Asus Laptop', Category='electronics', Quantity=24}

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 4

Enter Item ID to update: 2
Enter new quantity: 12
Restock needed for item: Item{ID='2', Name='charger', Category='electronics', Quantity=12}
Item updated successfully!
!! Item restock alert !!

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 5

Enter Item ID to search: 3
Item found: Item{ID='3', Name='table', Category='furniture', Quantity=34}

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 6

Enter Item ID to delete: 2
Item deleted successfully

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: mouse
Enter Item Category: electronics
Enter Item Quantity: 51
Item added successfully! Generated ID: 4

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 7

Enter Category Name: electronics
Items in category 'electronics':
Item{ID='4', Name='mouse', Category='electronics', Quantity=51}
Item{ID='1', Name='Asus Laptop', Category='electronics', Quantity=24}

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 1

Enter name for the new inventory: Inventory-2
Enter restock threshold for this inventory: 24
Inventory 'Inventory-2' created and set as the current inventory.

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: apple
Enter Item Category: fruits
Enter Item Quantity: 35
Item added successfully! Generated ID: 5

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: banana
Enter Item Category: fruits
Enter Item Quantity: 46
Item added successfully! Generated ID: 6

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 3

Enter Item Name: pillow
Enter Item Category: household-items
Enter Item Quantity: 26
Item added successfully! Generated ID: 7

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 9

Available inventories: [Inventory-1, Inventory-2]
Enter the name of the first inventory to merge: Inventory-1
Enter the name of the second inventory to merge: Inventory-2
Inventories merged successfully!
Merged inventory 'Inventory-2' into 'Inventory-1'.

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 2

Available inventories: [Inventory-1, Inventory-2]
Enter the name of the inventory to switch to: Inventory-1
Switched to inventory: 'Inventory-1'.

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 8

Enter the value of k: 10
Top 10 items by quantity:
Item{ID='4', Name='mouse', Category='electronics', Quantity=51}
Item{ID='6', Name='banana', Category='fruits', Quantity=46}
Item{ID='5', Name='apple', Category='fruits', Quantity=35}
Item{ID='3', Name='table', Category='furniture', Quantity=34}
Item{ID='7', Name='pillow', Category='household-items', Quantity=26}
Item{ID='1', Name='Asus Laptop', Category='electronics', Quantity=24}

---------------------------
Inventory Management System
---------------------------
1. Create New Inventory
2. Switch Inventory
3. Add Item
4. Update Item
5. Search Item
6. Delete Item
7. View Items by Category
8. View Top k Items
9. Merge Inventories
10. Exit
Enter your choice: 10
Exiting the system. Goodbye!

Process finished with exit code 0
```