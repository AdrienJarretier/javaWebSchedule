<%-- 
    Document   : nav
    Created on : 4 déc. 2016, 11:15:45
    Author     : Jarretier Adrien "jarretier.adrien@gmail.com"
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav>
    <ul>
        <li>
            <a href="index.jsp">Home</a>
        </li>
        <li>
            <a href="SelectSchedule?type=teachers">Teachers Schedules</a>
        </li>
        <li>
            <a href="SelectSchedule?type=degrees">Degrees Schedules</a>
        </li>
        <li>
            <a href="degreeStat.jsp">Degrees Stats</a>
        </li>

        <c:choose>
            <c:when test="${empty sessionScope.userEntity}" >
                <li>
                    <a href="login.jsp">Login</a>
                </li>
            </c:when>

            <c:otherwise>
                <li>
                    <a href="StaffController"> View lessons </a>
                </li>

            </c:otherwise>
        </c:choose>

    </ul>

</nav>
