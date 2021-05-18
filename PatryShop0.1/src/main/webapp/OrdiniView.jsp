<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Collection<?> ordini = (Collection<?>) request.getAttribute("ordini");
    if(ordini == null) {
        response.sendRedirect("./CartView.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.pastryshop.*"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="ProductStyle.css" rel="stylesheet" type="text/css">
    <title>Ordini</title>
</head>

<body>
    <h2>Ordini</h2>
    <table border="1">
        <tr>
            <th>Codice</th>
            <th>Totale</th>
            <th>DataOrdine</th>
        </tr>
        <%
            if (ordini != null && ordini.size() != 0) {
                Iterator<?> it = ordini.iterator();
                while (it.hasNext()) {
                    OrdiniBean bean = (OrdiniBean) it.next();
        %>
        <tr>
            <td><%=bean.getCode()%></td>
            <td><%=bean.getTotale()%></td>
            <td><%=bean.getData_ordine()%></td>


        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">Non ci sono ordini</td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="./ProductView.jsp">HOME</a>
</body>
</html>
