<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>

	function catClicked(cat) {
		//alert('category: ' + cat);
		var previouscat = '${cat}';
		var pagenum = '${pagenum}';
		if(previouscat != cat) {
			pagenum = 1;
		}
		
		if (cat == 'top') {
			//alert('if category = ' + cat);
			location.href = "plist.sp?menu=${menu}&cat=top&pagenum=" + pagenum + "&contentnum=${contentnum}";
		} else if (cat == 'bottom') {
			location.href = "plist.sp?menu=${menu}&cat=bottom&pagenum=" + pagenum + "&contentnum=${contentnum}";
		} else if (cat == 'outer') {
			location.href = "plist.sp?menu=${menu}&cat=outer&pagenum=" + pagenum + "&contentnum=${contentnum}";
		} else if (cat == 'acc') {
			location.href = "plist.sp?menu=${menu}&cat=acc&pagenum=" + pagenum + "&contentnum=${contentnum}";
		}
	};

	
	function page(pagenum) {
		if('${search}'==''||'${search}'== null){
			location.href = "plist.sp?menu=${menu}&cat=${cat}&pagenum=" + pagenum
			+ "&contentnum=${contentnum}";
		}else{
			location.href = "plist.sp?menu=${menu}&cat=${cat}&pagenum=" + pagenum
			+ "&contentnum=${contentnum}&search=${search}";
		}
		
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

						
					</div>
				</div>


				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-12">
							<div
								class="product_top_bar d-flex justify-content-between align-items-center">
								<div class="single_product_menu product_bar_item">
									<h2>
										${navi } (<span id="showContent">${totCount }</span>)
									</h2>
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