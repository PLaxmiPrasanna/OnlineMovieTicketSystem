<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
    border-spacing: 0;
    width:50%;
    margin-left:auto; 
    margin-right:auto;
    
}
th, td {
    /*border: 1px solid #171a18;*/
    padding: 0.5em 1em;
    border: solid black 2px;
}

thead tr:first-child th:first-child {
    border-radius: 0.6em 0 0 0;
    border: solid black 2px;
 
    
}

thead tr:first-child th:last-child {
    border-radius: 0 0.6em 0 0;
}

tbody tr:last-child td:first-child {
    border-radius: 0 0 0 0.6em;
    
}
 
tbody tr:last-child td:last-child {
    border-radius: 0 0 0.6em 0;


}

thead {
 font-size:30px;
 background-color: #75f542;
}
tbody {
font-size:20px;
background-color:white;
}
 th, td{
  padding: 8px;
  text-align: left;
 border: solid black 2px;
}

tr:hover {background-color:#d1cdd1}
body {
background-image: url("bg1.jpg");

}
</style>
</head>
<body>

<h2>Hoverable Table</h2>
<p>Move the mouse over the table rows to see the effect.</p>

<table >
<thead>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Points</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>Peter</td>
    <td>Griffin</td>
    <td>$100</td>
  </tr>
  <tr>
    <td>Lois</td>
    <td>Griffin</td>
    <td>$150</td>
  </tr>
  <tr>
    <td>Joe</td>
    <td>Swanson</td>
    <td>$300</td>
  </tr>
  <tr>
    <td>Cleveland</td>
    <td>Brown</td>
    <td>$250</td>
  </tr>
  </tbody>
</table>

</body>
</html>
