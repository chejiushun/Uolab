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
            <legend><strong>请输入修改用户的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>用户名</strong></label>
        <div class="layui-input-block">
            <input id="username" type="text" name="user_name" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名" value="${user1.user_name}" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>密码</strong></label>
        <div class="layui-input-block">
            <input id="password" type="password" name="user_pwd" lay-verify="required" lay-reqtext="密码不能为空" placeholder="请输入密码" value="${user1.user_pwd}" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>真实姓名</strong></label>
        <div class="layui-input-block">
            <input id="realname" type="text" name="user_realname" lay-verify="required" lay-reqtext="真实姓名不能为空" placeholder="请输入真实姓名" value="${user1.user_realname}" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>院系</strong></label>
        <div class="layui-input-block">
            <select name="user_dep" disabled>
                <option value="1" ${user1.user_dep=='计算机科学与技术学院'?'selected':''}>计算机科学与技术学院</option>
                <option value="2" ${user1.user_dep=='电子信息工程学院'?'selected':''}>电子信息工程学院</option>
                <option value="3" ${user1.user_dep=='机械电子工程学院'?'selected':''}>机械电子工程学院</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>专业</strong></label>
        <div class="layui-input-block">
            <select name="user_major" disabled>
                <option value="1" ${user1.user_major=='计算机科学与技术'?'selected':''}>计算机科学与技术</option>
                <option value="2" ${user1.user_major=='软件工程'?'selected':''}>软件工程</option>
                <option value="3" ${user1.user_major=='网络工程'?'selected':''}>网络工程</option>
                <option value="4" ${user1.user_major=='物联网'?'selected':''}>物联网</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label "><strong>年级</strong></label>
        <div class="layui-input-block">
            <div class="layui-input-inline">
                <input id="year" type="text" name="user_grade" placeholder="请选择入学年份"  value="${user1.user_grade}" autocomplete="off" class="layui-input" readonly disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>校内职务</strong></label>
        <div class="layui-input-block">
            <input type="text" name="user_duty"  placeholder="请输入校内职务" value="${user1.user_duty}" class="layui-input" >
        </div>
    </div>
    <div class="layui-form-item" >
        <label class="layui-form-label"><strong>性别</strong></label>
        <div class="layui-input-block">
            <input type="radio" name="user_sex" value="${user1.user_sex}" title="男" ${user1.user_sex=='男'?'checked':''} disabled>
            <input type="radio" name="user_sex" value="${user1.user_sex}" title="女" ${user1.user_sex=='女'?'checked':''} disabled>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>手机</strong></label>
        <div class="layui-input-block">
            <input id="telephone" type="number" name="user_tel" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value="${user1.user_tel}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>QQ</strong></label>
        <div class="layui-input-block">
            <input type="text" name="user_qq" placeholder="请输入QQ号码" value="${user1.user_qq}" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>角色</strong></label>
        <div class="layui-input-block">
            <select name="role_id" >
                <option value="1" ${user1.role_id==1?'selected':''}>超级管理员</option>
                <option value="2" ${user1.role_id==2?'selected':''}>管理员</option>
                <option value="3" ${user1.role_id==3?'selected':''}>普通用户</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>用户状态</strong></label>
        <div class="layui-input-block">
            <select name="user_state" disabled>
                <option value="1" ${user1.user_state==1?'selected':''}>启用</option>
                <option value="2" ${user1.user_state==0?'selected':''}>禁用</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text"  style="width: 600px">
        <label class="layui-form-label"><strong>备注</strong></label>
        <div class="layui-input-block">
            <textarea name="user_remarks" class="layui-textarea" placeholder="请输入备注信息" ></textarea>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form;
        var layer = layui.layer;
        $ = layui.$;


        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function(){
            var username = $("#username").val();
            var reg = /^[a-zA-Z0-9_-]{5,16}$/;//正则表达式
            if(username.length == 0|| username==null || username == '') {
                layer.msg('用户名不能为空', {icon: 5});
            }else{
                if(!reg.test(username)) {
                    layer.msg('格式不对，用户名至少要5个字符', {icon: 5});
                }
            }
        });

        // 2. 验证密码，失去焦点时触发
        $("#password").blur(function(){
            var password = $("#password").val();
            var reg = /^[a-zA-Z0-9_-]{6,20}$/;//正则表达式
            if(password.length == 0|| password==null || password == '') {
                layer.msg('密码不能为空', {icon: 5});
            }else{
                if(!reg.test(password)) {
                    layer.msg('密码格式不对，密码是6-20个字符，由数字和字母构成', {icon: 5});
                }
            }
        });

        // 3. 验证姓名，失去焦点时触发
        $("#realname").blur(function(){
            var realname = $("#realname").val();
            var reg = /^[\u4e00-\u9fa5]{2,5}$/;//正则表达式,2-5个汉字
            if(realname.length == 0|| realname==null || realname == '') {
                layer.msg('真实姓名不能为空', {icon: 5});
            }else{
                if(!reg.test(realname)) {
                    layer.msg('格式不对，真实姓名为2-5个汉字', {icon: 5});
                }
            }
        });

        // 4. 验证手机号码，失去焦点时触发
        $("#telephone").blur(function(){
            var telephone = $("#telephone").val();
            var reg = /^1[3456789]\d{9}$/;//正则表达式
            if(telephone.length == 0|| telephone==null || telephone == '') {
                layer.msg('手机号码不能为空', {icon: 5});
            }else{
                if(!reg.test(telephone)) {
                    layer.msg('手机号码格式不对', {icon: 5});
                }
            }
        });
        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var data = JSON.stringify(data.field);
            //alert(data);
            $.post('UserServlet?method=updateUser',{"data":data},function (data) {
                //alert(data);
                if(data == 1){
                    layer.msg("用户修改成功",{icon:1});
                    //window.location = 'page/user/findUser.jsp';
                }else{
                    layer.msg("用户修改失败",{icon:2})
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