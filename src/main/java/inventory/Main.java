package inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean condition = true;
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        inventory.INVENTORIES_PUSH_BASE();
        int option = 0;
        while (condition) {
            System.out.println("Ingrese una opción: ");
            System.out.println("1. Crear un nuevo producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Buscar un producto por nombre");
            System.out.println("4. Realizar una venta");
            System.out.println("5. Salir");
            option = sc.nextInt();
            if (option == 1) {
                System.out.println(inventory.save());
                System.out.println("");
            }
            if (option == 2) {
                System.out.println(inventory.showAll());
                System.out.println("");
            }
            if (option == 3) {
                System.out.println(inventory.showByName());
                System.out.println("");
            }
            if (option == 4) {
                System.out.println(inventory.sell());
            }
            if (option == 5) {
                condition = false;
            }

        }

    }
}