<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/30
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加公开课</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
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
            <legend><strong>请输入添加公开课的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form layuimini-form">

        <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>技术专题</strong></label>
        <div class="layui-input-block">
            <input type="text" id="username" name="public_project" lay-verify="required" lay-reqtext="技术专题不能为空" placeholder="请输入技术专题" value="" class="layui-input" required>
            <tip>字母和汉字组合，1-50 个字符</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>主讲人</strong></label>
        <div class="layui-input-block">
            <input type="text" id="pwd" name="public_speaker" lay-verify="required" lay-reqtext="主讲人不能为空" placeholder="请输入主讲人" value="" class="layui-input" required>
            <tip>汉字，2-4 个字</tip>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label"><strong>日期</strong></label>
        <div class="layui-input-inline">
            <input type="text" name="public_date" id="date1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" required readonly>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>组织人</strong></label>
        <div class="layui-input-block">
            <input type="text" id="organizer" name="public_organizer" lay-verify="required" lay-reqtext="组织人不能为空" placeholder="请输入组织人" value="" class="layui-input" required>
            <tip>只能输入一个组织人</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>地点</strong></label>
        <div class="layui-input-block">
            <input type="text" id="place" name="public_place" lay-verify="required"  placeholder="请输入地点" value="" class="layui-input" required>
        </div>
    </div>


    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>创新学分值</strong></label>
        <div class="layui-input-block">
            <input type="text" id="phone" name="public_credit" lay-verify="required" lay-reqtext="创新学分值不能为空" placeholder="请输入创新学分值" value="" class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>参加人数</strong></label>
        <div class="layui-input-block">
            <input type="number" id="people" name="public_people" placeholder="请输入参加人数" value="" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>方式</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="public_classway">
                <option value="1" selected>线下</option>
                <option value="2">直播</option>
                <option value="3">录播</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label required" ><strong>群体说明</strong></label>
        <div class="layui-input-block required">
            <textarea lay-verify="required" name="public_group" class="layui-textarea" placeholder="请输入群体说明"></textarea>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label"><strong>备注</strong></label>
        <div class="layui-input-block">
            <textarea name="public_remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveBtn">确认保存</button>
            <button type="button" id="btn" class="layui-btn">添加</button>
            <button type="button" id="btn1" class="layui-btn">删除</button>
        </div>
    </div>
    </div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript">

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1',
            min:maxDate()
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
    })

    layui.use(['form','layer'],function(){
        var form = layui.form;
        var layer = layui.layer;
        $ = layui.$;

        $("#btn").click(function () {
            let $input = $("<input type='text' name='organizer' lay-verify='required'  placeholder='请输入组织人' value='' class='layui-input' >");
            $("#organizer").after($input);
        })
        $("#btn1").click(function () {
            $("#organizer").siblings("input:last").remove();
            //$("#organizer").siblings().last().remove();
        })
        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function(){
            var username = $("#username").val();
            var reg=/^[\u4e00-\u9fa5]{1,50}$/;//正则表达式
            if(username.length == 0|| username==null || username == '') {
                $("#username").css('border','1px solid red');
                layer.msg('技术专题不能为空', {icon: 5});
            }else{
                if(!reg.test(username)) {
                    layer.msg('格式不对，技术专题1-50个汉字', {icon: 5});
                }else{
                    $("#username").css('border','1px solid green');
                }
            }
        });

        $("#phone").blur(function(){
            var username = $("#phone").val();
            if(username.length == 0) {
                $("#phone").css('border','1px solid red');
                layer.msg('学分不能为空', {icon: 5});
            }else{
                if(username<=0 || username>5) {
                    $("#phone").css('border','1px solid red');
                    layer.msg('格式不对，学分应在0-5之间', {icon: 5});
                }else{
                    $("#phone").css('border','1px solid green');
                }
            }
        });

        // 2. 验证密码，失去焦点时触发
        $("#pwd").blur(function(){
            var password = $("#pwd").val();
            var reg = /^[\u4e00-\u9fa5]{2,4}$/;//正则表达式
            if(password.length == 0|| password==null || password == '') {
                $("#pwd").css('border','1px solid red');
                layer.msg('主讲人不能为空', {icon: 5});
            }else{
                if(!reg.test(password)) {
                    layer.msg('学号格式不对，汉字2-4个', {icon: 5});
                }else{
                    $("#pwd").css('border','1px solid green');
                }
            }
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            $.post("/PublicServlet?method=addPublic", {"data": result}, function (data) {
                if(data==1){
                    layer.msg("恭喜你，添加成功",{icon:1});
                    //window.location="selectPuClass.jsp"
                }else {
                    layer.msg("很抱歉，添加失败",{icon:2});
                    // window.location="addPublic.jsp";
                }
            })
            return false;
        });
    });



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


    //监听指定开关
    form.on('switch(switchTest)', function(data){
        layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });
</script>
</body>
</html>
