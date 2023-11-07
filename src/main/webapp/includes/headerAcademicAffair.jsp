
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
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/style.css" />
        <title>MS</title>
    </head>
    <body>
        <div class="app">
            <!-- Header  -->
            <div class="d-grid grid">
                <nav class="navbar navbar-expand-lg navbar-white bg-white acaAff-header">
                    <a
                        class="navbar-brand navbar-logo h-100"
                        href="academicAffairProfile.jsp"
                        >
                        <img
                            src="./assets/imgs/logoPng.png"
                            class="d-inline-block align-top h-100"
                            alt=""
                            />
                        <p>Sổ liên lạc điện tử</p>
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarNavDropdown">
                        <ul class="navbar-nav ms-3">
                            <li class="nav-item">
                                <a class="nav-link" href="./academicAffairProfile.jsp">Giám thị</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="teacherListTimetable"  role="button">
                                    Thời khóa biểu
                                </a>
<!--                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><a class="dropdown-item" href="teacherListTimetable">Thời khóa biểu giáo viên</a></li>
                                    <li><a class="dropdown-item" href="./academicAffairTimetableStudent.jsp">Thời khóa biểu học sinh</a></li>
                                </ul>-->
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./academicAffairCheckAttendance.jsp">Điểm danh</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewApplicationTeacher">Đơn vắng học</a>
                            </li>
                            <li class="nav-item">

                                <a class="nav-link" href="/learning-tracking/LockMark">Tình trạng học sinh</a>

                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Danh sách
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><a class="dropdown-item" href="teacherlistcontroller">Danh sách giáo viên</a></li>
                                    <li><a class="dropdown-item" href="studentlistcontroller">Danh sách học sinh</a></li>
                                </ul>
                            </li>
                        </ul>
                        <!-- User DropDown  -->
                        <%@ include file="./dropDownSettings.jsp" %>

                        <!--                         User DropDown  
                                                <div class="dropdown user-dropdown">
                                                    <button class="btn btn-light dropdown-toggle user-dropdown-btn" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                                        User
                                                        <i class="fa-solid fa-user"></i>
                                                    </button>
                                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                                        <li><a class="dropdown-item" href="./academicAffairProfile.jsp">Hồ sơ cá nhân</a></li>
                                                        <li><a class="dropdown-item" href="./changePassword.jsp">Đổi mật khẩu</a></li>
                                                        <li><hr class="dropdown-divider"></li>
                                                        <li class=""><a class="dropdown-item bg-danger text-color-white" href="#">Đăng xuất</a></li>
                                                    </ul>
                                                </div>-->
                        <!--Dropdown Setting-->
                        <div class="btn-group nav-dropdown-setting">
                            <button
                                type="button"
                                class="btn btn-secondary dropdown-toggle"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                                ></button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="changePassword.jsp">Đổi mật khẩu</a></li>
                                <li><hr class="dropdown-divider" /></li>



                                <li><a class="dropdown-item" href="logout">Đăng xuất</a></li>

                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

