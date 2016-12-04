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
            <a href="Show schedule">Schedule</a>
        </li>

        <c:choose>
            <c:when test="${empty sessionScope.userEntity}" >
                <li>
                    <a href="login.jsp">Login</a>
                </li>
            </c:when>

            <c:otherwise>
                <li>
                    <a href="Add lesson"> Page to add a lesson </a>
                </li>
                <li>
                    <a href="Remove lesson"> Page to remove a lesson </a>
                </li>
                <li>
                    <a href="Edit lesson"> Page to edit a lesson </a>
                </li>
            </c:otherwise>
        </c:choose>

    </ul>

</nav>
