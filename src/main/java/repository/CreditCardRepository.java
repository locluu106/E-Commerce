
package repository;

import entity.CreditCardEntity;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer>{
    	  @Query(value = "select *  from  ecomdb.creditcard "
            + "Where creditCardName = ?1 "
            + "and cardNumber = ?2 "
            + "and expirationDate = ?3 "
            + "and securityCode = ?4 ",nativeQuery = true)
    CreditCardEntity getPayment(String creditCardName,String creditCardNumber,LocalDate expirationDate ,String securityCode);
    
    
}
