<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2020/8/31
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查询用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="table-search-fieldset">
            <legend>查询学生用户信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">

                    <div class="layui-form-item">

                        <div class="layui-inline">

                            <label class="layui-form-label"><strong>姓名</strong></label>
                            <div class="layui-input-inline">
                                <input type="text" name="user_name" autocomplete="off" class="layui-input" placeholder="请输入姓名">
                            </div>

                            <label class="layui-form-label"><strong>院系</strong></label>
                            <div class="layui-input-inline">
                                <select name="user_dep" id="department" lay-filter="test">
                                    <option value="">--请选择院系--</option>
                                </select>
                            </div>

                            <label class="layui-form-label"><strong>专业</strong></label>
                            <div class="layui-input-inline">
                                    <select name="user_major" id="major_name" lay-filter="test2">
                                        <option value="">--请选择专业--</option>
                                    </select>
                            </div>

                        </div>
                        <div class="layui-inline">

                            <label class="layui-form-label"><strong>入学年份</strong></label>
                            <div class="layui-input-inline">
                                <input id="year" type="text" name="user_grade" placeholder="请选择入学年份" autocomplete="off" class="layui-input" value="" readonly>
                            </div>

                            <label class="layui-form-label"><strong>班级</strong></label>
                            <div class="layui-input-inline">
                                <select name="user_class" id="class_name">
                                    <option value="">--请选择班级--</option>
                                </select>
                            </div>

                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加用户 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 批量删除 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <!--自定义的列模板-->
        <script type="text/html" id="statusTableBar">
            <input type="checkbox" name="status" value="{{d.user_id}}" checked lay-skin="switch" lay-text="启用|禁用" lay-event="open" lay-filter="modifystatus" {{ d.status =='1'?'checked':''}}/>
        </script>
        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit" lay-event="detail">查看详情</a>
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>
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
                    $("#major_name").html("<option value=''>--请选择--</option>");
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
                    $("#class_name").html("<option value=''>--请选择--</option>");
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
        
    });

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/UserServlet?method=selectByCondition',
            toolbar: '#toolbarDemo',
            cols: [[
                {type: "checkbox", width: 50 },
                {field: 'user_id', width: 80, title: 'ID', sort: true},
                {field: 'user_name', width: 120, title: '用户名'},
                {field: 'user_dep', width: 180, title: '院系'},
                {field: 'user_major', width: 180, title: '专业'},
                {field: 'user_class', width: 100, title: '班级', sort: true},
                {field: 'user_grade', width: 80, title: '年级', sort: true},
                {field: 'user_state', width: 100, title: '用户状态', templet : '#statusTableBar',
                    unresize : true,
                    align: "center" ,sort: true},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [5,10, 15, 20, 25, 50, 100],
            limit: 5,
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            /* layer.alert(result, {
                 title: '最终的搜索信息'
             });*/

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1,
                    limit:5
                }
                , where: {
                    data: result
                }
                ,url:'/UserServlet?method=selectByCondition'
            });

            return false;
        });

        form.on('switch(modifystatus)', function(data) {
            console.log(data);
            var switchData = data;
            var user_id = data.value;// 获取要修改的ID
            //alert(user_id)
            var user_state = this.checked ? '1' : '0';// 当前状态值
            layer.confirm("你确定要修改用户状态吗？", {
                btn: ['确定', '取消'],
                btn1: function (index) {
                    $.ajax({
                        url: '/UserServlet?method=editState',
                        data: {
                            "user_id": user_id,
                            "user_state": user_state
                        },
                        // 修改成功，请填写对应的参数
                        success: function (data) {
                            if (data) {
                                layer.msg('操作成功！', {icon: 1});
                            } else {
                                layer.msg('操作失败', {icon: 2});
                                /*   var em = $(switchData.othis[0]);
                                   switchData.othis[0].classList.remove('layui-form-onswitch');
                                   em.children('em').text('禁用');*/
                            }
                        },
                        error: function (data) {
                            console.log(data);
                            layer.msg('数据异常，操作失败！');
                        },

                    });
                },
                btn2: function (index) {
                    location.reload();
                }
            });
        });
        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'page/UserManage/addUser.jsp',
                    end:function () {
                        layer.close(index);
                        // 关闭增加页面时，刷新列表页面
                        location.reload();
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听批量删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                //layer.alert(JSON.stringify(data));
                if(data==""){
                    layer.msg("至少选择一个删除",{icon: 2});
                    return;
                }
                var ids = "";
                if(data.length > 0){
                    for(var i=0;i<data.length;i++){
                        // 获取所有要删除的id并进行拼接
                        ids += data[i].user_id+",";
                    }
                }
                //alert(ids);
                layer.confirm("确实要删除吗"+ids,{
                    btn:["确定","取消"],
                    btn1:function (index) {
                        $.ajax({
                            type:"POST",
                            url:"/UserServlet?method=batchDelete",
                            data:{"ids":ids},
                            success:function (data) {
                                if(data == 1){
                                    layer.msg("删除成功",{icon:1});
                                    // 重新加载
                                    table.reload('currentTableId', {
                                        page: {
                                            curr: 1
                                        }
                                    });
                                }

                            },
                            error:function (data) {
                                layer.msg("删除失败",{icon:2});
                            }
                        });

                    },

                    btn2:function (index) {
                        // alert(data)
                        $("input[type='checkbox']").each(function(){
                            $(this).prop('checked', false);
                        });
                        layui.form.render();
                    }
                });
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            //alert(data);
            if(obj.event === 'detail'){
                //layer.alert("查看详情");
                var index = layer.open({
                    title: '查看详情',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/UserServlet?method=selectDetailByUser_id&user_id='+data.user_id
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'edit') {
                var index = layer.open({
                    title: '修改用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/UserServlet?method=selectByUser_id&user_id='+data.user_id
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('你真的确认删除该行么', function (index) {
                    $.get("/UserServlet?method=deleteByUser_id",{"user_id":data.user_id},function (data) {
                        if(data == 1){
                            layer.msg("删除成功");
                        }else{
                            layer.msg("删除失败");
                        }
                    })
                    // 重新加载
                    table.reload('currentTableId', {
                        page: {
                            curr: 1
                        }

                    });
                    layer.close(index);
                });
            }
        });
    });
</script>
</body>
</html>
