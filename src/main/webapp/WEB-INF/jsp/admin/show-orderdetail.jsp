<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
   
        <div class="row">
 
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Chi tiết đơn hàng</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                   
                       <th scope="col">#</th>
                        <th scope="col">Tên Sản Phẩm</th>
                        
                        <th scope="col">Giá</th>
                         <th scope="col">Số lượng</th>
                         <th scope="col">Thành tiền</th>
                      </tr>
                    </thead>
                    <tbody>
                   <c:set var="s" value="0"></c:set>
                  <c:forEach items="${orderDetailsList}" var="details">
                   <c:set var="s" value="${s + details.total}"></c:set>
                      <tr>
                        <td scope="row">${details.orderDetailsId}</td>
                         <td>${details.product.name}</td>
                        <td>${details.priceFormatted} ₫</td>
                        <td>${details.quantity}</td>  
                         <td>${details.totalFormatted} ₫</td>
                     </tr>
                    </c:forEach>
                    </tbody>
                  </table><br>
                  
                  <a>Tổng Tiền</a>
                  <a class="list-group-item "><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${s}" />₫</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 
    <jsp:include page = "./footer/footer.jsp" flush = "true" />