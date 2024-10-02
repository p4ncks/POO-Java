import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Adicionar um novo produto.");
            System.out.println("2. Remover um produto.");
            System.out.println("3. Ver produtos.");
            System.out.println("4. Sair.");
            System.out.print("Escolher uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Insira o nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Insira a quantidade do produto: ");
                    int quantity = scanner.nextInt();
                    store.addProduct(new Product(name, quantity));
                    break;
                case 2:
                    System.out.print("Insira o nome do produto que deseja remover: ");
                    String removeName = scanner.nextLine();
                    store.removeProduct(removeName);
                    break;
                case 3:
                    store.viewProducts();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        scanner.close();
    }
}
