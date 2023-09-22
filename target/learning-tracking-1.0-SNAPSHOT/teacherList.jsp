<%-- 
    Document   : teacherList
    Created on : Sep 22, 2023, 10:04:23 AM
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
          <div class="app-home section-m1">
            <div class="row">
              <div class="col">
                <div class="box-section">
                  <div class="app-home__heading">
                    <div class="header-name">
                      <i class="fa-solid fa-arrow-left pe-2 ps-2"></i>
                      Nghỉ Học
                    </div>
                  </div>
                  
                  <div class="row mt-5 px-5">
                    <div class="col-3">
                      <div class="box-section h-100 w-75">
                        <div class="app-home__heading">
                          <div class="header-name">
                            <i class="fa-solid fa-calendar-days pe-2 ps-2"></i>
                            Danh sách Giáo Viên Bộ Môn
                          </div>
                        </div>
                        
                          <div class="dropdown mt-5">
                            <div class="drop-down--header" onclick="toggleMenu1()">
                              <span class="drop-down--title">Lớp 10</span>
                              <i class="fa-solid fa-caret-down dropdown--icon"></i>
                            </div>
                              <div class="drop-down-content" id="subMenu1">
                                <ul class="drop-down-link">
                                  <li><a href="#">Kỳ 1</a></li>
                                  <li><a href="#">Kỳ 2</a></li>
                                </ul>
                              </div>
                          </div>
                        
                    
                        
                          <div class="dropdown mt-5">
                            <div class="drop-down--header" onclick="toggleMenu2()">
                              <span class="drop-down--title">Lớp 10</span>
                              <i class="fa-solid fa-caret-down dropdown--icon"></i>
                            </div>
                              <div class="drop-down-content"  id="subMenu2">
                                <ul class="drop-down-link">
                                  <li><a href="#">Kỳ 1</a></li>
                                  <li><a href="#">Kỳ 2</a></li>
                                </ul>
                              </div>
                          </div>
                      
                       
                        <div class="dropdown my-5">
                          <div class="drop-down--header" onclick="toggleMenu3()">
                            <span class="drop-down--title">Lớp 10</span>
                            <i class="fa-solid fa-caret-down dropdown--icon"></i>
                          </div>
                            <div class="drop-down-content" id="subMenu3">
                              <ul class="drop-down-link">
                                <li><a href="#">Kỳ 1</a></li>
                                <li><a href="#">Kỳ 2</a></li>
                              </ul>
                            </div>
                        </div>
                      </div>

                      
                    </div>

                    <div class="col">
                      <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th class="col-1 text-center" scope="col" >Môn học</th>
                            <th class="col-2 text-center"  scope="col">Giáo Viên</th>
                            <th class="col-3 text-center" scope="col">SĐT</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>Toán</td>
                            <td>Nguyễn Thị A</td>
                            <td>1234567890</td>
                          </tr>
                          <tr>
                            <td>Văn</td>
                            <td>Trần Văn C </td>
                            <td>09999999999</td>
                          </tr>
                          <tr>
                            <td>Anh</td>
                            <td>Bùi Thị C</i></td>
                            <td>0888888888</td>
                          </tr>
                        </tbody>
                      </table>
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
