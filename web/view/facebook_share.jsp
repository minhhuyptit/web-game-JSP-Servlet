<%-- 
    Document   : facebook_share
    Created on : Sep 11, 2018, 8:33:00 PM
    Author     : huyla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="fb-root"></div>
<script>(function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id))
            return;
        js = d.createElement(s);
        js.id = id;
        js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.1&appId=695569454140514';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>
<div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="box_count" data-size="large" data-mobile-iframe="true">
    <a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">Share</a></div>