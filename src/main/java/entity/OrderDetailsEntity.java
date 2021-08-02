
package entity;

import com.sun.istack.NotNull;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="orderDetails")
public class OrderDetailsEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderDetailsId;

	@NotNull
	private int quantity;

	@NotNull
	private double price;

	@ManyToOne
	@JoinColumn(name = "ordersId")
	private OrdersEntity orders;

	@OneToOne
        @JoinColumn(name ="productId")
	private ProductEntity product;
    
    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(int orderDetailsId, int quantity, double price, OrdersEntity orders, ProductEntity product) {
        this.orderDetailsId = orderDetailsId;
        this.quantity = quantity;
        this.price = price;
        this.orders = orders;
        this.product = product;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Thong tin don hang : \n" 
                + "San pham: " + product.getName() + "\n"
                + "So luong: " + quantity + "\n"
                + "Gia: " + getPriceFormatted() + "\n"
                + "Ngay dat hang: " + orders.getOrderDate() + "\n" 
                + "Dia chi nhan hang: "+orders.getUser().getCustomer().getAddress();
    }

  public double getTotal(){
        double total = price* quantity;
        return total;
    }
    
    public String getTotalFormatted(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(getTotal());
    }
    
    public String getPriceFormatted(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(price);
    }
    
    
  
    
}
