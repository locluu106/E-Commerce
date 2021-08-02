<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Trang giỏ hàng</h1>

        <div class="checkout-right">
            <table class="timetable_sub">
                <thead>
                    <tr>
                        <th>SL No.</th>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Tên sản phẩm</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${order.orderDetailsList}">
                        <tr class="rem1">
                            <td class="invert">1</td>
                            <td class="invert-image">
                                <a href="#">
                                    <img src="<c:url value='/images/${item.product.images}'/>" alt=" " class="img-responsive">
                                </a>
                            </td>
                            <td class="invert">
                                <div class="quantity">
                                    <div class="quantity-select">
                                        <form action="${pageContext.request.contextPath}/update/${item.product.id}" method="post">
                                            <input type="hidden" name="productDetailsId
                                                   value="<c:out value='${item.productDetails.productDetailsId}'/>">               
                                            <input type="number" id="quantity"  value="<c:out value='${orderDetails.quantity}'/>" name="quantity" min="1" max="5">
                                            <input type="submit" value="update ">
                                        </form>
                                    </div>
                                </div>
                            </td>
                            <td class="invert">${item.product.name}</td>
                            <td class="invert">${item.product.priceFormatted} $1</td>
                            <td class="invert">
                                <div class="rem">
                                    <div >
                                        <a class="close1" href="${pageContext.request.contextPath}/remove/${item.product.id}"></a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
