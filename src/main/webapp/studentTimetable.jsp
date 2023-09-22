<%-- 
    Document   : studentTimetable
    Created on : Sep 22, 2023, 10:03:55 AM
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
                      Thời khóa biểu
                    </div>
                  </div>
                  
                  <div class="app-home__body">
                    <div class="row">
                        <div class="col">
                            <!-- Timetable details  -->
                            <table class="table table-bordered">
                              <thead class="background-primary">
                                  <tr class="text-color-white">
                                    <th>Buổi</th>
                                    <th>Tiết</th>
                                    <th>Thứ 2</th>
                                    <th>Thứ 3</th>
                                    <th>Thứ 4</th>
                                    <th>Thứ 5</th>
                                    <th>Thứ 6</th>
                                    <th>Thứ 7</th>
                                    <th>Chủ Nhật</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td rowspan="5" class="align-middle">Sáng</td>
                                    <td>1</td>
                                    <td>Toán</td>
                                    <td>Toán</td>
                                    <td>Toán</td>
                                    <td>Toán</td>
                                    <td>Toán</td>
                                    <td>Toán</td>
                                    <td></td>
                                  </tr>
                                  <tr>
                                      <td>2</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td></td>
                                    </tr>
                                    <tr>
                                      <td>3</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td></td>
                                    </tr>
                                    <tr>
                                      <td>4</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td></td>
                                    </tr>
                                    <tr>
                                      <td>5</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td>Toán</td>
                                      <td></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="5" class="align-middle">Chiều</td>
                                        <td>1</td>
                                        <td>Toán</td>
                                        <td>Toán</td>
                                        <td>Toán</td>
                                        <td>Toán</td>
                                        <td>Toán</td>
                                        <td>Toán</td>
                                        <td></td>
                                      </tr>
                                      <tr>
                                          <td>2</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td></td>
                                        </tr>
                                        <tr>
                                          <td>3</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td></td>
                                        </tr>
                                        <tr>
                                          <td>4</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td></td>
                                        </tr>
                                        <tr>
                                          <td>5</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td>Toán</td>
                                          <td></td>
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

