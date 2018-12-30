<%-- 
    Document   : facebook_comment
    Created on : Sep 11, 2018, 8:36:28 PM
    Author     : huyla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.1&appId=695569454140514';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div class="fb-comments" data-href="<%= request.getRequestURL() +"?"+ request.getQueryString() %>" data-width="100%" data-numposts="5"></div>