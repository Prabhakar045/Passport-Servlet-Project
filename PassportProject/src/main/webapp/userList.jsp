<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <h2>User List</h2>

    <table>

            <tr>
                <th>User ID</th>
                <th>Passport Office</th>
                <th>Given Name</th>
                <th>Surname</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Login ID</th>
                <th>Hint Question</th>
                <th>Hint Answer</th>
                 <th>Action</th>

            </tr>


            <c:forEach  items="${users}" var="user">
                <tr>
                    <td>${user.getUserId()}</td>
                    <td>${user.getPassportOffice()}</td>
                    <td>${user.getGivenName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getDob()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getLoginId()}</td>
                    <td>${user.getHintQuestion()}</td>
                    <td>${user.getHintAnswer()}</td>
                    <td>
                        <a href="update?userId=${user.getUserId()}">Update</a>
                        &nbsp; &nbsp; &nbsp;
                        <a href="delete?userID=${user.getUserId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

    </table>


</body>
</html>
