<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
    <div class="container-fluid">

        <div class="row mt-3">
            <div class="col-lg-12">
            </div>
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Danh sách User</h5>


                        <mvc:form
                            action="${pageContext.request.contextPath}/admin/searchAccount"
                            method="get" class="form-inline">
                            <input name="searchText" type="text" value="${searchText}"
                                   class="form-control mr-sm-2" />
                            <input class="btn btn-info" type="submit" value="Searchs">
                        </mvc:form>

                        </br>

                        <mvc:form
                            action="${pageContext.request.contextPath}/admin/Register"
                            method="get" class="form-inline">

                            <label for="startDate">Từ ngày :</label>
                            <input type="date" value="${formDate}" name="formDate"
                                   required="true"	class="form-control mr-sm-2" />


                            <label for="endDate">Đến ngày:</label>
                            <input type="date" value="${toDate}" name="toDate"
                                   required="true"	class="form-control mr-sm-2" />

                            <input type="submit" value="Tìm" class="btn btn-info">

                        </mvc:form>
                        </br>

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>

                                        <th scope="col">Tên khách hàng</th>
                                        <th scope="col">Tài khoản</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Số điện thoại</th>
                                        <th scope="col">Ngày đăng kí</th>


                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${user}" var="user">
                                        <tr>

                                            <td>${user.customer.name}</td>
                                            <td><a
                                                    href="${pageContext.request.contextPath}/admin/showAccOrder/${user.customer.customerId}">
                                                    ${user.username }</a></td>
                                            <td>${user.user_roles.role}</td>
                                            <td>${user.customer.email}</td>
                                            <td>${user.customer.phoneNumber}</td>
                                            <td>
                                                ${user.registerDate }
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay toggle-menu"></div>
    </div>
</div>


<jsp:include page="./footer/footer.jsp" flush="true" />