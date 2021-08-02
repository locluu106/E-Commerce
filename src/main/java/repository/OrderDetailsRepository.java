package repository;

import entity.OrderDetailsEntity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {

    @Query(value = "SELECT * FROM ecomdb.orders "
            + "o join ecomdb.orderdetails f "
            + "on o.ordersId=f.ordersId "
            + "where o.ordersId=?1", nativeQuery = true)
    List<OrderDetailsEntity> getOrderUser(int id);

    @Query(value = "SELECT * FROM ecomdb.orderdetails orderDetails "
            + "join ecomdb.orders order_1 "
            + "on orderDetails.ordersId = order_1.ordersId "
            + "where orderdetails.ordersId=?1", nativeQuery = true)
    List<OrderDetailsEntity> getOrderDetails(int orderId);

    

}
