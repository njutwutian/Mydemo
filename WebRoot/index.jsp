<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.easygo.model.SharedRouteModel" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String startPointString = (String)request.getAttribute("startpoint");
String endPointString = (String)request.getAttribute("endpoint");
List<SharedRouteModel> sharedRouteModelList = null;
sharedRouteModelList = (List<SharedRouteModel>)request.getAttribute("sharedroutemodellist");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>EasyGo</title>
    <style type="text/css">
        body
        {
        font-family: Georgia;
        }
        #maincontainer
        {
           margin-top:0px;
           margin-bottom:0px;
           background:#F0F8FF;
        }
        #container
        {
            float:left;
            width:1000px;
            height:500px;
            box-shadow: 1px 1px 1px #eaeaea;
            
        }
        #details
        {
            float:left;
            width:330px;
            height:500px;
            background:#F0F8FF;
            box-shadow: 1px 1px 1px #eaeaea;
        }
        #sharecontainer
        {
            float:right;
            width:1000px;
            box-shadow: 1px 1px 1px #eaeaea;
        }
        #header
        {
            height:100px;
        }
        #searchform
        {
            box-shadow: 1px 1px 1px #eaeaea;
        }
        #sharebutton
        {
            position:absolute;
            left:440px;
            top:33px;
            height:30px;
            width:100px;
            background: none repeat scroll 0% 0% #F0F8FF;
            text-align: center;
            font-size: 1em;
            clear: both;
            border: medium none;
        }
        #userinfo
        {
            float:right;
        }
        #routeid
        {
            visibility:hidden;
        }
        #sharedrouteid
        {
            visibility:hidden;
        }
        #sharediv
        {
            display:none;
            position:absolute;
            left:548px;
            top:33px;
            height:70px;
            width:700px;
            background:#DCDCDC
        }
        #inputdiv
        {
            float:left;
            height:70px;
            width:630px;
        }
        #sharetext
        {
            height:60px;
            width:620px;
        }
        #shareactionbuttondiv
        {
           float:right;
        }
        #shareactionbutton
        {
            height:70px;
            width:70px;
            background: none repeat scroll 0% 0% #F0F8FF;
            text-align: center;
            font-size: 1.5em;
            clear: both;
            border: medium none;
             
        }
        #submit
        {
            background: none repeat scroll 0% 0% #F0F8FF;
            text-align: center;
            font-size: 1em;
            clear: both;
            border: medium none;
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=5oyCsnQKBOSG8KCveozXmxHv">
        //此为v1.5版本的引用方式
        // http://api.map.baidu.com/api?v=1.4&key=5oyCsnQKBOSG8KCveozXmxHv&callback=initialize";此为v1.4版本及以前版本的引用方式
    </script>
</head>
<body onload="searchClick()">
<div id="header">
<div id="searchform">
<form action="/MyDemo/servlet/GetSharedRouteInfoServlet" method="post">
<label id="startlabel">起点:</label>
<input type="text" id="startinput" name="startpoint" placeholder="start"/>
<label id="endlabel">终点:</label>
<input type="text" id="endinput" name="endpoint" placeholder="end"/>
<input type="submit" id="submit" value="search"/>
<span id="userinfo">Welcome!<%=request.getSession().getAttribute("username") %>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
</form>
</div>
<%
if(sharedRouteModelList!=null)
{
if(sharedRouteModelList.size()>0)
{
%>
<span id="searchresult">
<span id="routeid">
<%=sharedRouteModelList.get(0).getRouteId()%>
</span>
从
<span id="startspan"><%=startPointString %></span>到
<span id="endspan"><%=endPointString%></span>
分享信息有<%=sharedRouteModelList.size() %>条,
</span>
<%      
}
else
{
%>
从
<span id="startspan"><%=startPointString %></span>到
<span id="endspan"><%=endPointString%></span>无分享结果
<% 
}
}
%>
<div id="sharespan">
<button id="sharebutton" onclick="shareRoute()">立刻分享</button>
</div>
<div id="sharediv">
<div id="inputdiv">
<textarea id="sharetext"></textarea>
</div>
<div id="shareactionbuttondiv">
<button id="shareactionbutton" onclick="shareContent()">Go</button>
</div>
</div>
</div>
<div id="maincontainer">
<div id="details">
搜索详细
</div>
<div id="container">
</div>
<div id="sharecontainer">
      <table>
           <%
              if(sharedRouteModelList!=null)
              {
              if(sharedRouteModelList.size()>0)
              {
            %>
           <tr>
                <td></td>
                <td>分享内容</td>
                <td>分享者</td>
                <td>用户评论</td>
           </tr>
           <%
              for (Iterator iterator = sharedRouteModelList.iterator(); iterator.hasNext();)
			  {
			    SharedRouteModel sharedRouteModel = (SharedRouteModel) iterator.next();
            %>
           <tr>
                <td><span id="sharedrouteid"><%=sharedRouteModel.getId()%></span></td>
                <td><%=sharedRouteModel.getShareRouteDesc()%></td>
                <td><%=sharedRouteModel.getSharerName() %>
                <a href="http://qr.liantu.com/api.php?text=从
                <%=sharedRouteModel.getStartPointString() %>到
                <%=sharedRouteModel.getEndPointString()%>路线信息，
                                                        由<%=sharedRouteModel.getSharerName()%>分享--
                <%=sharedRouteModel.getShareRouteDesc()%>" target="_blank">二维码分享给好友</a>
               </td>
               <td>
               <a href="/MyDemo/servlet/AddUpNumbServlet?sharedrouteid=<%=sharedRouteModel.getId()%>&upnumb=<%=sharedRouteModel.getUp()%>&startpoint=<%=startPointString %>&endpoint=<%=endPointString%>">顶</a><span id="upnumb<%=sharedRouteModel.getId()%>"><%=sharedRouteModel.getUp()%></span>&nbsp&nbsp
               <a href="/MyDemo/servlet/AddDownNumbServlet?sharedrouteid=<%=sharedRouteModel.getId()%>&downnumb=<%=sharedRouteModel.getDown()%>&startpoint=<%=startPointString %>&endpoint=<%=endPointString%>">踩</a><span id="downnumb<%=sharedRouteModel.getId()%>"><%=sharedRouteModel.getDown() %></span>
               </td>
           </tr>
           <% 
              }
              }
              }
           %>
      </table>
</div>
</div>
</body>
<script type="text/javascript">
    var map = new BMap.Map("container"); // 创建地图实例
    var point = new BMap.Point(118.778, 32.057); // 创建点坐标
    //alert(typeof(map));
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());
    map.setCurrentCity("南京");
    map.centerAndZoom(point, 13); // 初始化地图，设置中心点坐标和地图级别
