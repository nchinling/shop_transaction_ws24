package sg.ed.nus.iss.transactions.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import sg.ed.nus.iss.transactions.model.Order;
import sg.ed.nus.iss.transactions.model.OrderDetails;
import sg.ed.nus.iss.transactions.service.OrderException;
import sg.ed.nus.iss.transactions.service.OrderService;

@Controller
@RequestMapping
public class AppController {
    
    boolean reset = false;
    @Autowired
    OrderService orderservice;

    @PostMapping(path = "/add", consumes =  "application/x-www-form-urlencoded")
    public String addOrder(HttpServletRequest httpRequest, Model m, HttpSession session){

        if (reset == true){
            reset = false;
            List<OrderDetails> orderdetails = (List<OrderDetails>) session.getAttribute("orderdetails");
            orderdetails.clear();
            session.setAttribute("orderdetails", orderdetails);
        }
        List<OrderDetails> orderdetails = (List<OrderDetails>) session.getAttribute("orderdetails");
        if(null == orderdetails){
            orderdetails = new ArrayList<OrderDetails>();
            session.setAttribute("orderdetails", orderdetails);
        }

        String item = httpRequest.getParameter("item");
        Integer quantity = Integer.parseInt(httpRequest.getParameter("quantity"));

        orderdetails.add(new OrderDetails(item, quantity));

        //add in cart item info to order
        Order order = new Order();
        order.setOrderDetails(orderdetails);
        session.setAttribute("order", order);

        m.addAttribute("orderdetails", orderdetails);
        
        return "cart_template";
    }

    @PostMapping(path = "/checkout")
    public String checkoutOrder(HttpServletRequest httpRequest, Model m, HttpSession session) throws OrderException{
        
        List<OrderDetails> orderdetails = (List<OrderDetails>) session.getAttribute("orderdetails");
        String name = httpRequest.getParameter("name");
        String shipAddress = httpRequest.getParameter("ship_address");
        String notes = httpRequest.getParameter("notes");


        //retrieve order session which was set in previous controller
        Order order = (Order) session.getAttribute("order");

        //place form info into model
        order.setCustomerName(name);
        order.setShipAddress(shipAddress);
        order.setNotes(notes);
        orderservice.createOrder(order);
        m.addAttribute("order", order);

        // orderdetails.clear();
        // session.setAttribute("orderdetails", orderdetails);

        reset = true;
        return "checkout";

    }


    @ExceptionHandler(OrderException.class)
    public String handleOrderException(OrderException e, Model m){
        m.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

}



