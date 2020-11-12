<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!--CSS-->
    <link rel="stylesheet" href="../view/css/style.css">
    <link rel="stylesheet" href="../view/css/employeeSection.css">

    <!--    External Font for Header    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


    <title>Home Design Solutions | Inventory Page</title>
</head>
<body>


<!--     Inventory Page    -->
<div class="inventory">

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

            <li><a href="../employeeSection/employeeSection.html">Employee</a>

            <li><a href="../html-faq/faq.html">FAQs</a>

        </ul>
    </div>

    <div class="inventory-content">

        <h1>Inventory<br><br></h1>


        <table id="inventoryTable">
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Model Number</th>
                <th>Serial Number</th>
                <th>Description</th>
                <th>Retail Price</th>
                <th>Listed Price</th>
                <th>Delivery Cost</th>
                <th>Inventory Count</th>
                <th>Category</th>
                <th> </th>
            </tr>
            <tr>
                <td><label><input type="text" name="productId" value=""/></label></td>
                <td><label><input type="text" name="product.name" value=""/></label></td>
                <td><label><input type="text" name="product.modelNumber" value=""/></label></td>
                <td><label><input type="text" name="product.serialNumber" value=""/></label></td>
                <td><label><input type="text" name="product.description" value=""/></label></td>
                <td><label><input type="text" name="product.retailPrice" value=""/></label></td>
                <td><label><input type="text" name="product.listedPrice" value=""/></label></td>
                <td><label><input type="text" name="product.deliveryCost" value=""/></label></td>
                <td><label><input type="text" name="product.inventoryCount" value=""/></label></td>
                <td><label><input type="text" name="product.category" value=""/></label></td>
                <td>
                    <form action="../inventoryServlet" method="GET">
                        <input type="submit" name="Add New Product" value="Add New Product">
                    </form>
                </td>
            </tr>
            <c:forEach var="productList" items="${productList}">
                <tr>
                    <td>${productList.id}</td>
                    <td>${productList.name}</td>
                    <td>${productList.modelNumber}</td>
                    <td>${productList.serialNumber}</td>
                    <td>${productList.description}</td>
                    <td>${productList.retailPrice}</td>
                    <td>${productList.listedPrice}</td>
                    <td>${productList.deliveryCost}</td>
                    <td>${productList.inventoryCount}</td>
                    <td>${productList.category}</td>
                    <td>
                        <a href="edit?id=<c:out value='${productList.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${productList.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <%--Sample layout--%>
            <tr>
                <td>{productList.id}</td>
                <td>{productList.name}</td>
                <td>{productList.modelNumber}</td>
                <td>{productList.serialNumber}</td>
                <td>{productList.description}</td>
                <td>{productList.retailPrice}</td>
                <td>{productList.listedPrice}</td>
                <td>{productList.deliveryCost}</td>
                <td>{productList.inventoryCount}</td>
                <td>{productList.category}</td>
                <td>
                    <a href="edit?id=<c:out value='${productList.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${productList.id}' />">Delete</a>
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


</body>
</html>
