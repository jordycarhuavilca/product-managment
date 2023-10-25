<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
	<%@page import="model.TblProductocl2" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Productos</title>
</head>
<body bgcolor="#c5dec9">

<form action="ControllerProduct" method="post">

<table align="center">

<tr>
<td>Nombre</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>Precio Compra</td>
<td><input type="text" name="purchasedPrice"></td>
</tr>

<tr>
<td>Precio Venta</td>
<td><input type="text" name="sellPrice"></td>
</tr>

<tr>
<td>Estado</td>
<td><input type="text" name="state"></td>
</tr>

<tr>
<td>Descripcion</td>
<td><input type="text" name="description"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Registrar"></td>
</tr>

</table>

</form>

<%
String message=(String)request.getAttribute("success");
String menreg="";
//aplicamos condicion
if(message != null)  menreg=message;
%>
<h2 align="center" style="color:blue;">
<%=menreg%>
</h2>

<!-- ----------------------------------------------------------------------------------------- -->

<h1 align="center">Listado de Autos</h1>

<table align="center" border="2">

<tr>
<th>Codigo</th>
<th>Nombre</th>
<th>Precio venta</th>
<th>Precio compra</th>
<th>Estado</th>
<th>Descripcion</th>
</tr>

<%
List<TblProductocl2> ListadoProducto=(List<TblProductocl2>)request.getAttribute("listProducts");
if(ListadoProducto != null){
	for(TblProductocl2 lis:ListadoProducto){
%>

<tr>

<td>
<%=lis.getIdproductocl2()%>
</td>

<td>
<%=lis.getNombrecl2()%>
</td>

<td>
<%=lis.getPrecioventacl2()%>
</td>

<td>
<%=lis.getPreciocompcl2()%>
</td>

<td>
<%=lis.getEstadocl2()%>
</td>

<td>
<%=lis.getDescripcl2()%>
</td>

</tr>

<%
	}
}
%>

</table>

</body>
</html>