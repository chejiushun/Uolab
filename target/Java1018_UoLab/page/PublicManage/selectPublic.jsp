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
    <title>查询公开课</title>
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
            <legend>查询公开课用户信息</legend>

            <div style="margin: 10px 10px 10px 10px">

                <form class="layui-form layui-form-pane" action="">

                    <div class="layui-form-item">

                        <div class="layui-inline">

                            <label class="layui-form-label"><strong>日期范围</strong></label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input" id="test6" placeholder="请选择日期范围" readonly>
                            </div>

                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加公开课 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 批量删除 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <!--自定义的列模板-->
        <script type="text/html" id="statusTableBar">
            <input type="checkbox" name="status" value="{{d.public_id}}" checked lay-skin="switch" lay-text="启用|禁用" lay-event="open" lay-filter="modifystatus" {{ d.status =='1'?'checked':''}}/>
        </script>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-danger layui-btn-xs data-count-edit" lay-event="detail">查看详情</a>
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
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
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        //日期范围
        laydate.render({
            elem: '#test6'
            ,range: true
        });

    });

    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '/PublicServlet?method=selectByCondition',
            toolbar: '#toolbarDemo',
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'public_date', width: 80, title: '日期', sort: true},
                {field: 'public_project', width: 80, title: '技术专题'},
                {field: 'public_speaker', width: 80, title: '主讲人', sort: true},
                {field: 'public_organizer', width: 80, title: '组织人'},
                {field: 'public_place', width: 80, title: '地点'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });
        table.on('row(currentTableFilter)', function(obj){
            var selectData = layui.table.checkStatus('currentTableId').data;
            console.log(selectData);
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
                ,url:'/PublicServlet?method=selectByCondition'
            });

            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加公开课',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'page/PublicManage/addPublic.jsp',
                    end:function () {
                        layer.close(index);
                        // 关闭增加页面时，刷新列表页面
                        location.reload();
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
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
                        ids += data[i].public_id+",";
                    }
                }
                //alert(ids);
                layer.confirm("确实要删除吗"+ids,{
                    btn:["确定","取消"],
                    btn1:function (index) {
                        $.ajax({
                            type:"POST",
                            url:"/PublicServlet?method=batchDelete",
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
                    content: '/PublicServlet?method=selectDetailByPublic_id&public_id='+data.public_id
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
                    content: '/PublicServlet?method=selectByPublic_id&public_id='+data.public_id
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('你真的确认删除该行么', function (index) {
                    $.get("/PublicServlet?method=deleteByPublic_id",{"public_id":data.public_id},function (data) {
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
