
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
@Table (name="size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeId;
    private String sizeName;
    
    @OneToMany(mappedBy = "size",fetch = FetchType.LAZY)
    private List<ProductDetailsEntity> productDetailsList;

    public SizeEntity() {
    }

    public SizeEntity(int sizeId, String sizeName, List<ProductDetailsEntity> productDetailsList) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.productDetailsList = productDetailsList;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public List<ProductDetailsEntity> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetailsEntity> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
    
    
    
}
