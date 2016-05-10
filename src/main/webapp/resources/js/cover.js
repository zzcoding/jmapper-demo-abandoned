function showcover(num)
{
	document.getElementById("main").disabled="true";
	document.getElementById("cover").style.display="";
	document.getElementById("covercontainer").style.display="";
	document.getElementById("covercontent"+num).style.display="";
	scrollTo(0,0);
}
function hidecover(num)
{
	document.getElementById("main").disabled="";
	document.getElementById("cover").style.display="none";
	document.getElementById("covercontainer").style.display="none";
	document.getElementById("covercontent"+num).style.display="none";
}