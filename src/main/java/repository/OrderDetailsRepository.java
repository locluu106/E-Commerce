package repository;

import entity.OrderDetailsEntity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
    
    @Query(value = "SELECT * FROM fashiondb.orders "
            + "o join fashiondb.orderdetails f "
            + "on o.orderId=f.orderId "
            + "where o.orderId=?1", nativeQuery = true)
    List<OrderDetailsEntity> getOrderUser(int id);
    
    @Query(value = "SELECT * FROM fashiondb.orderdetails od"
            + "join fashiondb.orders o"
            + "on o.orderId=od.orderId =?1"
            + "where o.orderId=?1", nativeQuery = true)    
    List<OrderDetailsEntity> getOrderDetails(int orderId);
    
    @Query(value = "SELECT * FROM fashiondb.orders o join fashiondb.orderdetails f on o.orderId=f.orderId where o.orderId=?1", nativeQuery = true)
    List<OrderDetailsEntity> getOrderDetailsfindOrders(int id);
    
    
}
