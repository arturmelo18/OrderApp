package model.entities;

public class ImportedProduct extends Product{

    private Double tax;

    public ImportedProduct(){
    }

    public ImportedProduct(Integer id, String name, Double price, Integer quantity, char type, Double tax){
        super(id, name, price, quantity, type);
        this.tax = tax;
    }

    public Double getTax(){
        return tax;
    }

    public void setTax(Double tax){
        this.tax = tax;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=========== IMPORTED PRODUCT===========\n");
        sb.append("Id: " + getId() + "\n");
        sb.append("Name: " + getName() + "\n");
        sb.append("Price: $" + getPrice() + "\n");
        sb.append("Quantity: " + getQuantity() + "\n");
        sb.append("Tax: $" + getTax());
        return sb.toString();
    }
}