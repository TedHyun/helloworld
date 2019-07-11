<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>정규 표현실을 활용한 유효성 검사</h1>
<script type = "text/javascript">
	function checkReg(){
		//^시작문자 *반복 $마지막문자
		
		var regId =/^[a-z|A-Z]/;   //대소문자 a~z까지만 허용
		var regName = /^[가-힇]*$/;  // 모든한글만 허용
		var regAge = /^[0-9]*$/;
		var regPhone= /^\d{3}-\d{3,4}-\d{4}$/;  //숫자 3번 반복.
		
		var my = document.my;
		if(!regId.test(my.id.value)){
			alert("대소문자 a~Z 까지만 가능합니다.");
			my.id.focus();
		}
		if(!regName.test(my.name.value)){
			alert("한글만 가능합니다.");
			my.name.focus();
		}
		if(!regAge.test(my.age.value)){
			alert("숫자만 가능.");
			my.age.focus();
		}
		if(!regPhone.test(my.phone.value)){
			alert("010-0000-0000 형식 입력");
			my.phone.focus();
		}
	}

</script>


<form name="my" action="#">
	id : <input type= "text" name="id" required /> <br />
	pw : <input type= "password" name="pw" required/> <br />
	name: <input type = "text" name= "name" required/> <br />
	Age: <input type = "text" name= "age" required /> <br />
	phone: <input type ="text" name= "phone" required /> <br />
		 <input type= "button" value="전송" onclick="checkReg()"/> <br />
	
</form>