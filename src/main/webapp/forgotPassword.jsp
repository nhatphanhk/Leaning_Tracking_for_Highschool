<%-- 
    Document   : forgotPassword
    Created on : Oct 6, 2023, 10:00:30 PM
    Author     : nhatp
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
      <!-- header  -->
           <div class="header">
    <div class="grid h-100">
        <nav class="navbar navbar-light h-100">
            <a
                class="navbar-brand navbar-logo h-100"
                href="studentHomePage.jsp"
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
    <!--Dropdown Setting-->
    <div class="btn-group nav-dropdown-setting">
        <button
            type="button"
            class="btn btn-secondary dropdown-toggle"
            data-bs-toggle="dropdown"
            aria-expanded="false"
            ></button>
        <ul class="dropdown-menu">
            
            <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
        </ul>
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
                      <a href="studentHomePage.jsp">
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      Quên mật khẩu
                    </div>
                  </div>
                  <div class="app-home__body">
                    <div class="info-container">
                        <div class="m-5">
                            <div class="col-3 m-2">
                        <form class="change-password-container">
                          
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
    </div>
        <%@ include file="./includes/linkJS.jsp" %>
        <script src="./assets/js/mycode.js"></script>
    </script>
</body>
</html>
