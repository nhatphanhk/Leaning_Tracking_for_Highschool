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
                                            <a href="accountManagementProfile.jsp">
                                                <i class="fa-solid fa-arrow-left"></i>
                                            </a>
                                            Chỉnh sửa tài khoản
                                                                                    </div>
                                    </div>

                                    <div class="app-home__body">
                                        <div class="container">
                                            <div class="row">
                                                <div class="m-5">
                                                    <form action="">
                                                <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle">Mã học sinh</h3>
                                                    <input class="col-6 fs-3" type="text"  />
                                                </div>
                                                <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle">Họ và Tên</h3>
                                                    <input class="col-6 fs-3" type="text"  />
                                                </div>
                                                <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle">Giới Tính</h3>
                                                    <input class="col-6 fs-3" type="text" />
                                                </div>
                                                <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle">Ngày sinh</h3>
                                                    <input class="col-6 fs-3" type="date"  />
                                                </div>
                                                <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle" style="font-size: 16px">Số Điện Thoại</h3>
                                                    <input class="col-6 fs-3" type="tel" />
                                                </div>
                                                 <div class="row mb-5">
                                                    <h3 class="col-3 mt-1 align-middle">Tài Khoản</h3>
                                                    <input class="col-6 fs-3" type="email"/>
                                                </div>
                                                <div class="row mb-4">
                                                    <h3 class="col-3 mt-1 align-middle">Mật Khẩu</h3>
                                                    <input class="col-6 fs-3" type="text"/>
                                                </div>

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
       
    </body>
</html>
