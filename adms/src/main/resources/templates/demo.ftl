﻿<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
队伍名称 ：${teamName} <br />
训练阶段 ：${stage} <br />
训练目标 ：${target} <br />
训练地点 ：${site} <br />
训练时间 ：${startTime} - ${endTime} <br />
备注 ：${remark} <br />
参训运动员 ：<#list athleteIdList as a>
                ${a.name}
           </#list>  <br />
动作准备 ： <#list readyAction as b>
                ${b.actionName}
            </#list>  <br />
主要训练 ： <#list adminAction as c>
                ${c.actionName}
            </#list>  <br />
整理放松 ： <#list relaxAction as d>
                ${d.actionName}
            </#list>  <br />
</body>
</html>