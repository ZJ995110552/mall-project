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
            username : function (value) {
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




            // layer.alert("测试");
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });
            // return false;
        });

    });
});
function refreshCode() {
    var captcha = document.getElementById("captcha");
    // var captcha1 = document.getElementById("captcha1");
    captcha.src = "images/captcha.png?d=" + new Date().getTime();
    // captcha1.src = "images/captcha.png?d=" + new Date().getTime();
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
//
// var layer;
// $(function  () {
//     layui.use(['form','layer'], function(){
//         var form = layui.form;
//         // form.verify({
//         //     username:function(v){
//         //         if(v.trim()==''){
//         //             return "用户名不能为空";
//         //         }
//         //     }
//         //     ,password:function(v){
//         //         if(v.trim()==''){
//         //             return "密码不能为空";
//         //         }
//         //     },code:function(v){
//         //         if(v.trim()==''){
//         //             return '验证码不能为空';
//         //         }
//         //     }
//         // });
//
//         form.render();
//     });
//     layer = layui.layer;
//     // var msg='${message}';
//     // if(msg.trim()!=""){
//     //     layer.msg(msg, {icon: 5,anim:6,offset: 't'});
//     // }
//     // $("#code").click(function(){
//     //     var url = "${re.contextPath}/getCode?"+new Date().getTime();
//     //     this.src = url;
//     // }).click().show();
//     // $('#code').on('mouseover',function(){
//     //     layer.tips('点击刷新验证码', this,{time:1000});
//     // });
// })
//
// if (window != top)
//     top.location.href = location.href;


// $('.id-login').on('click', function () {
//     var datas = "username=" + $("#username").val() + "&password=" + $("#password").val() + "&captcha=" + $("#captcha").val();
//     console.log("");
//     $.ajax({
//         type: "POST",
//         url: "/sys/login",
//         data: datas,
//         dataType: "json",
//         success: function (result) {
//
//             if (result.code == 200) {//登录成功
//
//                 parent.location.href = '/index.html';
//             } else {
//                 alert(result.message);
//                 parent.location.href = '/login.html';
//                 // $.confirm({
//                 //     title: '对话框',
//                 //     content: '一些内容...',
//                 //     buttons: {
//                 //         confirm: {
//                 //             text: '确认',
//                 //             action: function(){
//                 //                 $.alert('确认的!');
//                 //             }
//                 //         },
//                 //         cancel: {
//                 //             text: '关闭',
//                 //             action: function(){
//                 //                 $.alert('取消的!');
//                 //             }
//                 //         },
//                 //         somethingElse: {
//                 //             text: '其他',
//                 //             btnClass: 'btn-blue',
//                 //             keys: ['enter', 'shift'],
//                 //             action: function(){
//                 //                 $.alert('其他的选择？');
//                 //             }
//                 //         }
//                 //     }
//                 // });
//                 // refreshCode();
//             }
//         }
//     });
//
// });



