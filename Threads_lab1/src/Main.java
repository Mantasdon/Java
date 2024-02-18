import java.util.ArrayList;
import java.util.List;

// Prekės klasė
class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Synchronized metodas prekių kiekiui pakeisti
    public synchronized void decreaseQuantity() {
        quantity--;
    }
    /*public synchronized void decreaseQuantity() {
        quantity--;
    }*/
}

// Parduotuvės klasė
class OnlineStore {
    private List<Product> products;

    public OnlineStore() {
        products = new ArrayList<>();
        products.add(new Product("Telefonas", 10000));
        products.add(new Product("Televizorius", 10000));
        products.add(new Product("Nešiojamas kompiuteris", 10000));
    }

    // Synchronized metodas prekių pirkimui
    public synchronized void buyProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {

                for(int i = 0; i < quantity; i++){
                    product.decreaseQuantity();
                }

                return;
            }
        }
        System.out.println("Tokios prekės nėra parduotuvėje: " + productName);
    }

    /*    public synchronized void buyProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {

                for(int i = 0; i < quantity; i++){
                    product.decreaseQuantity();
                }

                return;
            }
        }
        System.out.println("Tokios prekės nėra parduotuvėje: " + productName);
    }*/

    // Synchronized metodas grąžinti prekių sąrašą
    public synchronized List<Product> getProducts() {
        return products;
    }
    /*public List<Product> getProducts() {
        return products;
    }*/
}

// Pirkėjo gija
class Customer extends Thread {
    private OnlineStore store;
    private String productName;
    private int quantity;

    public Customer(OnlineStore store, String productName, int quantity) {
        this.store = store;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Pirkimo veiksmas
    public void run() {
        store.buyProduct(productName, quantity);
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        // Pirkėjų gijų kūrimas ir paleidimas
        Customer customer1 = new Customer(store, "Telefonas", 6666);
        Customer customer2 = new Customer(store, "Televizorius", 6666);
        Customer customer3 = new Customer(store, "Nešiojamas kompiuteris", 1000);
        Customer customer4 = new Customer(store, "Nešiojamas kompiuteris", 1000);


        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();

        // Laukiame, kol visos gijos baigs darbą


        // Išvedame likusias prekių atsargas
        System.out.println("Likusios prekių atsargos:");
        for (Product product : store.getProducts()) {
            System.out.println(product.getName() + ": " + product.getQuantity());
        }
    }
}
