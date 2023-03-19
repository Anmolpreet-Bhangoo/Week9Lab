<%-- 
    Document   : user
    Created on : 20-Feb-2023, 7:07:53 PM
    Author     : Anmolpreet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage User</h1>
        <form action="User" method="post">
        <table border ="5px solid DodgerBlue">
            <tr>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th></th>
            <th></th>
            </tr>
            <c:if test="${user.size() lt 1}"> <p>No users found.</p> </c:if>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td> ${user.email}</td>
                    <td> ${user.firstName}</td>
                    <td> ${user.lastName}</td>
                    <td> ${user.role}</td>
                    
                    <td><a href="User?change=edit&&email2=${user.email}">Edit</a></td>
                    <td><a href="User?change=delete&&email2=${user.email}">Delete</a></td>
                </tr>
                
            </c:forEach>
        </table>
            </form>
            
            <c:if test="${user2 eq null}">
        <form action="User" method="post">
              <h1>Add User</h1>
            Email: <input type="text" name="email"><br>
            First name: <input type="text" name="fname"><br>
            Last name: <input type="text" name="lname"><br>
            Password: <input type="password" name="password"><br>
            Role: <select name="role">
                <option  value="regular user">Regular user</option>
                <option value="system admin">System admin</option>
            </select>
            <br>
            <input type="submit" name="change" value="Add user">      
        </form>
        </c:if>
             <c:if test="${user2 ne null}">  
            <form action="User" method="post">
                <h1>Edit User</h1>
                Email: ${user2.email}<br>
            First name: <input type="text" name="fname" value="${user2.firstName}"><br>
            Last name: <input type="text" name="lname" value="${user2.lastName}"><br>
            Password: <input type="password" name="password"><br>
            Role: <select name="role">
                <option  value="regular user">Regular user</option>
                <option value="system admin">System admin</option>
            </select>
            <br>
            <input type="Submit" name="change" value="Update">
            <input type="Submit" name="change" value="Cancel">
            </form>
             </c:if>
            ${message}
    </body>
</html>
