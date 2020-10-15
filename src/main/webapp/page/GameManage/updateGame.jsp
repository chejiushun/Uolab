<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/25
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>修改用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()
                +":"+request.getServerPort()+path+"/";
    %>
    <!-- 告诉服务器，当前JSP的路径定位到该基本路径，JSP中的所有静态文件x.js,x.css
      x.jpg等等，获取时都以该路径为基准-->
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <script type="text/javascript" src="../../js/jquery-1.11.3.js"></script>
    <style>
        body {
            background-color: white;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">

    <div class="layuimini-main">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend><strong>请输入修改的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>组员</strong></label>
        <div class="layui-input-block">
            <input type="text" id="organizer" name="match_groupmember" lay-verify="required" lay-reqtext="组织人不能为空" placeholder="请输入组织人" value="${match1.match_groupmember}" class="layui-input" required>
            <tip>只能输入一个组员</tip>
            <tip>2-6汉字</tip><br>
            <tip>添加组织人请点下方的添加</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
    <label class="layui-form-label required"><strong>获奖等级</strong></label>
    <div class="layui-input-block">
        <select lay-verify="required" name="match_comgrade">
            <option value="无" ${match1.match_comgrade=='无'?'selected':''} selected>无</option>
            <option value="特等" ${match1.match_comgrade=='特等'?'selected':''}>特等</option>
            <option value="一等" ${match1.match_comgrade=='一等'?'selected':''}>一等</option>
            <option value="二等" ${match1.match_comgrade=='二等'?'selected':''}>二等</option>
            <option value="三等" ${match1.match_comgrade=='三等'?'selected':''}>三等</option>
            <option value="优秀奖" ${match1.match_comgrade=='优秀奖'?'selected':''}>优秀奖</option>
        </select>
    </div>
</div>

    <div class="layui-form-item" style="width: 400px">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认修改</button>
        </div>
    </div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form;
        var layer = layui.layer;
        $ = layui.$;


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var data = JSON.stringify(data.field);
            //alert(data);
            $.post('MatchServlet?method=updateMatch',{"data":data},function (data) {
                //alert(data);
                if(data == 1){
                    layer.msg("修改成功",{icon:1});
                    //window.location = 'page/user/findUser.jsp';
                }else{
                    layer.msg("修改失败",{icon:2})
                }
            },"json");

        });

        return false;
    });


    // 年选择器 （入学年份）
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var initYear;
        laydate.render({
            elem: '#year',
            type: 'year',
            trigger:'click',
            /* ready和change函数是为了实现选择年份时不用点确定直接关闭  */
            ready: function(date){ // 控件在打开时触发，回调返回一个参数：初始的日期时间对象
                initYear = date.year;
            },
            change: function(value, date, endDate){ // 年月日时间被切换时都会触发。回调返回三个参数，分别代表：生成的值、日期时间对象、结束的日期时间对象
                var selectYear = date.year;
                var differ = selectYear-initYear;
                if (differ != 15 && differ != -15) {
                    if($(".layui-laydate").length){
                        $("#year").val(value);
                        $(".layui-laydate").remove();
                    }
                }
                initYear = selectYear;
            }
        });
    });
</script>
</body>
</html>