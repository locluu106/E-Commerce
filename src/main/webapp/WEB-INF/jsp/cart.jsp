<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<jsp:include page="header.jsp" />
<c:set var="s" value="0"></c:set>
<c:forEach items="${order.orderDetails}" var="order" >
    <c:set var="s" value="${s + order.total}"></c:set>
        <div class="container">
            <div class="row">
                <div class="col-md-12">                                               
                    <div class="product-details" style="padding-top: 20px;">
                        <h2 class="product-name">${order.product.name}</h2>

                    <div>
                        <h3 class="product-price">${order.product.priceFormatted}₫</h3>
                    </div>


                    <div class="add-to-cart">
                        <form action="${pageContext.request.contextPath}/update/${order.product.productId}" method="post">
                            <div class="qty-label">
                                Số Lượng
                                <div class="input-number" >

                                    <input  type="number" value="<c:out value='${order.quantity}'/>" name="quantity" min='1' >
                                    <span class="qty-up">+</span>
                                    <span class="qty-down">-</span>
                                </div>
                            </div>
                            <button class="add-to-cart-btn"  value="update"><i class="fa fa-shopping-cart"></i>Câp nhập</button>

                            <a class="add-to-cart-btn" href="${pageContext.request.contextPath}/remove/${order.product.productId}">xóa</a>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </div>
</c:forEach>
<!-- container -->
<div class="container">
    <!-- row -->
    <div class="row">
        <div class="col-md-12">

            <div>
                <h3 class="product-price" >Thành Tiền  : 
                    <fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${s}" />₫
                </h3>
            </div>

            <div>
                <form  class="add-to-cart-btn" action="${pageContext.request.contextPath}/order" method="get" >                              
                    <input class="link-product-add-cart" type="submit" value="Đặt hàng">
                    <h3 style="color: #D10024"> ${errorMessage}</h3>
                </form> 
            </div>

        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>