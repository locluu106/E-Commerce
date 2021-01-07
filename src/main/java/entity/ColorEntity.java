
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
@Table (name="color")
public class ColorEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int colorId;
    private String colorName;
    
    @OneToMany (mappedBy = "color",fetch = FetchType.LAZY)
    private List<ProductDetailsEntity> productDetailsList;

    public ColorEntity() {
    }

    public ColorEntity(int colorId, String colorName, List<ProductDetailsEntity> productDetailsList) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.productDetailsList = productDetailsList;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<ProductDetailsEntity> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetailsEntity> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
    
    
}
