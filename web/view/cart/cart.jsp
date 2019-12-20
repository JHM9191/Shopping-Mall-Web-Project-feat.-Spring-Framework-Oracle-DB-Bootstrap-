<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="zxx">
<head>
	<!-- QTY button CSS (우리가 만든 것) -->
	<link rel="stylesheet" href="css/cart-controlQty.css">
</head>

<body class="bg-white">


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
                <th scope="col">Size</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Total</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>	
            
            <!-- **********EL로 넣을 부분!************* -->
				<c:forEach var="cart" items="${cartlist }" varStatus="status">
					<tr>
              		  <td >
                  		<div class="media">
                  		  <div class="d-flex">
                  		    <img src="img/product_img/${cart.p_id}.jpg" alt="" />
                  		  </div>
                	     	<!--<div class="media-body"></div> -->
                  		  <div>
                  		 	<h4 style="margin-top:90px;">${pdlist[status.index].p_name }</h4>
                  		  </div>
                  		</div>
                	</td>
                	<td>
                  		<h5>${cart.c_size }</h5>
               		</td>
                	<td>
                  		<h5>${pdlist[status.index].p_price }</h5>
               		</td>
               		<td>
                  		<div class="product_count">
                      		<!-- <span class="input-number-decrement"> <i class="ti-minus"></i></span> -->
                    		<input class="input-number" type="number" value="${cart.c_qty }" min="1" max="10" name="qty">
                    		<!-- <span class="input-number-increment"> <i class="ti-plus"></i></span> -->
                 		</div>
                	</td>
                	 <td>
                	 	<h5>
                	 		${cart.c_sum }
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
            <a class="btn_1" href="main.sp">Continue Shopping</a>
            <a class="btn_1 checkout_btn_1" href="checkout.sp?subtotal=${subtotal}">Proceed to checkout</a>
          </div>
        </div>
        </div>
      </div>
</section>



</body>

</html>