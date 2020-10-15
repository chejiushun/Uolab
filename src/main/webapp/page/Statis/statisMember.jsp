<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/9
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>成员统计</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../../css/public.css" media="all">

    <script src="../../js/lay-module/echarts/echarts.js" charset="utf-8"></script>
    <script src="../../js/lay-module/echarts/echartsTheme.js" charset="utf-8"></script>
    <script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
        // 定义全局变量
        var $;
        layui.use(['form', 'layer', 'laydate'], function() {
            $ = layui.jquery;
            var form = layui.form,
                layer = layui.layer,
                laydate = layui.laydate;
            //日期1
            laydate.render({
                elem: '#grade',
                type: 'year'
            });
            //日期2
            laydate.render({
                elem: '#daterange',
                type: 'month',
                range: '~'
            });




            /**
             * 图表统计
             */
            var echarts_pienum = echarts.init(document.getElementById('pienum'), 'walden');
            var echarts_piewin = echarts.init(document.getElementById('piewin'), 'walden');
            var echarts_histogram = echarts.init(document.getElementById('histogrammajor'), 'walden');

            // 接收Servlet提供的数据
            let grads = ['大一','大二','大三','大四','毕业'];
            let gradDatas = [
                {value:335, name:'大一'},
                {value:560, name:'大二'},
                {value:800, name:'大三'},
                {value:300, name:'大四'},
                {value:150, name:'毕业'}
            ];
            // 成员人数统计饼图
            function showPienum(grads,gradDatas) {
                var pienum = {
                    title : {
                        text: '根据各年级统计成员人数饼图',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        /*  data: ['大一','大二','大三','大四','毕业']*/
                        data:grads
                    },
                    series : [
                        {
                            name: '成员来源',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            /* data:[
                                 {value:335, name:'大一'},
                                 {value:560, name:'大二'},
                                 {value:800, name:'大三'},
                                 {value:300, name:'大四'},
                                 {value:150, name:'毕业'}
                             ],*/
                            data:gradDatas ,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                echarts_pienum.setOption(pienum);
            }
            // 调用方法，显示图1
            showPienum(grads, gradDatas);

            // 接收Servlet回来的数据
            var college = ${college};
            //alert(college);
            var collegeDatas = ${collegeDatas};
            //alert(collegeDatas);
            // 各院系成员统计饼图
            function showPiewin(college,collegeDatas) {
                var piewin = {
                    title : {
                        text: '根据各院系统计成员饼图',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        /*  data: ['计算机科学与技术学院','软件学院','电子信息工程学院','机械工程学院','材料科学与工程学院']*/
                        data: college
                    },
                    series : [
                        {
                            name: '成员来源',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            /* data:[
                                 {value:5, name:'计算机科学与技术学院'},
                                 {value:4, name:'软件学院'},
                                 {value:3, name:'电子信息工程学院'},
                                 {value:3, name:'机械工程学院'},
                                 {value:1, name:'材料科学与工程学院'}
                             ],*/
                            data:collegeDatas,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                echarts_piewin.setOption(piewin);
            }
            // 显示图2
            showPiewin(college,collegeDatas);

            // 这是原始静态数据，用来测试
            let dataList = [
                ['product', '2018', '2019'],
                ['软件工程', 43.3,  93.7],
                ['计算机科学与技术', 83.1,  55.1],
                ['网络工程', 86.4, 82.5],
                ['数字媒体技术', 72.4, 39.1],
                ['物联网工程', 72.4, 39.1]
            ];
            let bars = [
                {type: 'bar'},
                {type: 'bar'}
            ]
            function showMajorGrade(dataList, bars) {
                var histogram = {
                    legend: {},
                    tooltip: {},
                    toolbox : {
                        show : true,
                        feature : {
                            mark : {
                                show : true
                            },
                            dataView : {
                                show : true,
                                readOnly : false
                            },
                            magicType : {
                                show : true,
                                type : [ 'line', 'bar' ]
                            },
                            restore : {
                                show : true
                            },
                            saveAsImage : {
                                show : true
                            }
                        }
                    },
                    dataset: {
                        source: dataList
                    },
                    xAxis: {type: 'category'},
                    yAxis: {},
                    // Declare several bar series, each will be mapped
                    // to a column of dataset.source by default.
                    series: bars
                };
                echarts_histogram.setOption(histogram);
            }
            // 统计专业和年级
            showMajorGrade(dataList, bars);

            // echarts 窗口缩放自适应
            window.onresize = function() {
                echarts_pienum.resize();
                echarts_piewin.resize();
                echarts_histogram.resize();
            }
        });

        // 监听搜索_1操作
        form.on('submit(data-search-btn1)', function(data) {
            var result = JSON.stringify(data.field);
            layer.alert(result, {
                title: '最终的搜索信息'
            });

            //执行搜索重载
            table.reload('userloginlogTable', {
                page: {
                    curr: 1
                },
                where: {
                    searchParams: result
                }
            }, 'data');
            return false;
        });
        // 监听搜索_2操作
        form.on('submit(data-search-btn2)', function(data) {
            var result = JSON.stringify(data.field);
            layer.alert(result, {
                title: '最终的搜索信息'
            });


            //执行搜索重载
          /*  table.reload('userloginlogTable', {
                page: {
                    curr: 1
                },
                where: {
                    searchParams: result
                }
            }, 'data');*/
            return false;
        });


    </script>
</head>

<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="layui-elem-field layui-field-title">
            <legend>成员统计</legend>
        </fieldset>

        <div class="layui-form" style="margin: 10px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">选择学院</label>
                        <div class="layui-input-inline">
                            <label>
                                <select name="deptname">
                                    <option value="" selected="selected">--请选择--</option>
                                    <option value="1" >计算机科学与技术学院</option>
                                    <option value="2">电子信息工程学院</option>
                                    <option value="3">机械电子工程学院</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">年级</label>
                        <div class="layui-input-inline" >
                            <input type="text" name="grade" id="grade" autocomplete="off" placeholder="请选择年级" class="layui-input" readonly="readonly">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">选择专业</label>
                        <div class="layui-input-inline" >
                            <label for="major"></label><select name="major" id="major" >
                            <option value="" selected="selected">--请选择--</option>
                            <option value="162056">软件工程</option>
                            <option value="162054">计算机科学与技术</option>
                        </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">状态</label>
                        <div class="layui-input-inline" >
                            <label>
                                <select  name="status">
                                    <option value="" selected="selected">--请选择--</option>
                                    <option value="1" >正常</option>
                                    <option value="2">退出</option>
                                    <option value="3">毕业</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" lay-submit="" lay-filter="data-search-btn1"><i class="layui-icon layui-icon-search"></i> 搜索</button>
                        <button type="reset" class="layui-btn layui-btn-primary"><i class="layui-icon layui-icon-refresh"></i>重置</button>
                    </div>
                </div>
            </form>
        </div>

        <!--图表一-->

        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">

                <div class="layui-card-body">
                    <div class="layui-row layui-col-space15">
                        <div class="layui-col-md6">
                            <div class="layui-card" style="box-shadow: 0px 0px 10px 3px gainsboro; border-radius: 20px;">
                                <div class="layui-card-header" style="font-weight: bold; font-size: 18px;">成员人数统计</div>
                                <div class="layui-card-body">
                                    <div id="pienum" style="width: 100%; height: 400px;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-col-md6">
                            <div class="layui-card" style="box-shadow: 0px 0px 10px 3px gainsboro; border-radius: 20px;">
                                <div class="layui-card-header" style="font-weight: bold; font-size: 18px;">学院情况统计</div>
                                <div class="layui-card-body">
                                    <div id="piewin" style="width: 100%; height: 400px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form" style="margin: 50px 10px 10px 10px">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">专业名称</label>
                        <div class="layui-input-inline" >
                            <label for="major2"></label><select name="major2" id="major2" >
                            <option value="" selected="selected">--请选择--</option>
                            <option value="162056">软件工程</option>
                            <option value="162054">计算机科学与技术</option>
                        </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">时间范围</label>
                        <div class="layui-input-inline" style="width: 230px;">
                            <input type="text" name="daterange" id="daterange" autocomplete="off" placeholder="请选择日期范围" class="layui-input" readonly="readonly">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" lay-submit="" lay-filter="data-search-btn2"><i class="layui-icon layui-icon-search"></i> 搜索</button>
                        <button type="reset" class="layui-btn layui-btn-primary"><i class="layui-icon layui-icon-refresh"></i>重置</button>
                    </div>
                </div>
            </form>
        </div>
        <div style="padding: 20px;">
            <div class="layui-row layui-col-space15">
                <div class="layui-card" style="border-radius: 20px; border: 2px solid buttonface; box-shadow: 0px 0px 10px 3px gainsboro;">
                    <div class="layui-card-header" style="font-weight: bold; font-size: 18px;">各专业成员人数比较</div>
                    <div class="layui-card-body">
                        <div id="histogrammajor" style="width: 100%; height: 400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<script src="../../js/statis/statis.js"></script>--%>

</body>

</html>
