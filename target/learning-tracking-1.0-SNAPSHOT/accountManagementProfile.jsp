<%-- 
    Document   : accountManagementProfile
    Created on : Oct 3, 2023, 10:55:17 AM
    Author     : htk09
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="./includes/headerAccountManagement.jsp" %>


      <div class="app-container mt-0">
        <div class="grid d-grid">
          <div class="section-m1">
            <div class="row">
              <div class="col">
                <div class="box-section">
                  <div class="app-home__heading">
                    <div class="header-name">
                      Hồ sơ Quản lí tài khoản
                    </div>
                  </div>
                  <div class="app-home__body">
                    <div class="info-container">
                      <div class="row mt-5">
                        <div class="col">
                          <div class="row">
                            <div class="col">
                              <div class="card-body text-center student-profile__avatar">
                                <img
                                  class="img-account-profile rounded-circle mb-4 mt-4"
                                  src="./assets/imgs/GrayUser.png"
                                  alt=""
                                />
                              </div>
                            </div>
                            <div class="col">
                              <div class="card-body student-profile">
                                <ul class="profile-info">
                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                      Họ & Tên: ${sessionScope.accountManager.lastname} ${sessionScope.accountManager.firstname}
                                    </li>
                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                      Thời gian công tác : 2015 - 2023
                                    </li>
                                    <li class="profile-info-item h2 ms-2 mb-4 fw-bold">
                                      Giới tính: Nam
                                    </li>
                                </ul>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="col">
                        </div>
                      </div>
                    </div>
                  </div>


                  <!-- Tabs profile  -->
                  <div class="tabs ms-5">
                    <div class="tab-item active">
                      Tổng quan
                    </div>
                    <div class="line"></div>
                  </div>
    
                  <div class="tab-content p-3">
                    <div class="tab-pane active">
                      <ul class="general-info-list">
                        <li class="general-info-item fs-20 mb-2 fw-bold">Ngày, tháng, năm sinh: 04/03/1990</li>
                        <li class="general-info-item fs-20 mb-2 fw-bold">Hộ khẩu thường trú: 86 land, kdt FPT, Đà Nẵng</li>
                        <li class="general-info-item fs-20 mb-2 fw-bold">Số điện thoại: ${sessionScope.accountManager.phone}</li>
                        <li class="general-info-item fs-20 mb-2 fw-bold">Email: ${sessionScope.accountManager.email}</li>
                      </ul>
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