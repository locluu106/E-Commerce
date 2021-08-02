
package repository;

import entity.CustomerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>{
    @Query(value ="SELECT * FROM ecomdb.user u "
            + "join ecomdb.customer c "
            + "on u.customerId=c.customerId "
            + "where u.username = ?1", nativeQuery = true)
    List<CustomerEntity> getCustomerByUserName(String username);
    
    
    
    CustomerEntity findByCustomerId(int customerId);
}
