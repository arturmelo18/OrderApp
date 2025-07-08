package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.entities.Order;
import model.entities.Product;
import model.entities.UsedProduct;
import model.exceptions.OrderException;

public class Program{

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String path = "/home/artur/Documentos/Vscode_projects/Java/TesteLambda";
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            
            String line = br.readLine();
            while(line != null){
                String[]fields = line.split(",");
                products.add(new UsedProduct(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    Double.parseDouble(fields[2]),
                    Integer.parseInt(fields[3]),
                    fields[4].charAt(0),
                    LocalDate.parse(fields[5], dtf)
                ));
                line = br.readLine();
            }
            products.forEach(System.out::println);
        } catch(IOException | OrderException e){
            System.out.println(e.getMessage());
        } catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }

}