
package entity;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int promotionId;
    private String description;
    
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate dateStart;
    
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;
    
    private double amount;
    
    @ManyToOne
    @JoinColumn(name="productId")
    private ProductEntity product;
    
    @OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)
    private List<PromotionDetailsEntity> promotionDetailsList;

    public PromotionEntity() {
    }

    public PromotionEntity(int promotionId, String description, LocalDate dateStart, LocalDate dateEnd, double amount, ProductEntity product, List<PromotionDetailsEntity> promotionDetailsList) {
        this.promotionId = promotionId;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.product = product;
        this.promotionDetailsList = promotionDetailsList;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<PromotionDetailsEntity> getPromotionDetailsList() {
        return promotionDetailsList;
    }

    public void setPromotionDetailsList(List<PromotionDetailsEntity> promotionDetailsList) {
        this.promotionDetailsList = promotionDetailsList;
    }

    
    
}
