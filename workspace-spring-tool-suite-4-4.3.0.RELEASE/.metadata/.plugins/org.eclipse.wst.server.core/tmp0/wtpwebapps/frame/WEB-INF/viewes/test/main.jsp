<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<img src="/frame/imgs/${vo.img}" width="250" /> <br />
<b>${sessionScope.memId}</b> <br />
${vo.name} / ${vo.age}

<button onclick="window.location='modifyForm.do'">¼öÁ¤</button>
<button onclick="window.location='logout.do'">·Î±×¾Æ¿ô</button>
<button onclick="window.location='deletForm.do'">Å»Åð</button>

