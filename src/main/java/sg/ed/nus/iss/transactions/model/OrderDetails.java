package sg.ed.nus.iss.transactions.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
    
    private Integer id; 
    private String product;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;
    

    public List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
    
    public OrderDetails() {
    }

    public OrderDetails(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderDetails(Integer id, String product, Integer quantity, Double unitPrice, Double discount) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    
    @Override
    public String toString() {
        return "OrderDetails [id=" + id + ", product=" + product + ", unitPrice=" + unitPrice + ", discount=" + discount
                + "]";
    }



}
