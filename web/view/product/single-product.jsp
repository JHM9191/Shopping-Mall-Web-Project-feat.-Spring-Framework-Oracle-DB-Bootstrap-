<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script>
	function isLogin(loginid) {
		var detailform = $('form[name="detailform"]');
		var confirmLogin;
		alert("isLogin() 실행");
		if ( loginid == null) {
			confirmLogin = confirm('로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?');
			if (confirmLogin) {
				alert('로그인 페이지로 이동합니다.');
				detailform.action = "login.sp";
			} else {
				alert('메인 페이지로 이동합니다.');
				detailform.action = "main.sp";
			}
		} 
		else {
			confirmLogin = confirm('장바구니에 성공적으로 추가되었습니다.\n 장바구니 페이지로 이동하시겠습니까?');
			if(confirmLogin) {
				alert('장바구니 페이지로 이동합니다.');
				detailform.action = "cart.sp";
				detailform.submit();
//			} else {
//				detailform.action = "cart.sp";
//			}
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
								<span class="number-decrement"> <i class="ti-minus"></i></span>
								<!-- 수량 버튼 -->
								<input class="input-number" type="text" value="1" min="1"	max="10" name="qty"> 
									<span class="number-increment"><i class="ti-plus"></i>
								</span>
							</div>
							<!-- add cart 버튼 -->
							<div class="add_to_cart">
								<input class="btn_3" type="submit" value="add to cart"
									id="cartaddbutton" onclick="isLogin('${loginid}');"> 
								<a href="#" class="like_us"> <i class="ti-heart"></i></a>
							</div>
							<div class="social_icon">
								<a href="https://ko-kr.facebook.com/" class="fb"><i class="ti-facebook"></i></a> 
								<a href="https://twitter.com/login?lang=ko" class="tw"><i class="ti-twitter-alt"></i></a> 
								<a href="https://www.instagram.com/accounts/login/?hl=ko" class="li"><i class="ti-linkedin"></i></a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--================End Single Product Area =================-->


