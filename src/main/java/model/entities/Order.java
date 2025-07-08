package model.entities;

import java.util.List;

import model.exceptions.OrderException;

public class Order{

    private Integer id;
    private OrderStatus orderStatus;
    private List<Product> products;

    public Order(){
    }
    
    public Order(Integer id, OrderStatus orderStatus){
        this.id = id;
        this.orderStatus = orderStatus;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getOrderStatus(){
        return orderStatus.toString();
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus = OrderStatus.valueOf(orderStatus);
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProducts(Product product){
        products.add(product);
        System.out.println("Product added");
    }

    public String removeProducts(Product product){
        for(Product p:products){
            if(p == product){
                products.remove(product);
                return "Product removed";
            }
        }
        throw new OrderException("Product not found");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("========ORDER========");
        sb.append("Id: " + getId() + "\n");
        sb.append("OrderStatus: " + getOrderStatus() + "\n");
        sb.append("Products:\n");
        for(Product p:products){
            sb.append(p.getName());
        }
        return sb.toString();
    }
}