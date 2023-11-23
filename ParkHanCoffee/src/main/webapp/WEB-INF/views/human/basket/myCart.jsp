<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>


var productSumPrice = 0;


$().ready(function(){
	
	$("[name=productName]").each(function(index, element){
		
		console.log($("[name=productName]").eq(index).text());
		console.log("안녕");
		
	});//연습
	
	
	$("[name=minus]").each(function(index, element){
		$("[name=minus]").eq(index).click(function(){
	
			var minus = $("[name=num-product1]").eq(index).val();
			minus = parseInt(minus);
			console.log(minus);
				
					
			var price = $("[name=basketPrice]").eq(index).text();
			price = parseInt(price);
			console.log(price);
					
					
			var totalPrice = minus * price;
					
					
			$("[name=totalPrice]").eq(index).text(totalPrice + "원");
			
			var totalPriceZero = $("[name=totalPrice]").eq(index).text();
			totalPriceZero = parseInt(totalPriceZero);
			
			
			if(totalPriceZero == 0){
				$("[name=totalPrice]").eq(index).text(0 + "원");
			}
			
			if(minus == 0){
				$("[name=totalPrice]").eq(index).text(0 + "원");
			}
			
			if(productSumPrice == 0){
				$("[name=mtext-110]").text(0 + "원");
			}else{
				productSumPrice -= price;
				$("[name=mtext-110]").text(productSumPrice + "원");
			}
			
			
			
			
		});
	});
	
	$("[name=plus]").each(function(index,element){
		$("[name=plus]").eq(index).click(function(){
		
			var plus = $("[name=num-product1]").eq(index).val();
			plus = parseInt(plus);
			console.log(plus);
				
			var price1 = $("[name=basketPrice]").eq(index).text();
			price1 = parseInt(price1);
			console.log(price1);
				
				
			var totalPrice1 = plus * price1;
			
			$("[name=totalPrice]").eq(index).text(totalPrice1 + "원");
			
			productSumPrice += price1;
			
			$("[name=mtext-110]").text(productSumPrice + "원");
			
			
		});
	});
	
	$("#couponInput").click(function(){
		
		$(".answer").empty();
		
		var coupon = $("#coupon").val();
		
		if(coupon == null){
			alert('쿠폰 번호를 입력해주세요.');
			
		}
		
		$.ajax({
			
			type : "get",
			url : "${contextPath}/basket/couponInput?couponNumber="+coupon,
			success : function(data){
				if(data == "checked"){
					
					alert("쿠폰 적용 완료!");
					
					var discountProductSumPrice = $("[name=mtext-110]").text();
					discountProductSumPrice = parseInt(discountProductSumPrice);
					discountProductSumPrice = discountProductSumPrice - (discountProductSumPrice * 10/100);
					$("[name=mtext-110]").text(discountProductSumPrice + "원");
					
					$("#couponInput").remove();
					$("#coupon").remove();
					$(".answer").append("<p style='color: green;'>"+"쿠폰 인증이 확인되었습니다." + "</p>");
					
					
					
				}else{
					
					alert("존재하지 않거나 이미 사용된 쿠폰입니다.");
					$(".answer").append("<p style='color: red;'>" + "쿠폰 번호를 확인해주세요." + "</p>");
				}
			}
		});
	});
	
	
	
	$("#buy").click(function(){
		
		var productBuyPrice = $("[name=mtext-110]").text();
		productBuyPrice = parseInt(productBuyPrice);
		
		$.ajax({
			
			type : "post",
			url : "${contextPath}/ParkHanShop/productBuy?price="+productBuyPrice,
			success : function(data){
				
				if(data == "successful"){
					
					alert("정상적으로 구매가 완료되었습니다.");
					var url = "${contextPath}";
					url += "/";
					location.href = url;
					
				}else{
					
					alert("소유하고 계신 금액이 부족하십니다.");
					return;
				}
				
				
			}	
			
		});
		
	});
	
	
});





