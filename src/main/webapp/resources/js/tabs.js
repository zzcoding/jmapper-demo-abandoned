function inittabs(tabcount,curtab)
{
	var count = parseInt(tabcount);
	var i;
	for(i = 1;i<=count;i++)
	{
	document.getElementById("tab"+i).style.display="none";
	document.getElementById("tab"+i+"btn").className="tabitem_link";
	}

	document.getElementById("tab"+curtab).style.display="";
	document.getElementById("tab"+curtab+"btn").className="tabitem_current";
}