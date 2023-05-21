<%--
    Document   : index
    Created on : May 16, 2023, 12:29:38 PM
    Author     : Thuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DateTime.DateTimeError" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="mycss.css" type="text/css"/>
        <title>Date Time Checker</title>
    </head>
    <body>
        <div>
            <img src="images/logo_FPT.jpg" />
            <h1>Date Time Checker</h1>
            <form action="MainController" method="POST">
                <table>
                    <tr>
                        <td>Day</td>
                        <td><input type="text" name="txtDay" value="${param.txtDay}" /></td>
                        <td>
                            <c:if test="${not empty DTE.dayFormatError}">
                                <p id="day-format-error" color="red"> ${DTE.dayFormatError} </p>
                            </c:if>
                            <c:if test="${not empty DTE.dayRangeError}">
                                <p id="day-range-error" color="red"> ${DTE.dayRangeError} </p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Month</td>
                        <td><input type="text" name="txtMonth" value="${param.txtMonth}"  /></td>
                        <td>
                            <c:if test="${not empty DTE.monthFormatError}">
                                <p id="month-format-error" color="red"> ${DTE.monthFormatError} </p>
                            </c:if>
                            <c:if test="${not empty DTE.monthRangeError}">
                                <p id="month-range-error" color="red"> ${DTE.monthRangeError} </p>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td><input type="text" name="txtYear" value="${param.txtYear}" /></td>
                        <td>
                            <c:if test="${not empty DTE.yearFormatError}">
                                <p id="year-format-error" color="red"> ${DTE.yearFormatError} </p>
                            </c:if>
                            <c:if test="${not empty DTE.yearRangeError}">
                                <p id="year-range-error" color="red"> ${DTE.yearRangeError} </p>
                            </c:if>
                        </td>
                    </tr>
                </table>

                <br/>
                <input type="submit" value="Clear" name="btAction" />
                <input type="submit" value="Check" name="btAction" />
                <br/>
                <c:if test="${not empty DTE.invalidDate}">
                    <p color="red"> ${DTE.invalidDate} </p>
                </c:if>
                <c:if test="${not empty DTE.validDate}">
                    <p color="red"> ${DTE.validDate} </p>
                </c:if>
            </form>
        </div>
    </body>
</html>
