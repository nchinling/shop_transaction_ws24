package sg.ed.nus.iss.transactions.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.ed.nus.iss.transactions.model.Order;
import sg.ed.nus.iss.transactions.model.OrderDetails;

import static sg.ed.nus.iss.transactions.repository.DBQueries.*;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class OrderRepository {
    
    @Autowired 
    JdbcTemplate jdbcTemplate;

    public static BigDecimal discount;

    public boolean insertOrder(Order order){

        return jdbcTemplate.update(INSERT_ORDER, order.getOrderId(), order.getCustomerName(), 
                                order.getShipAddress(), order.getNotes()) > 0;
    }

    public void insertOrderDetails(List<OrderDetails> orderdetails, String orderId){
        
        List<Object[]> data = orderdetails.stream().map(li ->{

            Object[] l = new Object[4];
            l[0] = li.getProduct();
            // l[1] = OrderUtility.calculateUnitPrice(li.getProduct(), li.getQuantity());
            l[1] = 2; // unit price
            l[2] = li.getQuantity();
            l[3] = orderId;
            return l;

        }).toList();
    
        jdbcTemplate.batchUpdate(INSERT_ORDER_DETAILS, data) ;

    }



   

    
}
