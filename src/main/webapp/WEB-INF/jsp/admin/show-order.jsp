<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>

<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
    <div class="container-fluid">
        <!--End Row-->


        <div class="row">

            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách đơn hàng</h5>
                        <mvc:form action="${pageContext.request.contextPath}/admin/searchOrder" method="get" class="form-inline" >
                            <input name="searchText" type="text" value="${searchTex}"  class="form-control mr-sm-2" />
                            <input class="btn btn-info" type="submit" value="Searchs">
                        </mvc:form>

                        </br>	
                        <mvc:form  action="${pageContext.request.contextPath}/admin/searchDate" method="get" class="form-inline" > 	
                            <label for="startDate">Từ ngày :</label>
                            <input type="date" value="${formDate}"  name ="formDate" required="true" class="form-control mr-sm-2">
                            
                           

                            <label for="endDate">Đến ngày:</label>
                            <input type="date" value="${toDate}" name ="toDate" required="true" class="form-control mr-sm-2"/>
                            
                            <input type="submit" value="Tìm" class="btn btn-info">
                        </mvc:form>
                        </br>



                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Tài khoản User</th>
                                        <th scope="col">Địa chỉ giao hàng</th>

                                        <th scope="col">Tổng Tiền</th>
                                        <th scope="col">Trạng thái</th>
                                        <th scope="col">Ngày Đặt</th>


                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${pagedListHolder.pageList}" var="orders">
                                        <tr>
                                            <td>${orders.ordersId}</td>
                                            <td><a href="#">${orders.user.username}</a></td>
                                            <td>${orders.user.customer.address}</td>
                                            <td>${orders.payment[0].amountFormatted}₫</td>
                                            <td>${orders.orderStatus}</td>
                                            <td>${orders.orderDate}</td>
                                            <td>
                                                <button class="btn btn-danger">
                                                    <a href="${pageContext.request.contextPath}/admin/orderDetails/${orders.ordersId}">Chi tiết</a>
                                                </button>

                                                <button class="btn btn-success">
                                                    <a href="#">Sửa</a>
                                                </button>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <c:url value="/admin/show-Order/" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>
                        <tg:paging pagedListHolder="${pagedListHolder}"	pagedLink="${pagedLink}" ></tg:paging>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('#datepicker').datepicker();
    $('#datepicker').on('changeDate', function () {
        $('#my_hidden_input').val(
                $('#datepicker').datepicker('getFormattedDate')
                );
    });
</script>

<jsp:include page="./footer/footer.jsp" flush="true" />