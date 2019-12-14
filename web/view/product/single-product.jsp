<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="icon" href="img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<!--<link rel="stylesheet" href="css/owl.carousel.min.css">  -->
<link rel="stylesheet" href="css/lightslider.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/nice-select.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">

<script>
	function isLogin(loginid) {
		var detailform = $('form[name="detailform"]');
		var confirmLogin;
		alert("isLogin() 실행");
		if ( loginid == null) {
			confirmLogin = confirm('로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?');
			if (confirmLogin) {
				alert('로그인 페이지로 이동합니다.');
				// location.href = "login.sp";
				detailform.action = "login.sp";
			} else {
				alert('메인 페이지로 이동합니다.');
				// location.href = "main.sp";
				detailform.action = "main.sp";
			}
		} 
		else {
			confirmLogin = confirm('장바구니에 성공적으로 추가되었습니다.\n 장바구니 페이지로 이동하시겠습니까?');
			if(confirmLogin) {
				alert('장바구니 페이지로 이동합니다.');
				detailform.action = "cart.sp";
			} else {
				detailform.action = "cart.sp";
			}
		}
	};
</script>




<!--================Single Product Area =================-->
<div class="product_image_area section_padding">
	<div class="container">
		<div class="row s_product_inner">
			<div class="col-lg-5">
				<div class="product_slider_img">
					<div id="vertical">
						<!-- 이미지 파일들! -->
						<div data-thumb="img/product_img/${pd.p_id }.jpg">
							<img src="img/product_img/${pd.p_id }.jpg" />
						</div>
						<!--  <div data-thumb="img/product_img2/${pd_category }/${pd_id}/0.jpg">
								<img src="img/product_img2/${pd_category }/${pd_id}/0.jpg" />
							</div>
							<div data-thumb="iimg/product_img2/${pd_category }/${pd_id}/1.jpg">
								<img src="img/product_img2/${pd_category }/${pd_id}/1.jpg" />
							</div>
							<div data-thumb="img/product_img2/${pd_category }/${pd_id}/2.jpg">
								<img src="img/product_img2/${pd_category }/${pd_id}/2.jpg" />
							</div>-->
					</div>
				</div>
			</div>
			<div class="col-lg-5 offset-lg-1">
				<div class="s_product_text">
					<h3>${pd.p_name }</h3>
					<h2>${pd.p_price }WON</h2>
					<ul class="list">
						<li><a class="active" href="#"> <span>Category</span> :
								${pd.p_category }
						</a></li>
						<li><a href="#"> <span>Availibility</span> :
								${pd_stockstatus }
						</a></li>
						<!--  <li><a href="#"> <span>Arrival</span> : ${pd_dday } </a></li> -->
					</ul>
					<p></p>
					<!-- cart controller로 올릴 form -->
					<form action="addcart.sp?p_id=${pd.p_id }" method="post" name="detailform">
						<!-- 사이즈 버튼  -->
						<div class="default-select" id="default-select_2">
							<select name="size">
								<option value="small">small</option>
								<option value="medium">medium</option>
								<option value="large">large</option>
							</select>
						</div>
						<div class="card_area">
							<div class="product_count d-inline-block">
								<span class="inumber-decrement"> <i class="ti-minus"></i></span>
								<!-- 수량 버튼 -->
								<input class="input-number" type="number" value="1" min="0"
									max="10" name="qty"> <span class="number-increment">
									<i class="ti-plus"></i>
								</span>
							</div>
							<!-- 아이디 로그인 안 되어 있으면 경고 띄우자! -->
							<!-- add cart 버튼 -->
							<div class="add_to_cart">
								<input class="btn_3" type="submit" value="add to cart"
									id="cartaddbutton" onclick="isLogin(${loginid});"> 
								<a href="#" class="like_us"> <i class="ti-heart"></i></a>
							</div>
							<div class="social_icon">
								<a href="#" class="fb"><i class="ti-facebook"></i></a> 
								<a href="#" class="tw"><i class="ti-twitter-alt"></i></a> 
								<a href="#" class="li"><i class="ti-linkedin"></i></a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--================End Single Product Area =================-->

<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="js/lightslider.min.js"></script>
<!-- swiper js -->
<script src="js/mixitup.min.js"></script>
<script src="js/lightslider.min.js"></script>
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
