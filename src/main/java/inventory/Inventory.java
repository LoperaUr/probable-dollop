package inventory;


import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Inventory {
    private String name;
    private Double price;
    private String reference;
    private Integer quantity;

    private ArrayList<Inventory> inventories = new ArrayList<>();


    public Inventory(String name, Double price, String reference, Integer quantity) {
        this.name = name;
        this.price = price;
        this.reference = reference;
        this.quantity = quantity;
    }

    public void INVENTORIES_PUSH_BASE () {
        inventories.addAll(Arrays.asList(
                new Inventory("Producto 1", 100.0, "Referencia 1", 10),
                new Inventory("Producto 2", 200.0, "Referencia 2", 20),
                new Inventory("Producto 3", 300.0, "Referencia 3", 30),
                new Inventory("Producto 4", 400.0, "Referencia 4", 40),
                new Inventory("Producto 5", 500.0, "Referencia 5", 50)
        ));
    }

    public String save() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto: ");
        String name = sc.nextLine();

        System.out.println("Ingrese el precio del producto: ");
        Double price = sc.nextDouble();

        System.out.println("Ingrese la referencia del producto: ");
        String reference = sc.next();

        System.out.println("Ingrese la cantidad del producto: ");
        Integer quantity = sc.nextInt();

        Inventory inventory = new Inventory(name, price, reference, quantity);

        inventories.add(inventory);

        return "Producto creado";
    }

    public String showAll() {
        if (inventories.isEmpty()) {
            return "No hay productos";
        }
        for (int i = 1; i < inventories.size() + 1; i++) {
            System.out.println("Producto " + i + ": " + "\n" +
                    "Nombre: " + inventories.get(i - 1).getName() + "\n" +
                    "Precio: " + inventories.get(i - 1).getPrice() + "\n" +
                    "Referencia: " + inventories.get(i - 1).getReference() + "\n" +
                    "Cantidad: " + inventories.get(i - 1).getQuantity() + "\n"
            );
        }
        return "Productos mostrados";
    }

    public String showByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        String name = sc.nextLine();
        for (int i = 0; i < inventories.size(); i++) {
            if (inventories.get(i).getName().equals(name)) {
                System.out.println("Producto " + (i + 1) + ": " + "\n" +
                        "Nombre: " + inventories.get(i).getName() + "\n" +
                        "Precio: " + inventories.get(i).getPrice() + "\n" +
                        "Referencia: " + inventories.get(i).getReference() + "\n" +
                        "Cantidad: " + inventories.get(i).getQuantity() + "\n"

                );
                return "Producto mostrado";
            }
        }

        return "Producto no encontrado en el inventario";

    }

    public String sell() {
        Scanner sc = new Scanner(System.in);

        boolean condition = true;
        double total = 0.0;
        while (condition) {
            System.out.println("Ingrese el nombre del producto: ");
            String name = sc.nextLine();
            for (int i = 0; i < inventories.size(); i++) {
                if (inventories.get(i).getName().equals(name)) {
                    System.out.println("Producto " + (i + 1) + ": " + "\n" +
                            "Nombre: " + inventories.get(i).getName() + "\n" +
                            "Precio: " + inventories.get(i).getPrice() + "\n" +
                            "Referencia: " + inventories.get(i).getReference() + "\n" +
                            "Cantidad: " + inventories.get(i).getQuantity() + "\n"

                    );
                    System.out.println("Ingrese la cantidad a comprar: ");
                    Integer quantity = sc.nextInt();
                    if (quantity > inventories.get(i).getQuantity()) {
                        return "No hay suficientes productos en el inventario";
                    }
                    inventories.get(i).setQuantity(inventories.get(i).getQuantity() - quantity);
                    total += inventories.get(i).getPrice() * quantity;
                    System.out.println("Subtotal: " + total);
                    System.out.println("¿Desea seguir comprando? (S/N)");
                    String answer = sc.next();
                    if (answer.equalsIgnoreCase("n")) {
                        condition = false;
                        System.out.println("Con cuánto va a pagar?");
                        double pay = sc.nextDouble();
                        if (pay < total) {
                            return "No le alcanza para pagar";
                        }
                        System.out.println("Su cambio es: " + (pay - total));
                    }
                }
            }

        }
        return "Venta realizada, total: " + total;
    }
}



