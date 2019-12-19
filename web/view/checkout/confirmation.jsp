<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="zxx">

 <!--================ confirmation part start =================-->
  <section class="confirmation_part section_padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="confirmation_tittle">
            <span>Thank you. Your order has been received.</span>
          </div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>order info</h4>
            <ul>
              <li>
                <p>order number</p><span>: ${order_info.o_id }</span>
              </li>
              <li>
                <p>date</p><span>: ${regdate }</span>
              </li>
              <li>
                <p>total</p><span>: ${order_info.o_total } 원</span>
              </li>
              <li>
                <p>payment method</p><span>: ${order_info.o_payment }</span>
              </li>
            </ul>
          </div>
        </div>
        
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>shipping Address</h4>
            <ul>
              <li>
                <p>name</p><span>: ${order_info.o_name }</span>
              </li>
              <li>
                <p>phone number</p><span>: ${order_info.o_tel }</span>
              </li>
              <li>
                <p>country</p><span>: 대한민국</span>
              </li>
              <li>
                <p>address</p><span>: ${order_info.o_address }</span>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="order_details_iner">
            <h3>Order Details</h3>
            <table class="table table-borderless">
              <thead>
                <tr>
                  <th scope="col" colspan="2">Product</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Total</th>
                </tr>
              </thead>
              <tbody>
	              <c:forEach var="ccart" items="${c_cartlist }" varStatus="status">
	                <tr>
	                  <th colspan="2"><span>${c_pdlist[status.index].p_name }</span></th>
	                  <th>${ccart.c_qty }</th>
	                  <th> <span>${ccart.c_sum }</span></th>
	                </tr>
	               </c:forEach>
                <tr>
                  <th colspan="3">Total</th>
                  <th> <span>${order_info.o_total } 원</span></th>
                </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--================ confirmation part end =================-->
  
</html>