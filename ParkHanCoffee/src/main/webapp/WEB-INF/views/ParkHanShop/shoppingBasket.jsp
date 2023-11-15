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
							<li class="active-menu">
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
								<li>
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
</body>
</html>