// JavaScript Document
/*$(document).ready(function(){
   $(".li_t").toggle(function(){
     $(this).next(".sslist").animate({height: 'toggle', opacity: 'toggle'}, "");
   },function(){
		 $(this).next(".sslist").animate({height: 'toggle', opacity: 'toggle'}, "");
   });
});*/
// 最新签约向上单条滚动效果
function AutoScroll(obj){
        $(obj).find("ul:first").animate({
                marginTop:"-31px"
        },1000,function(){
                $(this).css({marginTop:"0px"}).find("li:first").appendTo(this);
        });
}
$(document).ready(function(){
setInterval('AutoScroll("#scrollDiv")',5000)
});

//Tab导航---点击切换导航背景图，其他导航背景图复原
$(document).ready(function(){
	$("#list_DH .list_menu2 h4").click(function(){
		$(this).addClass("current");
		$(this).siblings("h4").removeClass("current");
	})
	$("#list_DH .list_menu2 h4").first().click();
	
		
});

 //回到顶部
$(function(){	
	$(window).scroll(function() {		
		if($(window).scrollTop() >= 300){ //向下滚动像素大于这个值时，即出现小火箭~
			$('.sidetop').fadeIn(150); //火箭淡入的时间，越小出现的越快~
		}else{    
			$('.sidetop').fadeOut(150); //火箭淡出的时间，越小消失的越快~
		}  
	});
	$('.sidetop').click(function(){$('html,body').animate({scrollTop: '0px'}, 500);}); //滚回顶部的时间，越小滚的速度越快~
});