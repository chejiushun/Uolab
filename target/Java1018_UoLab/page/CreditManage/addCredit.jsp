<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/31
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加学分</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <link rel="stylesheet" href="../../lib/lay-module/step-lay/step.css" media="all">
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
            <legend><strong>请输入录入学分的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form layuimini-form">

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>姓名</strong></label>
        <div class="layui-input-block">
            <input type="text" id="username" name="credit_name" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" value="" class="layui-input" required>
            <tip>2-5个汉字</tip>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>学号</strong></label>
        <div class="layui-input-block">
            <input type="text" id="pwd" name="credit_sno" lay-verify="required" lay-reqtext="学号不能为空" placeholder="请输入学号" value="" class="layui-input" required>
            <tip>数字</tip>
        </div>
    </div>


    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>入学年份</strong></label>
        <div class="layui-input-block">
            <div class="layui-input-inline">
                <input id="year" type="text" name="credit_grade" placeholder="请选择入学年份" autocomplete="off" class="layui-input" value="" readonly>
            </div>
        </div>
    </div>


    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label required"><strong>事由</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="credit_reason">
                <option value="">请选择事由(公开课)</option>
                <option value="1">公开课1</option>
                <option value="2">公开课2</option>
                <option value="3">公开课3</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>分值</strong></label>
        <div class="layui-input-block">
            <input type="text" id="phone" name="credit_score" lay-verify="required" lay-reqtext="创新学分值不能为空" placeholder="请输入创新学分值" value="" class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>院系</strong></label>
        <div class="layui-input-block">
            <select name="credit_dep" id="department" lay-filter="test">
                <option>--请选择院系--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>专业</strong></label>
        <div class="layui-input-block">
            <select name="credit_major" id="major_name" lay-filter="test2">
                <option>--请选择专业--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label"><strong>取得时间</strong></label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="test3" name="credit_gettime" placeholder="yyyy-MM-dd" readonly>
        </div>
    </div>


    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label"><strong>备注</strong></label>
        <div class="layui-input-block">
            <textarea name="credit_remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
    </div>
</div>
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

    layui.use("laydate", function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: "#test1",
            // 当前日期 --添加下面这句
            value: new Date(),
            done: function (value, date, endDate) {
                // console.log(value); //得到日期生成的值，如：2017-08-18
                // console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。


            }
        });
        //年月选择器
        laydate.render({
            elem: '#test3'
            ,type:'datetime'
            ,range: false
            ,max:maxDate()
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



    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1',
            max:maxDate()
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
                        $("#department").append("<option value="+this.dep_name+">"+this.dep_name+"</option>");
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
            var $dep_name = data.value;
            //alert($dname)
            $.get(
                "/MajorServlet?method=selectByDep_name",
                {"dep_name":$dep_name},
                function (data) {
                    // 清空前一次选择的院系的专业选项
                    $("#major_name").html("<option>--请选择--</option>");
                    if(data != null){
                        // 遍历院系的专业
                        $(data).each(function () {
                            $("#major_name").append("<option value="+this.major_name+">"+this.major_name+"</option>");
                        })
                    }
                    form.render();
                },
                "json"
            );
        });

        // 根据专业查班级
        form.on('select(test2)',function (data) {
            //console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            //console.log(data.othis); //得到美化后的DOM对象
            var $major_name = data.value;
            $.get(
                "/ClazzServlet?method=selectByMajor_name",
                {"major_name":$major_name},
                function (data) {
                    // 清空前一次所选中的院系的专业
                    $("#class_name").html("<option>--请选择--</option>");
                    if (data != null) {
                        // 遍历班级
                        $(data).each(function () {
                            $("#class_name").append("<option value="+this.class_name+">"+this.class_name+"</option>");
                        })
                    }
                    form.render();
                },"json"
            );
        });


        //alert(flag1)
        // 监听提交
        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            // if(flag1&&flag2&&flag3&&flag4){
            //
            // }
            $.post("/CreditServlet?method=addCredit",{"data":result},function(data){
                // layer.close(index);
                // miniTab.deleteCurrentByIframe();
                if(data==1) {
                    layer.msg("学分添加成功",{icon:1})
                    //window.location="selectUser.jsp";
                }else{
                    layer.msg("学分添加失败",{icon:2})
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
