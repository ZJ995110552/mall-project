<!DOCTYPE html>
<html>
<head>
    <title>Demo</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/demo/js/list.js"></script>
</head>
<body>
<form action="">
    <div>
        <label>用户名:</label>
        <div>
            <input type="text" name="username" placeholder="请输入用户名">
        </div>
        <label>操作时间:</label>
        <div>
            <input placeholder="开始日" id="LAY_demorange_s" name="startDate">
        </div>
        <div>
            <input placeholder="截止日" id="LAY_demorange_e" name="endDate">
        </div>
        <div>
            <button id="" onclick="search('demoTable')" lay-filter="search">
                <iclass
                ="fa fa-search">&nbsp;</i>查询
            </button>
            <button type="reset"><i class="fa fa-refresh">&nbsp;</i>重置</button>
        </div>
    </div>
</form>

<div>
    <table id="demoTable">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">用户ID</th>
            <th width="10%" param="{name:'username'}">用户名</th>
            <th width="10%" param="{name:'operation'}">用户操作</th>
            <th width="10%" param="{name:'method'}">请求方法</th>
            <th width="10%" param="{name:'params'}">请求参数</th>
            <th width="10%" param="{name:'ip',render:'Render.customState'}">ip地址</th>
            <th width="10%" param="{name:'createDate'}">创建时间</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>