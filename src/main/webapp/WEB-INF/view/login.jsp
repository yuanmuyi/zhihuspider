<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>zhihuspider后台管理系统</title>
    <link rel="Shortcut Icon" href="static-resource/icon/all.png"/>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="zhihuspider后台管理系统 v1.0">
    <meta name="description" content="zhihuspider后台管理系统 v1.0，是一款爬取知乎数据，后台统计展示的系统。">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Meta tag Keywords -->

    <!-- css files -->
    <link rel="stylesheet" href="static-resource/lib/login/style.css" type="text/css" media="all"/> <!-- Style-CSS -->
    <link rel="stylesheet" href="static-resource/lib/login/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
    <link rel="stylesheet" href="static-resource/lib/layer/2.4/skin/layer.css"> <!-- Font-Awesome-Icons-CSS -->

    <!-- js -->
    <script type="text/javascript" src="static-resource/lib/jquery/jquery-2.1.4.min.js"></script>
    <script src="static-resource/lib/login/jquery.vide.min.js"></script>
    <script type="text/javascript" src="static-resource/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="static-resource/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
    <script type="text/javascript" src="static-resource/lib/jquery.validation/1.14.0/validate-methods.js"></script>
    <script type="text/javascript" src="static-resource/lib/gt.js"></script>

    <style>
        .title, h6 {
            font-family: "黑体";
        }

        .layui-layer-title {
            padding-right: 220px;
            font-family: "Microsoft Yahei"
        }

        .layui-layer-dialog .layui-layer-content {
            font-family: "Microsoft Yahei"
        }

        .layui-layer-btn {
            font-family: "Microsoft Yahei"
        }

        span.icon1 {
            top: 23%;
        }

        span.icon2 {
            top: 42%;
        }

    </style>
</head>
<body>

<!-- main -->
<div data-vide-bg="static-resource/lib/video/Ipad">
    <div class="center-container">
        <!--header-->
        <div class="header-w3l">
            <h1>zhihuspider<span class="title">后台管理系统</span></h1>
        </div>
        <!--//header-->
        <div class="main-content-agile">
            <div class="sub-main-w3">
                <div class="wthree-pro">
                    <h2>Login Here</h2>
                </div>
                <form id="login" action="" method="post" width="100%">
                    <input placeholder="用户名" name="username" id="username" class="user" type="text" required="">
                    <span class="icon1"><i class="fa fa-user" aria-hidden="true"></i></span><br><br>
                    <input placeholder="密码" name="password" id="password" class="pass" type="password" required="">
                    <span class="icon2"><i class="fa fa-unlock" aria-hidden="true"></i></span><br><br>


                    <div class="sub-w3l">
                        <h6 onclick="forgetPass()" style="cursor: pointer"><a>忘记密码?</a></h6>
                        <div class="right-w3l">
                            <input id="loginButton" type="button" class="login" value="登录">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!--//main-->

        <!--footer-->
        <div class="footer">
            <p>&copy; 2018 jjwhnd. All rights reserved | Design by <a href="www.baidu.com"
                                                                     target="_blank">jjwhnd</a></p>
        </div>
        <!--//footer-->
    </div>
</div>
<script type="text/javascript">

    $('#loginButton').click(function () {
        $("#loginButton").val("登录中...");
        $("#loginButton").attr("disabled", "disabled");
        var name = $("#username").val();
        var pass = $("#password").val();
        if (name == "" || pass == "") {
            layer.msg("用户名或密码不能为空");
            $("#loginButton").val("登录");
            $("#loginButton").removeAttr("disabled");
            return;
        }
        var reg = /^[0-9A-Za-z]+$/;
        if (!reg.exec(name)) {
            layer.msg("用户名格式有误");
            $("#loginButton").val("登录");
            $("#loginButton").removeAttr("disabled");
            return;
        }
        $.ajax({
            url: '/login?t=' + (new Date()).getTime(), // 加随机数防止缓存
            type: 'POST',
            dataType: 'json',
            data: {
                username: name,
                password: pass
            },
            success: function (data) {
                console.log(data);
                if (data.success == true) {
                    window.location.href = "/index";
                } else {
                    layer.msg(data.message);
                    $("#loginButton").val("登录");
                    $("#loginButton").removeAttr("disabled");
                }
            },
            error: function (XMLHttpRequest) {
                layer.alert('数据处理失败! 错误码:' + XMLHttpRequest.status + ' 错误信息:' + JSON.parse(XMLHttpRequest.responseText).message, {
                    title: '错误信息',
                    icon: 2
                });
                $("#loginButton").val("登录");
                $("#loginButton").removeAttr("disabled");
            }
        });
    })


    function forgetPass() {
        layer.alert('体验测试账号密码：test | test', {
            icon: 4,
            title: "提示"
        });
    }
</script>
</body>
</html>
