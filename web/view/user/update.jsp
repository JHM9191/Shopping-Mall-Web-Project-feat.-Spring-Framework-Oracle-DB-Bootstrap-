<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
<link rel="stylesheet" href="css/cart-controlQty.css">
</head>
<div class="bg-white">
	<section class="cat_product_area section_padding border_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="left_sidebar_area">
						<aside class="left_widgets p_filter_widgets sidebar_box_shadow">
							<div class="l_w_title">
								<h3>My Page</h3>
							</div>
							<div class="widgets_inner">
								<ul class="list">
									<li><a class="category" onclick="catClicked('top');"
										href="#">회원 정보</a></li>
									<li><a class="category" onclick="catClicked('bottom');"
										href="odetail.sp">나의 주문 내역</a></li>
									<li><a class="category" onclick="catClicked('outer');"
										href="#">Q&A</a></li>
								</ul>
							</div>
						</aside>
					</div>
				</div>

				<!-- Signup part start -->
				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-12">
							<div class="right_sidebar_area">
								<div
									class="product_top_bar d-flex justify-content-between align-items-center">
									<div class="col-lg-8 col-md-8"
										style="margin: 0 auto; background-color: #E8F0F2;">
										<br>
										<h2>회원정보 수정</h2>
										<section style="margin-bottom: 60px; margin-top: 40px;">
											<form action="uupdateimpl.sp">
												<div class="mt-10">
													<input type="text" name="u_id" placeholder="ID"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = 'ID'" required
														class="single-input" value="${duser.u_id }"
														readonly="readonly">
												</div>

												<div class="mt-10">
													<input type="text" name="u_pwd"
														placeholder="${duser.u_pwd }"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_pwd }'" required
														value="${duser.u_pwd }" class="single-input">
												</div>

												<div class="mt-10">
													<input type="text" name="u_name"
														placeholder="${duser.u_name}"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_name}'" required
														class="single-input" value="${duser.u_name}">
												</div>

												<div class="mt-10">
													<input type="text" name="u_tel"
														placeholder="${duser.u_tel }"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_tel }'" required
														class="single-input" value="${duser.u_tel }">
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
													<input type="number" name="u_age"
														placeholder="${duser.u_age }"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_age }'" required
														class="single-input" value="${duser.u_age }">
												</div>
												<div class="mt-10">
													<input type="text" name="u_email"
														placeholder="${duser.u_email }"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_email }'" required
														class="single-input" value="${duser.u_email }">
												</div>
												<div class="mt-10">
													<input type="text" name="u_address"
														placeholder="${duser.u_address }"
														onfocus="this.placeholder = ''"
														onblur="this.placeholder = '${duser.u_address }'" required
														class="single-input" value="${duser.u_address }">
												</div>
												<div style="text-align: center; margin-top:20px;">
													<input type="submit" class="genric-btn primary"
														value="수정 완료">
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
