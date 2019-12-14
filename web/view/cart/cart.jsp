<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="zxx">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>SP365</title>
  <link rel="icon" href="img/favicon.png">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- animate CSS -->
  <link rel="stylesheet" href="css/animate.css">
  <!-- owl carousel CSS -->
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <!-- nice select CSS -->
  <link rel="stylesheet" href="css/nice-select.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/all.css">
  <!-- flaticon CSS -->
  <link rel="stylesheet" href="css/flaticon.css">
  <link rel="stylesheet" href="css/themify-icons.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/magnific-popup.css">
  <!-- swiper CSS -->
  <link rel="stylesheet" href="css/slick.css">
  <link rel="stylesheet" href="css/price_rangs.css">
  <!-- style CSS -->
  <link rel="stylesheet" href="css/style.css">
</head>

<body class="bg-white">
  <!--::header part start::-->
  <header class="main_menu home_menu">
      <div class="container-fluid">
          <div class="row align-items-center justify-content-center">
              <div class="col-lg-11">
                  <nav class="navbar navbar-expand-lg navbar-light">
                      <a class="navbar-brand" href="index.html"> <img src="img/logo.png" alt="logo"> </a>
                      <button class="navbar-toggler" type="button" data-toggle="collapse"
                          data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                          aria-expanded="false" aria-label="Toggle navigation">
                          <span class="menu_icon"><i class="fas fa-bars"></i></span>
                      </button>

                      <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                          <ul class="navbar-nav">
                              <li class="nav-item">
                                  <a class="nav-link" href="index.html">Home</a>
                              </li>
                              <li class="nav-item dropdown">
                                  <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_1"
                                      role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                      Shop
                                  </a>
                                  <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                      <a class="dropdown-item" href="category.html"> shop category</a>
                                      <a class="dropdown-item" href="single-product.html">product details</a>
                                  </div>
                              </li>
                              <li class="nav-item dropdown">
                                  <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_3"
                                      role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                      pages
                                  </a>
                                  <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                      <a class="dropdown-item" href="login.html"> 
                                          login
                                          
                                      </a>
                                      <a class="dropdown-item" href="tracking.html">tracking</a>
                                      <a class="dropdown-item" href="checkout.html">product checkout</a>
                                      <a class="dropdown-item" href="cart.html">shopping cart</a>
                                      <a class="dropdown-item" href="confirmation.html">confirmation</a>
                                      <a class="dropdown-item" href="elements.html">elements</a>
                                  </div>
                              </li>
                              
                              <li class="nav-item dropdown">
                                  <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_2"
                                      role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                      blog
                                  </a>
                                  <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                      <a class="dropdown-item" href="blog.html"> blog</a>
                                      <a class="dropdown-item" href="single-blog.html">Single blog</a>
                                  </div>
                              </li>
                              
                              <li class="nav-item">
                                  <a class="nav-link" href="contact.html">Contact</a>
                              </li>
                          </ul>
                      </div>
                      <div class="hearer_icon d-flex">
                          <div class="dropdown cart">
                              <a class="dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  <i class="ti-bag"></i>
                              </a>
                              <!-- <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                  <div class="single_product">
  
                                  </div>
                              </div> -->
                          </div>
                          <a id="search_1" href="javascript:void(0)"><i class="ti-search"></i></a>
                      </div>
                  </nav>
              </div>
          </div>
      </div>
      <div class="search_input" id="search_input_box">
          <div class="container ">
              <form class="d-flex justify-content-between search-inner">
                  <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                  <button type="submit" class="btn"></button>
                  <span class="ti-close" id="close_search" title="Close Search"></span>
              </form>
          </div>
      </div>
  </header>
  <!-- Header part end-->

  <!-- breadcrumb start-->
  <section class="breadcrumb breadcrumb_bg">
      <div class="container">
          <div class="row justify-content-center">
              <div class="col-lg-12">
                  <div class="breadcrumb_iner">
                      <div class="breadcrumb_iner_item">
                          <p>Home/Shop/Single product/Cart list</p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </section>
  <!-- breadcrumb start-->



  <!--================Cart Area =================-->
  <section class="cart_area section_padding">
    <div class="container">
      <div class="cart_inner">
        <div class="table-responsive">
        <form action="updatecitem.sp?u_id=${cart.u_id}" method = "post">	<!-- 카트 update form -->
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Product</th>
                <th scope="col">Price</th>
                <!--  <th scope="col">Size</th> -->
                <th scope="col">Quantity</th>
                <th scope="col">Total</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>	
            
            <!-- **********아작스로 넣을 부분!************* -->
				<c:forEach var="cart" items="${cartlist }" varStatus="status">
					<tr>
              		  <td>
                  		<div class="media">
                  		  <div class="d-flex">
                  		    <img src="img/product_img/${cart.p_id}.jpg" alt="" />
                  		  </div>
                	    <div class="media-body">
                     		 <p>${pdlist[status.index].p_name }</p>
                  		  </div>
                  		</div>
                	</td>
                	<td>
                  		<h5>${pdlist[status.index].p_price }</h5>
               		</td>
               		<!--<td>
                  		<h5>${cart.c_size }</h5>
               		</td> -->
               		<td>
                  		<div class="product_count">
                      		<span class="input-number-decrement"> <i class="ti-minus"></i></span>
                    		<input class="input-number" type="text" value="${cart.c_qty }" min="1" max="10" name="qty">
                    		<span class="input-number-increment"> <i class="ti-plus"></i></span>
                 		</div>
                	</td>
                	 <td>
                	 	<h5>
                	 		${cart.c_price }
                	 		<input type="text" value="${cart.c_id }" name="id" style="display:none;">
                	 		<input type="text" value="${pdlist[status.index].p_price }" name="price" style="display:none;">
                	 	</h5>
                	</td>
                    <td>
                	 	<a href="deletecitem.sp?c_id=${cart.c_id}&u_id=${cart.u_id}" >DELETE</a>
                	</td>
				</c:forEach>
				
   			 <!-- **********아작스로 넣을 부분 끝************* -->
              <tr class="bottom_button">
                <td></td>
                <!-- <td>
                  <a class="btn_1" href="#">Update Cart</a>
                </td> -->
                <td></td>
                <td></td>
                <td></td>
                <td>
                  <div class="cupon_text float-right">
                    <input type="submit" class="btn_1" value="Update Cart">
                  </div>
                </td>
              </tr>
              
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>
                  <h5>Subtotal</h5>
                </td>
                <td>
                  <h5>${subtotal}</h5>
                </td>
              </tr>
              
              
              
              <!-- ************* 배송 옵션 (나라 등 ) ************** -->
              <!--<tr class="shipping_area">
                <td></td>
                <td></td>
                <td>
                  <h5>Shipping</h5>
                </td>
                <td>
                  <div class="shipping_box">
                    <ul class="list">
                       <li>
                        Flat Rate: $5.00
                        <input type="radio" aria-label="Radio button for following text input">
                      </li>
                      <li> 
                        Free Shipping
                        <input type="radio" aria-label="Radio button for following text input">
                      </li>-->
                      <!--<li>
                        Flat Rate: $10.00
                        <input type="radio" aria-label="Radio button for following text input">
                      </li>
                      <li class="active">
                        Local Delivery: $2.00
                        <input type="radio" aria-label="Radio button for following text input">
                      </li>
                    </ul>
                    <h6>
                      Calculate Shipping
                      <i class="fa fa-caret-down" aria-hidden="true"></i>
                    </h6>
                    <select class="shipping_select">
                      <option value="1">Bangladesh</option>
                      <option value="2">India</option>
                      <option value="4">Pakistan</option>
                    </select>
                    <select class="shipping_select section_bg">
                      <option value="1">Select a State</option>
                      <option value="2">Select a State</option>
                      <option value="4">Select a State</option>
                    </select>
                    <input class="post_code" type="text" placeholder="Postcode/Zipcode" />
                    <a class="btn_1" href="#">Update Details</a>
                  </div>
                </td>
              </tr>-->
            </tbody>
          </table> 
          </form> <!-- 카트 업데이트 form 끝 -->
          <!--  **********구매 페이지 넘어감 *************** -->
          <div class="checkout_btn_inner float-right">
            <a class="btn_1" href="#">Continue Shopping</a>
            <a class="btn_1 checkout_btn_1" href="order.sp?subtotal=${subtotal}">Proceed to checkout</a>
          </div>
        </div>
      </div>
  </section>
  <!--================End Cart Area =================-->

  <!--::footer_part start::-->
  <footer class="footer_part">
      <div class="container">
          <div class="row justify-content-between">
              <div class="col-sm-6 col-lg-2">
                  <div class="single_footer_part">
                      <h4>Category</h4>
                      <ul class="list-unstyled">
                          <li><a href="#">Male</a></li>
                          <li><a href="#">Female</a></li>
                          <li><a href="#">Shoes</a></li>
                          <li><a href="#">Fashion</a></li>
                      </ul>
                  </div>
              </div>
              <div class="col-sm-6 col-lg-2">
                  <div class="single_footer_part">
                      <h4>Company</h4>
                      <ul class="list-unstyled">
                          <li><a href="">About</a></li>
                          <li><a href="">News</a></li>
                          <li><a href="">FAQ</a></li>
                          <li><a href="">Contact</a></li>
                      </ul>
                  </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                  <div class="single_footer_part">
                      <h4>Address</h4>
                      <ul class="list-unstyled">
                          <li><a href="#">200, Green block, NewYork</a></li>
                          <li><a href="#">+10 456 267 1678</a></li>
                          <li><span>contact89@winter.com</span></li>
                      </ul>
                  </div>
              </div>
              <div class="col-sm-6 col-lg-4">
                  <div class="single_footer_part">
                      <h4>Newsletter</h4>
                      <div id="mc_embed_signup">
                          <form target="_blank"
                              action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                              method="get" class="subscribe_form relative mail_part">
                              <input type="email" name="email" id="newsletter-form-email" placeholder="Email Address"
                                  class="placeholder hide-on-focus" onfocus="this.placeholder = ''"
                                  onblur="this.placeholder = ' Email Address '">
                              <button type="submit" name="submit" id="newsletter-submit"
                                  class="email_icon newsletter-submit button-contactForm">subscribe</button>
                              <div class="mt-10 info"></div>
                          </form>
                      </div>
                      <div class="social_icon">
                          <a href="#"><i class="ti-facebook"></i></a>
                          <a href="#"><i class="ti-twitter-alt"></i></a>
                          <a href="#"><i class="ti-instagram"></i></a>
                      </div>
                  </div>
              </div>
          </div>
          <div class="row justify-content-center">
              <div class="col-lg-12">
                  <div class="copyright_text">
                      <P><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></P>
                  </div>
              </div>
          </div>
      </div>
  </footer>
  <!--::footer_part end::-->

  <!-- jquery plugins here-->
  <script src="js/jquery-1.12.1.min.js"></script>
  <!-- popper js -->
  <script src="js/popper.min.js"></script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.min.js"></script>
  <!-- easing js -->
  <script src="js/jquery.magnific-popup.js"></script>
  <!-- swiper js -->
  <script src="js/swiper.min.js"></script>
  <!-- swiper js -->
  <script src="js/mixitup.min.js"></script>
  <script src="js/price_rangs.js"></script>
  <!-- particles js -->
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.nice-select.min.js"></script>
  <!-- slick js -->
  <script src="js/slick.min.js"></script>
  <script src="js/jquery.counterup.min.js"></script>
  <script src="js/waypoints.min.js"></script>
  <script src="js/contact.js"></script>
  <script src="js/jquery.ajaxchimp.min.js"></script>
  <script src="js/jquery.form.js"></script>
  <script src="js/jquery.validate.min.js"></script>
  <script src="js/mail-script.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
</body>

</html>