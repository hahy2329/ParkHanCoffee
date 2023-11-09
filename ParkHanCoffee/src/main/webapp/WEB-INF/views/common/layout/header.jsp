<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<header>
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar">
						ParkHan커피에 오신 걸 환영합니다!
					</div>
					<c:if test="${sessionScope.humanId eq null and sessionScope.adminId eq null }">
					<div class="right-top-bar flex-w h-full">
						<a href="${contextPath }/human/joinHuman" class="flex-c-m trans-04 p-lr-25">
							회원가입
						</a>
						
						<a href="${contextPath }/human/login" class="flex-c-m trans-04 p-lr-25">
							회원 로그인
						</a>

						<a href="#" class="flex-c-m trans-04 p-lr-25">
							회원 ID/PW찾기
						</a>

						<a href="${contextPath }/admin/login" class="flex-c-m trans-04 p-lr-25">
							관리자 로그인
						</a>
					</div>
					</c:if>
					
					<c:if test="${sessionScope.humanId ne null }">
					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							${sessionScope.humanId }님
						</a>
						
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							마이페이지
						</a>
						
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							로그아웃
						</a>
					</div>
					</c:if>
					
					<c:if test="${sessionScope.adminId ne null }">
					<div class="right-top-bar flex-w h-full">
						<a href="#" class="flex-c-m trans-04 p-lr-25">
							${sessionScope.adminId }님
						</a>
						
						<a href="${contextPath }/admin/logout" class="flex-c-m trans-04 p-lr-25">
							로그아웃
						</a>
					</div>
					</c:if>
				</div>
			</div>
		</div>


		<!-- Modal Search -->
		<div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="${contextPath }/resources/cozastore-master/images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search" placeholder="Search...">
				</form>
			</div>
		</div>
	</header>
	
</body>
</html>