<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var isValid = false;
	var isEmail = false;
	
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;
	
	$().ready(function() {
		
		$("#btnOverlappedInfo").click(function(){
			
			$(".answer").empty();
			
			var humanId = $("#humanId").val();
			
			
			if(humanId == ''){
				alert("ID를 입력해주세요.");
				return;
			}
			
			if(humanId.search(/\s/) != -1){
				alert("공백은 허용할 수 없습니다.");
				return false;
			}//공백 체크
			
			if(special_pattern.test(humanId) == true) {
				alert("특수문자는 허용할 수 없습니다.");
				return false;
			}//특수문자 체크
			
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/human/checkDuplicatedInfo?humanId=" + humanId,
				success : function(data){
					if(data == "duplicate"){
						alert("사용할 수 있는 ID입니다.");
						isValid = true;
						$("#btnOverlappedInfo").remove();
						$(".answer").append("<p style='color: green;'>" + "확인되었습니다." +"</p>");
					}else{
						alert("이미 존재하는 ID입니다.");
						isValid = false;
						$(".answer").append("<p style='color: red;'>" +"이미 존재하는 ID입니다." + "</p>");
					}
				}
				
				
			});
			
		});
		
		$("#btnOverlappedEmail").click(function(){
			
			$(".answer2").empty();
			
			var email = $("#email").val();
			
			if(email == ''){
				alert("이메일을 입력해주세요.");
				return;
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/human/checkOverlappedEmail?email=" + email,
				success : function(data){
					if(data == "duplicate"){
						alert("확인되었습니다.");
						isEmail = true;
						$("#btnOverlappedEmail").remove();
						$(".answer2").append("<p style='color: green;'>" + "확인되었습니다." +"</p>")
					}
					else{
						alert("이미 존재하는 이메일입니다.");
						isEmail = false;
						$(".answer2").append("<p style='color: red;'>" +"이메일을 다시 확인해주세요." + "</p>");
					}
					
				}
				
				
			});
			
			
		});
		
		$("form").submit(function(){
			
			if(isValid == false){
				alert("ID를 다시 확인해주세요.");
				return false;
			}
			
			if(isEmail == false){
				alert("Email을 다시 확인해주세요.");
				return false;
			}
			
			if($("#password").val() == ''){
				alert("PW입력란이 비어있습니다.");
				return false;
			}
			
			if(isValid == true && isEmail == true){
				if($("#password").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#password").val())||!pattern2.test($("#password").val())||!pattern3.test($("#password").val())||$("#password").val().length<8||$("#password").val().length>50){
						alert("영문+숫자+특수기호 8자리 이상으로 구성하여야 합니다.");
						return false;
					}
					else{
						$("[name='birthDt']").val($("#birthY").val() +"-" + $("#birthM").val() + "-" + $("#birthD").val());
						return true;
					}
				}
				else{
					alert("PW를 다시 확인해주세요.");
					return false;
				}
			}
			
			
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
				</nav>
			</div>
		</div>
	
	</header>
	
	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container">
			<div class="flex-w flex-tr">
				<div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
					<form action="${contextPath }/human/joinHuman" method="post">
						<h3 class="mtext-105 cl2 txt-center p-b-30">
							회원가입
						</h3>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="humanId" name="humanId" required="required" placeholder="가입하실 ID를 입력해 주세요.">
						</div>
						<br>
							<button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" id="btnOverlappedInfo" value="인증">
									인증
							</button>
						<p class="answer"></p><br>
						
						<div class="bor8 m-b-20 how-pos4-parent">				
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="password" id="password" name="password" placeholder="등록하실 PW를 입력해주세요." required="required">				
						</div>
						<div class="bor8 m-b-20 how-pos4-parent">	
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="password" id="confirmPasswd" placeholder="PW를 한 번 더 입력해주세요." required="required">	
						</div>
						
						
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" name="name" required="required" placeholder="이름을 입력해주세요.">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" placeholder="생년월일을 입력해주세요." readonly="readonly">
							
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="birthY" id="birthY" required="required">
								<c:forEach var="i" begin="0" end="2023">
									<option>${2023-i}</option>
								</c:forEach>
							</select>				
						
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="birthM" id="birthM" required="required">
								<c:forEach var="i" begin="1" end="12">
									<c:choose>
										<c:when test="${i<10 }">
											<option>0${i }</option>
										</c:when>
										<c:otherwise>
											<option>${i }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="birthD" id="birthD" required="required">
								<c:forEach var="i" begin="1" end="31">
									<c:choose>
										<c:when test="${i<10 }">
											<option>0${i }</option>
										</c:when>
										<c:otherwise>
											<option>${i }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>					
						<input type="hidden" name="birthDt">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="email" id="email" name="email" placeholder="이메일을 입력해주세요." required="required">
							<br>
							<button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" id="btnOverlappedEmail" value="인증">
									인증
							</button>
						</div>
						<p class="answer2"></p>
						
						<button type="submit" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
							회원가입
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