$(function(){
	$(".left").click(function(){
		$(this).next(".sslist").animate({height:'toggle', opacity: 'toggle'});
			
	});
})