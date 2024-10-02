import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produto adicionado: " + product);
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        System.out.println("Produto removido: " + name);
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("Não há produtos na loja.");
        } else {
            products.forEach(System.out::println);
        }
    }
}
