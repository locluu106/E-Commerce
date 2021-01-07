package repository;

import antlr.collections.impl.LList;
import entity.ProductDetailsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetailsEntity, Integer> {

    ProductDetailsEntity findByProductDetailsId(int productDetailsId);
    
    List<ProductDetailsEntity> findByProductDetailsNameLike(String productDetailsName);
    
    @Query(value = "select count(*) from productdetails", nativeQuery = true)
    int getCountProduct();
    
    @Query(value = "select * from fashiondb.productdetails ORDER BY productDetailsId DESC limit ?1,?2", nativeQuery = true)
    List<ProductDetailsEntity> getAllProduct(int pageProductId, int limitProduct);
    
    @Query(value = "select * from fashiondb.productdetails ORDER BY productDetailsId DESC limit 10", nativeQuery = true)
    List<ProductDetailsEntity> getAllProduct1();
    
    @Query(value = "SELECT * FROM fashiondb.productdetails order by rand() limit 10",nativeQuery = true)
    List<ProductDetailsEntity> getShowHomeProductLimit10();
    
    @Query(value = "SELECT * FROM fashiondb.productdetails order by rand() limit 4",nativeQuery = true)
    List<ProductDetailsEntity> getShowHomeProductLimit4();

    @Query(value = "SELECT * FROM fashiondb.productdetails pr "
            + "where pr.productId =?1",nativeQuery = true)
    List<ProductDetailsEntity> getProductType(int productId);

    @Query(value = "SELECT * FROM fashiondb.sex c "
            + "join fashiondb.productdetails p "
            + "on c.sexId=p.sexId "
            + "where c.sexId= ?1", nativeQuery = true)
    List<ProductDetailsEntity> getSexId(int id);

    @Query("select p from ProductDetailsEntity p "
            + "where(p.productDetailsName Like %?1%) "
            + "or(p.size.sizeName = ?2) "
            + "or(p.color.colorName = ?3)")
    List<ProductDetailsEntity> searchProduct(String productDetails, String size, String color);

    @Query(value = "SELECT * FROM fashiondb.color c "
            + "join fashiondb.productdetails p "
            + "on c.colorId=p.colorId "
            + "where c.colorId= ?1", nativeQuery = true)
    List<ProductDetailsEntity> getColorfindProductDetails(int id);

    @Query(value = "SELECT * FROM fashiondb.product a "
            + "join fashiondb.productdetails p "
            + "on a.productId=p.productId "
            + "where a.productId=?1", nativeQuery = true)
    List<ProductDetailsEntity> getProductfindProductDetails(int id);
}
