$(document).ready(function () {
    layui.use(['form', 'layer'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        //日期
        // laydate.render({
        //     elem: '#date'
        // });
        // laydate.render({
        //     elem: '#date1'
        // });

        //创建一个编辑器
        // var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            username: function (value) {
                if (value.length < 7) {
                    return '用户名不能为空且至少6位';
                }
            }
            // , password: [
            //     /^[\S]{6,12}$/
            //     ,'密码必须6到12位，且不能出现空格'
            // ]
            // , captcha: function (value) {
            //    if(value.length < 1){
            //        return '验证码不能为空';
            //    }
            // }
        });

        //监听指定开关
        // form.on('switch(switchTest)', function (data) {
        //     layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
        //         offset: '6px'
        //     });
        //     layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        // });

        //监听提交
        form.on('submit(login)', function () {
            var data = {};
            data.username = $("input[name='username']").val();
            data.password = $("input[name='password']").val();

            $.ajax({
                type: "POST",
                url: "/sys/login",
                data: data,
                dataType: "json",
                success: function (result) {
                    console.info(result);
                    if (result.code == 0) {//登录成功
                        parent.location.href = '/index.html';
                    } else {
                        layer.msg(result.msg, {icon: 5});
                        refreshCode();
                    }
                }
            });
        });

    });
});

function refreshCode() {
    document.getElementById("captchapng").src = "images/captcha.png?d=" + Math.random();
}


// layui.config({
//     base: "js/"
// }).use(['form', 'layer'], function () {
//
//     alert(111);
//     var form = layui.form(),
//         layer = parent.layer === undefined ? layui.layer : parent.layer,
//         $ = layui.jquery;
//     //登录按钮事件
//     form.on("submit(login)", function (data) {
//         var datas = "username=" + data.field.username + "&password=" + data.field.password + "&captcha=" + data.field.captcha;
//         $.ajax({
//             type: "POST",
//             url: "/sys/login",
//             data: datas,
//             dataType: "json",
//             success: function (result) {
//                 if (result.code == 0) {//登录成功
//                     parent.location.href = '/index.html';
//                 } else {
//                     layer.msg(result.msg, {icon: 5});
//                     // refreshCode();
//                 }
//             }
//         });
//         return false;
//     })
// });
