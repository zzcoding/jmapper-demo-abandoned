
function switchSysBar(){
 if (parent.document.getElementById('attachucp').cols=="220,10,*"){
 document.getElementById('leftbar').style.display="";
 parent.document.getElementById('attachucp').cols="0,10,*";
 }
 else{
 parent.document.getElementById('attachucp').cols="220,10,*";
 document.getElementById('leftbar').style.display="none"
 }
}
function load(){
 if (parent.document.getElementById('attachucp').cols=="0,10,*"){
 document.getElementById('leftbar').style.display="";
 }
}
