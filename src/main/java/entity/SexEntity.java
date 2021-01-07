
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
@Table (name="sex")
public class SexEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int sexId;
    private String sexName;
    
    @OneToMany(mappedBy = "sex",fetch = FetchType.LAZY)
    private List<ProductDetailsEntity> productDetailsList;

    public SexEntity() {
    }

    public SexEntity(int sexId, String sexName, List<ProductDetailsEntity> productDetailsList) {
        this.sexId = sexId;
        this.sexName = sexName;
        this.productDetailsList = productDetailsList;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public List<ProductDetailsEntity> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetailsEntity> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }
    
            
}
