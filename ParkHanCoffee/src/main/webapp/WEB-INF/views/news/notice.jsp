<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<colgroup>
									<col width="10%">
									<col width="40%">
									<col width="20%">
									<col width="20%">
									<col width="10%">
								</colgroup>
								<tr>
									<td>조회 : <span style="color: red;">${allBoardCnt }개</span></td>
									<td colspan="4" align="right">
										<select id="onePageViewCnt" onchange="getBoardList()">
											<option <c:if test="${onePageViewCnt eq 5}">selected</c:if>></option>
											<option <c:if test="${onePageViewCnt eq 7}">selected</c:if>></option>
											<option <c:if test="${onePageViewCnt eq 10}">selected</c:if>></option>
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
									<td class="column-2">${noticeDTO.subject }</td>
									<td class="column-3">${noticeDTO.adminId }</td>
									<td class="column-4">${noticeDTO.enrollDt } </td>
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
                        </div>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>