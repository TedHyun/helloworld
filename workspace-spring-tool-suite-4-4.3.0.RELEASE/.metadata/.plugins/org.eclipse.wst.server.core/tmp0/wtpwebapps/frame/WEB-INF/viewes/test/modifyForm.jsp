<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 
 <form action ="modifyPro.do" method="post" enctype="multipart/form-data">
    id :${vo.id}<br/>
    pw : <input type ="password" name="pw" value="${vo.pw}"/><br/>
    age : <input type ="text" name="age"value="${vo.age}"/><br/>
    name : <input type ="text" name="name"value="${vo.name}"/><br/>
    img: <img src="/frame/imgs/${vo.img}" width="150" /> <br/>
    <input type ="file" name="img" />
    <input type ="hidden" name="org" value="${vo.img}" /><br/>
    <input type="submit" value="����"/><br/>
 </form>