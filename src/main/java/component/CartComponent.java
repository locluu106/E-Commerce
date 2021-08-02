package component;

import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class CartComponent {

    private OrdersEntity order;

    public CartComponent() {
        order = new OrdersEntity();
        List<OrderDetailsEntity> orderDetailsList = new ArrayList<>();
        order.setOrderDetails(orderDetailsList);
    }

    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    public void addItems(ProductEntity product) {
        boolean t = false;
        for (int i = 0; i < order.getOrderDetails().size(); i++) {
            OrderDetailsEntity orderDetails = order.getOrderDetails().get(i);
            if (orderDetails.getProduct().getProductId() == product.getProductId()) {
                orderDetails.setQuantity(orderDetails.getQuantity() + 1);
                order.getOrderDetails().set(i, orderDetails);
                t = true;
            }
        }
        if (!t) {
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setProduct(product);
            orderDetails.setQuantity(1);
            orderDetails.setPrice(product.getPrice());
            order.getOrderDetails().add(orderDetails);
        }
    }

    public void removeItems(ProductEntity product) {
        for (int i = 0; i < order.getOrderDetails().size(); i++) {
            OrderDetailsEntity orderDetails = order.getOrderDetails().get(i);
            if (orderDetails.getProduct().getProductId() == product.getProductId()) {
                order.getOrderDetails().remove(i);
            }
        }
    }

    public int getCount() {

        int count = order.getOrderDetails().size();
        return count;
    }

}
