<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<img src="/frame/imgs/${vo.img}" width="250" /> <br />
<b>${sessionScope.memId}</b> <br />
${vo.name} / ${vo.age} <br />

<button onclick="window.location='modifyForm.do'">����</button>
<button onclick="window.location='logout.do'">�α׾ƿ�</button>
<button onclick="window.location='deleteForm.do'">Ż��</button>

