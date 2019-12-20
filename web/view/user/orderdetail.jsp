<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="zxx">
<head>
<!-- QTY button CSS (우리가 만든 것) -->
<link rel="stylesheet" href="css/cart-controlQty.css">
</head>

<section class="cat_product_area section_padding border_top" style="background-color:white;">
	<div class="container" style="max-width: 1040px;" >
		<div class="row">
			<div class="col-lg-2" >
				<div class="left_sidebar_area">
					<aside class="left_widgets p_filter_widgets sidebar_box_shadow">
						<div class="l_w_title">
							<h3>My Page</h3>
						</div>
						<div class="widgets_inner" style="padding:10px 10px;">
							<ul class="list">
								<li><a class="category" onclick="catClicked('top');"
									href="umypage.sp">회원 정보</a></li>
								<li><a class="category" onclick="catClicked('bottom');"
									href="#">나의 주문 내역</a></li>
								<li><a class="category" onclick="catClicked('outer');"
									href="mypage_qna.sp">Q&A</a></li>
							</ul>
						</div>
					</aside>

				</div>
			</div>


			<div class="col-lg-10">
				<div class="row">
					<div class="col-lg-12">
						<div class="right_sidebar_area">
							<div
								class="product_top_bar d-flex justify-content-between align-items-center">
								<div class="single_product_menu product_bar_item"><br>
								<h2>나의 주문 내역</h2>
									
								</div>

							</div>
						</div>

						<div class="cart_inner">
							<div class="table-responsive">
								<!-- 카트 update form -->
								<table class="table">
									<thead>
										<tr>
											<th scope="col">주문 번호</th>
											<th scope="col">주문 상품</th>
											<th scope="col">사이즈</th>
											<th scope="col">제품 가격</th>
											<th scope="col">제품 수량</th>
											<th scope="col">총 가격</th>
										</tr>
									</thead>
									<tbody>



										<!-- **********EL로 넣을 부분!************* -->
										<c:forEach var="cart" items="${cartlist }" varStatus="status">
											<tr>
												<td>
													<h4>${ cart.o_id}</h4>
												</td>
												<td>
													<div class="media">
														<div class="d-flex">


															<img src="img/product_img/${cart.p_id}.jpg" alt="" />
														</div>
														<!--<div class="media-body"></div> -->
														<div>
															<h4 style="margin-top: 90px;">${prod_o_detail_list[status.index].p_name }</h4>
														</div>
													</div>
												</td>
												<td>
													<h5>${cart.c_size }</h5>
												</td>
												<td>
													<h5>${prod_o_detail_list[status.index].p_price }</h5>
												</td>
												<td>
													<div class="product_count">
														<h5>${cart.c_qty }</h5>
													</div>
												</td>
												<td>
													<h5>
														${cart.c_sum } <input type="text" value="${cart.c_id }"
															name="id" style="display: none;"> <input
															type="text"
															value="${prod_o_detail_list[status.index].p_price }"
															name="price" style="display: none;">
													</h5>
												</td>
										</c:forEach>

										<!-- **********아작스로 넣을 부분 끝************* -->

									</tbody>
								</table>

								<!-- 카트 업데이트 form 끝 -->
								<!--  **********구매 페이지 넘어감 *************** -->

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>




</html>