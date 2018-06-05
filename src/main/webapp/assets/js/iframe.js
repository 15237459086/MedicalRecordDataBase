function iframeAutoHeight(iframeId)  
{  
	parent.document.getElementById(iframeId).height=0;
	parent.document.getElementById(iframeId).height=document.body.scrollHeight + 50;
} 

$(function(){
	
	parent.document.getElementById("mainContent").height=0;
	parent.document.getElementById("mainContent").height=document.body.scrollHeight + 50;
});