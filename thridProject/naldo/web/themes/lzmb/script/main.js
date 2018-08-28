function AutoScroll(obj){
$(obj).find("ul:first").animate({
marginTop:"-25px"
},500,function(){
$(this).css({marginTop:"0px"}).find("li:first").appendTo(this);
});
}
$(document).ready(function(){
setInterval('AutoScroll("#scrollDiv")',2000)
});
/* »ÃµÆ´óÍ¼ */
function autopro(z){
 var g = 5000;
 for(i=1;i<=z;i++){
 setTimeout("projector("+i+","+z+")",g);
 g = g + 5000;
 }
 setTimeout("autopro("+z+")",g+5000);
}
function projector(imgid,num){
 for(var i=1;i<=parseInt(num);i++){
 if(i==parseInt(imgid)){
 $('#turnimg'+i).fadeIn("slow");
 $('#turnimg'+i).css("display","block");
 $('#caption'+i).addClass("caption"+i);
 }else{
 $('#turnimg'+i).fadeOut("slow");
 $('#turnimg'+i).css("display","none");
 $('#caption'+i).removeClass("caption"+i);
 }
 }
}

function setTab(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
}
}

function setSearchPriceValue(v){   
	
	if(document.getElementById("search_mip")){
	 document.getElementById("search_mip").value="";
     document.getElementById("search_map").value=""; 
	 if(v!=""){
	   var t=v.split("-");
	   document.getElementById("search_mip").value=t[0]==""?0:t[0];
	   document.getElementById("search_map").value=t[1]==""?0:t[1]; 
	   if(t[0]=="50000"&&t[1]=="")
		 document.getElementById("search_map").value=1000000;
	 } 
	}


   if(document.getElementById("mininput")){
		
     document.getElementById("mininput").value="";
     document.getElementById("maxinput").value=""; 
	 if(v!=""){
	   var t=v.split("-");
	   document.getElementById("mininput").value=t[0]==""?0:t[0];
	   document.getElementById("maxinput").value=t[1]==""?0:t[1]; 
	   if(t[0]=="50000"&&t[1]=="")
		 document.getElementById("maxinput").value=1000000;
	 }  
 } 
}

 function fixpic(){ 
   var picobj=document.getElementById("goods_img_id");
   var tempw=picobj.offsetWidth; 
   if(tempw>310){
     picobj.style.width="310px"; 
	 var temph=picobj.height; 
     var t=(1-((tempw-310)/tempw))*temph;   
     picobj.style.height=t+"px";
   }

  }

 function resizepic(){
  
   var content_div=document.getElementById("zoom");
   var cdobj=content_div.getElementsByTagName("img");
   for(var i=0;i<cdobj.length;i++){ 
      if(cdobj[i].width>680)
          cdobj[i].style.width="680";
   }
   
 }

function search_bare_dia(){
 
   var lz_weight_v=document.getElementById("lz_weight").value;
   var lz_cut_v=document.getElementById("lz_cut").value;
   var lz_color_v=document.getElementById("lz_color").value;
   var lz_clarity_v=document.getElementById("lz_clarity").value;
   var lz_shape_v=document.getElementById("lz_shape").value; 
   
   var url="/luozuan/index.php?wws_weight="+lz_weight_v
			+"&wws_cut="+lz_cut_v
		    +"&wws_color="+lz_color_v
		    +"&wws_clarity="+lz_clarity_v
		    +"&wws_shape="+lz_shape_v;
   
   window.location.href=url;
	     

 }