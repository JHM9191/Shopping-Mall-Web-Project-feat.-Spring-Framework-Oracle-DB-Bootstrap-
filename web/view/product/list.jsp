<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/nice-select.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/slick.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/price_rangs.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">


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

<script>
	/*
	function menuClicked(menu) {
		alert(menu);
		if (menu == 'All') {
			location.href = "plist.sp?menu=All&cat=none&pagenum=${pagenum}&contentnum=10";
		} else if (menu == 'New') {
			location.href = "plist.sp?menu=New&cat=none&pagenum=${pagenum}&contentnum=10";
		} else if (menu == 'Best') {
			location.href = "plist.sp?menu=Best&cat=none&pagenum=${pagenum}&contentnum=10";
		}
	};
	 */
	function catClicked(cat) {
		alert('category: ' + cat);
		if (cat == 'top') {
			alert('if category = ' + cat);
			location.href = "plist.sp?menu=${menu}&cat=top&pagenum=${pagenum}&contentnum=${contentnum}";
		} else if (cat == 'bottom') {
			location.href = "plist.sp?menu=${menu}&cat=bottom&pagenum=${pagenum}&contentnum=${contentnum}";
		} else if (cat == 'outer') {
			location.href = "plist.sp?menu=${menu}&cat=outer&pagenum=${pagenum}&contentnum=${contentnum}";
		} else if (cat == 'acc') {
			location.href = "plist.sp?menu=${menu}&cat=acc&pagenum=${pagenum}&contentnum=${contentnum}";
		}
	};
	
	var selected = ${contentnum};
		var selected2 = $('#contentnumber option:selected').val(); 
		alert(selected);
		alert("hello");
		$(function() {
			$('#contentnumber').on('change', function() {
				selected = $(this).val();
				alert("select onchange: " + $(this).val());
				location.href = "plist.sp?menu=${menu}&cat=acc&pagenum=1&contentnum=" + selected;	
			});
		});
	
	
	function page(pagenum) {
		location.href = "plist.sp?menu=${menu}&cat=acc&pagenum=" + pagenum
				+ "&contentnum=${contentnum}";
	}
</script>


<!--================Category Product Area =================-->
<div class="bg-white">
	<section class="cat_product_area section_padding border_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="left_sidebar_area">
						<aside class="left_widgets p_filter_widgets sidebar_box_shadow">
							<div class="l_w_title">
								<h3>상품 카테고리</h3>
							</div>
							<div class="widgets_inner">
								<ul class="list">
									<li><a class="category" onclick="catClicked('top');"
										href="#">Top</a></li>
									<li><a class="category" onclick="catClicked('bottom');"
										href="#">Bottom</a></li>
									<li><a class="category" onclick="catClicked('outer');"
										href="#">Outer</a></li>
									<li><a class="category" onclick="catClicked('acc');"
										href="#">Accessories</a></li>
								</ul>
							</div>
						</aside>

						<!-- <aside class="left_widgets p_filter_widgets sidebar_box_shadow">
							<div class="l_w_title">
								<h3>Product filters</h3>
							</div>
							<div class="widgets_inner">
								<ul class="list">
									<p>Brands</p>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Apple</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Asus</a></li>
									<li class="active"><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Gionee</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Micromax</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Samsung</a></li>
								</ul>
								<ul class="list">
									<p>color</p>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Black</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Black Leather</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Black with red</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Gold</a></li>
									<li><input type="radio"
										aria-label="Radio button for following text input"> <a
										href="#">Spacegrey</a></li>
								</ul>
							</div>
						</aside>-->

						<aside
							class="left_widgets p_filter_widgets price_rangs_aside sidebar_box_shadow">
							<div class="l_w_title">
								<h3>Price Filter</h3>
							</div>
							<div class="widgets_inner">
								<div class="range_item">
									<!-- <div id="slider-range"></div> -->
									<input type="text" class="js-range-slider" value="" />
									<div class="d-flex align-items-center">
										<div class="price_text">
											<p>Price :</p>
										</div>
										<div class="price_value d-flex justify-content-center">
											<input type="text" class="js-input-from" id="amount" readonly />
											<span>to</span> <input type="text" class="js-input-to"
												id="amount" readonly />
										</div>
									</div>
								</div>
							</div>
						</aside>
					</div>
				</div>


				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-12">
							<div
								class="product_top_bar d-flex justify-content-between align-items-center">
								<div class="single_product_menu product_bar_item">
									<h2>
										전체상품 (<span id="showContent">10</span>)
									</h2>
								</div>
								<div class="product_top_bar_iner product_bar_item d-flex">
									<div class="product_bar_single">
										<select class="wide">
											<option data-display="Default sorting">Default
												sorting</option>
											<option value="1">Some option</option>
											<option value="2">Another option</option>
											<option value="3">Potato</option>
										</select>
									</div>
									<div class="product_bar_single">
										<select id="contentnumber">
											<option value="10" selected>Show 10</option>
											<option value="20">Show 20</option>
											<option value="30">Show 30</option>
										</select>
									</div>
								</div>
							</div>
						</div>


						<!-- Product List START HERE -->
						<c:forEach var="p" items="${plist }">
							<div class="col-lg-4 col-sm-6">
								<div class="single_category_product">
									<div class="single_category_img">
										<img src="img/product_img/${p.p_id }.jpg" alt="${p.p_name }">
										<div class="category_social_icon">
											<ul>
												<li><a href="#"><i class="ti-heart"></i></a></li>
												<li><a href="addcart.sp?p_id=${p.p_id }"><i
														class="ti-bag"></i></a></li>
											</ul>
										</div>
										<div class="category_product_text">
											<a href="pdetail.sp?p_id=${p.p_id }"><h5>${p.p_name }</h5></a>
											<p>${p.p_price_sale }</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

						<div class="col-lg-12 text-center">
							<table>
								<tbody>
									<tr>
										<td colspan="2"><c:if test="${page.prev}">
												<a style="text-decoration: none;"
													href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
											</c:if> <c:forEach begin="${page.getStartPage()}"
												end="${page.getEndPage()}" var="idx">
												<a style="text-decoration: none;"
													href="javascript:page(${idx});">${idx}</a>
											</c:forEach> <c:if test="${page.next}">
												<a style="text-decoration: none;"
													href="javascript:page(${page.getEndPage()+1});">&raquo;</a>
											</c:if></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<!--================End Category Product Area =================-->