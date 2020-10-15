<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/30
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加院系</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--引入jQuery库文件-->
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
            <legend><strong>请输入添加院系的信息：</strong></legend>
        </fieldset>
    </div>
<div class="layui-form layuimini-form" >

    <div class="layui-form-item" style="width: 400px;">
        <label class="layui-form-label required"><strong>学院代号</strong></label>
        <div class="layui-input-block">
            <input id="d_id" type="text" name="dep_id" lay-verify="required" lay-reqtext="学院代号不能为空" placeholder="请输入学院代号" value="" class="layui-input">
            <tip>数字，1-2位，必填</tip>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>院系名称</strong></label>
        <div class="layui-input-block" id="div1">
            <input id="d_name" type="text" name="dep_name" lay-verify="required" lay-reqtext="院系名称不能为空" placeholder="请输入学院名称" value="" class="layui-input">
            <tip>必填，2-15个汉字</tip>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label"><strong>备注</strong></label>
        <div class="layui-input-block">
            <textarea name="dep_remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="btn" class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveBtn">确认保存</button>
            <button class="layui-btn layui-btn-danger" lay-event="reset" lay-filter="password" id="reset">重置</button>
        </div>
    </div>
</div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
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
        // 验证院系代号
        $("#d_id").blur(function () {
            var depid = $("#d_id").val();
            if (depid <1 || depid > 100) {
                $("#d_id").css('border', '1px solid red');
                layer.msg('学院代号不能为空', {icon: 5});
            } else {
                $("#d_id").css('border', '1px solid green');
            }
        });

        $("#reset").click(function () {
            $("#username").val("");
            $("#password").val("");
            $("#phone").val("");
            $("#realname").val("");
            $("#remark").val("");
            $("#qq").val("");
            $("#dojob").val("") ;
            $("#email").val("");
            $("#year").val("");
            $("#select1").val("");
            $("#select2").val("");
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            $.post("/DepartmentServlet?method=addDepartment",{"data":result},function(data){
                // layer.close(index);
                // miniTab.deleteCurrentByIframe();
                if(data==1) {
                    layer.msg("院系添加成功",{icon:1});
                    //window.location="selectClass.jsp";
                }else {
                    layer.msg("院系添加失败",{icon:2});
                    //window.location="addDepartment.jsp";
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
