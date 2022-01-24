<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Postings</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Postings</h1>


<br/><br/>
    <table  width="1300" border="1">
        <tr align="center">
            <th>Mat.Doc</th>
            <th>Item</th>
            <th>Doc. Date</th>
            <th>Pstng. Date</th>
            <th>Material Description</th>
            <th>Quantity</th>
            <th>BUn</th>
            <th>Amount LC</th>
            <th>Crcy</th>
            <th>User Name</th>
            <th>authorizDelivery</th>
        </tr>
        <c:forEach  items="${suppliesListFromFiltredDb}" var ="suppliesList">
            <tr align="center">
                <td>${suppliesList.getMatDoc()}</td>
                <td>${suppliesList.getItem()}</td>
                <td>${suppliesList.getDocDate()}</td>
                <td>${suppliesList.getPstngDate()}</td>
                <td>${suppliesList.getMaterialDesc()}</td>
                <td>${suppliesList.getQuantity()}</td>
                <td>${suppliesList.getBun()}</td>
                <td>${suppliesList.getAmountLC()}</td>
                <td>${suppliesList.getCrcy()}</td>
                <td>${suppliesList.getUserName()}</td>
                <td>${suppliesList.getAuthorizDelivery()}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>