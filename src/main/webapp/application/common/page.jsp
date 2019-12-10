<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/lib/layui/css/layui.css" media="all">
<title>Insert title here</title>
<%--<script type="text/javascript" src="js/jquery-1.8.2.js"></script>--%>
<script src="/lib/layui/layui.js"></script>
<script>

layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
	elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
    count: ${page.totalCount}, //数据总数，从服务端得到
    limit:${page.pageSize},//每页显示的条数
    limits:[1, 2, 3, 4, 5],//每页显示的条数的下拉菜单
    curr:${page.currentPage},//当前第几页
    groups:5,//连续出续页码个数,
    layout:['count','prev','page','next','limit','refresh','skip'],
    jump: function(obj, first){
        //obj包含了当前分页的所有参数，比如：
        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
        console.log(obj.limit); //得到每页显示的条数
        console.log(${conditions});
        
        //首次不执行
        if(!first){
        	//写分页的跳转地址
            debugger;
        	//location.href="${page.url}?currentPage="+obj.curr+"&pageSize="+obj.limit;
            $("#${param.bodyId}").load("${page.url}?currentPage="+obj.curr+"&pageSize="+obj.limit, ${conditions});
        }
      }
  });
});
</script>
</head>
<body>
<div id="page"></div>
</body>
</html>