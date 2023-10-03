<%-- 
    Document   : teacherMarkReport
    Created on : Sep 22, 2023, 11:19:02 AM
    Author     : flywt
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
                                            Sổ Điểm
                                            <div class="search-btn-contain">
                                                <a
                                                    role="button"
                                                    class="btn btn-block nav-link"
                                                    data-bs-toggle="modal" 
                                                    data-bs-target="#infoModal"
                                                    >Tìm kiếm</a>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="app-home__body">
                                        <div class="row">
                                            <div class="col">
                                                <form>
                                                    <!-- Student List details  -->
                                                    <table class="table table-bordered table-striped">
                                                        <thead class="background-primary">
                                                            <tr class="text-color-white">
                                                                <th class="align-middle">STT</th>
                                                                <th class="align-middle">Mã học sinh</th>
                                                                <th class="align-middle">Họ và Tên</th>
                                                                <th class="align-middle">KTTX</th>
                                                                <th class="align-middle">KTGK</th>
                                                                <th class="align-middle">KTCK</th>
                                                                <th class="align-middle">TBM HK</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>1</td>
                                                                <td>DE170068</td>
                                                                <td>Hà Trọng Tấn</td>
                                                                <td><input class="input-mark-student" type="number" value="8"/></td>
                                                                <td><input class="input-mark-student" type="number"/></td>
                                                                <td><input class="input-mark-student" type="number"/></td>
                                                                <td></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <div class="change-password-btn m-4">
                                                        <button class="btn btn-me change-btn">
                                                            <i class="fa-solid fa-circle-check ms-2 me-3"></i>
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
        <!--Modal-->
        <div id="infoModal" class="modal fade" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header background-primary text-color-white">
                        <h4 class="modal-title">Thông tin tìm kiếm</h4>
                        <button type="button" class="btn-close text-color-white" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body p-4">
                        <form action="">
                            <div class="row mb-5">
                                <div class="col-6">
                                    <label class="col-3 col-form-label"
                                           >Khối</label
                                    >
                                    <div class="col-8 d-flex justify-content-around">
                                        <select class="form-select" aria-label="Default select example">
                                            <option value="10">Khối 10</option>
                                            <option value="11">Khối 11</option>
                                            <option value="12">Khối 12</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <label class="col-3 col-form-label"
                                           >Lớp</label
                                    >
                                    <div class="col-8 d-flex justify-content-around">
                                        <select class="form-select" aria-label="Default select example">
                                            <option value="A3">Lớp A3</option>
                                            <option value="A4">Lớp A4</option>
                                            <option value="A5">Lớp A5</option>
                                        </select>
                                    </div>
                                </div>

                            </div>

                            <div class="form-group row">
                                <div class="col-12">
                                    <button type="submit" class="btn btn-block submit-modal-btn">
                                        Tìm kiếm
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="./includes/linkJS.jsp" %>
        <script src="./assets/js/mycode.js"></script>
    </script>
</body>
</html>

