<%-- 
    Document   : homeAdminFooter
    Created on : 18 thg 11, 2020, 22:53:19
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="../admin/vendors/jquery/dist/jquery.min.js"></script>
        <script src="../admin/vendors/popper.js/dist/umd/popper.min.js"></script>
        <script src="../admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="../admin/assets/js/main.js"></script>


        <script src="../admin/vendors/chart.js/dist/Chart.bundle.min.js"></script>
        <script src="../admin/assets/js/dashboard.js"></script>
        <script src="../admin/assets/js/widgets.js"></script>
        <script src="../admin/vendors/jqvmap/dist/jquery.vmap.min.js"></script>
        <script src="../admin/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
        <script src="../admin/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
        <script>
            (function ($) {
                "use strict";

                jQuery('#vmap').vectorMap({
                    map: 'world_en',
                    backgroundColor: null,
                    color: '#ffffff',
                    hoverOpacity: 0.7,
                    selectedColor: '#1de9b6',
                    enableZoom: true,
                    showTooltip: true,
                    values: sample_data,
                    scaleColors: ['#1de9b6', '#03a9f5'],
                    normalizeFunction: 'polynomial'
                });
            })(jQuery);
        </script>
    </body>
</html>
