<%-- 
    Document   : teacherProfile
    Created on : Sep 22, 2023, 10:04:32 AM
    Author     : htk09
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700;800;900&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./assets/css/style.css" />
        <title>MS</title>
    </head>
    <body>
        <div class="app">
            <!-- header  -->
            <%@ include file="./includes/header.jsp" %>

            <div class="app-container">
                <div class="grid d-grid">
                    <div class="section-m1">
                        <div class="row">
                            <div class="col">
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="teacherHomePage.jsp">
                                                <i class="fa-solid fa-arrow-left"></i>
                                            </a>
                                            Hồ sơ giáo viên
                                        </div>
                                    </div>
                                    <div class="app-home__body">
                                        <div class="p-5 info-container">
                                            <div class="row mt-5">
                                                <div class="col">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="card-body text-center student-profile__avatar">
                                                                <img
                                                                    class="img-account-profile rounded-circle mb-4 mt-4"
                                                                    src="./assets/imgs/hih.jfif"
                                                                    alt=""
                                                                    />
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="card-body student-profile">
                                                                <ul class="profile-info">
                                                                    <li class="profile-info-item h1 ms-2 mb-5 fw-bold">
                                                                        Họ & Tên: Trần Thị Thoa
                                                                    </li>
                                                                    <li class="profile-info-item h1 ms-2 mb-5 fw-bold">
                                                                        Lớp chủ nhiệm: 10A3
                                                                    </li>
                                                                    <li class="profile-info-item h1 ms-2 mb-5 fw-bold">
                                                                        Môn giảng dạy: Toán
                                                                    </li>
                                                                    <li class="profile-info-item h1 ms-2 mb-5 fw-bold">
                                                                        Giới tính: Nữ
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <!-- Tabs profile  -->
                                    <div class="tabs ms-5">
                                        <div class="tab-item active">
                                            Tổng quan
                                        </div>
                                        <div class="line"></div>
                                    </div>

                                    <div class="tab-content p-5">
                                        <div class="tab-pane active">
                                            <ul class="general-info-list">
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Ngày, tháng, năm sinh: 01/01/2007</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Hộ khẩu thường trú: 86 land, kdt FPT, Đà Nẵng</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Số điện thoại: 0123456789</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Email: email@example.com</li>
                                            </ul>
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
    </script>
</body>
</html>
