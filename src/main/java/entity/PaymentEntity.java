
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
@Table (name="payment")
public class PaymentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int paymentId;
    
    @DateTimeFormat (pattern ="yyyy-MM-dd")
    private LocalDate paymentDate;
    
    private double amount;
    
    @ManyToOne
    @JoinColumn(name="creditCardId")
    private CreditCardEntity creditCard;
    
    @ManyToOne
    @JoinColumn(name="orderId")
    private OrdersEntity orders;

    public PaymentEntity() {
    }



    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }

    

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    
    
}
