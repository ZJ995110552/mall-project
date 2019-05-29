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

$('.id-login').on('click', function () {
    var datas = "username=" + $("#username").val() + "&password=" + $("#password").val() + "&captcha=" + $("#captcha").val();
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


function refreshCode(){
    var captcha = document.getElementById("captcha");
    var captcha1 = document.getElementById("captcha1");
    // captcha.src = "/captcha.jpg?t=" + new Date().getTime();
    // captcha1.src = "/captcha.jpg?t=" + new Date().getTime();
}
