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
	
	$().ready(function() {
		
		$("#btnOverlappedPasswd").click(function(){
			
			$(".answer").empty();
			
			var adminId = $("#adminId").val();
			var adminPassword = $("#adminPassword").val();
			
			if(adminPassword == ''){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/admin/checkDuplicatedPasswd?adminId=" + adminId+"&adminPassword="+adminPassword,
				success : function(data){
					if(data == "duplicate"){
						alert("확인되었습니다.");
						isValid = true;
						$("#btnOverlappedPasswd").remove();
						$(".answer").append("<p style='color: green;'>" + "확인되었습니다." +"</p>");
					}else{
						alert("비밀번호를 확인해주세요.");
						isValid = false;
						$(".answer").append("<p style='color: red;'>" +"비밀번호를 다시 확인해주세요." + "</p>");
					}
				}
				
				
			});
			
		});
		
		$("form").submit(function(){
			
			if(isValid == false){
				alert("비밀번호를 다시 입력해주세요.");
				return false;
			}
			
			if(isValid == true){
				$("[name='coffeeReleaseDate']").val($("#coffeeY").val() +"-" + $("#coffeeM").val() + "-" + $("#coffeeD").val());
				return true;
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
								<c:if test="${sessionScope.adminId ne null }">
									<ul class="sub-menu">
										<li><a href="${contextPath }/admin/ParkHanShop/productRegistration">상품등록</a></li>
										<li><a href="home-02.html">상품삭제</a></li>
									</ul>
								</c:if>
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
					<form action="${contextPath }/admin/ParkHanShop/productRegistration" method="post" enctype="multipart/form-data">
						<h3 class="mtext-105 cl2 txt-center p-b-30">
							상품등록
						</h3>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="adminId" name="adminId" value="${sessionScope.adminId }" readonly="readonly">				
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="password" id="adminPassword" name="adminPassword" placeholder="Password를 입력해주세요." required="required">				
							<br>
							<button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" id="btnOverlappedPasswd" value="인증">
									인증
							</button>
						</div>
						
						
						<p class="answer"></p><br>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" placeholder="등록할 상품의 이미지를 선택해주세요.">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="file" name="coffeeImage" required="required" value="파일 선택">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeSubject" name="coffeeSubject" placeholder="상품 제목을 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeSubjectEn" name="coffeeSubjectEn" placeholder="상품 제목을 영문으로 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeWeight" name="coffeeWeight" placeholder="상품의 무게를 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeKcal" name="coffeeKcal" placeholder="상품의 칼로리를 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<textarea class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" id="coffeeContent" name="coffeeContent" placeholder="상품의 내용을 자세히 입력해주세요." required="required"></textarea>
							<script>CKEDITOR.replace("content")</script>				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeAllergy" name="coffeeAllergy" placeholder="상품의 알러지 성분을 정확하게 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeFat" name="coffeeFat" placeholder="상품의 포화지방 수치를 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeSaccharides" name="coffeeSaccharides" placeholder="상품의 당류 수치를 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeSodium" name="coffeeSodium" placeholder="상품의 나트륨 수치를 입력해주세요." required="required">				
						</div>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeProtein" name="coffeeProtein" placeholder="상품의 프로틴 수치를입력해주세요." required="required">				
						</div>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeCaffeine" name="coffeeCaffeine" placeholder="상품의 카페인 수치를 입력해주세요." required="required">				
						</div>

						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" placeholder="상품의 종류를 선택해주세요.">
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="coffeeSort" id="coffeeSort" required="required">
								<option value="coffee">커피</option>
								<option value="tea">티</option>
								<option value="ade&juice">에이드&주스</option>
								<option value="smoothie&frappe">스무디&프라페</option>
								<option value="decaffeinated">디카페인</option>
								<option value="beverage">음료</option>
								<option value="newProduct">신상품</option>
							</select>				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" placeholder="상품의 출시일을 선택해주세요.">
							
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="coffeeY" id="coffeeY" required="required">
								<c:forEach var="i" begin="0" end="2023">
									<option>${2023-i}</option>
								</c:forEach>
							</select>				
						
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="coffeeM" id="coffeeM" required="required">
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
							<select class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" name="coffeeD" id="coffeeD" required="required">
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
						<input type="hidden" name="coffeeReleaseDate">
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeePrice" name="coffeePrice" placeholder="상품의 가격을 숫자로 입력해주세요." required="required">				
						</div>
						
						<div class="bor8 m-b-20 how-pos4-parent">
							<input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" type="text" id="coffeeInventoryMount" name="coffeeInventoryMount" placeholder="상품의 재고량을 숫자로 입력해주세요." required="required">				
						</div>
						
						<button type="submit" class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">
							등록
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