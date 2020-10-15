<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/30
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加专业</title>
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
            <legend><strong>请输入添加专业的信息：</strong></legend>
        </fieldset>
    </div>
<div class="layui-form layuimini-form">

    <div class="layui-form-item" style="width: 400px;">
        <label class="layui-form-label "><strong>所在院系</strong></label>
        <div class="layui-input-block">
                <select name="dep_id" id="department" lay-filter="test">
                    <option>--请选择要添加专业的院系--</option>
                </select>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px;">
        <label class="layui-form-label "><strong>专业名称</strong></label>
        <div class="layui-input-block">
            <input type="text" id="major" name="major_name" lay-verify="required" lay-reqtext="专业不能为空" placeholder="请输入专业" value="" class="layui-input" required>
            <tip>必填，2-15个汉字</tip>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label"><strong>备注</strong></label>
        <div class="layui-input-block">
            <textarea name="major_remarks" id="remark" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">添加专业</button>
        </div>
    </div>
</div>

</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        $ = layui.$;
        $(function () {
            // 页面加载成功，查询所有的院系
            $.get(
                "/DepartmentServlet?method=selectAll",
                function (data) {
                    // 判断响应数据是否为空
                    if(data != null){
                        // 遍历
                        $(data).each(function(){
                            $("#department").append("<option value="+this.dep_id+">"+this.dep_name+"</option>");
                        })
                    }
                    // layui中动态添加option后必须使用form.render()渲染
                    form.render();
                },
                "json"
            );

        })

        // 1. 验证专业名，失去焦点时触发
        $("#major").blur(function(){
            var major = $("#major").val();
            var reg = /^[\u4e00-\u9fa5]{2,15}$/;//正则表达式,2-15个汉字
            if(major.length == 0|| major==null || major == '') {
                layer.msg('专业名称不能为空', {icon: 5});
            }else{
                if(!reg.test(major)) {
                    layer.msg('格式不对，专业名称为2-15个汉字', {icon: 5});
                }
            }
        });


        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });



        //监听提交
        form.on('submit(demo1)', function (data) {
            /*layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })*/
            var data = JSON.stringify(data.field);
            alert(111);
            $.get('/MajorServlet?method=addMajor',{"data":data},function (data) {
                alert(222);
                if(data == 1){
                    layer.msg("专业添加成功",{icon:1});
                }else{
                    layer.msg("专业添加失败",{icon: 2})
                }
            },"json");
            return false;
        });
    });
</script>
</body>
</html>
