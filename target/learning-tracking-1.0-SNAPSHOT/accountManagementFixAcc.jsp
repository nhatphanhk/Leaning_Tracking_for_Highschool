<%-- 
    Document   : accountManagementFixAcc
    Created on : Oct 23, 2023, 1:10:22 PM
    Author     : nhatp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="./includes/headerAccountManagement.jsp" %>

        <div class="app-container m-0">
            <div class="grid d-grid">
                <div class="section-m1">
                    <div class="row">
                        <div class="col">
                            <div class="box-section">
                                <div class="app-home__heading">
                                    <div class="header-name">
                                        <a href="listaccount">
                                            <i class="fa-solid fa-arrow-left"></i>
                                        </a>
                                        Chỉnh sửa tài khoản
                                    </div>
                                </div>

                               <div class="app-home__body">
                                    <div class="container">
                                        <div class="row">
                                            <div class="m-5">
                                                <form action="updateaccount" method="post">

                                                    <div class="row mb-5">
                                                        <h3 class="col-3 mt-1 align-middle">Mã số</h3>
                                                        <input  class="col-6 fs-3" readonly="" value="${requestScope.account.id} ${requestScope.ms}" /> 
                                                    </div>
                                                    <div class="row mb-5">
                                                        <h3 class="col-3 mt-1 align-middle">Họ và Tên</h3>
                                                        <input class="col-6 fs-3" readonly=""  value="${requestScope.account.lastname} ${requestScope.account.firstname} ${requestScope.ms} " />
                                                    </div>



                                                    <div class="row mb-5">
                                                        <h3 class="col-3 mt-1 align-middle">Tài Khoản Email</h3>

                                                        <input class="col-6 fs-3" name="email" readonly="" value="${requestScope.account.email}"/>
                                                    </div>
                                                    <div class="row mb-4">
                                                        <h3 class="col-3 mt-1 align-middle">Mật Khẩu</h3>
                                                        <input class="col-6 fs-3" name="pass" value="${requestScope.account.password}" />
                                                    </div>

                                                    <div class="row mb-4" style="width: 100px">
                                                        <h3 class="col-3 mt-1 align-middle">Chức Vụ </h3>
                                                        <select name="role">
                                                            <option ${(requestScope.account.roleid == 1) ? 'selected' : ''} value="1">Học sinh</option>
                                                            <option ${(requestScope.account.roleid == 2) ? 'selected' : ''} value="2">Giáo viên</option>
                                                            <option ${(requestScope.account.roleid == 3) ? 'selected' : ''} value="3">Quản lí tài khoản</option>
                                                            <option ${(requestScope.account.roleid == 4) ? 'selected' : ''} value="4">Kế toán</option>
                                                            <option ${(requestScope.account.roleid == 5) ? 'selected' : ''} value="5">Giáo vụ</option>
                                                            <option ${(requestScope.account.roleid == 6) ? 'selected' : ''} value="6">Admin</option>
                                                        </select>

                                                    </div>        

                                                            <div><h3 style="color: red">${sessionScope.msg}</h3></div> 
                                                             <div><h3 style="color: green">${sessionScope.msgs}</h3></div> 
                                                    <div class="form-group row">
                                                        <span class="col-8" ></span>
                                                        <div class="col-3">
                                                            <button type="submit" class="btn btn-outline-primary fs-4">
                                                                Submit
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
   <%@ include file="./includes/linkJS.jsp" %>
        <script src="./assets/js/mycode.js"></script>
</body>
</html>
