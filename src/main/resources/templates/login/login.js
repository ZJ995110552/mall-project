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



$('.id-login').on('click', function () {
    var datas = "username=" + $("#username").val() + "&password=" + $("#password").val() + "&captcha=" + $("#captcha").val();
    console.log("");
    $.ajax({
        type: "POST",
        url: "/sys/login",
        data: datas,
        dataType: "json",
        success: function (result) {

            if (result.code == 200) {//登录成功

                parent.location.href = '/index.html';
            } else {
                alert(result.message);
                parent.location.href = '/login.html';
                // $.confirm({
                //     title: '对话框',
                //     content: '一些内容...',
                //     buttons: {
                //         confirm: {
                //             text: '确认',
                //             action: function(){
                //                 $.alert('确认的!');
                //             }
                //         },
                //         cancel: {
                //             text: '关闭',
                //             action: function(){
                //                 $.alert('取消的!');
                //             }
                //         },
                //         somethingElse: {
                //             text: '其他',
                //             btnClass: 'btn-blue',
                //             keys: ['enter', 'shift'],
                //             action: function(){
                //                 $.alert('其他的选择？');
                //             }
                //         }
                //     }
                // });
                // refreshCode();
            }
        }
    });

});


function refreshCode() {
    var captcha = document.getElementById("captcha");
    var captcha1 = document.getElementById("captcha1");
    // captcha.src = "/captcha.jpg?t=" + new Date().getTime();
    // captcha1.src = "/captcha.jpg?t=" + new Date().getTime();
}
