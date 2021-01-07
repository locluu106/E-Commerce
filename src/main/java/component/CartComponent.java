package component;

import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.ProductDetailsEntity;
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
        order.setOrderDetailsList(orderDetailsList);
    }

    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    public void addItems(ProductDetailsEntity productDetails) {
        boolean t = false;
        for (int i = 0; i < order.getOrderDetailsList().size(); i++) {
            OrderDetailsEntity orderDetails = order.getOrderDetailsList().get(i);
            if (orderDetails.getProductDetails().getProductDetailsId() == productDetails.getProductDetailsId()) {
                orderDetails.setQuantity(orderDetails.getQuantity() + 1);
                order.getOrderDetailsList().set(i, orderDetails);
                t = true;
            }
        }
        if (!t) {
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setProductDetails(productDetails);
            orderDetails.setQuantity(1);
            orderDetails.setUnitPrice(productDetails.getPrice());
            order.getOrderDetailsList().add(orderDetails);
        }
    }

    public void removeItems(ProductDetailsEntity productDetails) {
        for (int i = 0; i < order.getOrderDetailsList().size(); i++) {
            OrderDetailsEntity orderDetails = order.getOrderDetailsList().get(i);
            if (orderDetails.getProductDetails().getProductDetailsId() == productDetails.getProductDetailsId()) {
                order.getOrderDetailsList().remove(i);
            }
        }
    }   

}
