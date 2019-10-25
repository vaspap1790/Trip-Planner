<%-- 
    Document   : hotelForm
    Created on : Oct 22, 2019, 3:22:32 PM
    Author     : vaspa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="../css/autocomplete.css">
    </head>
    <body>
        <jsp:include page="../components/navbar.jsp"/> 
        <h1>Hello World!ggffg</h1>
        <a href="${pageContext.request.contextPath}/hotel/postHotelForm">hotel</a>




        <form action="${pageContext.request.contextPath}/hotel/postHotelForm" method="POST">
            <div class="container w-25">

                <input type="text" id="city1" class="form-control autocomplete" placeholder="Pick destination">
                <input name="checkin" type="date" class="form-control" placeholder="Check in">
                <input name="checkout" type="date" class="form-control" placeholder="Check out">
                <select name="guests" class="form-control">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <input name="dest_id" id="dest_id" hidden>
                <button class="btn btn-primary" id="submit" >Search</button>
            </div>
        </form>

        <div id="cityImg" ></div>








        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
            src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"
            integrity="sha256-0YPKAwZP7Mp3ALMRVB2i8GXeEndvCq3eSl/WsAl1Ryk="
        crossorigin="anonymous"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/booking.js"></script>

    </body>
</html>
