<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/27
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <link rel="stylesheet" href="../../js/lay-module/step-lay/step.css" media="all">
    <style>
        body {
            background-color: white;
        }

    </style>
</head>
<body>

<div class="layuimini-container">

    <div class="layuimini-main">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend><strong>请输入录入的参赛信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form layuimini-form">

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>年度</strong></label>
            <div class="layui-input-inline">
                <input id="year" type="text" name="match_year" placeholder="请选择入学年份" autocomplete="off" class="layui-input" value="" readonly>
            </div>
        </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>题目</strong></label>
        <div class="layui-input-block">
            <input type="text" id="username" name="match_title" lay-verify="required" lay-reqtext="题目不能为空" placeholder="请输入题目" value="" class="layui-input" required>
            <tip>2-30个汉字字母组合</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>组长</strong></label>
        <div class="layui-input-block">
            <input type="text" id="pwd" name="match_groupleader" lay-verify="required" lay-reqtext="组长不能为空" placeholder="请输入组长" value="" class="layui-input" required>
            <tip>2-6汉字</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>组员</strong></label>
        <div class="layui-input-block">
            <input type="text" id="organizer" name="match_groupmember" lay-verify="required" lay-reqtext="组员不能为空" placeholder="请输入组员" value="" class="layui-input" required>
            <tip>只能输入一个组员,2-6汉字</tip>
        </div>
    </div>


    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>指导老师</strong></label>
        <div class="layui-input-block">
            <input type="text" id="teacher" name="match_teacher" lay-verify="required" lay-reqtext="指导老师不能为空" placeholder="请输入指导老师" value="" class="layui-input" required>
            <tip>2-6汉字</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>竞赛类别</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="match_kind">
                <option value="全国赛" selected >全国赛</option>
                <option value="省赛" >省赛</option>
                <option value="校赛" >校赛</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>获奖等级</strong></label>
        <div class="layui-input-block">
            <select lay-verify="required" name="match_comgrade">
                <option value="无" selected>无</option>
                <option value="特等">特等</option>
                <option value="一等">一等</option>
                <option value="二等">二等</option>
                <option value="三等">三等</option>
                <option value="优秀奖">优秀奖</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="btn" class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
    </div>
</div>
</form>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript">

    // 年选择器 （入学年份）
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var initYear;
        laydate.render({
            elem: '#year'
            ,type:'year'
            ,min: minDate()
            ,max: maxDate()
        });
        // 设置最大可选的日期
        function maxDate(){
            var now = new Date();
            return now.getFullYear()+"-" + (now.getMonth()+1) + "-" + now.getDate();
        }
        // 设置最小可选的日期
        function minDate(){
            var now = new Date();
            return (now.getFullYear()-3)+"-" + now.getMonth() + "-" + now.getDate();
        }
    });

    layui.use(['form','layer'],function(){
        var form = layui.form;
        var layer = layui.layer;
        $ = layui.$;

        $("#btn").click(function () {
            let $input = $("<input type='text' name='match_groupmember' lay-verify='required'  placeholder='请输入组员' value='' class='layui-input' >");
            $("#n_number").after($input);
        })
        $("#btn1").click(function () {
            $("#organizer").siblings("input:last").remove();
            //$("#organizer").siblings().last().remove();
        })
        var flag1 = false;
        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function(){
            var username = $("#username").val();
            var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]{2,30}$/;//正则表达式
            if(username.length == 0|| username==null || username == '') {
                $("#username").css('border','1px solid red');
                layer.msg('题目不能为空', {icon: 5});
            }else{
                flag1 = reg.test(username);
                if(!reg.test(username)) {
                    layer.msg('格式不对，2-30个汉字字母组合', {icon: 5});
                }else{
                    $("#username").css('border','1px solid green');
                }
            }
        });
        var flag2 =false;
        // 2. 验证密码，失去焦点时触发
        $("#pwd").blur(function(){
            var password = $("#pwd").val();
            var reg = /^[\u4e00-\u9fa5]{2,6}$/;//正则表达式
            if(password.length == 0|| password==null || password == '') {
                $("#pwd").css('border','1px solid red');
                layer.msg('组长不能为空', {icon: 5});
            }else{
                flag2=reg.test(password);
                if(!reg.test(password)) {
                    layer.msg('格式不对，2-6汉字', {icon: 5});
                }else{
                    $("#pwd").css('border','1px solid green');
                }
            }
        });
        var flag3 = false;
        $("[ name = 'match_groupmember']").blur(function(){
            var password = $("[name= 'match_groupmember']").val();
            var reg = /^[\u4e00-\u9fa5]{2,6}$/;//正则表达式
            if(password.length == 0|| password==null || password == '') {
                $("[ name = 'match_groupmember']").css('border','1px solid red');
                layer.msg('组员不能为空', {icon: 5});
            }else{
                flag3=reg.test(password);
                if(!reg.test(password)) {
                    layer.msg('格式不对，2-6汉字', {icon: 5});
                }else{
                    $("[ name = 'match_groupmember']").css('border','1px solid green');
                }
            }

        });

        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            // if(flag1&&flag2&&flag3&&flag4){
            //
            // }
            $.post("/MatchServlet?method=addMatch",{"data":result},function(data){
                // layer.close(index);
                // miniTab.deleteCurrentByIframe();
                if(data==1) {
                    layer.msg("参赛信息录入成功",{icon:1})
                    //window.location="selectUser.jsp";
                }else{
                    layer.msg("参赛信息录入失败",{icon:2})
                }
            })
            return false;
        });
    });

</script>
</body>
</html>
