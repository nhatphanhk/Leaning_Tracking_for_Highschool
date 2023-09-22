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
                      Danh sách học sinh
                    </div>
                  </div>
                  
                  <div class="app-home__body">
                    <div class="row">
                        <div class="col">
                            <!-- Student List details  -->
                            <table class="table table-bordered table-striped">
                              <thead class="background-primary">
                                  <tr class="text-color-white">
                                    <th>STT</th>
                                    <th>Mã học sinh</th>
                                    <th>Họ và Tên</th>
                                    <th>Giới tính</th>
                                    <th>Ngày sinh</th>
                                    <th>Số điện thoại</th>
                                    <th>Địa chỉ</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td>1</td>
                                    <td>DE170068</td>
                                    <td>Hà Trọng Tấn</td>
                                    <td>Nam</td>
                                    <td>1/1/2007</td>
                                    <td>0123456789</td>
                                    <td>86 Land, FPT Arena</td>
                                  </tr>
                                  <tr>
                                    <td>1</td>
                                    <td>DE170068</td>
                                    <td>Hà Trọng Tấn</td>
                                    <td>Nam</td>
                                    <td>1/1/2007</td>
                                    <td>0123456789</td>
                                    <td>86 Land, FPT Arena</td>
                                  </tr>
                                  <tr>
                                    <td>1</td>
                                    <td>DE170068</td>
                                    <td>Hà Trọng Tấn</td>
                                    <td>Nam</td>
                                    <td>1/1/2007</td>
                                    <td>0123456789</td>
                                    <td>86 Land, FPT Arena</td>
                                  </tr>
                                  <tr>
                                    <td>1</td>
                                    <td>DE170068</td>
                                    <td>Hà Trọng Tấn</td>
                                    <td>Nam</td>
                                    <td>1/1/2007</td>
                                    <td>0123456789</td>
                                    <td>86 Land, FPT Arena</td>
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
