<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/30
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加实验室成员</title>
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
<div class="layui-form layuimini-form">

    <div class="layuimini-main">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend><strong>请输入添加成员的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>姓名</strong></label>
        <div class="layui-input-block">
            <input type="text" id="username" name="mem_name" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" value="" class="layui-input" required>
            <tip>2-5个汉字</tip>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>学号</strong></label>
        <div class="layui-input-block">
            <input type="text" id="pwd" name="mem_sno" lay-verify="required" lay-reqtext="学号不能为空" placeholder="请输入学号" value="" class="layui-input" required>
            <tip>数字</tip>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label required"><strong>性别</strong></label>
        <div class="layui-input-block">
            <input type="radio" name="mem_sex" value="男" title="男" checked="">
            <input type="radio" name="mem_sex" value="女" title="女">
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label required"><strong>手机号</strong></label>
        <div class="layui-input-block">
            <input type="text" id="phone" name="mem_tel" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value="" class="layui-input" required>
        </div>
    </div>

    <div class="layui-form-item" style="width: 500px">
        <label class="layui-form-label "><strong>年级</strong></label>
        <div class="layui-input-block">
            <div class="layui-input-inline">
                <input id="year" type="text" name="mem_grade" placeholder="请选择入学年份" autocomplete="off" class="layui-input" value="" readonly>
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>状态</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="mem_state">
                <option value="1" selected>正常</option>
                <option value="2">退出</option>
                <option value="3">毕业</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item required" id="area-picker">
        <div class="layui-form-item" style="margin-left: 40px">
        <label class="layui-form-label"><strong>籍贯</strong></label>

        <div class="layui-input-inline" style="width: 250px;">
            <select name="l_native" class="province-selector" data-value="广东省" lay-filter="province-1">
                <option value="">请选择省</option>
            </select>
        </div>
        </div>
        <div class="layui-form-item" style="margin-left: 150px">
        <div class="layui-input-inline" style="width: 250px;">
            <select name="l_native" class="city-selector" data-value="深圳市" lay-filter="city-1">
                <option value="">请选择市</option>
            </select>
        </div>
        </div>
        <div class="layui-form-item" style="margin-left: 150px">
        <div class="layui-input-inline" style="width: 250px;">
            <select name="mem_nation" class="county-selector" data-value="龙岗区" lay-filter="county-1">
                <option value="">请选择区</option>
            </select>
        </div>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label "><strong>院系</strong></label>
        <div class="layui-input-block">
            <select name="mem_dep" id="department" lay-filter="test">
                <option>--请选择院系--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>专业</strong></label>
        <div class="layui-input-block">
            <select name="mem_major" id="major_name" lay-filter="test2">
                <option>--请选择专业--</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label "><strong>班级</strong></label>
        <div class="layui-input-block">
            <select name="mem_class" id="class_name">
                <option>--请选择班级--</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label "><strong>加入日期</strong></label>
        <div class="layui-input-inline">
            <input type="text" name="mem_date" id="date1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" required>
        </div>

    </div>
    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label "><strong>校内职务</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="mem_duty">
                <option value="无">无</option>
                <option value="班干部" >班干部</option>
                <option value="学生会干部">学生会干部</option>
                <option value="社团干部">社团干部</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width: 400px">
        <label class="layui-form-label required"><strong>实验室职务</strong></label>
        <div class="layui-input-block" >
            <select lay-verify="required" name="mem_sysduty">
                <option value="无" selected>无</option>
                <option value="秘书长" >秘书长</option>
                <option value="副秘书长">副秘书长</option>
                <option value="技术总监">技术总监</option>
                <option value="项目经理">项目经理</option>
                <option value="组长">组长</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="mem_remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../../js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script type="text/javascript">

    layui.use(['layer', 'form', 'layarea'], function () {
        var layer = layui.layer
            , form = layui.form
            , layarea = layui.layarea;

        layarea.render({
            elem: '#area-picker',
            // data: {
            //     province: '广东省',
            //     city: '深圳市',
            //     county: '龙岗区',
            // },
            change: function (res) {
                //选择结果
                console.log(res);
            }
        });
    })

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


    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1',
            trigger:'click',
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

    layui.use(['form','layer','jquery'],function(){
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

        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function(){
            var username = $("#username").val();
            var reg=/^[\u4e00-\u9fa5]{2,5}$/;//正则表达式
            if(username.length == 0|| username==null || username == '') {
                $("#username").css('border','1px solid red');
                layer.msg('姓名不能为空', {icon: 5});
            }else{
                if(!reg.test(username)) {
                    layer.msg('格式不对，姓名2-5个汉字', {icon: 5});
                }else{
                    $("#username").css('border','1px solid green');
                }
            }
        });

        // 2. 验证密码，失去焦点时触发
        $("#pwd").blur(function(){
            var password = $("#pwd").val();
            var reg = /^\d{8,}$/;//正则表达式
            if(password.length == 0|| password==null || password == '') {
                $("#pwd").css('border','1px solid red');
                layer.msg('学号不能为空', {icon: 5});
            }else{
                if(!reg.test(password)) {
                    layer.msg('学号格式不对，学号是9位数，由数字构成', {icon: 5});
                }else{
                    $("#pwd").css('border','1px solid green');
                }
            }
        });


// 4. 验证手机号码，失去焦点时触发
        $("#phone").blur(function(){
            var telephone = $("#phone").val();
            var reg = /^1[3456789]\d{9}$/;//正则表达式
            if(telephone.length == 0|| telephone==null || telephone == '') {
                $("#phone").css('border','1px solid red');
                layer.msg('手机号码不能为空', {icon: 5});
            }else{
                if(!reg.test(telephone)) {
                    layer.msg('手机号码格式不对', {icon: 5});
                }else{
                    $("#phone").css('border','1px solid green');
                }
            }
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            $.post("/MemberServlet?method=addMember", {"data": result}, function (data) {
                if(data==1){
                    layer.msg("添加成员成功",{icon:1});
                    //window.location="selectLab.jsp"
                }else {
                    layer.msg("添加成员失败",{icon:2});
                }
            })

            return false;
        });

    });

    //监听指定开关
    form.on('switch(switchTest)', function(data){
        layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    //配置插件目录
</script>
</body>
</html>