</script>
</head>
<body class="animsition">
	<header class="header-v4">
		<div class="container-menu-desktop">
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">
					
					<!-- Logo desktop -->		
					<a href="${contextPath }/" class="logo">
						<img src="${contextPath }/resources/cozastore-master/images/icons/favicon.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li>
								<a href="index.html">Home</a>
								<ul class="sub-menu">
									<li><a href="index.html">브랜드</a></li>
									<li><a href="home-02.html">인사말</a></li>
									<li><a href="home-03.html">찾아오시는 길</a></li>
								</ul>
							</li>

							<li>
								<a href="${contextPath }/ParkHanShop/menu">메뉴소개</a>
								<c:if test="${sessionScope.adminId ne null }">
									<ul class="sub-menu">
										<li><a href="${contextPath }/admin/ParkHanShop/productRegistration">상품등록</a></li>
										<li><a href="home-02.html">상품삭제</a></li>
									</ul>
								</c:if>
							</li>

							<li>
								<a href="shoping-cart.html">ParkHan소식</a>
								<ul class="sub-menu">
									<li><a href="index.html">공지사항</a></li>
									<li><a href="home-02.html">이벤트</a></li>
									<li><a href="home-03.html">FAQ</a></li>
									<li><a href="home-03.html">고객의 소리</a></li>
								</ul>
							</li>
							
							<c:if test="${sessionScope.humanId ne null }">
								<li class="active-menu">
									<a href="${contextPath }/basket/myCart?humanId=${sessionScope.humanId}">장바구니</a>
								</li>
							</c:if>
							
							<li>
								<a href="about.html">About</a>
							</li>

							<li>
								<a href="contact.html">Contact</a>
							</li>
						</ul>
					</div>		

					<!-- Icon header -->
					<c:if test="${sessionScope.humanId ne null }">
						<div class="wrap-icon-header flex-w flex-r-m">
							<div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
								<i class="zmdi zmdi-search"></i>
							</div>
	
							<a href="#" class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
								<i class="zmdi zmdi-shopping-cart"></i>
							</a>
	
							<a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
								<i class="zmdi zmdi-favorite-outline"></i>
							</a>
						</div>
					</c:if>
				</nav>
			</div>
		</div>
	
	</header>
	
	<!-- Shoping Cart -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-0" align="center">번호</th>
									<th class="column-1">상품 이미지</th>
									<th class="column-2">상품 이름</th>
									<th class="column-3">상품 수량</th>
									<th class="column-4">상품 가격</th>
									<th class="column-5">금액</th>
								</tr>
								
						<c:if test="${basketList ne null }">
							<c:forEach var="basketDTO" items="${basketList }" varStatus="status">
								<tr class="table_row" name="test_body">
									<td class="column-0" name="index" align="center">${status.count }</td>
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="${contextPath }/ParkHanShop/thumbnails?images=${basketDTO.basketImage}" width="60" height="80" alt="IMG">
										</div>
									</td>
									<td class="column-2" name="productName">${basketDTO.basketName }</td>
									<td class="column-3">
										<div class="wrap-num-product flex-w m-l-auto m-r-0">
											<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m" id="minus" name="minus">
												<i class="fs-16 zmdi zmdi-minus"></i>
											</div>
										
											<input class="mtext-104 cl3 txt-center num-product" type="number" id="num-product1" name="num-product1" value="0" readonly="readonly">
										
											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m" id="plus" name="plus">
												<i class="fs-16 zmdi zmdi-plus"></i>
											</div>
										</div>
									</td>
									<td class="column-4" id="basketPrice" name="basketPrice">${basketDTO.basketPrice }원</td>
									<td class="column-5" id="totalPrice" name="totalPrice">0원</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${basketList eq null }">
							<tr align="center">
								<td colspan="6" align="center"><strong>상품이 존재하지 않습니다.</strong></td>
							</tr>
						</c:if>
					</table>
				</div>
						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
						<p><strong>쿠폰 입력 시, 상품 수량을 선택 후 이용해 주시길 바랍니다.</strong></p>
							 <div class="flex-w flex-m m-r-20 m-tb-5" align="right">
								<input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5" type="text" id="coupon" name="coupon" placeholder="쿠폰번호 입력">
								
								
								<div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5" id="couponInput">
									쿠폰 입력
								</div>
								
								<p class="answer"></p>
							 </div>
							
						 <a href="${contextPath }/ParkHanShop/menu">		
							<div class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
								메뉴보기
							</div>
						 </a>
						</div>
					</div>
				</div>
				
				<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">
							총 주문내역
						</h4>
						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">
								<span class="stext-110 cl2">
									총 금액:
								</span>
							</div>
							<div class="size-209">
								<span class="mtext-110 cl2" name="mtext-110">
									0원
								</span>
							</div>
						</div>

						<div class="flex-w flex-t bor12 p-t-15 p-b-30">
							<div class="size-208 w-full-ssm">
								<span class="stext-110 cl2">
									상품목록:
								</span>
							</div>
							<div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
							<c:forEach var="basketDTO" items="${basketList }">
								<p class="stext-111 cl6 p-t-2">
									${basketDTO.basketName }
								</p>
							</c:forEach>
							<div class="p-t-15">
									<a href="${contextPath }/basket/myCartReset?humanId=${sessionScope.humanId}">
									<div class="flex-w">
										<div class="flex-c-m stext-101 cl2 size-115 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
											장바구니 초기화
										</div>
									</div>
									</a>	
							</div>	
								
							</div>
						</div>
						<button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer" id="buy">
							구매하기
						</button>
					</div>
					
				</div>
				
			</div>
		</div>
	</form>
</body>
</html>