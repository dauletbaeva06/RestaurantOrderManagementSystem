import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// items on the menu
class MenuItem {
    private String name;
    private double price;
    private String category;

    // the menu item attributes
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // using getter
    // the item name
    public String getName() {
        return name;
    }

    // the item price
    public double getPrice() {
        return price;
    }

    // the item category
    public String getCategory() {
        return category;
    }

    // using setter
    // the item name
    public void setName(String name) {
        this.name = name;
    }

    // the item price
    public void setPrice(double price) {
        this.price = price;
    }

    // the item category
    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return String.format("MenuItem: %s, Price: %.2f, Category: %s", name, price, category);
    }
}

// a customer's order
class Order {
    private int orderId;
    private String customerName;
    private List<MenuItem> items;
    private String status;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.status = "Pending"; // Default status of order is Pending
    }

    // using getter
    // the order ID
    public int getOrderId() {
        return orderId;
    }

    // the customer's name
    public String getCustomerName() {
        return customerName;
    }

    // the list of items in the order
    public List<MenuItem> getItems() {
        return items;
    }

    // the order status
    public String getStatus() {
        return status;
    }

    // using setter
    //the order ID
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // the customer's name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // the order status
    public void setStatus(String status) {
        this.status = status;
    }

    // Add a menu item to the order
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Calculating the total price
    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public String toString() {
        String itemsStr = items.stream().map(MenuItem::getName).collect(Collectors.joining(", "));
        return String.format("Order ID: %d, Customer: %s, Items: [%s], Status: %s", orderId, customerName, itemsStr, status);
    }
}

// a restaurant with a menu and a list of orders
class Restaurant {
    private String name; // Name of the restaurant
    private List<MenuItem> menu; // List of menu items
    private List<Order> orders; // List of orders placed at the restaurant

    //the restaurant with a name
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>(); // Initialize an empty menu list
        this.orders = new ArrayList<>(); // Initialize an empty orders list
    }

    // using getter
    // the restaurant's name
    public String getName() {
        return name;
    }

    // the list of menu items
    public List<MenuItem> getMenu() {
        return menu;
    }

    // the list of orders
    public List<Order> getOrders() {
        return orders;
    }

    // using setter
    // the restaurant's name
    public void setName(String name) {
        this.name = name;
    }

    // Adding a menu item to the restaurant's menu
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Adding an order to the restaurant's list of orders
    public void addOrder(Order order) {
        orders.add(order);
    }

    public String toString() {
        return String.format("Restaurant: %s, Menu Items: %d, Orders: %d", name, menu.size(), orders.size());
    }
}


public class Main {
    public static void main(String[] args) {
        MenuItem item1 = new MenuItem("Cream Pasta", 4590, "Main Course");
        MenuItem item11 = new MenuItem("Lobster Risotto", 5690, "Main Course");
        MenuItem item2 = new MenuItem("Caviar Bisque", 4990, "Appetizer");
        MenuItem item21 = new MenuItem("Carpaccio", 3490, "Appetizer");
        MenuItem item3 = new MenuItem("Chocolate Soufflé", 3290, "Dessert");
        MenuItem item31 = new MenuItem("Opera Cake", 3890, "Dessert");

        // Creating orders for customers
        Order order1 = new Order(101, "Askhar");
        Order order2 = new Order(102, "Akbota");

        // Adding items to the first order
        order1.addItem(item1);
        order1.addItem(item21);
        order1.addItem(item3);

        // Adding items to the second order
        order2.addItem(item11);
        order2.addItem(item2);
        order2.addItem(item31);

        // a restaurant's name
        Restaurant restaurant = new Restaurant("La Dolce Vita");

        // Add all menu items to the restaurant's menu
        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item11);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item21);
        restaurant.addMenuItem(item3);
        restaurant.addMenuItem(item31);

        // Add orders to the restaurant
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);

        // output of restaurant details
        System.out.println(restaurant);

        // output of the full menu
        System.out.println("MENU:");
        restaurant.getMenu().forEach(System.out::println);

        // output of details of the first order and its total cost
        System.out.println();
        System.out.println(order1);
        System.out.println("Total for Order 1: " + order1.calculateTotal() + "tg");

        // output of details of the second order and its total cost
        System.out.println();
        System.out.println(order2);
        System.out.println("Total for Order 2: " + order2.calculateTotal() + "tg");
    }
}
