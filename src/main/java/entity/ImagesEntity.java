package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class ImagesEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int imagesId;
    private String imagesName;
    
    @ManyToOne
    @JoinColumn(name = "productDetailsId")
    private ProductDetailsEntity productDetails;
    
    public ImagesEntity() {
    }

    public int getImagesId() {
        return imagesId;
    }

    public void setImagesId(int imagesId) {
        this.imagesId = imagesId;
    }

    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

    public ProductDetailsEntity getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetailsEntity productDetails) {
        this.productDetails = productDetails;
    }

 
}
