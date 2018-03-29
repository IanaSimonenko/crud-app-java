
<html>
<head>
<meta charset="UTF-8">
<title>Add new users</title>
</head>
<body>

<h1>Add New Employee</h1>
<form action="SaveServlet" method="post">
<table>
<tr><td>Name:</td><td><input type="text" name="login"/></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Country:</td><td>
<select name="country" style="width:150px">
<option>Russia</option>
<option>Ukraine</option>
<option>USA</option>
<option>Other</option>
</select>
</td></tr>
<tr><td colspan="2"><input type="submit" value="Save User"/></td></tr>
</table>
</form>

<br/>
<a href="ViewServlet">view employees</a>

</body>
</html>