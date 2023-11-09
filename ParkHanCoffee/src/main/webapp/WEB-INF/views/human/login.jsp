<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
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
							<li>
								<a href="${contextPath }/">Home</a>
								<ul class="sub-menu">
									<li><a href="index.html">브랜드</a></li>
									<li><a href="home-02.html">인사말</a></li>
									<li><a href="home-03.html">찾아오시는 길</a></li>
								</ul>
							</li>

							<li class="active-menu">
								<a href="${contextPath }/ParkHanShop/menu">메뉴소개</a>
							</li>

							<li class="label1" data-label1="hot">
								<a href="shoping-cart.html">ParkHan소식</a>
								<ul class="sub-menu">
									<li><a href="index.html">공지사항</a></li>
									<li><a href="home-02.html">이벤트</a></li>
									<li><a href="home-03.html">FAQ</a></li>
									<li><a href="home-03.html">고객의 소리</a></li>
								</ul>
							</li>

							<li>
								<a href="blog.html">Blog</a>
							</li>

							<li>
								<a href="about.html">About</a>
							</li>

							<li>
								<a href="contact.html">Contact</a>
							</li>
						</ul>
					</div>	
				</nav>
			</div>
		</div>
	</header>
	
	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">
				<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
					<form action="${contextPath }/human/login" method="post">
						<h3 class="mtext-105 cl2 txt-center p-b-30">
							회원 로그인
						</h3>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" name="humanId" placeholder="ID를 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="password" name="password" placeholder="Password를 입력해주세요." required="required">				
						</div>
	
						<button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
							로그인
						</button>
					</form>
				</div>
				<div class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">
					<div class="flex-w w-full p-b-42">
						<span class="fs-18 cl5 txt-center size-211">
							<span class="lnr lnr-map-marker"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2">
								주소
							</span>

							<p class="stext-115 cl6 size-213 p-t-18">
								서울특별시 가나다 라마바사 123 3층,4층,5층,(주)ParkHan커피
							</p>
						</div>
					</div>

					<div class="flex-w w-full p-b-42">
						<span class="fs-18 cl5 txt-center size-211">
							<span class="lnr lnr-phone-handset"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2">
								전화 문의
							</span>

							<p class="stext-115 cl1 size-213 p-t-18">
								+82 123-4567
							</p>
						</div>
					</div>

					<div class="flex-w w-full">
						<span class="fs-18 cl5 txt-center size-211">
							<span class="lnr lnr-envelope"></span>
						</span>

						<div class="size-212 p-t-2">
							<span class="mtext-110 cl2">
								이메일 문의
							</span>

							<p class="stext-115 cl1 size-213 p-t-18">
								abcdefg@hijklmn.com
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>	
	

</body>
</html>