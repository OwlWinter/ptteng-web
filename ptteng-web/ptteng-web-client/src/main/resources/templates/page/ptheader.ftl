<div class="container  hidden-xs">
    <div class="row header-top">

        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            客服电话:010-594-78634 | ${settime?number_to_datetime}
        </p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="${ctx!"/static"}/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="${ctx!"/static"}/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="${ctx!"/static"}/imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${ctx!"/static"}/imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
<#--                检测登录状态 & 拼接 url-->
                <#if token??>
                    <li><a href="/home?token=${token}">首页</a></li>
                    <li><a href="/u/occupation?token=${token}">职业</a></li>
<#--                    logo 这一块我没做，如果实现了上传之后存好图片到 /static/imges/head/ 保存图片名到数据库就可以看到了-->
                    <li><img src="${ctx!"/static"}/imges/head/${logo!"687.png"}" title="${username!"logo"}" alt="${username!"logo"}" style="width:60px;height:60px"/></li>
                    <li><a href="/logout">登出</a></li>
                <#else>
                    <li><a href="/">首页</a></li>
                    <li><a href="/login">登录</a></li>
                    <li><a href="/register/sms">注册</a></li>
                </#if>
            </ul>
        </div>

    </div>
</nav>