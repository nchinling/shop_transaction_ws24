package sg.ed.nus.iss.transactions.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class Order {
    
    private Integer orderId;
    private LocalDate orderDate;
    private String customerName;
    private String shipAddress;
    private String notes; 
    private Double tax;
    private Integer total;
    public List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
    
    public Order() {
    }

    public Order(Integer orderId, LocalDate orderDate, String customerName, String shipAddress, String notes,
            Double tax, Integer total, List<OrderDetails> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.shipAddress = shipAddress;
        this.notes = notes;
        this.tax = tax;
        this.total = total;
        this.orderDetails = orderDetails;
    }



    public void setTax(Double tax) {
        this.tax = tax;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerName=" + customerName
                + ", shipAddress=" + shipAddress + ", notes=" + notes + ", tax=" + tax + ", orderDetails="
                + orderDetails + "]";
    }

    public Integer getTotal() {
        return orderDetails.size();
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    

    


}
