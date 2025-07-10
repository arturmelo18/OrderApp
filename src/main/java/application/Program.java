package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Order;
import model.entities.OrderStatus;
import model.entities.Product;
import model.entities.UsedProduct;
import model.exceptions.OrderException;

public class Program{

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        
        //Creating the lists that I will use in this application
        String path = "/home/artur/Documentos/Vscode_projects/Java/TesteLambda/Products.txt";
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            //Reading products from a file
            String line = br.readLine();
            while(line != null){
                String[]fields = line.split(",");
                products.add(new UsedProduct(
                    Integer.valueOf(fields[0]),
                    fields[1],
                    Double.valueOf(fields[2]),
                    Integer.valueOf(fields[3]),
                    fields[4].charAt(0),
                    LocalDate.parse(fields[5])
                ));
                line = br.readLine();
            }
            int option = 0;
            do { 
                //Showing the menu to users
                System.out.println("=======================================");
                System.out.println("1)Place an order");
                System.out.println("2)See the products");
                System.out.println("3)See the orders");
                System.out.println("4)Exit the application");
                System.out.println("=======================================");
                System.out.println("Select an option:");
                option = sc.nextInt();

                switch(option){
                    case 1 -> {
                        products.forEach(System.out::println);
                        System.out.println("These are the products available in our store");
                        System.out.println("Please, select the product ID and the product's quantity");
                        char keep = 's';
                        Order order = new Order(1, OrderStatus.PROCESSING);
                        while(keep == 's'){
                            System.out.println("Enter the product ID:");
                            int id = sc.nextInt();
                            System.out.println("Enter the product quantity:");
                            int quantity = sc.nextInt();
                            Product p1 = products.stream().filter(p -> p.getId() == id).findFirst().get();
                            p1.setQuantity(quantity);
                            order.addProducts(p1);
                            System.out.println("Do you want to add another product in your order? (s/n)");
                            sc.nextLine();
                            keep = sc.nextLine().toLowerCase().charAt(0);
                        }
                        orders.add(order);
                        System.out.println("Your order has been accepted, you will receive it soon!");
                    }
                    case 2 -> products.forEach(System.out::println);
                    case 3 -> orders.forEach(System.out::println);
                    case 4 -> System.out.println("Thank you for using this app and see you soon!");
                    default -> System.out.println("Choose a correct option!");
                }
            } while (option != 4);
        } catch(IOException | OrderException e){
            e.printStackTrace();
        } catch(RuntimeException e){
            e.printStackTrace();
        } finally{
            sc.close();
        }
    }

}