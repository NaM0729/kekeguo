<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <title>comp</title>
    <style type="text/css">
    	#app{
    		width:100%;
    		/*background: red;*/
    		/*height: 200px;*/
    		margin: 0 auto;
    		padding:20px;
    		font-size: 14px;
    	}
    	/*.detail{
    		font-size:16px;
    		color: #333;
    	}
    	.container{
    		border-top: 1px solid #eee;
    	}*/
       /* ul{
            margin-left: -40px;
        }
    	li{
    		border-bottom: 1px dashed #eee;
    		height: 54px;
    		line-height: 54px;
    		width: 100%;
            list-style: none;
    	}*/
        .li_div{
            color: #999;
            width: 50%;
            float: left;
        }
    	/*.clearFloat::after{
    		content: "";
    		display: block;
    		clear: both;
    		zoom:1;
    	}*/
    	table{
    		border-collapse: collapse;
    		margin-top: 10px;
    		color: rgb(51, 51, 51);
    	}
    	table tr td{
    		border:1px solid #ccc;
    	}
    	tr{
    		height: 45px;
    	}
    	td{
    		text-align: center;
    		
    	}
        .teamName{
            display: inline-block;
        }
    	.color-value{
    		color: rgb(51,51,51);
            display: inline-block;
    	}
        .head_container{
            padding-left: 75px;
        }
        .head_container>div{
            display: inline-block;
            margin-right: 15px;
        }
        .circle{
            width: 45px;
            height: 45px;
            border:1px solid #ff644b;
            border-radius: 50%;
            display: inline-block;
            vertical-align: middle;
            position: relative;
            z-index: 5;
            background: #fff;
        }
        .circle img{
            width: 45px;
            height: 45px;
            border-radius: 50%;
        }
        .head_name{
            width: 90px;
            height: 30px;
            border-radius: 15px;
            background: #ff644b;
            display: inline-block;
            margin-left: -48px;
            vertical-align: middle;
            text-align: right;
            padding-right: 20px;
            line-height: 28px;
            color: #fff;
        }
    </style>
  </head>
  <body>
    <div id="app">
    	<p class="detail">训练计划表</p>
    	<div class="container">
    		<ul>
    			<li class="clearFloat">
                    队伍名称 ：${teamName}
    			</li>
                <li class="clearFloat">
                    所属教练 ：${belongCoach}
    			</li>
                <li class="clearFloat">
                    训练阶段 ：${stage}
                </li>
                <li class="clearFloat">
                    训练目标 ：${target}
                </li>
                <li class="clearFloat">
                    训练地点 ：${site}
                </li>
                <li class="clearFloat">
                    训练时间 ：${startTime}&nbsp;&nbsp;&nbsp;&nbsp;${lengthOfTime}
                </li>
                <#--<li class="clearFloat">
                    训练时间段 ：${lengthOfTime}
                </li>-->
                <li class="clearFloat">
                    备注 ：${remark}
                </li>
                <li class="clearFloat">
                    参训运动员 ：<#list athleteIdList as a>
                                    ${a.name}&nbsp;&nbsp;
                                </#list>
                </li>
    		</ul>
    	</div>
    	<table style="width: 100%;" cellpadding="0" cellspacing="0">
    		<tr>
    			<td colspan="8" align="center" bgcolor="#e6e6e6" height="45px">动作准备</td>
    		</tr>
    		<tr style="width: 100%">
    			<td>准备主题</td>
    			<td>动作名称</td>
    			<td>组数</td>
    			<td>次数</td>
    			<td>间歇</td>
    			<td>练习时长</td>
    			<td>负荷</td>
    			<td>备注</td>
    		</tr>
			<#list readyAction as b>
			<tr>
                <td>${b.themeName}</td>
                <td>${b.actionName}</td>
                <td>${b.groupNum}</td>
                <td>${b.time}</td>
                <td>${b.interval}</td>
                <td>${b.duration}</td>
                <td>${b.strength}</td>
                <td>${b.aremark}</td>
            </tr>
			</#list>
    		<tr>
    			<td colspan="8" align="center" bgcolor="#e6e6e6" height="45px">主要训练</td>
    		</tr>
    		<tr style="width: 100%">
    			<td>准备主题</td>
    			<td>动作名称</td>
    			<td>组数</td>
    			<td>次数</td>
    			<td>间歇</td>
    			<td>练习时长</td>
    			<td>负荷</td>
    			<td>备注</td>
    		</tr>
			<#list adminAction as c>
			<tr style="width: 100%">
                <td>${c.themeName}</td>
                <td>${c.actionName}</td>
                <td>${c.groupNum}</td>
                <td>${c.time}</td>
                <td>${c.interval}</td>
                <td>${c.duration}</td>
                <td>${c.strength}</td>
                <td>${c.aremark}</td>
            </tr>
			</#list>

    		<tr>
    			<td colspan="8" align="center" bgcolor="#e6e6e6" height="45px">整理放松</td>
    		</tr>
    		<tr style="width: 100%">
    			<td>准备主题</td>
    			<td colspan="2">动作名称</td>
    			<td>间歇</td>
    			<td colspan="2">练习时长</td>
    			<td>负荷</td>
    			<td>备注</td>
    		</tr>
			<#list relaxAction as d>
			<tr style="width: 100%">
                <td>${d.themeName}</td>
                <td colspan="2">${d.actionName}</td>
                <td>${d.interval}</td>
                <td colspan="2">${d.duration}</td>
                <td>${d.strength}</td>
                <td>${d.aremark}</td>
            </tr>
			</#list>

    	</table>
    </div>
  </body>
</html>
