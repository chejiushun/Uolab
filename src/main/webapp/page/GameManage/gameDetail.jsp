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
<!--竞赛类别（选择）、年度、题目（2-30 个汉字字母组合）、组长（汉字 2-6 个）、组员（汉字
2-6 个）、获奖等级（特等、一等、二等、三等、优秀奖、无（默认值））、指导老师（汉字 2-6
个）-->

<div class="layui-t">
    <div class="layui-form-item">
        <label class="layui-form-label ">竞赛类别 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_kind}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">年度 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_year}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">题目 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_title}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">组长 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_groupleader}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">组员 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_groupmember}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">获奖等级 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_comgrade}</p>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label ">指导教师 :</label>
        <div class="layui-input-block">
            <p class="layui-p ">${match2.match_teacher}</p>
        </div>
    </div>
</div>
<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script src="../../js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>

    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#year'
            ,type: 'year',theme: '#393D49',trigger:'click'
        });
        laydate.render({
            elem: '#date1',theme: '#393D49',trigger:'click'
        });




        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '技术专题至少得5个字符啊';
                }
            }
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

    });
</script>

</body>
</html>