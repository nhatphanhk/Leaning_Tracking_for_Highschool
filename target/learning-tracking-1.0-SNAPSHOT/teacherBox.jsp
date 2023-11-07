<%-- 
Document   : teacherBox
Created on : Sep 22, 2023, 10:04:05 AM
Author     : htk09
--%>

<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet" />

        <link rel="stylesheet" href="./assets/css/teacher-base.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
        <!--  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>-->
        <link rel="stylesheet" href="./assets/css/style.css" />
        <link rel="stylesheet" href="./assets/css/teacher-style.css" />
        <title>MS</title>
    </head>

    <body>
        <div class="app">
            <!-- header  -->
            <%@ include file="./includes/header.jsp" %>
            <div class="app-container d-flex justify-content-center">
                <div class="box-section w-75 mt-lg-5">
                    <div class="app-home__heading">
                        <div class="header-name">
                            <a href="academicAffairProfile.jsp"><i class="fa-solid fa-arrow-left me-3"></i></a>
                            Hòm Thư
                        </div>
                    </div>
                    <div class="app-home__content" style="padding: 20px 0px 20px 30px">
                        <div class="grid-container3 grid-header">
                            <div class="grid-item">STT</div>
                            <div class="grid-item">Họ Và Tên</div>
                            <div class="grid-item">Tiêu đề</div>
                            <div class="grid-item">Đơn</div>
                            <div class="grid-item">Ngày Gửi</div>
                        </div>
                        <c:forEach items="${applicationTeacher}" var="app" varStatus="loopStatus">
                            <a href="#" class="grid-container3">
                                <div class="grid-item">${loopStatus.index + 1}</div>
                                <div class="grid-item">${app.lastname} ${app.firstname}</div>
                                <div class="grid-item">${app.title}</div>
                                <div class="grid-item">
                                    <a href="DownloadFileServlet?appId=${app.applicationid}">Tải xuống</a>
                                </div>
                                <div class="grid-item">${app.date}</div>
                            </a>
                        </c:forEach>

                    </div>

                </div>
            </div>
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h2 class="modal-title" style="color: #2fb5fa">
                                Chi tiết đơn
                            </h2>
                            <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                ></button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="" >
                                <div class="form-row mt-3 mb-3 pb-3 pt-3">
                                    <dl class="row">
                                        <dt class="col-12 col-sm-2 pb-4"><h3>Người gửi :</h3> </dt>
                                        <dd class="col-12 col-sm-8">

                                            <h3></h3>

                                        </dd>
                                        <hr/>
                                        <dt class="col-12 col-sm-2 pb-4">
                                            <h3>Tiêu đề :</h3>
                                        </dt>
                                        <dd class="col-12 col-sm-8">
                                            <h3></h3>
                                        </dd>
                                        <h3>File đính kèm : <a href="sendApplicationStudent?value=File.zip">Tải về</a></h3>
                                        <h3></h3>
                                    </dl>

                                </div>
                            </form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button
                                type="button"
                                class="btn btn-success"
                                data-bs-dismiss="modal"
                                >
                                <h3>Đồng ý</h3>
                            </button>
                            <button
                                type="button"
                                class="btn btn-danger"
                                data-bs-dismiss="modal"
                                >
                                <h3>Từ chối</h3>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="./includes/linkJS.jsp" %>
</body>

</html>
