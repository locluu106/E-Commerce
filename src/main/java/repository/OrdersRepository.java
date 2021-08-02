package repository;

import entity.OrdersEntity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {

    @Query(value = "SELECT * FROM ecomdb.orders o "
            + "join ecomdb.orderdetails f "
            + "on o.orderId=f.orderId "
            + "where o.orderId=?1", nativeQuery = true)
    List<OrdersEntity> getOrderUser(int id);

    @Query(value = "SELECT * FROM ecomdb.orders oder_1 "
            + "join ecomdb.user user_1 "
            + "on user_1.userId=oder_1.userId "
            + "where user_1.userId=?1", nativeQuery = true)
    List<OrdersEntity> getOrderByUser(int userId);

    @Query(value = " SELECT * FROM ecomdb.orders order_1 "
            + "join ecomdb.user user_1 "
            + "on order_1.userId = user_1.userId "
            + "join ecomdb.customer customer_1 "
            + "on user_1.customerId= customer_1.customerId "
            + "where order_1.orderStatus  Like %?1% "
            + "or customer_1.address like %?2% "
            + "GROUP BY order_1.shippingAddress,customer_1.address", nativeQuery = true)
    List<OrdersEntity> searchOrders(String shippingAddress, String orderStatus);

    List<OrdersEntity> findByOrderDateBetween(LocalDate dateForm, LocalDate dateTo);

    @Query(value = "SELECT * FROM ecomdb.orders o "
            + "join ecomdb.orderdetails f "
            + "on o.orderId=f.orderId "
            + "where o.orderId=?1", nativeQuery = true)
    List<OrdersEntity> getOrderfindOrderDetails(int id);

    @Query(value = "select count(*) from orders", nativeQuery = true)
    int getCountOrder();


}
