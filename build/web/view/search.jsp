<%-- 
    Document   : search
    Created on : Sep 11, 2018, 2:37:08 PM
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
        <script type="text/javascript" src="<%= request.getContextPath()%>/template/wowslider/jquery.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath() %>/template/js/custom.js"></script>
        <title>Document</title>
        <script type="text/javascript">
            var paramID = GetURLParameter('search');
            if (paramID == '' || paramID === false) {
                window.location = "404.html";
            }

            $(document).ready(function () {
                //Phần Ajax Load Game
                var keyword = GetURLParameter('search');
                var startAtQuantity = 8;
                var jumpStep = 12;
                var position = startAtQuantity;
                $("section.list-game").load("<%= request.getContextPath()%>/SearchServlet?keyword=" + keyword + "&position=0&item=" + startAtQuantity);

                $("button.box-game-xemthem").click(function () {
                    $.get("<%= request.getContextPath()%>/SearchServlet", {'keyword': keyword, 'position': position, 'item': jumpStep}, function (data) {
                        if (data.length > 0) {
                            $("section.list-game .box-game-last:last").after(data);
                        } else {
                            $("button.box-game-xemthem").remove();
                        }
                    });
                    position += jumpStep;
                });

            });
        </script>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Start Wrapper  -->
            <section class="wrapper">
            <jsp:include page="inc_search.jsp"></jsp:include>
            </section>
            <!-- End Wrapper -->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
