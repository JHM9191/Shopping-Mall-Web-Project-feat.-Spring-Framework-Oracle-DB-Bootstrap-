<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>winter</title>
<link rel="icon" href="img/favicon.png">
</head>


<body class="bg-white">


	<!--================Home Banner Area =================-->
	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-12">
				<div class="breadcrumb_iner">
					<div class="breadcrumb_iner_item">
						<p>Home / Signup</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>



	<!-- breadcrumb start-->
	<!-- Signup part start -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-8" style="margin: 40px auto; padding-bottom:30px; background-color: #E8F0F2;">
				<br>
				<h3>Create Account</h3>
				<section style="margin-top:40px;">
				<form action="signupimpl.sp">
					<div class="mt-10">
						<input type="text" id="u_id" name="u_id" placeholder="ID"
							onfocus="this.placeholder = ''" onblur="this.placeholder = 'ID'"
							required class="single-input">
					</div>

					<div class="mt-10">
						<input type="text" name="u_pwd" placeholder="PASSWARD"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'PASSWARD'" required
							class="single-input">
					</div>

					<div class="mt-10">
						<input type="text" name="u_name" placeholder="Name"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Name'" required class="single-input">
					</div>

					<div class="mt-10">
						<input type="text" name="u_tel" placeholder="Phone Number"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Phone Number'" required
							class="single-input">
					</div>

					<div class="input-group-icon mt-10">
						<div class="default-select" id="default-select_1">
							<select name="u_gender">
								<option value="M">Male</option>
								<option value="F">Female</option>
							</select>
						</div>
					</div>
					<div class="mt-10">
						<input type="text" name="u_age" placeholder="Age"
							onfocus="this.placeholder = ''" onblur="this.placeholder = 'Age'"
							required class="single-input">
					</div>
					<div class="mt-10">
						<input type="text" name="u_email" placeholder="Email address"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Email address'" required
							class="single-input">
					</div>

					<div class="mt-10">
						<button type="button" class="genric-btn primary-border small" onclick="goPopup()" style="margin-bottom:5px">주소검색</button><br>
						<input type="text" id="address" name="u_address"
							placeholder="Address" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Address'" required
							class="single-input" readonly="true" required="true">
					</div>
					<br> 
					<div class="mt-10" style="text-align: center;">
						<input class="genric-btn primary e-large" type="submit" value="Sign Up">
					</div>
				</form>
				</section>
			</div>
		</div>
	</div>
	<!-- subscribe_area part start-->
	<section class="instagram_photo">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<div class="instagram_photo_iner">
					<div class="single_instgram_photo">
						<img src="img/instagram/inst_1.png" alt=""> <a href="#"><i
							class="ti-instagram"></i></a>
					</div>
					<div class="single_instgram_photo">
						<img src="img/instagram/inst_2.png" alt=""> <a href="#"><i
							class="ti-instagram"></i></a>
					</div>
					<div class="single_instgram_photo">
						<img src="img/instagram/inst_3.png" alt=""> <a href="#"><i
							class="ti-instagram"></i></a>
					</div>
					<div class="single_instgram_photo">
						<img src="img/instagram/inst_4.png" alt=""> <a href="#"><i
							class="ti-instagram"></i></a>
					</div>
					<div class="single_instgram_photo">
						<img src="img/instagram/inst_5.png" alt=""> <a href="#"><i
							class="ti-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!--::subscribe_area part end::-->

	<!-- 주소 API (우리가 만든 것) -->
	<script src="js/address-api.js"></script>
	<!-- ID 중복체크 (우리가 만든 것) -->
	<script src="js/isAvailableID.js"></script>

</body>


</html>