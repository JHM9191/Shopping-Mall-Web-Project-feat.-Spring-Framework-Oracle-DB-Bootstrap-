<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	for(var i = 0; i < '${f_qty}'; i++){
		if($('#product_name'+i).text().length > 8)
		  $('#product_name'+i).html($('#product_name'+i).text().substring(0, 8)+" ...");
	}
});

</script>
<style>
	.products {
		float : left;
		margin : 0;
		padding : 0;
		text-align : left;
		line-height: auto;
	}
	
	.billing_details h3 {
		margin-top : 15px;
		margin-bottom: 15px;
	}
	.classname {
		margin-left : 15px;
	}
</style>
</head>

<body>
	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<p>Home / checkout</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->

	<!--================Checkout Area =================-->
	<section class="checkout_area section_padding" style="padding-top: 60px">
		<div class="container">

			<div class="billing_details">
				<div class="row">
				    <form class="row contact_form" action="confirmorder.sp" method="post">
						<div class="col-lg-7">
							<h3 class="classname">Billing Details</h3>
							<p class="classname" style="font-size: 0.8em;">* 배송받으실 주소를 입력해 주세요! *</p><br>
								
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="o_name" name="o_name" value = "${f_user.u_name}" required class="single-input"/>
									</div>
									<div class="col-md-6 form-group p_star">
										<input type="text" class="form-control" id="o_tel" name="o_tel" value = "${f_user.u_tel}" required class="single-input"/> 
									</div>
									<div class="col-md-6 form-group p_star">
										<input type="text" class="form-control" id="o_email" name="o_email" value = "${f_user.u_email}" required class="single-input"/> 
									</div>
									<div class="col-md-12 form-group p_star">
										<input type="text" class="form-control" id="country" name="country" readonly /> 
										<span class="placeholder" data-placeholder="대한민국"></span>
									</div>
									<div class="col-md-12 form-group p_star">
									 	<button type="button" class="btn btn-warning" onclick="goPopup()">주소검색</button><br><br>
										<input type="text" class="form-control" id="address" name="o_address" value = "${f_user.u_address}" readonly="true" required/>
									</div>
									
									
									<div class="col-md-12 form-group"></div><br>
									<div class="col-md-12 form-group">
										<div class="creat_account">
											<h3>Shipping Details</h3>
											<p style="font-size: 0.8em;">* 기사님께 전해드릴 배송 메시지를 남겨주세요! *</p>
										</div>
										<textarea class="form-control" name="message" id="message"
											rows="1" placeholder="배송 메시지"></textarea>
									</div>
								
						</div>
						<div class="col-lg-5">
							<div class="order_box">
								<h2>Your Order</h2>
								<ul class="list">
									<li><a href="#">Product <span></span> <span>Total</span>
									</a></li>
									<c:forEach var="fcart" items="${f_cartlist }" varStatus="status">
										<li><a href="#">
											<p id="product_name${status.index}" class="products">${f_pdlist[status.index].p_name }</p>
											<span class="middle">X ${fcart.c_qty }</span> 
											<span class="last">${fcart.c_sum }원</span>
										</a></li>
									</c:forEach>
								</ul>
								<ul class="list list_2">
									<li>
										<!-- <a href="#">Subtotal
	                    <span>$2160.00</span>
	                  </a> -->
									</li>
									<li><br>
										<p></p> <!-- <a href="#">Shipping
	                     <span>Flat rate: $50.00</span>
	                  </a>--></li>
									<li><span></span> <a href="#">Total <span>${total }원</span>
									<input type="text" value="${total }" name="o_total" style="display:none;">
									</a></li>
								</ul>
								<div class="payment_item active">
									<div class="radion_btn">
										<input type="radio" id="f-option6" name="o_payment" value ="신용카드" checked="checked" required/> <label
											for="f-option6">신용카드</label> <img src="img/card.jpg" alt="" />
										<div class="check"></div>
									</div>
								</div>
								<div class="payment_item">
									<div class="radion_btn">
										<input type="radio" id="f-option5" name="o_payment" value ="휴대폰 결제" required/> <label
											for="f-option5">휴대폰 결제</label>
										<div class="check"></div>
									</div>
								</div>
								<div class="payment_item">
									<div class="radion_btn">
										<input type="radio" id="f-option4" name="o_payment" value ="계좌이체" required/> <label
											for="f-option4">실시간 계좌이체</label>
										<div class="check"></div>
									</div>
								</div>
								<div class="payment_item">
									<div class="radion_btn">
										<input type="radio" id="f-option3" name="o_payment" value ="카카오페이" required/> <label
											for="f-option3">카카오페이 (KAKAOPAY)</label> <img src="img/kakaopay.jpg" alt="" />
										<div class="check"></div>
									</div>
								</div>
								<div class="payment_item">
									<div class="radion_btn">
										<input type="radio" id="f-option2" name="o_payment" value ="페이코" required/> <label
											for="f-option2">페이코 (PAYCO)</label> <img src="img/payco.jpg" alt="" />
										<div class="check"></div>
									</div>
								</div>
								<div class="creat_account">
									<input type="checkbox" id="f-option1" name="termselector" required/> 
									<label for="f-option1">I’ve read and accept the </label> 
									<a href="#">terms & conditions*</a>
								</div>
								<button class="btn_3" id="checkout">CHECK OUT</button>
								<!--  <input type="submit" class="btn_3" value ="CHECK OUT" id="checkout"> -->
							</div>
						</div>
					</form> <!-- 폼 끝나는 부분 -->
				</div>
			</div>
		</div>
	</section>
	<!--================End Checkout Area =================-->
	

<!-- 주소 API (우리가 만든 것) -->
<script src="js/address-api.js"></script>	


</body>

</html>