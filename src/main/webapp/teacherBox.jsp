<%-- 
    Document   : teacherBox
    Created on : Sep 22, 2023, 10:04:05 AM
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
  <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet" />
  <link rel="stylesheet" href="./assets/css/teacher-base.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="./assets/css/teacher-style.css" />
  <title>MS</title>
</head>

<body>
  <div class="app">
    <div class="header">
      <div class="grid h-100">
        <nav class="navbar navbar-light h-100">
            <a class="navbar-brand navbar-logo h-100" href="teacherHomePage.jsp">
            <img src="./assets/imgs/logoPng.png" class="d-inline-block align-top h-100" alt="" />
            <p>Sổ liên lạc điện tử</p>
          </a>

          <div class="navbar-school">
            <img src="./assets/imgs/highSchool.png" width="30" height="30" class="d-inline-block align-top" alt="" />
            <p>FPT High School</p>
          </div>
        </nav>
      </div>
    </div>
    <div class="app-container d-flex justify-content-center">
      <div class="box-section w-50 mt-lg-5">
        <div class="app-home__heading">
          <div class="header-name">
              <a href="teacherHomePage.jsp"><i class="fa-solid fa-arrow-left me-3"></i></a>
            Hòm Thư
          </div>
        </div>
        <div class="app-home__content">
          <div class="grid-container grid-header">
            <div class="grid-item">STT</div>
            <div class="grid-item">Họ Và Tên</div>
            <div class="grid-item">Nội Dung</div>
            <div class="grid-item">Ngày Gửi</div>
          </div>
          <a href="#" class="grid-container">
            <div class="grid-item">1</div>
            <div class="grid-item">Hà Trọng Tấn</div>
            <div class="grid-item">Thư xin vắng học buổi thứ 3 ngày 23/2/2019</div>
            <div class="grid-item">07/07/2019</div>
          </a>
          <a href="#" class="grid-container">
            <div class="grid-item">2</div>
            <div class="grid-item">Nguyễn Thị Trà My</div>
            <div class="grid-item">Thư xin giấy xác nhận học sinh</div>
            <div class="grid-item">07/07/2019</div>
          </a>
          <a href="#" class="grid-container">
            <div class="grid-item">3</div>
            <div class="grid-item">Hoàng Tuấn Kiệt</div>
            <div class="grid-item">Thư đăng ký học kèm môn Toán</div>
            <div class="grid-item">07/07/2019</div>
          </a>
        </div>
        <div class="navigation me-5">
          <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end pagination-lg mt-3">
              <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#">Next</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
  <script src="https://kit.fontawesome.com/5dd1c416dc.js" crossorigin="anonymous"></script>
</body>

</html>