<%-- 
    Document   : payFee_Create
    Created on : Nov 7, 2023, 8:20:58 AM
    Author     : nhatp
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

        <link rel="stylesheet" href="./assets/css/sendApplication.css" />
        <title>MS</title>
    </head>
    <body>
        <div class="app">
            <!-- header  -->
            <%@ include file="./includes/header.jsp" %>
           <div class="app-container">
                <div class="grid d-grid">
                    <div class="app-home section-m1">
                        <div class="row">
                            <div class="col">
                                <div class="box-section">
                                    <div class="app-home__heading">
                                        <div class="header-name">
                                            <a href="studentHomePage.jsp">
                                                <i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                            Tạo học phí                   
                                        </div>
                                    </div>
                                        <form action="AddFeeController" method="post">
<!--                                        <div class="row py-5 px-5 mx-5 mt-5">
                                            <h1 class="mb-4 text-secondary fw-bolder">
                                                Gửi đơn cho thầy cô giáo chủ nhiệm
                                            </h1>
                                        </div> comment -->
                                        <div class="row mt-5 px-5 mx-5 mb-5 pb-5 ">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Loại học phí
                                                </h1>
                                            </div>
                                            <div class="col-5">
                                                <div class="dropdown">
                                                    <div class="drop-down--content" id="subMenu2">
                                                        <select name="categoryid" id="application" class="form-control noti-select" style="font-size: 20px; border: 1px solid #ccc; padding: 5px; border-radius: 5px;">
                                                            <option value="1">Học phí</option>
                                                            <option value="2">Học phí khác</option>
                                                        </select>
                                                        <i class="fas fa-caret-down" style="font-size:15px ;position: absolute; right: 15px; top: 50%; transform: translateY(-50%);"></i>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                        <div class="row px-5 mx-5 mb-5 pb-5 ">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Số tiền
                                                </h1>
                                            </div>
                                            <div class="col-5">
                                                <input name="title" type="text" class="form-control noti-select" style="font-size: 20px;" placeholder="" required>
                                            </div>
                                        </div>
                                                                                                               
                                            <div class="row px-5 mx-5 pt-5 pb-5">
                                            <div class="col-10"></div>
                                            <button type="submit" class="btn btn-primary col-1 fs-3" >Lưu</button>
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


    <%@ include file="./includes/linkJS.jsp" %>
    <%@ include file="./includes/script.html" %>
    <script src="assets/js/scripts.js"></script>
</body>
</html>
</html>

