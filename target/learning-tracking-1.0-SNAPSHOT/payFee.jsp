<%-- 
    Document   : payFee
    Created on : Sep 22, 2023, 10:02:36 AM
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
    
    <link rel="stylesheet" href="./assets/css/style-attendanceStatu--student.css" />
    <title>MS</title>
  </head>
  <body>
    <div class="app">
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
      </div>
      <div class="app-container">
        <div class="grid d-grid">
          <div class="app-home section-m1">
            <div class="row">
              <div class="col">
                <div class="box-section">
                  <div class="app-home__heading">
                    <div class="header-name">
                        <a href="studentHomePage.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                      Đóng học phí
                    </div>
                  </div>

                  <div class="row py-5 px-5 mx-5 my-5">
                    <h1 class="mb-4 text-secondary fw-bolder">
                      Lựa chọn các khoản phí
                    </h1>
                  </div>
                  
                  <div class="row px-5 mx-5 my-5">
                    <div class="col-2">
                      <h1 class="mb-4 text-secondary fw-bolder">
                        Học phí theo kì
                      </h1>
                    </div>
                    <div class="col-7">
                      <div class="form-group w-50">
                        <label for="exampleFormControlInput1"></label>
                        <input type="email" class="form-control fs-3" id="exampleFormControlInput1" placeholder="Nhập số tiền">
                      </div>
                    </div>
                  </div>
<!--                  <div class="row px-5 mx-5 my-5 pt-5 ">
                    <div class="col-2">
                      <h1 class="mb-4 text-secondary fw-bolder">
                        Kí túc xá
                      </h1>
                    </div>
                    <div class="col-5">
                      <div class="dropdown w-50">
                          <div class="drop-down--content" id="subMenu2">
                            <select id="application" class="fs-3">
                              <option value="Đơn xin nghỉ học">4 giường - 2 000 000</option>
                              <option value="Đơn rút hồ sơ">2 giường - 3 000 000</option>
                            </select>
                          </div>
                      </div>
                    </div>
                  </div>-->
                 
                  <div class="row px-5 mx-5 my-5">
                    <div class="col-2">
                      <h1 class="mb-4 text-secondary fw-bolder">
                        Các khoản khác
                      </h1>
                    </div>
                    <div class="col-7">
                      <div class="form-group w-50">
                        <label for="exampleFormControlInput1"></label>
                        <input type="email" class="form-control fs-3" id="exampleFormControlInput1"  placeholder="Nhập số tiền">
                      </div>
                    </div>
                  </div>

                  <div class="row px-5 mx-5 pt-5">
                    <button type="button" class="btn btn-primary col-1 fs-3">Submit</button>
                  </div>
                  
                </div>
              </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" 
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
      crossorigin="anonymous"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
      integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/5dd1c416dc.js"
      crossorigin="anonymous"
    ></script>
    <script src="assets/js/scripts.js"></script>
  </body>
</html>

