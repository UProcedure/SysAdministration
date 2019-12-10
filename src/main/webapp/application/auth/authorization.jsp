<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/9/26
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <title>Title</title>
</head>
<body id="userBody" style="text-decoration:none">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
    <div class="text-c">
        <div class="row cl ">
            <div class="formControls col-6">
               角色:
                <select id="role">
                    <option value="-1">请选择</option>
                    <c:forEach items="${roleList}" var="role">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="formControls col-6">
                类型:
                <select id="type">
                    <option value="-1">请选择</option>
                    <option value="1">用户</option>
                    <option value="2">菜单</option>
                </select>
            </div>
        </div>
        <div class="row cl">
            <div class="cl pd-5">
                <button type="button"
                        class="btn btn-success radius" id="query" name="">
                    <i class="Hui-iconfont">&#xe665;</i> 搜索
                </button>
            </div>
        </div>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" style="text-decoration: none" onclick="auth_add_user('授权新用户','auth/getNoAuthUserByRoleId','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 授权新用户</a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg" id="authorization">
        <%--动态填充数据--%>
    </table>

</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript">
    $(function(){
        $("#query").click(function(){
            //判断是否选择类型和角色
            var role = $("#role").val();
            var type = $("#type").val();
            if(role==-1){
                layer.msg('请选择角色名称', {icon:5,time:2000});
                return;
            }

            if(type==-1){
                layer.msg('请选择类型', {icon:5,time:2000});
                return;
            }

            //判断选择了用户还是菜单
            if(type==1){
                //选择是用户
                //auth/getUserListByRoleId?roleId=1
                $("#authorization").load("auth/getUserListByRoleId",{'roleId':role});
            }else{
                //选择是菜单
                $("#authorization").load("auth/getMenuListByRoleId",{'roleId':role});
            }
        })
    })

    //授权新用户
    function auth_add_user(title,url,w,h){
        //判断是否选择类型和角色
        var role = $("#role").val();
        var type = $("#type").val();
        if(role==-1){
            layer.msg('请选择角色名称', {icon:5,time:2000});
            return;
        }

        if(type==-1){
            layer.msg('请选择类型', {icon:5,time:2000});
            return;
        }

        if(type==1){
            //选择用户
            //auth/getNoAuthUserByRoleId?roleId=2
            url = url+"?roleId="+role;
            layer_show(title,url,w,h);
        }else{
            layer.msg('请选择用户', {icon:5,time:2000});
            return;
        }

    }
</script>
</body>
</html>
