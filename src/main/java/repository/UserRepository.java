
package repository;

import entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
    UserEntity findByUserId(int userId);
    
    @Query(value ="SELECT * FROM fashiondb.user u "
            + "join fashiondb.customer c "
            + "on u.customerId=c.customerId where"
            + " u.username = ?1", nativeQuery = true)
     UserEntity getCustomerByUserName(String username);
     
     @Query(value ="SELECT * FROM fashiondb.user u "
             + "join fashiondb.customer c "
             + "on u.customerId=c.customerId "
             + "join fashiondb.orders o "
             + "on o.customerId=c.customerId "
             + "where u.username = ?1 "
             + "and o.customerId = ?2 ", nativeQuery = true)
     UserEntity getOrderByUser(String username,int customerId );
     
     UserEntity findByusername(String username);
}
