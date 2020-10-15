<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/31
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查看详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
        .layui-p{
            padding:9px 10px;
            width:200px;
            font-weight:400;
            line-height:20px;
            text-align:center;
        }
    </style>
</head>
<body>

<div class="layui-form layuimini-form">

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>用户名:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_name}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>密码:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p ">${user2.user_pwd}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>真实姓名:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_realname}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>院系:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_dep}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>专业:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_major}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>班级:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_class}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>年级:</strong></label>
        <div class="layui-input-block">
            <div class="layui-input-inline">
                <p class="layui-p ">${user2.user_grade}</p>
            </div>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>校内职务:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_duty}</p>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label"><strong>性别:</strong></label>
        <div class="layui-input-block" >
            <p class="layui-p">${user2.user_sex}</p>
        </div>
    </div>

    <div class="layui-form-item" style="width: 400px">
        <label class="layui-form-label"><strong>手机:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_tel}</p>
        </div>
    </div>

         <div class="layui-form-item">
             <label class="layui-form-label"><strong>角色:</strong></label>
            <div class="layui-input-block">
                <c:if test="${user2.role_id==1}">
                    <p class="layui-p">超级管理员</p>
                </c:if>
                <c:if test="${user2.role_id==2}">
                    <p class="layui-p">管理员</p>
                </c:if>
                <c:if test="${user2.role_id==3}">
                    <p class="layui-p">普通成员</p>
                </c:if>
            </div>
        </div>

    <div class="layui-form-item" >
        <label class="layui-form-label"><strong>用户状态:</strong></label>
        <div class="layui-input-block" >
            <c:if test="${user2.user_state==1}">
                <p class="layui-p">启用</p>
            </c:if>
            <c:if test="${user2.user_state==0}">
                <p class="layui-p">禁用</p>
            </c:if>
        </div>
    </div>

    <div class="layui-form-item layui-form-text" style="width: 600px">
        <label class="layui-form-label"><strong>备注:</strong></label>
        <div class="layui-input-block">
            <p class="layui-p">${user2.user_remarks}</p>
        </div>
    </div>

</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {
                // 关闭弹出层
                layer.close(index);
                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);
            });
            return false;
        });

        //监听重置密码
        form.on('reset(password)', function (data) {
            alert("hello");
            alert(data);
            var index = layer.alert(JSON.stringify(data), {
                title: '最终的提交信息'
            }, function () {
                // 关闭弹出层
                layer.close(index);
                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });
            return false;
        });
    });




    // 年选择器 （入学年份）
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        var initYear;
        laydate.render({
            elem: '#year',
            type: 'year',
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
