<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<h1> 사진 파일만 업로드 </h1>
<%
	String saveDir = request.getRealPath("save"); 
	int max = 1024*1024*10; //10M 업로드 최대크기
	String enc = "UTF-8";	//파일명 한글 인코딩
	DefaultFileRenamePolicy dp = new DefaultFileRenamePolicy(); //파일명 중복 방지
	MultipartRequest mr = new MultipartRequest(request,saveDir,max,enc,dp);
	
	String type = mr.getContentType("save");//  image/jpeg
	String [] format = type.split("/");  //[image][jpeg]
	if(!format[0].equals("image")){
		File f = mr.getFile("save");  
		f.delete();								
%>
	<script>
		alert("이미지만 업로드 가능합니다.");
		history.go(-1);
	</script>
<%} else{%>
	업로드된 이미지 <br />
	<img src="/web/save/<%=mr.getFilesystemName("save") %>" width="400" />
<%} %>