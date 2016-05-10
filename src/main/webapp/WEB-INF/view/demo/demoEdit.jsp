<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
 String path = request.getContextPath();
 if(path!=null &&!path.equals("")){
	 path=path+"/";
 }
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学校统计报表上报</title>
<script src="resources/plugins/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/plugins/jquery.validate.js"></script>
<script src="resources/plugins/tools.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/plugins/mmGrid.js"></script>
<script type="text/javascript" src="resources/plugins/mmPaginator.js"></script>
<script type="text/javascript" src="resources/plugins/artDialog.source.js"></script>
<script type="text/javascript" src="resources/plugins/iframeTools.source.js"></script>
<script type="text/javascript" src="resources/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="resources/plugins/jquery.validate.js"></script>
<script type="text/javascript" src="resources/plugins/additional-methods.js"></script>
<script type="text/javascript" src="resources/plugins/select2.js" charset="utf-8"></script>
<script src="resources/js/tablebg.js" type="text/javascript"></script>
<script src="resources/js/searchpanel.js" type="text/javascript"></script>
<script src="resources/js/cover.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/plugins/tools.js" charset="utf-8"></script>
<link rel="stylesheet" href="resources/style/mmGrid.css" />
<link rel="stylesheet" href="resources/style/mmPaginator.css" />
<link href="resources/style/base.css" rel="stylesheet" type="text/css">
<link href="resources/plugins/select2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/plugins/skins/default.css" />
<link href="resources/plugins/jquery.pagination.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/plugins/icon/css/font-awesome.min.css" />

<style>
body{
font-size: 12px;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/view/common/preloading.jsp"%>
<div class="formarea">
<form id="fm" method="post" style="margin: 0px;margin-top: 10px">
<table class="bgtable"  width="100%" >
              <tbody>
              <tr>
                <td align="right">用户名：</td>
                <td>&nbsp;<input type="hidden" name="id" /></td>
                
                <td><input required="required" data-msg-required="用户名不能为空！" name="username" size="30" type="text"></td>
                <td >用户名</td>
              </tr>
               <tr>
                <td align="right">用户真实姓名：</td>
                <td>&nbsp;</td>
                <td><input required="required" data-msg-required="用户真实姓名不能为空！" name="realname" size="30" type="text"></td>
                <td >用户真实姓名</td>
              </tr>
              <tr>
                <td align="right">网站访问地址：</td>
                <td>&nbsp;</td>
                <td><input name="url" size="30" type="text"></td>
                <td >网站的网址</td>
              </tr>
              <tr>
                <td  align="right" >网站备案证号：</td>
                <td>&nbsp;</td>
                <td ><input name="code" size="25" type="text"></td>
                <td >信息产业部备案号</td>
              </tr>
              <tr>
                <td align="right">联系电话信息： </td>
                <td>&nbsp;</td>
                <td><input name="tel" size="30" type="text"></td>
                <td>设置网站联系电话</td>
              </tr>
              <tr>
                <td align="right">网站客服QQ：</td>
                <td>&nbsp;</td>
                <td><input name="qq" size="30" type="text"></td>
                <td >设置网站客服QQ号</td>
              </tr>
              <tr>
                <td align="right">网站客服QQ2：</td>
                <td >&nbsp;</td>
                <td ><input name="qq2" size="30" type="text"></td>
                <td >设置网站客服QQ2号</td>
              </tr>
              <tr>
                <td align="right">管理员邮箱：</td>
                <td >&nbsp;</td>
                <td ><input name="email" type="email" id="email" size="30" type="text"></td>
                <td >设置网站客服Email</td>
              </tr>
              <tr>
                <td align="right">网站滚动通知：</td>
                <td>&nbsp;</td>
                <td><input name="notice" size="30" type="text"></td>
                <td>设置网站滚动公告内容，支持HTML</td>
              </tr>
              <tr>
                <td align="right">关键词设置为： </td>
                <td>&nbsp;</td>
                <td><input name="keyword" size="30" type="text"></td>
                <td>设置网站的关键词，更容易被搜索引挚找到。</td>
              </tr>
            
            </tbody></table>
            </form>
            </div>
<script type="text/javascript" src="resources/plugins/main.js"></script>
<script type="text/javascript">


function saveInfo(){
	  $('#fm').form({
          url: 'demo/update',
          onSubmit: function() {
              return $('#fm').valid();
          },
          success: function(result) {
              var result = eval('(' + result + ')');
              var parent = art.dialog.parent;				// 父页面window对象
              alert(result.msg)
              if (result.success ) {
            	  art.dialog.close();
            	  parent.query();
              }
          }
      });
      $('#fm').submit();
}
$(function(){
   var formObj=$.parseJSON('<%=request.getAttribute("json")%>');
   $('#fm').form('load',formObj);
	
});
</script>
</body>