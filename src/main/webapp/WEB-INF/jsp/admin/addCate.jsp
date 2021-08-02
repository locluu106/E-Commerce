<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<jsp:include page = "./header/header.jsp" flush = "true" />
<div class="content-wrapper">
    <div class="container-fluid">
        <div class="row mt-3">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">

                        <form:form modelAttribute="category" method="post"
                                   action="${pageContext.request.contextPath}/admin/save-Cate" >
                            <div class="form-group">
                                <label for="input-2">Tên danh sách sản phẩm</label>
                                <form:input path="name"  class="form-control" />
                                <form:errors path="name" cssClass="error" >2</form:errors><br><br>
                                </div>
                                <div class="form-footer">
                                    <button class="btn btn-danger">
                                        <i class="fa fa-times"></i><a href="#">Hủy</a>
                                    </button>
                                    <button type="submit" class="btn btn-success">
                                        <i class="fa fa-check-square-o"></i> Thêm
                                    </button>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page = "./footer/footer.jsp" flush = "true" />