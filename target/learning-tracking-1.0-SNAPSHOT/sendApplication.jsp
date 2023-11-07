<%-- 
    Document   : sendApplication
    Created on : Sep 22, 2023, 10:02:52 AM
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
                                            Gửi đơn                   
                                        </div>
                                    </div>
                                        <form action="insertApplicationStudent" method="post" enctype="multipart/form-data">
                                        <div class="row py-5 px-5 mx-5 mt-5">
                                            <h1 class="mb-4 text-secondary fw-bolder">
                                                Gửi đơn cho phòng giáo vụ
                                            </h1>
                                        </div><!-- comment -->
                                        <div class="row px-5 mx-5 mb-5 pb-5 ">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Tiêu đề
                                                </h1>
                                            </div>
                                            <div class="col-5">
                                                <input name="title" type="text" class="form-control noti-select" style="font-size: 20px;" placeholder="" required>
                                            </div>
                                        </div>
                                        <div class="row px-5 mx-5 mb-5 pb-5 ">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Loại đơn
                                                </h1>
                                            </div>
                                            <div class="col-5">
                                                <div class="dropdown">
                                                    <div class="drop-down--content" id="subMenu2">
                                                        <select name="categoryid" id="application" class="fs-3" style="font-size: 20px;">
                                                            <option value="1">Đơn xin nghỉ học</option>
                                                            <!--<option value="2">Đơn rút hồ sơ</option>-->
                                                        </select>
                                                    </div>                         
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row px-5 mx-5 mb-5 pb-5 ">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Mẫu đơn
                                                </h1>
                                            </div>
                                            <div class="col-8">
                                                 <a style="font-size: 20px;" href="sendApplicationStudent?value=File.zip" >Tải về</a>
                                            </div>
                                            
                                        </div>

                                        <div class="row px-5 mx-5 my-5">
                                            <div class="col-2">
                                                <h1 class="mb-4 text-secondary fw-bolder">
                                                    Nộp đơn
                                                </h1>
                                            </div>
                                            <div class="col-9">
                                                <div class="form-group">
                                                    <label  style="font-size: 16px;" for="attachmentFile" class="form-label">File đính kèm:</label>
                                                    <input  style="font-size: 16px;" type="file" class="form-control" id="attachmentFile" name="docxFile" required>
                                                </div>
                                            </div>
                                            <input type="hidden" name="studentid" value="" />
                                        </div>                                      
                                        <div class="row px-5 mx-5 pt-5 pb-5">
                                            <div class="col-10"></div>
                                            <button type="submit" class="btn btn-primary col-1 fs-3">NỘP ĐƠN</button>
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
