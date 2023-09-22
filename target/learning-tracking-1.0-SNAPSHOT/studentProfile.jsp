<%-- 
    Document   : studentProfile
    Created on : Sep 22, 2023, 10:03:40 AM
    Author     : htk09
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
            <div class="header">
                <div class="grid h-100">
                    <nav class="navbar navbar-light h-100">
                        <a
                            class="navbar-brand navbar-logo h-100"
                            href="studentHomePage.html"
                            >
                            <img
                                src="./assets/imgs/logoPng.png"
                                class="d-inline-block align-top h-100"
                                alt=""
                                />
                            <p>Sổ liên lạc điện tử</p>
                        </a>

                        <div class="navbar-school">
                            <img
                                src="./assets/imgs/highSchool.png"
                                width="30"
                                height="30"
                                class="d-inline-block align-top"
                                alt=""
                                />
                            <p>FPT High School</p>
                        </div>
                    </nav>
                </div>
            </div>

            <div class="app-container">
                <div class="grid d-grid">
                    <div class="section-m1">
                        <div class="row">
                            <div class="col">
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="studentHomePage.html">
                                                <i class="fa-solid fa-arrow-left"></i>
                                            </a>
                                            Hồ sơ học sinh
                                        </div>
                                    </div>
                                    <div class="app-home__body">
                                        <div class="info-container">
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
                                                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                                                        Họ & Tên: ${student.lastName} ${student.firstName}
                                                                    </li>
                                                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                                                        Lớp: ${student.className}
                                                                    </li>
                                                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                                                        Giới tính: <c:choose>
                                                                            <c:when test="${student.gender}">
                                                                                Nam
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                Nữ
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="row d-flex justify-content-center">
                                                        <div class="col-6">
                                                            <h3>Báo cáo điểm</h3>
                                                            <div class="box-section ps-4">
                                                                <p class="text-color-green fs-16">Tham dự: 50</p>
                                                                <p class="text-color-red fs-16">Vắng: 5</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row mt-5 d-flex justify-content-center">
                                                        <div class="col-6">
                                                            <h3>Báo cáo điểm</h3>
                                                            <div class="box-section ps-4">
                                                                <p class="text-color-green fs-16">Điểm trung bình: 7.1</p>
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
                                        <div class="tab-item">
                                            Đổi mật khẩu
                                        </div>
                                        <div class="line"></div>
                                    </div>

                                    <div class="tab-content p-3">
                                        <div class="tab-pane active">
                                            <ul class="general-info-list">
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Ngày, tháng, năm sinh: ${student.dob}</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Hộ khẩu thường trú: ${student.address}</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Số điện thoại: ${student.phoneNumber}</li>
                                                <li class="general-info-item fs-20 mb-2 fw-bold">Email: ${student.email}</li>
                                            </ul>
                                            <div class="update-info-btn m-5">
                                                <button class="btn btn-me update-btn">
                                                    <i class="fa-solid fa-pen-to-square ms-2 me-3"></i>
                                                    Chỉnh sửa thông tin
                                                </button>
                                            </div>
                                        </div>
                                        <div class="tab-pane">
                                            <div class="col-3 m-2">
                                                <form class="change-password-container">
                                                    <div class="mb-4">
                                                        <input type="email" class="form-control" id="currentPassword" aria-describedby="emailHelp" placeholder="Mật khẩu hiện tại">
                                                    </div>
                                                    <div class="mb-4">
                                                        <input type="password" class="form-control" id="newPassword" placeholder="Mật khẩu mới">
                                                    </div>
                                                    <div class="mb-4">
                                                        <input type="password" class="form-control" id="verifyPassword" placeholder="Nhập lại mật khẩu">
                                                    </div>
                                                    <div class="change-password-btn">
                                                        <button class="btn btn-me change-btn">
                                                            <i class="fa-solid fa-key ms-2 me-3"></i>
                                                            Xác nhận
                                                        </button>
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

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://kit.fontawesome.com/5dd1c416dc.js"
            crossorigin="anonymous"
        ></script>
        <script src="./assets/js/mycode.js"></script>
    </script>
</body>
</html>

