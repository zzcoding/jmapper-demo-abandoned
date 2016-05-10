var Sys = {};

var ua = navigator.userAgent.toLowerCase();

window.ActiveXObject?Sys.ie = ua.match(/msie ([\d.]+)/)[1]:
document.getBoxObjectFor ? Sys.firefox = ua.match(/firefox\/([\d.]+)/)?Sys.firefox = ua.match(/firefox\/([\d.]+)/)[1]:'':
window.MessageEvent && !document.getBoxObjectFor ? Sys.chrome = ua.match(/chrome\/([\d.]+)/)?ua.match(/chrome\/([\d.]+)/)[1]:'':
window.opera ? Sys.opera = ua.match(/opera.([\d.]+)/)[1]:
window.openDatabase ? Sys.safari = ua.match(/version\/([\d.]+)/)[1]:0;

var searchareaheight = 0;
var flag = 0;

function showopeninfo()
{
	document.getElementById("searchpanelopeninfo").style.display="";
}

function hideopeninfo()
{
	document.getElementById("searchpanelopeninfo").style.display="none";
}

function showcloseinfo()
{
	document.getElementById("searchpanelcloseinfo").style.display="";	
}

function hidecloseinfo()
{
	document.getElementById("searchpanelcloseinfo").style.display="none";	
}

function showsearchpanel1()
{
	document.getElementById("searchclosearea").style.display="none";
	document.getElementById("searchpanelleft").style.display="none";
	document.getElementById("searchpanelopenbtn").style.display="none";
	document.getElementById("searchpanelopeninfo").style.display="none";

	document.getElementById("searcharea").style.display="";
	document.getElementById("searchpanelclosebtn").style.display="";
	document.getElementById("searchpanelcloseinfo").style.display="none";
	document.getElementById("hidepanelflag").value = 0;
}

function hidesearchpanel(e)
{
          if (!e) var e = window.event;
          e.cancelBubble = true;
          if (e.stopPropagation) e.stopPropagation();

	if(Sys.ie == "8.0" || Sys.ie == "7.0")
	{
		hidesearchpanel2();
	}
	else
	{
		hidesearchpanel1();
	}
}

function showsearchpanel(e)
{
          if (!e) var e = window.event;
          e.cancelBubble = true;
          if (e.stopPropagation) e.stopPropagation();

	if(Sys.ie == "8.0" || Sys.ie == "7.0")
	{
		showsearchpanel2()
	}
	else
	{
		showsearchpanel1();
	}
}

function hidesearchpanel1()
{
	if(searchareaheight == 0)
	{
		searchareaheight = document.getElementById("searcharea").clientHeight;
		document.getElementById("searcharea").style.height = 17;
	}

	document.getElementById("searchclosearea").style.display="";
	document.getElementById("searchpanelleft").style.display="";
	document.getElementById("searchpanelopenbtn").style.display="";
	document.getElementById("searchpanelopeninfo").style.display="none";

	document.getElementById("searcharea").style.display="none";
	document.getElementById("searchpanelclosebtn").style.display="none";
	document.getElementById("searchpanelcloseinfo").style.display="none";

	document.getElementById("hidepanelflag").value = 1;
}

function hidesearchpanel2()
{
	if(searchareaheight == 0)
	{
		searchareaheight = document.getElementById("searcharea").clientHeight;
	}
	
	if(flag == 0)
	{
		document.getElementById("searchpanelopeninfo").style.display="none";
		document.getElementById("searchpanelclosebtn").style.display="none";
		document.getElementById("searchpanelcloseinfo").style.display="none";
		flag = 1;
	}

	if(document.getElementById("searcharea").clientHeight > 22)
	{
		document.getElementById("searcharea").style.height = document.getElementById("searcharea").clientHeight - 5;
		document.getElementById("searcharea").style.overflow = "hidden";
		setTimeout("hidesearchpanel2()",5);
	}
	else
	{
		document.getElementById("searchclosearea").style.display="";
		document.getElementById("searchpanelleft").style.display="";
		document.getElementById("searchpanelopenbtn").style.display="";
		document.getElementById("searchpanelopeninfo").style.display="none";
	
		document.getElementById("searcharea").style.display="none";
		document.getElementById("searchpanelclosebtn").style.display="none";
		document.getElementById("searchpanelcloseinfo").style.display="none";
		document.getElementById("searcharea").style.overflow = "";
		flag = 0;
		document.getElementById("hidepanelflag").value = 1;
	}

}

function showsearchpanel2()
{
	if(flag == 0)
	{
		document.getElementById("searchclosearea").style.display="none";
		document.getElementById("searchpanelleft").style.display="none";
		document.getElementById("searchpanelopenbtn").style.display="none";
		document.getElementById("searchpanelopeninfo").style.display="none";

		document.getElementById("searcharea").style.display="";
		document.getElementById("searchpanelclosebtn").style.display="none";
		document.getElementById("searchpanelcloseinfo").style.display="none";
		flag = 1;
	}
	
	if(document.getElementById("searcharea").clientHeight < searchareaheight-5)
	{
		document.getElementById("searcharea").style.height = document.getElementById("searcharea").clientHeight + 5;
		document.getElementById("searcharea").style.overflow = "hidden";
		setTimeout("showsearchpanel2()",5);
	}
	else
	{
		document.getElementById("searcharea").style.height = searchareaheight;
		document.getElementById("searchclosearea").style.display="none";
		document.getElementById("searchpanelleft").style.display="none";
		document.getElementById("searchpanelopenbtn").style.display="none";
		document.getElementById("searchpanelopeninfo").style.display="none";

		document.getElementById("searcharea").style.display="";
		document.getElementById("searchpanelclosebtn").style.display="";
		document.getElementById("searchpanelcloseinfo").style.display="none";
		document.getElementById("searcharea").style.overflow = "";
		flag = 0;
		document.getElementById("hidepanelflag").value = 0;
	}
}

function searchpanel()
{
	if(document.getElementById("hidepanelflag").value == 1)
	{
		hidesearchpanel1();
	}
}