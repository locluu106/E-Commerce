
package repository;

import entity.UserEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
    UserEntity findByUserId(int userId);
    
    
    
    @Query(value ="SELECT * FROM ecomdb.user u "
            + "join ecomdb.customer c "
            + "on u.customerId=c.customerId where"
            + " u.username = ?1", nativeQuery = true)
     UserEntity getUserName(String username);
     
 
     List<UserEntity> findByRegisterDateBetween(LocalDate dateForm, LocalDate dateTo);
     
     UserEntity findByusername(String username);
}