</script>
<script>
    function searchClick(){
      var startpoint = document.getElementById("startspan").innerHTML;
      var endpoint = document.getElementById("endspan").innerHTML;
     // alert(startpoint);
     // alert(endpoint);
          var transit = new BMap.TransitRoute(map, {
        renderOptions: { map: map, panel: "details" },
       // policy:BMAP_TRANSIT_POLICY_LEAST_TRANSFER
      });
      transit.search(startpoint,endpoint);    
    }
    function shareRoute(){
        var div = document.getElementById("sharediv");
        if(div){
           div.style.display="block";
        }
    }
    var xmlHttp;
    function createXmlHttp() {
        if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        }
        else 
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } 
    }
    function shareContent() {
        createXmlHttp();
       // alert(typeof(xmlHttp));
       // alert("shareContent");
      //  var routeid = document.getElementById("routeid").innerHTML;
        var shareroutedesc = document.getElementById("sharetext").value;
        var startpoint = document.getElementById("startspan").innerHTML;
        var endpoint = document.getElementById("endspan").innerHTML;
      //  alert(shareroutedesc);
        var url = "/MyDemo/servlet/InsertSharedRouteServlet?shareroutedesc=" +shareroutedesc+"&startpoint="+startpoint+"&endpoint="+endpoint;
        xmlHttp.open("POST",url);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = shareContentCallback;
    }
    function shareContentCallback() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
               var startpoint = document.getElementById("startspan").innerHTML;
               var endpoint = document.getElementById("endspan").innerHTML;
               window.location.href="/MyDemo/servlet/GetSharedRouteInfoServlet?startpoint="+startpoint+"&endpoint="+endpoint;
               // var text = xmlHttp.responseText;
               // alert(text);
            }
        } 
    }
</script>
</html>  

