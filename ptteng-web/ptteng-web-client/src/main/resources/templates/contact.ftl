<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <#include "/page/pttitle.ftl" parse=true>
</head>
<body>
<#include "/page/ptheader.ftl" parse=true>
<#include "${body}.ftl" parse=true>
<#include "/page/ptfooter.ftl">
</body>
</html>