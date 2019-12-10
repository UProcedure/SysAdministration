<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <link href="css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/H-ui.admin.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="lib/zTree/v3/css/demo.css" type="text/css">
    <link rel="stylesheet" href="lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body style="text-decoration:none">
<div class="pd-20">
    <table class="table table-border table-bordered table-bg">
        <div class="zTreeDemoBackground left" style="margin-left: 100px">
            <%--<input type="button" class="btn btn-primary radius" value="授权新菜单" id="refreshAuthMenu"/>--%>
            <span class="btn btn-primary radius" id="refreshAuthMenu"><i class="Hui-iconfont">&#xe600;</i> 授权新菜单</span>
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <br/>

    </table>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript">
    $(function () {
        var setting = {
            check: {
                enable: true
            },
            data: {
                key: {
                    name: "menuName"
                },
                simpleData: {
                    enable: true,
                    idKey: "menuId",
                    pIdKey: "menuParentId"
                }
            }
        };
        console.log(${sysMenuVoList});
        var zNodes =${sysMenuVoList};
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);

        $("#refreshAuthMenu").click(function () {
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getCheckedNodes(true);

            var ids = [];
            for (var i = 0; i < nodes.length; i++) {
                ids.push(nodes[i].menuId)
            }

            $.ajax({
                url: "auth/refreshAuthMenu",
                type: "GET",
                data: "ids=" + ids + "&roleId=" +${roleId},
                success: function (data) {
                    if (data.result) {
                        layer.msg('授权新菜单成功', {icon: 1, time: 2000});
                    } else {
                        layer.msg('授权新菜单失败', {icon: 5, time: 2000});
                    }
                }
            })

        })
    })
</script>
</body>
</html>
