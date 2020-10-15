<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/19
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加用户</title>
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
    <script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="../../lib/jquery-3.4.1/jquery-1.11.3.js"></script>
</head>
<body>

<div class="layuimini-container">

    <div class="layuimini-main">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend><strong>请输入添加用户的信息：</strong></legend>
        </fieldset>
    </div>

    <div class="layui-form layuimini-form">

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label required"><strong>用户名</strong></label>
            <div class="layui-input-block">
                <input type="text" id="username" name="user_name" lay-verify="required" lay-reqtext="用户名不能为空" placeholder="请输入用户名" value="" class="layui-input" ><span id="s1"></span>
                <tip>字母数字组合，开头是字母，3-15个字符</tip>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label required"><strong>用户密码</strong></label>
            <div class="layui-input-block">
                <input type="password" id="password" name="user_pwd" lay-verify="required" lay-reqtext="密码不能为空" placeholder="请输入密码" value="123456" class="layui-input">
                <tip>密码是6-20个字符，由数字和字母构成</tip>
            </div>
        </div>

        <div class="layui-form-item" style="width: 250px">
            <label class="layui-form-label"><strong>用户状态</strong></label>
            <div class="layui-input-block">
                <select name="user_state">
                    <option value="1" selected>启用</option>
                    <option value="0">禁用</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label required"><strong>用户角色</strong></label>
            <div class="layui-input-block" id="div1">
                <select lay-verify="required" name="role_id" id="select1">
                    <option value="0" ></option>
                    <option value="1" >超级管理员</option>
                    <option value="2" >管理员</option>
                    <option value="3" selected>普通用户</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>用户院系</strong></label>
            <div class="layui-input-block">
                <select name="user_dep" id="department" lay-filter="test">
                    <option>--请选择院系--</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label"><strong>用户专业</strong></label>
            <div class="layui-input-block">
                <select name="user_major" id="major_name" lay-filter="test2">
                    <option>--请选择专业--</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>用户班级</strong></label>
            <div class="layui-input-block">
                <select name="user_class" id="class_name">
                    <option>--请选择班级--</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>入学年份</strong></label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <input id="year" type="text" name="user_grade" placeholder="请选择入学年份" autocomplete="off" class="layui-input" value="" readonly>
                </div>
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label required"><strong>真实姓名</strong></label>
            <div class="layui-input-block">
                <input type="text" id="realname" name="user_realname" lay-verify="required" lay-reqtext="真实姓名不能为空" placeholder="请输入真实姓名" value="" class="layui-input" >
                <tip>2-5个汉字</tip>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required"><strong>用户性别</strong></label>
            <div class="layui-input-block">
                <input type="radio" name="user_sex" value="男" title="男" checked="">
                <input type="radio" name="user_sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>校内职务</strong></label>
            <div class="layui-input-block">
                <input type="text" name="user_duty" placeholder="请输入校内职务" value="" class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label required"><strong>手机号</strong></label>
            <div class="layui-input-block">
                <input type="text" id="phone" name="user_tel" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value="" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" style="width: 400px">
            <label class="layui-form-label "><strong>QQ</strong></label>
            <div class="layui-input-block">
                <input type="text" id="u_qq" name="user_qq" lay-verify="required" lay-reqtext="qq不能为空" placeholder="请输入qq" value="" class="layui-input" required>
            </div>
        </div>

        <div class="layui-form-item layui-form-text" style="width: 600px">
            <label class="layui-form-label"><strong>备注</strong></label>
            <div class="layui-input-block">
                <textarea name="user_remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="btn" class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveBtn">确认保存</button>
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
        
        var flag1 = false;
        // 1. 验证用户名，失去焦点时触发
        $("#username").blur(function () {
            var username = $("#username").val();
            var reg = /^[a-zA-Z0-9_-]{3,15}$/;//正则表达式
            if (username.length == 0 || username == null || username == '') {
                $("#username").css('border', '1px solid red');
                layer.msg('用户名不能为空', {icon: 5});
                return;
            } else {
                flag1 = reg.test(username);
                if (!reg.test(username)) {
                    $("#username").css('border', '1px solid red');
                    layer.msg('格式不对，用户名要3-15个字符', {icon: 5});
                    return;
                } else {
                    $("#username").css('border', '1px solid green');
                }
            }
        });

        var flag2 = false;
        // 2. 验证密码，失去焦点时触发
        $("#password").blur(function () {
            var password = $("#password").val();
            var reg = /^[a-zA-Z0-9_-]{6,20}$/;//正则表达式
            if (password.length == 0 || password == null || password == '') {
                $("#password").css('border', '1px solid red');
                layer.msg('密码不能为空', {icon: 5});
                return;
            } else {
                flag2 = reg.test(password);
                if (!reg.test(password)) {
                    $("#password").css('border', '1px solid red');
                    layer.msg('密码格式不对，密码是6-20个字符，由数字和字母构成', {icon: 5});
                    return;
                } else {
                    $("#password").css('border', '1px solid green');
                }
            }
        });

        var flag3 = false;
        //  3. 验证姓名，失去焦点时触发
        $("#realname").blur(function () {
            var realname = $("#realname").val();
            var reg = /^[\u4e00-\u9fa5]{2,5}$/;//正则表达式,2-5个汉字
            if (realname.length == 0 || realname == null || realname == '') {
                $("#realname").css('border', '1px solid red');
                layer.msg('真实姓名不能为空', {icon: 5});
                return;
            } else {
                flag3 = reg.test(realname);
                if (!reg.test(realname)) {
                    $("#realname").css('border', '1px solid red');
                    layer.msg('格式不对，真实姓名为2-5个汉字', {icon: 5});
                    return;
                } else {
                    $("#realname").css('border', '1px solid green');
                }
            }
        });

        var flag4 = false;
        // 4. 验证手机号码，失去焦点时触发
        $("#phone").blur(function () {
            var telephone = $("#phone").val();
            var reg = /^1[3456789]\d{9}$/;//正则表达式
            if (telephone.length == 0 || telephone == null || telephone == '') {
                $("#phone").css('border', '1px solid red');
                layer.msg('手机号码不能为空', {icon: 5});
                return;
            } else {
                flag4 = reg.test(telephone);
                if (!reg.test(telephone)) {
                    $("#phone").css('border', '1px solid red');
                    layer.msg('手机号码格式不对', {icon: 5});
                    return;
                } else {
                    $("#phone").css('border', '1px solid green');
                }
            }
        });

        //alert(flag1)
        // 监听提交
        form.on('submit(saveBtn)', function (data) {
            var result = JSON.stringify(data.field);
            //alert(result)
            // if(flag1&&flag2&&flag3&&flag4){
            //
            // }
            $.post("/UserServlet?method=addUser",{"data":result},function(data){
                // layer.close(index);
                // miniTab.deleteCurrentByIframe();
                if(data==1) {
                    layer.msg("用户添加成功",{icon:1})
                    //window.location="selectUser.jsp";
                }else{
                    layer.msg("用户添加失败",{icon:2})
                }
            })
            return false;
        });
    });
</script>
</body>
</html>
