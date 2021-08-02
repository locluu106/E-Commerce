package entity;

import com.sun.istack.NotNull;
import java.text.NumberFormat;
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
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordersId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate orderDate;

    private String shippingAddress;

    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetailsEntity> orderDetails;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<PaymentEntity> payment;

    public OrdersEntity() {
    }

    public OrdersEntity(int ordersId, LocalDate orderDate, String shippingAddress, String orderStatus, UserEntity user, List<OrderDetailsEntity> orderDetails, List<PaymentEntity> payment) {
        this.ordersId = ordersId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderStatus = orderStatus;
        this.user = user;
        this.orderDetails = orderDetails;
        this.payment = payment;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }
    

    
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<PaymentEntity> getPayment() {
        return payment;
    }

    public void setPayment(List<PaymentEntity> payment) {
        this.payment = payment;
    }

    public double getTotal() {
        double sum = 0;
        for (OrderDetailsEntity o : orderDetails) {
            sum += o.getQuantity() * o.getPrice();
        }
        return sum;
    }
    public String getTotalFormatted() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(getTotal());
    }

}
