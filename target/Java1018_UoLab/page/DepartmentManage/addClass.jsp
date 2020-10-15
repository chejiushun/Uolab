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
    <title>添加班级</title>
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
            <legend><strong>请输入添加班级的信息：</strong></legend>
        </fieldset>
    </div>
    <div class="layui-form layuimini-form">

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>所在院系</strong></label>
            <div class="layui-input-block">
                <select name="dep_id" id="department" lay-filter="test">
                    <option>--请选择院系--</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label"><strong>所在专业</strong></label>
            <div class="layui-input-block">
                <select name="major_id" id="major_name" lay-filter="test2">
                    <option>--请选择专业--</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px;">
            <label class="layui-form-label "><strong>班级名称</strong></label>
            <div class="layui-input-block">
                <input type="text" id="class" name="class_name" lay-verify="required" lay-reqtext="班级不能为空" placeholder="请输入班级" value="" class="layui-input" required>
                <tip>必填，2-15个汉字</tip>
            </div>
        </div>

        <div class="layui-form-item layui-form-text" style="width: 600px">
            <label class="layui-form-label"><strong>人数</strong></label>
            <div class="layui-input-block">
                <input type="text" name="class_people" lay-verify="required"  placeholder="请输入人数" value="" class="layui-input" required>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">添加班级</button>
            </div>
        </div>
    </div>

</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate','layer'],function(){
        var form = layui.form;
        var layer = layui.layer;
        $ = layui.$;
        $(function () {
            // 查询所有院系
            $.get(
                "/DepartmentServlet?method=selectAll",
                function (data) {
                    // 判断响应数据是否为空
                    if(data != null){
                        // 遍历
                        $(data).each(function(){
                            /*alert(this.did);
                            alert(this.dname);*/
                            $("#department").append("<option value="+this.dep_id+">"+this.dep_name+"</option>");
                        })
                    }
                    // layui中动态添加option后必须使用form.render()渲染
                    form.render();
                },
                "json"
            );


            // layui中的使用form表单的监听下拉框取代原生的select的change事件
            form.on('select(test)', function(data){
                //console.log(data.elem); //得到select原始DOM对象
                console.log(data.value); //得到被选中的值
                //console.log(data.othis); //得到美化后的DOM对象
                var $dep_id = data.value;
                //alert($dname)
                $.get(
                    "/MajorServlet?method=selectByDep_id",
                    {"dep_id":$dep_id},
                    function (data) {
                        // 清空前一次选择的院系的专业选项
                        $("#major_name").html("<option>--请选择--</option>");
                        if(data != null){
                            // 遍历院系的专业
                            $(data).each(function () {
                                $("#major_name").append("<option value="+this.major_id+">"+this.major_name+"</option>");
                            })
                        }
                        form.render();
                    },
                    "json"
                );
            });
        })


        // 1. 验证班级名，失去焦点时触发
        $("#class").blur(function(){
            var clazz = $("#class").val();
            var reg = /^[\u4e00-\u9fa5]{2,15}$/;//正则表达式,2-15个汉字
            if(clazz.length == 0|| clazz==null || clazz == '') {
                layer.msg('班级名称不能为空', {icon: 5});
            }else{
                if(!reg.test(clazz)) {
                    layer.msg('格式不对，班级名称为2-15个汉字', {icon: 5});
                }
            }
        });




        //监听提交
        form.on('submit(demo1)', function (data) {
            /*layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })*/
            var data = JSON.stringify(data.field);
            $.post('/ClazzServlet?method=addClazz',{"data":data},function (data) {
                if(data == 1){
                    layer.msg("班级添加成功",{icon:1});
                }else{
                    layer.msg("班级添加失败",{icon: 2})
                }
            },"json");
            return false;
        });
    });



</script>
</body>
</html>
