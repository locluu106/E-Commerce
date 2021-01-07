
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
@Table(name="orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;    
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate orderDate;
    
       
    @ManyToOne
    @JoinColumn(name="customerId")
    private CustomerEntity customer;
    
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentList;
    
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<ShippingEntity> shippingList;
    
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetailsList;

    public OrdersEntity() {
    }

    public List<ShippingEntity> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<ShippingEntity> shippingList) {
        this.shippingList = shippingList;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<PaymentEntity> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<PaymentEntity> paymentList) {
        this.paymentList = paymentList;
    }

    public List<OrderDetailsEntity> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsEntity> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    
    
    public double getTotal(){
        double sum = 0;
        for(OrderDetailsEntity o:orderDetailsList){
            sum += o.getQuantity()*o.getProductDetails().getPrice();
        }
        return sum;
    }
}

