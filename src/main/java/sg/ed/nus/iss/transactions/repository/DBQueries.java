package sg.ed.nus.iss.transactions.repository;

public class DBQueries {
    public static final String GET_ALL_PRODUCTS = "select * from products";
    public static final String INSERT_ORDER = "insert into orders(order_id, order_date, customer_name, ship_address, notes, tax)"
                                                        +" values (?, SYSDATE(), ?, ? ,?, 0.05)";
    public static final String INSERT_ORDER_DETAILS = "insert into order_details(product, unit_price,"
                                                    +" quantity, order_id)"
                                                    +" values (?, ?, ? ,?)";
    
}



