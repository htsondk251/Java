<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatement == null}">
	<c:set var="sqlStatement" value="select * from User" />
</c:if>
<h1>The SQL Gateway</h1>

<p>Enter an SQL statement and clicK the Execute button.</p>

<p><b>SQL statement:</b></p>

<form action="sqlGateway" method="post">
	<textarea name="sqlStatement" rows="8" cols="60">${sqlStatement}</textarea><br>
	<input type="submit" value="Execute">
</form>

<c:if test="${sqlStatement != null}">
<p><b>SQL result:</b><br>
${sqlResult}</p>
<%--
<c:choose>
	<c:when test="${sqlResult == null}">
		<p>The statement failed</p>
	</c:when>
	<c:when test='${sqlResultType.equals("int")}'>
		<p>The statement executed successfully</p>
	</c:when>
	<c:when test='${sqlResultType.equals("ResultSet")}'>
		<table>
		<c:forEach var="user" items="${sqlResult}">
			<tr>
				<td><c:out value="user."</td>
			</tr>
		</c:forEach>
		</table>
	</c:when>
</c:choose>
--%>
</c:if>