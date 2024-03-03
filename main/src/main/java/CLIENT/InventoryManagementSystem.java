package CLIENT;

import DTO.ProductRequest;

import java.util.Scanner;


public class InventoryManagementSystem {
    public class InventoryManagementSystemsg {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inventory Management System");
            System.out.println("1. Add product");
            System.out.println("2, Display all products");
            System.out.println("3, Notify for low stock product");
            System.out.println("4, Add category");
            System.out.println("5 display all categories");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //createproduct
                    break;
                case 2:
                    //displayAllProduct
            }
        }

        public static void createProduct(Scanner scanner) {
            ProductRequest productRequest = new ProductRequest();
            System.out.println("Vendosni emrin e produktit");
            productRequest.setTitle(scanner.next());

            //productService.createProduct(productRequest)

        }
    }
}
