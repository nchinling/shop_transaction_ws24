package sg.ed.nus.iss.transactions.service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.ed.nus.iss.transactions.model.Order;
import sg.ed.nus.iss.transactions.model.OrderDetails;
import sg.ed.nus.iss.transactions.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderrepo;
    
    @Transactional(rollbackFor = OrderException.class)
    public void createOrder(Order order) throws OrderException{

        //create order id. 
        Random rand = new Random();
        Integer ordId = rand.nextInt(10000000);
        String orderId = String.valueOf(ordId);

        order.setOrderId(ordId);

        // retrieves list of products from purchase order details
        OrderDetails.orderDetails = orderrepo.getProducts();

        //insert order info eg. customer name, ship_addressm notes into order table
        orderrepo.insertOrder(order);

        if (order.getOrderDetails().size() > 5){
            throw new OrderException("Can not order more than 5 items");
        }

        //insert order i.e. fruit order info into (purchase) order_details table
        orderrepo.insertOrderDetails(order.getOrderDetails(), orderId);

    
    }
}
