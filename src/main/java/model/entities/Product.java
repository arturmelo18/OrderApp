package model.entities;

public abstract class Product{

    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private char type;

    public Product(){
    }

    public Product(Integer id, String name, Double price, Integer quantity, char type){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public char getType(){
        return type;
    }

    public void setType(char type){
        this.type = type;
    }
}