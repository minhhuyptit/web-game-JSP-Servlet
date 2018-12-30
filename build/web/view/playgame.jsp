<%-- 
    Document   : playgame
    Created on : Sep 10, 2018, 8:29:33 PM
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
        <link rel="stylesheet prefetch" href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" />
        <title>Document</title>
        <script type="text/javascript" src="<%= request.getContextPath() %>/template/js/custom.js"></script>
        <script type="text/javascript">
            var paramID = GetURLParameter('id');
            if (paramID === '' || paramID === false) {
                window.location = "404.html";
            }

            $(document).ready(function () {
                //Phần Ajax Rating
                var count = 0;
                var id_game = GetURLParameter('id');
                $("#star").click(function () {
                    count++;
                    $.post('<%= request.getContextPath()%>/RatingServlet', {'count': count, 'id_game': id_game}, function(data){
                        console.log(data);
                        $("#luotyeuthich").html(data);
                    });
                });
                
                //Phần phóng to thu nhỏ
                var count_1 = 0;
                $("#fullscreen").click(function(){
                    count_1++;
                    if(count_1 % 2 == 1){
                        $('aside.content-right').hide();
                        $('section.wrapper').attr('style','width:80%');
                        $('section.content-left').attr('style','width:100%');
                        $('section.box-playgame object').attr('style','height:700px');                       
                    }else{
                        $('aside.content-right').show();
                        $('section.wrapper').removeAttr('style');
                        $('section.content-left').removeAttr('style');
                        $('section.box-playgame object').removeAttr('style');
                    }
                });
                
                //Phần Ajax Load Game
                var startAtQuantity  = 8;
                var jumpStep        = 12;
                var position        = startAtQuantity;
                $("section.list-game").load("<%= request.getContextPath()%>/LoadGameServlet?id=" + id_game + "&position=0&item=" + startAtQuantity);
                
                $("button.box-game-xemthem").click(function(){
                    $.get("<%= request.getContextPath()%>/LoadGameServlet", {'id': id_game, 'position': position, 'item': jumpStep}, function(data){
                        if(data.length > 0){
                            $("section.list-game .box-game-last:last").after(data);
                        }else{
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
            <jsp:include page="inc_playgame.jsp"></jsp:include>
            </section>
            <!-- End Wrapper -->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>

