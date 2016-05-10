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
<title>基础信息维护管理</title>
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

<div id="cover" style="display:none;"><iframe src="" frameborder="0" style="position:absolute; visibility:inherit; top:0px; left:0px; height:expression(eval(document.body.clientHeight)); width:100%; z-index:-1; FILTER: alpha(opacity=0); "> </iframe></div>


  <div id="titlearea">
 
   
  <h1>当前操作：</h1>
  <h2>基础信息维护管理</h2>
   
  </div>
  <div style="display:none" id="searchclosearea">
  	<div  style="display:none" id="searchpanelleft"></div>
	<div  style="display:none" id="searchpanelopenbtn" onclick="showsearchpanel(event);" onmouseover="showopeninfo();" onmouseout="hideopeninfo();">
		<div onclick="showsearchpanel(event);" id="searchpanelopeninfo" style="display:none">
		</div>
	</div>
  </div>  <div id="searcharea">
  <input name="hidepanelflag" id="hidepanelflag" type="hidden" value="" />
  <div id="searchpanelclosebtn" onclick="hidesearchpanel(event);" onmouseover="showcloseinfo();" onmouseout="hidecloseinfo();"><div onclick="hidesearchpanel(event);" id="searchpanelcloseinfo" style="display:none;"></div></div>
       <form action="" id="fm">
       <table border="0" cellpadding="0" cellspacing="1">
         <tr>
           <td width="11%"><div id="inputname">用户真实姓名：</div></td>
           <td width="30%"><div id="inputvalue">
               <select id="realname" name="realname" style="width: 129px">
                
               </select>
           </div></td>
           <td width="12%"><div id="inputname">用户名：</div></td>
           <td width="20%">
           <div id="inputvalue"><input name="username" type="text" size="30" /></div>    
</td>
          
       
         </tr>
      <tr>
        <td><div id="inputname">电子邮箱：</div></td>
        <td><div id="inputvalue">
         <input name="email" type="text" size="30" />   
        </div></td>
		 <td><div id="inputname">网站地址：</div></td>
		 <td><div id="inputvalue">
		 <input name="url" type="text" size="30" />   
         </div></td>
		
		<td><div id="inputname">电话号码：</div></td>
        <td><div id="inputvalue">
		    <input name="tel" type="text" size="30" />     
        </div></td>
		 <td> 
		 <input class="searchbtn" onclick="query()"  type="button" id="button" value=" 查询 " />
		 <input class="searchbtn" onclick="resetForm()"  type="button" id="button" value=" 重置" />
		</td>
	     </tr>
	   
    </table>
    </form>
  </div>
  <div id="resulttitlearea"> <span>基础信息列表【<span class="style1">JMAPPER CRUD DEMO</span>】</span> </div>
  <div id="resultlistarea">
    
	
  </div>
  <div id="formarea">
   <div id="xoverflow">
  
    <table id="table12-1" ></table>
	<div id="pg"></div>
	</div>
  </div>
  <div id="operationarea"> 
  <div id="operationcontent">
	<div id="operationcontent">
    <input name="Submit" type="button" value="添加信息" onclick="addInfo();" class=funbutton 
                    />    
    <input name="Submit" type="button" value="修改信息" onclick="editInfo()" class=funbutton  />
  	<input name="Submit" type="button" value="删除信息" onClick="deleteInfo()" class=funbutton >
    </div>
  </div>
</div>
<div id="bottomarea">
  <div id="bottomarea_l"></div>
  <div id="bottomarea_r"></div>
  </div>
<script type="text/javascript">

var mmg;
//表头分组
$(function(){
var groupCols = [
    {title:'序号', name:'', width: 30, align: 'center',  renderer: function(val,item,rowIndex){
        return rowIndex+1;
    }},
   
        { title:'用户名', name:'username' ,width:100, align:'left' ,sortable: true},
        { title:'用户真实姓名', name:'realname' ,width:100, align:'left' ,sortable: true},
   
    { title:'电话号码', name:'tel' ,width:60, align:'left' ,sortable: true},
    { title:'电子邮箱', name:'email' ,width:120, align:'left' ,sortable: true},
    { title:'网站地址', name:'url' ,width:120, align:'left' ,sortable: true},
    { title:'备案编码', name:'code' ,width:60, align:'left' ,sortable: true},
  
    { title:'qq号码', name:'qq' ,width:70, align:'left' },
    { title:'qq2号码', name:'qq2' ,width:70, align:'left' },
    
    { title:'通知消息', name:'notice' ,width:80, align:'left' },
    { title:'关键字', name:'keyword',width:80, align:'left' ,sortable: true},
    { title:'创建时间', name:'creatTime' ,width:70, align:'left' ,sortable: true}
    
];
mmg = $('#table12-1').mmGrid({
    cols: groupCols
    ,height:'auto'
    ,url: 'demo/list'
    ,method: 'post'
    ,remoteSort:false
    ,multiSelect: false
    ,checkCol: false
    ,fullWidthRows: true
    ,autoLoad: true
    ,nowrap:true
    ,plugins: [
        $('#pg').mmPaginator({})
     ]
    ,params: function(){
         return $.getFormParams($('#fm'));
    }
});

$.loadSelect($('#realname'),'demo/realname/list');

});
function query(){
mmg.load($.getFormParams($("#fm")));
}
function addInfo(){
	art.dialog.open("demo/add",{
	    width:650,
	    title:'新增信息',
	    height:330,
	    lock: true,
	    background: '#000', // 背景色
	    opacity: 0.67,	// 透明度
	    button: [
	        {
	            name: '保存',
	            callback: function () {
	            	var iframe = this.iframe.contentWindow;
	            	iframe.saveInfo();
	                return false;
	            },
	            focus: true
	        },
	       
	        {
	            name: '取消'
	        }
	    ]
	});
}
function resetForm(){
	$("#realname").select2('val','');
	$("#fm").get(0).reset();

}
function editInfo(){
	var rows = mmg.selectedRows();
	if(!rows || rows.length==0){
          alert('请选择要修改的数据！');
          return;
    }
	art.dialog.open("demo/edit/"+rows[0].id,{
	    width:650,
	    title:'修改信息',
	    height:330,
	    lock: true,
	    background: '#000', // 背景色
	    opacity: 0.67,	// 透明度
	    button: [
	        {
	            name: '保存',
	            callback: function () {
	            	var iframe = this.iframe.contentWindow;
	            	iframe.saveInfo();
	                return false;
	            },
	            focus: true
	        },
	       
	        {
	            name: '取消'
	        }
	    ]
	});
}
function deleteInfo(){
	var rows = mmg.selectedRows();
	if(!rows || rows.length==0){
          alert('请选择要删除的数据！');
          return;
    }
    if(confirm('确定要删除吗？')){
        $.getJSON('demo/delete/'+rows[0].id,function(result){
     	    alert(result.msg);
            if (result.success ) {
          	   art.dialog.close();
          	   query();
            }
      });
    }

}
</script>

</body>

</html>