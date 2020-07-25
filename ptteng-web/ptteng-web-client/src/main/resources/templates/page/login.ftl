<div>
    <#if call_back??>
    <form action="/check?call_back=${call_back}" method="post" >
    <#else>
    <form action="/check" method="post" >
    </#if>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登录" />
            </tr>
        </table>
    </form>
</div>