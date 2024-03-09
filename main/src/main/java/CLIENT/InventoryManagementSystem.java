package CLIENT;

import DTO.CategoryRequest;
import DTO.ProductRequest;
import ENTITY.Category;
import ENTITY.Product;
import SERVICE.CategoryService;
import SERVICE.CategoryServiceIMPL;
import SERVICE.ProductService;
import SERVICE.ProductServiceIMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InventoryManagementSystem {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inventory Management System");
            System.out.println("1. Add product");
            System.out.println("2, Display all products");
            System.out.println("3, Notify for low stock product");
            System.out.println("4, Add category");
            System.out.println("5 Display all categories");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createProduct(sc);
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    notifyLowStock();
                    break;
                case 4:
                    createCategory(sc);
                    break;
            }
        }

    private static void displayAllProducts() {
        ProductService productService = new ProductServiceIMPL();
        List<Product> getAllProducts = productService.findAll();
        for (Product product:getAllProducts){
            System.out.println(product);
        }
    }

    public static void createProduct(Scanner scanner) {
        ProductRequest productRequest = new ProductRequest();
        System.out.println("Name the Product");
        productRequest.setTitle(scanner.next());
        System.out.println("Description");
        productRequest.setDescription(scanner.next());
        System.out.println("Category ID");
        productRequest.setCategory(scanner.nextLong());
        System.out.println("Product price");
        productRequest.setPrice(scanner.nextLong());
        System.out.println("Product quantity");
        productRequest.setQuantity(scanner.nextInt());
        ProductService productService = new ProductServiceIMPL();
        productService.createProduct(productRequest);
    }

    public static void notifyLowStock(){


    }

    public static void createCategory(Scanner scanner){

        CategoryRequest categoryRequest=new CategoryRequest();
        System.out.println("Put category id");
        categoryRequest.setId(scanner.nextLong());
        System.out.println("Put category title");
        categoryRequest.setTitle(scanner.next());
        categoryRequest.setCreatedAt(LocalDateTime.now());
        categoryRequest.setUpdatedAt(LocalDateTime.now());


        CategoryService categoryService = new CategoryServiceIMPL();
        categoryService.createCategory(categoryRequest);

    }



}
