<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Customer Records Page</title>
</head>
<body>


<!--     Customer Records Page    -->
<div class="customerRecords">

    <!--      Navbar    -->
    <div class="nav">
        <div><strong>Home Design Solutions (HDS)</strong></div>

        <!--      Hyperlinks   -->
        <ul>
            <li><a href="../html-home/index.html">Home</a></li>
            <li><a href="../html-home/about.html">About</a></li>
            <li><a href="../html-home/contact.html">Contact</a></li>
        </ul>
    </div>

    <!--     Vertical DropDown Menu         -->
    <div id="divMenu">
        <ul>
            <li><a href="../html-home/about.html">About</a></li>

            <li><a href="../html-services/services.html">Services</a></li>

            <li><a href="#">Products</a>
                <ul>
                    <li><a href="../html-appliances/appliances.html">Appliances</a></li>
                    <li><a href="../html-appliances/cabinets.html">Cabinets</a></li>
                    <li><a href="../html-appliances/lighting.html">Lighting</a></li>
                    <li><a href="../html-appliances/plumbing.html">Plumbing</a></li>
                    <li><a href="../html-appliances/ct_ft.html">Countertops &
                        FloorTile</a></li>
                </ul>
            </li>

            <li><a href="#">Locations</a>
                <ul>
                    <li><a href="../html-locations/phoenix.html">Phoenix, AZ</a></li>
                    <li><a href="../html-locations/scottsdale.html">Scottsdale, AZ</a>
                    </li>
                    <li><a href="../html-locations/tucson.html">Tucson, AZ</a></li>
                    <li><a href="../html-locations/lv.html">Las Vegas, NV</a></li>
                    <li><a href="../html-locations/al.html">Albuquerque, NM</a></li>
                </ul>
            </li>

            <!--    Gallery Images      -->
            <li><a href="../html-gallery/gallery.html">Our Work</a></li>

            <li><a href="../employeeSection/employeeSection.html">Employee test</a>

        </ul>
    </div>

    <div class="customerRecords-content">

        <h1>Customer Records<br><br></h1>


        <table id="recordTable">
            <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th></th>
            </tr>
            <tr>
                <%--Add new Customer--%>
                <td><label><input type="text" name="customerID" value=""/></label></td>
                <td><label><input type="text" name="cus.firstName" value=""/></label></td>
                <td><label><input type="text" name="cus.lastName" value=""/></label></td>
                <td><label><input type="text" name="cus.streetAddress" value=""/></label>
                </td>
                <td><label><input type="text" name="cus.city" value=""/></label></td>
                <td>
                    <jsp:include page="../templates/selectState.html"></jsp:include>
                </td>
                <td><label><input type="text" name="cus.zip" value=""/></label></td>
                <td><label><input type="tel" name="cus.phNumber" value=""/></label></td>
                <td><label><input type="email" name="cus.email" value=""/></label></td>
                <td>
                    <form action="../customerServlet" method="POST">
                        <input type="submit" name="ADD" value="Add New Customer">
                    </form>
                </td>
            </tr>
            <c:forEach var="customerList" items="${customerList}">
                <tr>
                    <td>${customerList.id}</td>
                    <td>${customerList.firstName}</td>
                    <td>${customerList.lastName}</td>
                    <td>${customerList.streetAddress}</td>
                    <td>${customerList.city}</td>
                    <td>${customerList.state}</td>
                    <td>${customerList.zip}</td>
                    <td>${customerList.phNumber}</td>
                    <td>${customerList.email}</td>
                    <td>
                        <a href="edit?id=<c:out value='${customerList.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${customerList.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <%--Sample layout--%>
            <tr>
                <td>{customerList.id}</td>
                <td>{customerList.firstName}</td>
                <td>{customerList.lastName}</td>
                <td>{customerList.streetAddress}</td>
                <td>{customerList.city}</td>
                <td>{customerList.state}</td>
                <td>{customerList.zip}</td>
                <td>{customerList.phNumber}</td>
                <td>{customerList.email}</td>
                <td>
                    <a href="edit?id=<c:out value='${customerList.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${customerList.id}' />">Delete</a>
                </td>
            </tr>
        </table>

    </div>
</div>


<footer>
    <p><br><br><br></p>
    <h3>CONTACT US:<br><br></h3>
    <p>
        <strong>Home Design Solutions</strong> <br/>
        <strong>101 Sedalia Dr.</strong> <br/>
        <strong>Phoenix, AZ 85001</strong> <br/>
        Phone: 602-KITCHEN <br/>
        Fax: 602-555-1212
    </p>
</footer>
<script>

</script>

</body>
</html>

