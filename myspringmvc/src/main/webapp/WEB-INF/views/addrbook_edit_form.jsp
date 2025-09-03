<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp" import="lx.edu.springmvc.*"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addrbook.css" type="text/css" media="screen" />

<script type="text/javascript">
	function delcheck() {
		result = confirm("정말로 삭제하시겠습니까 ?");
	
		if(result == true){
			document.form1.action.value="delete";
			document.form1.submit();
		}
		else
			return;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:수정화면</title>
</head>

<jsp:useBean id="ab" scope="request" class="lx.edu.springmvc.AddrBookVO" />

<body>
<div align="center">
<H2>주소록:수정화면 </H2>
<HR>
[<a href="list.do">주소록 목록으로</a>] <p>
ab_id: ${requestScope.ab.abId} <br/>
ab_id: ${ab.abId} <br/>
<form name=form1 method=post action=addrbook_control.jsp>
<input type=hidden name="ab_id" value="${ab.abId}">
<input type=hidden name="action" value="update">

<table border="1">
  <tr>
    <th>이 름</th>
    <td><input type="text" name="abNme" value="${ab.abName}"></td>
  </tr>
  <tr>
    <th>email</th>
    <td><input type="text" name="abEmail" value="${ab.abEmail}"></td>
  </tr>
    <tr>
    <th>전화번호</th>
    <td><input type="text" name="abTel" value="${ab.abTel}"></td>
  </tr>
      <tr>
    <th>생 일</th>
    <td><input type="date" name="abBirth" value="${ab.abBirth}"></td>
  </tr>
  <tr>
    <th>회 사</th>
    <td><input type="text" name="abComdept" value="${ab.abComdept}"></td>
  </tr>
  <tr>
    <th>메 모</th>
    <td><input type="text" name="abMemo" value="${ab.abMemo}"></td>
  </tr>
  <tr>
    <td colspan=2 align=center><input type=submit value="저장"><input type=reset value="취소"><input type="button" value="삭제" onClick="delcheck()"></td>
</tr>
</table>
</form>

</div>
</body>
</html>