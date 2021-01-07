
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shippingOrders")
public class ShippingEntity {

   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int shippingOrdersId;
    
    @ManyToOne
    @JoinColumn(name="orderId")
    private OrdersEntity orders;

    public ShippingEntity() {
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    
    public int getShippingOrdersId() {
        return shippingOrdersId;
    }

    public void setShippingOrdersId(int shippingOrdersId) {
        this.shippingOrdersId = shippingOrdersId;
    }

    
    
    
}
