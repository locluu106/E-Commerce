<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="breadcrumb" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">

            </div>
        </div>
    </div>
</div>

    <div class="section">
        <div class="container">
            <form action="${pageContext.request.contextPath}/paymentProduct" method="post" >
            <div class="row">
                <div class="col-md-7">
                    
                        <div class="billing-details">
                            <div class="section-title">
                                <h3 class="title">Thanh Toán</h3>
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="cardName" placeholder="Tên chủ thẻ" required >
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="cardNumber" placeholder="Số thẻ"  required>
                            </div>

                            <div class="form-group">
                                <input class="input" type="password" name="cvv" placeholder="CVV"  required>
                            </div>
                            <div class="form-group">
                                <input class="input" type="Date" name="exDate" placeholder="Expiration Date"  required>
                            </div>




                        </div>
                    
                </div>
                <div class="col-md-5 order-details">
                    <div class="section-title text-center">
                        <h3 class="title">Đơn Hàng Của Bạn</h3>
                    </div>
                    <div class="order-summary">
                        <div class="order-col">
                            <div><strong>Sản Phẩm</strong></div>
                            <div><strong>Thành Tiền</strong></div>
                        </div>
                        <c:set var="s" value="0"></c:set>
                        <c:forEach items="${order.orderDetails}" var="order" >
                            <c:set var="s" value="${s + order.total}"></c:set>
                                <div class="order-products">
                                    <div class="order-col">
                                        <div><c:out value="${order.quantity}"/>x  <c:out value="${order.product.name}"/>(<c:out value="${order.product.priceFormatted}"/>/₫)</div>
                                    <div><fmt:formatNumber  value="${order.quantity * order.product.price}"/>₫</div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="order-col">

                        </div>
                        <div class="order-col">
                            <div><strong>Tổng Đơn Hàng</strong></div>
                            <div><strong class="order-total"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${s}" />₫</strong></div>
                        </div>
                    </div>


                    <button class="primary-btn "  >Đặt hàng</button>
                    <br>
                    <div class="order-col"><strong class="order-total">${errorMessage}</strong></div>
                </div>
            </div>
                        </form>
        </div>
    </div>


<jsp:include page="footer.jsp"/>