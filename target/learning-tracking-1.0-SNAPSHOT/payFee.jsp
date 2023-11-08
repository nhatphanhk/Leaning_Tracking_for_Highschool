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
    <link rel="stylesheet" href="./assets/css/styleFee.css" />
    <link rel="stylesheet" href="assets/css/sendApplication.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>


    
    <title>MS</title>
  </head>
 

<body>
    <div class="app">
        <%@ include file="./includes/header.jsp" %>

    <div class="app-container">
        <div class="grid d-grid">
            <div class="app-home section-m1">
                <div class="row">
                    <div class="col">
                        <div class="box-section row">
                            <div class="app-home__heading">
                                <div class="header-name">
                                    <a href="studentHomePage.jsp"><i class="fa-solid fa-arrow-left pe-2 ps-2"></i></a>
                                    Học phí
                                </div>
                            </div>
                            <form class="col">
                                <div class="row px-5 mx-5 mt-5">
                                    <h1 class="mb-4 text-secondary fw-bolder">
                                        Lựa chọn các khoản phí :
                                    </h1>
                                </div>

                               <div class="row px-5 mx-5 mb-5 pb-5">
                                <div class="col-3">
                                    <h1 class="mt-2 text-secondary fw-bolder align-middle">
                                        Học Phí theo Kỳ :
                                    </h1>
                                </div>
                                <div class="col-5">
                                    <input class="fs-2" type="checkbox" id="hoc-phi" onchange="LinkVPN()"/>
                                    <label for="hoc-phi">7.499.000</label>
                                </div>
                            </div>

                            <div class="row px-5 mx-5 mb-5 pb-5">
                                <div class="col-3">
                                    <h1 class="mt-2 text-secondary fw-bolder align-middle">
                                        Các khoản phí khác :
                                    </h1>
                                </div>
                                <div class="col-5">
                                    <input class="fs-2" type="checkbox" id="khoan-phi" onchange="LinkVPN()"/>
                                    <label for="khoan-phi">2.000.000</label>
                                </div>
                            </div>

                            <input type="hidden" id="hoc-phi-amount" name="hoc-phi-amount" value="0">
                            <input type="hidden" id="khoan-phi-amount" name="khoan-phi-amount" value="0">

                                
                                <div class="row px-5 mx-5 mb-5 pb-5 collapse" id="LinkVPN" style="font-size: 20px">
                                    <div class="col-8">
                                        Hãy tới nhấn vào đường link để tới trang thanh toán. <a id="payLink" class="text-color-green" target="_blank" href="#" >Link</a>
                                    </div>

                                </div>

                                <div class="row px-5 mx-5 pt-5 pb-5">
                                    <div class="col-10"></div>
                                    <button type="button" class="btn btn-primary col-1 fs-3" onclick="showLinkVPN()">Submit</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
                
</body>
</html>


    <%@ include file="./includes/linkJS.jsp" %>
    <script>
            
                function LinkVPN() {
                    var checkbox1 = document.getElementById("hoc-phi");
                    var checkbox2 = document.getElementById("khoan-phi");
                    var hocPhiAmount = parseFloat(checkbox1.checked ? checkbox1.nextElementSibling.textContent : 0);
                    var khoanPhiAmount = parseFloat(checkbox2.checked ? checkbox2.nextElementSibling.textContent : 0);

                    var totalAmount = (hocPhiAmount + khoanPhiAmount)*1000000;

                    if (totalAmount > 0) {
                        var payLink = document.getElementById("payLink");
                        payLink.href = "payServlet?totalAmount=" + totalAmount;
                    }
                }


   


            function showLinkVPN() {
                var checkbox1 = document.getElementById("hoc-phi");
                var checkbox2 = document.getElementById("khoan-phi");
                var collapsible = document.getElementById("LinkVPN");

                if (checkbox1.checked || checkbox2.checked) {
                    collapsible.classList.add("show");
                } else {
                    collapsible.classList.remove("show");
                }
            }
</script>
    <script src="assets/js/scripts.js"></script>




      </body>
</html>
