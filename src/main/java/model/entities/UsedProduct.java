package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate productionDate;

    public UsedProduct(){
    }

    public UsedProduct(Integer id, String name, Double price, Integer quantity, char type, LocalDate productionDate){
        super(id, name, price, quantity, type);
        this.productionDate = productionDate;
    }

    public LocalDate getProductionDate(){
        return productionDate;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=========== USED PRODUCT===========\n");
        sb.append("Id: " + getId() + "\n");
        sb.append("Name: " + getName() + "\n");
        sb.append("Price: $" + getPrice() + "\n");
        sb.append("Quantity: " + getQuantity() + "\n");
        sb.append("Production date: " + getProductionDate().format(dtf));
        return sb.toString();
    }
}