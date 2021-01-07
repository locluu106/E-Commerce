
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
@Table (name = "ageGroup")
public class AgeGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ageGroupId;
    private String ageName;
    
    @OneToMany(mappedBy = "ageGroup",fetch = FetchType.LAZY)
    private List<ProductDetailsEntity> productDetailsList;

    public int getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(int ageGroupId) {
        this.ageGroupId = ageGroupId;
    }

    public String getAgeName() {
        return ageName;
    }

    public void setAgeName(String ageName) {
        this.ageName = ageName;
    }

    public List<ProductDetailsEntity> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetailsEntity> productDetailsList) {
        this.productDetailsList = productDetailsList;
    }

    public AgeGroupEntity() {
    }

    public AgeGroupEntity(int ageGroupId, String ageName, List<ProductDetailsEntity> productDetailsList) {
        this.ageGroupId = ageGroupId;
        this.ageName = ageName;
        this.productDetailsList = productDetailsList;
    }
    
    
}
