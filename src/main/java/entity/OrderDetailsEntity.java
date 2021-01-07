
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
@Table (name="orderDetails")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int orderDetailsId;
    private int quantity;
    private double unitPrice;
      
    @ManyToOne
    @JoinColumn(name="orderId")
    private OrdersEntity orders;

    @ManyToOne
    @JoinColumn(name="productDetailsId")
    private ProductDetailsEntity productDetails;
    
    public OrderDetailsEntity() {
    }

  
    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductDetailsEntity getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetailsEntity productDetails) {
        this.productDetails = productDetails;
    }

    public double getTotal(){
        double total = productDetails.getPrice()*quantity;
        return total;
    }

  
    
}
