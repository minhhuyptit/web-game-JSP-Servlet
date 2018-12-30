<%-- 
    Document   : register
    Created on : Sep 6, 2018, 8:57:58 PM
    Author     : huyla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/template/css/style.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/template/wowslider/wowslider.css">
        <script type="text/javascript" src="<%= request.getContextPath()%>/template/wowslider/jquery.js"></script>
        <title>Document</title>
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#username").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="<%= request.getContextPath()%>/template/images/load.gif" />');
                    $.post('<%= request.getContextPath()%>/CheckUsernameServlet', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Start Wrapper  -->
            <section class="wrapper">
            <jsp:include page="inc_register.jsp"></jsp:include>
            </section>
            <!-- End Wrapper -->

        <jsp:include page="footer.jsp"></jsp:include>
            <!-- Start Wowslider -->
            <script type="text/javascript" src="<%= request.getContextPath()%>/template/wowslider/wowslider.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/template/wowslider/script.js"></script>
        <!-- End Wowslider -->
    </body>

</html>

