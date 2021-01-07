
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="product")
public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productCode;
    private String productMaterial ;
    private String productBrand;
    
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductDetailsEntity> productDetailsList;
    
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<CommentEntity> commentList;
    
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<PromotionEntity> promotionList;
    
    
    public ProductEntity() {
    }

    public ProductEntity(int productId, String productName, String productCode, String productMaterial, String productBrand, List<ProductDetailsEntity> productDetailsList, List<CommentEntity> commentList, List<PromotionEntity> promotionList) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.productMaterial = productMaterial;
        this.productBrand = productBrand;
        this.productDetailsList = productDetailsList;
        this.commentList = commentList;
        this.promotionList = promotionList;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductMaterail() {
        return productMaterial;
    }

    public void setProductMaterail(String productMaterail) {
        this.productMaterial = productMaterail;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public List<ProductDetailsEntity> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetailsEntity> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public List<PromotionEntity> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(List<PromotionEntity> promotionList) {
        this.promotionList = promotionList;
    }

   
    
    
}
