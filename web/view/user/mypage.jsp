<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
<link rel="stylesheet" href="css/cart-controlQty.css">
<script>

</script>
</head>
<div class="bg-white">
	<section class="cat_product_area section_padding border_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-2">
					<div class="left_sidebar_area">
						<aside class="left_widgets p_filter_widgets sidebar_box_shadow">
							<div class="l_w_title">
								<h3>My Page</h3>
							</div>
							<div class="widgets_inner" style="padding:10px 10px;">
								<ul class="list">
									<li><a class="category" onclick="catClicked('top');"
										href="#">회원 정보</a></li>
									<li><a class="category" onclick="catClicked('bottom');"
										href="odetail.sp">나의 주문 내역</a></li>
									<li><a class="category" onclick="catClicked('outer');"
										href="mypage_qna.sp">Q&A</a></li>
								</ul>
							</div>
						</aside>
					</div>
				</div>

				<!-- Signup part start -->
				<div class="col-lg-10">
					<div class="row">
						<div class="col-lg-12">
							<div class="right_sidebar_area">
								<div
									class="product_top_bar d-flex justify-content-between align-items-center">
									<div class="col-lg-8 col-md-8"
										style="margin: 0 auto; padding-bottom: 8px; background-color: #E8F0F2;">
										<br>
										<h2>나의 회원 정보</h2>
										<section style="margin-bottom: 60px; margin-top: 40px;">
											<form action="signupimpl.sp">
												<div class="mt-10">
													<input type="text" name="u_id" placeholder="ID"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'ID'" required
														class="single-input" value="${duser.u_id }"
														readonly="readonly">
												</div>

												<div class="mt-10">
													<input type="text" name="u_pwd" placeholder="PASSWARD"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'PASSWARD'" required
														class="single-input" value="${duser.u_pwd }"
														readonly="readonly">
												</div>

												<div class="mt-10">
													<input type="text" name="u_name" placeholder="Name"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'Name'" required
														class="single-input" value="${duser.u_name}"
														readonly="readonly">
												</div>

												<div class="mt-10">
													<input type="text" name="u_tel" placeholder="Phone Number"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'Phone Number'" required
														class="single-input" value="${duser.u_tel }"
														readonly="readonly">
												</div>

												<div class="input-group-icon mt-10">
													<div class="form-select" id="default-select_1">
														<input type="text" id="gender" class="single-input" 
															 value="${duser.u_gender }" readonly="readonly">
													</div>
												</div>
												<div class="mt-10">
													<input type="text" name="u_age" placeholder="Age"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'Age'" required
														class="single-input" value="${duser.u_age }"
														readonly="readonly">
												</div>
												<div class="mt-10">
													<input type="text" name="u_email"
														placeholder="Email address"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'Email address'" required
														class="single-input" value="${duser.u_email }"
														readonly="readonly">
												</div>
												<div class="mt-10">
													<input type="text" name="u_address" placeholder="Address"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'Address'" required
														class="single-input" value="${duser.u_address }"
														readonly="readonly">
												</div>
												<br>
												<div style="text-align: center; margin-top: 10px;">
													<a href="uupdate.sp?id=${duser.u_id }"
														class="genric-btn primary">정보 수정</a> <a
														href="udelete.sp?id=${duser.u_id }"
														class="genric-btn primary">회원 탈퇴</a>
												</div>
											</form>
										</section>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

