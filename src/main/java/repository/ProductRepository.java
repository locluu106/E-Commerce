/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
     ProductEntity findByProductId(int productId);
     
     List<ProductEntity> findByName(String name);
     
     
     List<ProductEntity> findByNameLike(String name);
     
     @Query(value = "select * from ecomdb.product p "
           + "join ecomdb.category c "
          + "on p.categoryId = c.categoryId "
          + "where c.name = ?1", nativeQuery = true)
     List<ProductEntity> findByCategory(String name);
     
     List<ProductEntity> findByPriceBetween(Double price1,Double price2);
     
     List<ProductEntity> findByPriceGreaterThanEqual(Double price);

     @Query(value = "SELECT * FROM ecomdb.product product_1 "
             + "JOIN ecomdb.orderdetails oder_1 "
             + "on  product_1.productId = oder_1.productId "
             + "GROUP BY  product_1.productId,product_1.name "
             + "Order by Sum(quantity)  DESC limit 5",nativeQuery = true)
     List<ProductEntity> productSale();
     
     @Query(value = "SELECT * FROM ecomdb.product order by rand() limit 5",nativeQuery = true)
     List<ProductEntity> findProduct();
// 
}
