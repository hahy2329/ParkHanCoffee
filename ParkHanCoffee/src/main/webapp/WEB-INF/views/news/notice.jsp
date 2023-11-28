<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$.ready(function(){
		
		$("#onePageViewCnt").val("${onePageViewCnt}");
		$("#searchKeyword").val("${searchKeyword}");
		
		
	});
	
	function getBoardList(){
		
		var url = "${contextPath}/news/notice";
			url +="?searchKeyword=" + $("#searchKeyword").val();
			url +="&searchWord="+$("#searchWord").val();
			url +="&onePageViewCnt="+$("#onePageViewCnt").val();
		
		location.href= url;
	}

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
									<li><a href="${contextPath }/news/notice">공지사항</a></li>
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
				</nav>
			</div>
		</div>
	
	</header>

	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<colgroup>
									<col width="20%">
									<col width="30%">
									<col width="10%">
									<col width="20%">
									<col width="30%">
								</colgroup>
								<tr>
									<td>조회 : <span style="color: red;">${allBoardCnt }개</span></td>
									<td colspan="4" align="right">
										<select id="onePageViewCnt" onchange="getBoardList()">
											<option <c:if test="${onePageViewCnt eq 5}">selected</c:if>>5</option>
											<option <c:if test="${onePageViewCnt eq 7}">selected</c:if>>7</option>
											<option <c:if test="${onePageViewCnt eq 10}">selected</c:if>>10</option>
										</select>
									</td>
								</tr>
								<tr class="table_head">
									<th class="column-1">번호</th>
									<th class="column-2">제목</th>
									<th class="column-3">아이디</th>
									<th class="column-4">작성일</th>
									<th class="column-5">조회수</th>
								</tr>
							<c:forEach var="noticeDTO" items="${noticeList }">	
								<tr class="table_row" align="center">
								<c:set var="startBoardIdx" value="${startBoardIdx + 1 }"/>
									<td class="column-1">${startBoardIdx } </td>
									<td class="column-2"><a href="${contextPath }/news/noticeDetail?boardId=${noticeDTO.boardId}">${noticeDTO.subject }</a></td>
									<td class="column-3">${noticeDTO.adminId }</td>
									<td class="column-4"><fmt:formatDate value="${noticeDTO.enrollDt }" pattern="yyyy-MM-dd"/></td>
									<td class="column-5">${noticeDTO.readCnt }</td>
								</tr>
							</c:forEach>
							</table>
						</div>
 						<div style="display: table; margin-left: auto; margin-right: auto">
                        	<ul>
                        		<c:if test="${startPage > 10 }">
                        			<li>
                        				<a href="${contextPath }/news/notice?currentPageNumber=${startPage - 10}&onePageViewCnt=${onePageViewCnt }&searchKeyword=${searchKeyword }&searchWord=${searchWord }">이전</a>
                        			</li>
                        		</c:if>
                        		<c:forEach var="i" begin="${startPage }" end="${endPage }">
                        			<li>
                        				<a href="${contextPath }/news/notice?currentPageNumber=${i }&onePageViewCnt=${onePageViewCnt  }&searchKeyword=${searchKeyword }&searchWord=${searchWord}">${i }</a>
                        			</li>
                        		</c:forEach>
                        		<c:if test="${endPage != allPageCnt && endPage >=10}">
                        			<li>
                        				<a href="${contextPath }/news/notice?currentPageNumber=${startPage + 10}&onePageViewCnt=${onePageViewCnt  }&searchKeyword=${searchKeyword }&searchWord=${searchWord}">다음</a>
                        			</li>
                        		</c:if>
                        	</ul>
                        	  <div class="flex-w flex-m m-r-20 m-tb-5">
								<select id="searchKeyword">
	                            			<option value="total">전체검색</option>
	                            			<option value="adminId">아이디</option>
	                            			<option value="subject">제목</option>
	                            			<option value="content">내용</option>
	                            </select> &nbsp;
	                            
	                            <input class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5" type="text" id="searchWord" name="searchWord" value="${searchWord }">
	                            <div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5" onclick="getBoardList()">
									검색
								</div>
								<c:if test="${sessionScope.adminId ne null }">
									<div class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5" onclick="location.href='${contextPath}/admin/addNotice'">
										글쓰기
									</div>
								</c:if>
							</div>
							
                        </div>
					</div>
				</div>
			</div>
		</div>
	</form>
	

</body>
</html>