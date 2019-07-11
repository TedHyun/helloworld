<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>login form 을 이용한 유효성 검사</h1>

<script>
	function checkForm(){
		form = document.form;
		if(form.id.value.length < 4 || form.id.value.length > 12){
			alert("4~12자 이내로 작성하세요.");
			form.id.focus();
			return;
			
		}
		if(form.pw.value.length < 4){
			alert("4자 이상 작성하시요.");
			form.pw.focus();
			return;
		}
		form.submit();
		
		if(!form.id.value){
			alert("아이디를 입력하세요.");
			form.id.focus();
		}
		if(form.pw.value==""){
			alert("비밀번호를 입력하세요.");	
			form.pw.selet();
		}
		alert(document.form.id.value +"\n"+document.form.pw.value);			
	}


</script>
<!-- id/pw 중 하나라도 입력이 안되면 이동금지 -->
<!-- 아이디를 4~12 이내로 입력 가능 -->
<!-- 비밀번호 4글자 이상 -->

<form name=form action= "LoginPro.jsp" method="post" >
		id : <input type="text" name="id"  /> <br />
		pw : <input type="password" name="pw"  /> <br />
			 <input type="button" value="로그인" onclick="checkForm()"/> <br />		 
</form>
