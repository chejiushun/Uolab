<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/18
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../lib/layui-v2.5.5/css/layui.css" media="all">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        html, body {width: 100%;height: 100%;overflow: hidden}
        body {background: black;}
        body:after {content:'';background-repeat:no-repeat;background-size:cover;-webkit-filter:blur(3px);-moz-filter:blur(3px);-o-filter:blur(3px);-ms-filter:blur(3px);filter:blur(3px);position:absolute;top:0;left:0;right:0;bottom:0;z-index:-1;}
        .layui-container {width: 100%;height: 100%;overflow: hidden}
        .admin-login-background {width:360px;height:300px;position:absolute;left:50%;top:40%;margin-left:-180px;margin-top:-100px;}
        .logo-title {text-align:center;letter-spacing:2px;padding:14px 0;}
        .logo-title h1 {color:#1E9FFF;font-size:25px;font-weight:bold;}
        .login-form {background-color:#fff;border:1px solid #fff;border-radius:3px;padding:14px 20px;box-shadow:0 0 8px #eeeeee;}
        .login-form .layui-form-item {position:relative;}
        .login-form .layui-form-item label {position:absolute;left:1px;top:1px;width:38px;line-height:36px;text-align:center;color:#d2d2d2;}
        .login-form .layui-form-item input {padding-left:36px;}
        .captcha {width:60%;display:inline-block;}
        .captcha-img {display:inline-block;width:34%;float:right;}
        .captcha-img img {height:34px;border:1px solid #e6e6e6;height:36px;width:100%;}
    </style>
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form id="form1" class="layui-form" action='${pageContext.request.contextPath}/login' method="post">
                <div class="layui-form-item logo-title">
                    <h1>UOL联合开放实验室登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" id="username" name="user_name" lay-verify="required|account" placeholder="用户名或者邮箱" autocomplete="off" class="layui-input" value="${cookie.username.value}">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" id="password" name="user_pwd" lay-verify="required|password" placeholder="密码" autocomplete="off" class="layui-input" value="${cookie.password.value}">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-vercode" for="captcha"></label>
                    <!--lay-verify="required|captcha"-->
                    <input type="text" id="captcha" name="code"  placeholder="图形验证码" autocomplete="off" class="layui-input verification captcha" >
                    <div class="captcha-img">
                        <img id="captchaPic" src="${pageContext.request.contextPath}/code" title="看不清楚，换一张" alt="验证码" onclick="changeImge(this);">
                    </div>
                </div>
                <%--                <div class="layui-inline">--%>
                <%--                    <label class="layui-form-label">记住密码</label>--%>
                <%--                    <div class="layui-input-inline">--%>
                <%--                        <input type="checkbox" name="rememberMe" lay-skin="primary"  class="layui-input" >--%>
                <%--                    </div>--%>
                <%--                    <label class="layui-form-label">7天免登录</label>--%>
                <%--                    <div class="layui-input-inline">--%>
                <%--                        <input type="checkbox" name="freelogin" lay-skin="primary"  class="layui-input"  >--%>
                <%--                    </div>--%>
                <%--                </div>--%>

                <%--                <div class="layui-form-item">--%>
                <%--                    <div class="layui-input-inline">--%>
                <%--                    <input type="checkbox" name="rememberMe"  lay-skin="primary" class="layui-input" title="记住密码">--%>
                <%--                    </div>--%>
                <%--                    <div class="layui-input-inline">--%>
                <%--                         --%>
                <%--                        <input type="checkbox" name="freelogin" lay-skin="primary" class="layui-input" title="7天免密登录">--%>
                <%--                    </div>--%>
                <%--                </div>--%>

                <div class="layui-form-item">

                    <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" title="记住密码">
                    <input type="checkbox" name="freelogin" value="ok" lay-skin="primary" title="7天免密登录">

                </div>

                <div class="layui-form-item">

                    <button id="btn" type="button" class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit="" lay-filter="login">登 录</button><span id="span1" style="color: red">${msg}</span>
                    <!--
                    <input id="btn" type="button" class="layui-btn layui-btn layui-btn-normal layui-btn-fluid" lay-submit="" lay-filter="login" value="登录">
                    -->
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../lib/jq-module/jquery.particleground.min.js" charset="utf-8"></script>
<script type="text/javascript">
    function changeImge(obj) {
        //修改图片路径，操作src属性
        obj.src="/code?i="+Math.random(); // 为了告诉浏览器每次发送的是新的请求
    }
</script>
<script>
    layui.use(['form','layer'], function () {
        var form = layui.form,
            layer = layui.layer;

        // 登录过期的时候，跳出ifram框架
        if (top.location != self.location) top.location = self.location;

        // 粒子线条背景
        $(document).ready(function () {
            $('.layui-container').particleground({
                dotColor: '#7ec7fd',
                lineColor: '#7ec7fd'
            });
        });
        $("#username").focus(function () {
            $("#username")
            $("#span1").html("");
            return;
        })
        $("#password").focus(function () {
            $("#span1").html("");
            return;
        })
        $("#captcha").focus(function () {
            $("#span1").html("");
            return;
        })
        $("#captchaPic").focus(function () {
            $("#span1").html("");
            return;
        })
        var flag1 = false;
        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function () {
            var username = $("#username").val();
            var reg = /^[a-zA-Z0-9_-]{3,15}$/;//正则表达式
            if (username.length == 0 || username == null || username == '') {
                layer.msg('用户名不能为空', {icon: 5});
                return;
            } else {
                flag1 = reg.test(username);
                if (!flag1) {
                    layer.msg('用户名格式错误，3-5汉字', {icon: 5});
                }
            }
        });

        var flag2 = false;
        // 2. 验证密码，失去焦点时触发
        $("#password").blur(function () {
            var password = $("#password").val();
            var reg = /^[a-zA-Z0-9_-]{6,20}$/;//正则表达式
            if (password.length == 0 || password == null || password == '') {

                layer.msg('密码不能为空', {icon: 5});
                return;
            } else {
                flag2 = reg.test(password);
                if (!flag2) {
                    layer.msg('密码格式不对，密码是6-20个字符，由数字和字母构成', {icon: 5});
                }
            }
        });
        // var flag3 = false;
        // // 3.验证验证码，失去焦点时触发
        // $("#captcha").blur(function(){
        //     var captcha = $("#captcha").val();
        //     if(captcha.length == 0|| captcha==null || captcha == '') {
        //         layer.msg('验证码不能为空', {icon: 5});
        //         return;
        //     }
        //
        //     flag3 = true;


        //});
        //alert(flag1);
        //先去cookie的值，不能直接获取id的值
        //   if(Boolean($("#username").val())&&Boolean($("#password").val())) {
        //       $("#form1").submit();
        //   }
        $("#btn").click(function () {

            if (flag1 && flag2) {
                $("#form1").submit();
            }
        })
        // 进行登录操作
        // form.on('submit(login)', function (data) {
        //     data = data.field;
        //     if (data.username == '') {
        //         layer.msg('用户名不能为空');
        //         return false;
        //     }
        //     if (data.password == '') {
        //         layer.msg('密码不能为空');
        //         return false;
        //     }
        //     if (data.captcha == '') {
        //         layer.msg('验证码不能为空');
        //         return false;
        //     }
        //     layer.msg('登录成功', function () {
        //         window.location = '../index.html';
        //     });
        //     return false;
        // });


    })
</script>
</body>
</html>
