/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.CategoryEntity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Iterable> {

    @Query(value = "SELECT category_1.categoryId,category_1.name, sum(order_1.price) as total "
            + "FROM  ecomdb.category category_1 "
            + "	JOIN ecomdb.product product_1 "
            + " on  product_1.categoryId = category_1.categoryId "
            + " join ecomdb.orderdetails order_1 " 
            + " on order_1.productId = product_1.productId " 
            + " GROUP BY category_1.categoryId ", nativeQuery  = true

    )
    List<CategoryEntity> getTotalCate();

}
