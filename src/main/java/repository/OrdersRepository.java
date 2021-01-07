package repository;

import entity.OrdersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {

    @Query(value = "SELECT * FROM fashiondb.orders o "
            + "join fashiondb.orderdetails f "
            + "on o.orderId=f.orderId "
            + "where o.orderId=?1", nativeQuery = true)
    List<OrdersEntity> getOrderUser(int id);
    
    @Query(value = "SELECT * FROM fashiondb.orders o "
            + "join fashiondb.customer c "
            + "on o.customerId=c.customerId "
            + "join fashiondb.user u "
            + "on u.userId=c.customerId "
            + "where u.userId = ?1 "
            + "and o.customerId = ?2", nativeQuery = true)
    List<OrdersEntity> getOrderByUser(int userId, int customerId);

    @Query(value = "SELECT * FROM fashiondb.orders o "
            + "join fashiondb.orderdetails f "
            + "on o.orderId=f.orderId "
            + "where o.orderId=?1", nativeQuery = true)
    List<OrdersEntity> getOrderfindOrderDetails(int id);
    
    @Query(value = "select count(*) from orders", nativeQuery = true)
    int getCountOrder();
    
    @Query(value = "select * from fashiondb.orders ORDER BY orderid DESC limit ?1,?2", nativeQuery = true)
    List<OrdersEntity> getAllOrder(int pageOrderId, int limitOrder);
    
    @Query(value = "select * from fashiondb.orders ORDER BY orderId DESC limit 10", nativeQuery = true)
    List<OrdersEntity> getAllOrder1();
    
    @Query(value = "SELECT * FROM fashiondb.orders o join fashiondb.customer c on o.customerId = c.customerId where c.customerName like ?1", nativeQuery = true)
    List<OrdersEntity> getByCustomerNameLike(String customerName);
    
}
