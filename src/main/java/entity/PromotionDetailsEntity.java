
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="promotionDetails")
public class PromotionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionDetailsId;
    private String productDetailsName;
    private double valueOfPromotion;
    
    @ManyToOne
    @JoinColumn(name="promotionId")
    private PromotionEntity promotion;

    public PromotionDetailsEntity() {
    }

    public PromotionDetailsEntity(int promotionDetailsId, String productDetailsName, double valueOfPromotion, PromotionEntity promotion) {
        this.promotionDetailsId = promotionDetailsId;
        this.productDetailsName = productDetailsName;
        this.valueOfPromotion = valueOfPromotion;
        this.promotion = promotion;
    }

    public int getPromotionDetailsId() {
        return promotionDetailsId;
    }

    public void setPromotionDetailsId(int promotionDetailsId) {
        this.promotionDetailsId = promotionDetailsId;
    }

    public String getProductDetailsName() {
        return productDetailsName;
    }

    public void setProductDetailsName(String productDetailsName) {
        this.productDetailsName = productDetailsName;
    }

    public double getValueOfPromotion() {
        return valueOfPromotion;
    }

    public void setValueOfPromotion(double valueOfPromotion) {
        this.valueOfPromotion = valueOfPromotion;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }
    
    
}
