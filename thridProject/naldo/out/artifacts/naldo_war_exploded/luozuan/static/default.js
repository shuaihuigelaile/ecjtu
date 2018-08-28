var loadSlide = function() {
	$(".jslider").remove();
	$("#_weight").removeData("jslider");
	$("#_weight").slider({
		from: 0,
		to: 5,
		step: 0.01,
		round: 2,
		dimension: '&nbsp;CT',
		scale: ['0', '0.5', '1', '1.5', '2', '2.5', '3', '3.5', '4', '4.5', '5'],
		callback: function(value) {
			var arr = value.split(';');
			$("#minWeight").val(arr[0]);
			$("#maxWeight").val(arr[1]);
			submitData()
		}
	});
	$("#_price").removeData("jslider");
	$("#_price").slider({
		from: 0,
		to: 100000,
		step: 500,
		scale: ['0', '|', '2W', '|', '4W', '|', '6W', '|', '8W', '|', '10W'],
		callback: function(value) {
			var arr = value.split(';');
			$("#minPrice").val(arr[0]);
			$("#maxPrice").val(arr[1]);
			submitData()
		}
	})
};
var getCache = function(name) {
	return $("#_luozuanCache").data(name)
};
var addCache = function(name, val) {
	var tmpdata = getCache(name);
	if (tmpdata) {
		tmpdata = tmpdata + ',' + val
	} else {
		tmpdata = val
	};
	tmpdata = $.trim(tmpdata);
	if (tmpdata.charAt(0) == ',') {
		tmpdata = tmpdata.substr(1)
	};
	$("#_luozuanCache").data(name, tmpdata)
};
var delCache = function(name, val) {
	var tmpdata = getCache(name);
	tmpdata = tmpdata.replace(',' + val, '');
	tmpdata = tmpdata.replace(val + ',', '');
	tmpdata = tmpdata.replace(val, '');
	$("#_luozuanCache").data(name, tmpdata)
};
var clearCache = function(name) {
	if (name) {
		$("#_luozuanCache").removeData(name)
	} else {
		$("#_luozuanCache").removeData()
	}
};
$("#_tab_type h2").bind('click',
function() {
	$("#_tab_type h2").removeClass('hover');
	$(this).addClass('hover');
	if ($(this).attr('rel') == '1') {
		$("#_toolbar").show();
		$("#_textbar").hide();
		$("#_btnToManual").show();
		$("#_btnToBlur").show();
		//if ($("#_btnToBlur").hasClass('blur')) {
			$("#_btnBlurSubmit").show()
		//}
	} else {
		$("#_toolbar").hide();
		$("#_textbar").show();
		$("#_btnToManual").hide();
		$("#_btnToBlur").hide();
		$("#_btnBlurSubmit").hide()
	};
	blurReset()
});
$("#_dataHead .order").hover(function() {
	$(this).addClass('hover')
},
function() {
	$(this).removeClass('hover')
});
$("#_dataHead span").bind('click',
function() {
	clearCache("orderway");
	clearCache("orderby");
	if ($(this).attr('class') == 'asc') {
		$(this).attr('class', 'desc');
		addCache("orderway", 'desc')
	} else if ($(this).attr('class') == 'desc') {
		$(this).attr('class', 'asc');
		addCache("orderway", 'asc')
	} else {
		$("#_dataHead span").removeClass('asc');
		$("#_dataHead span").removeClass('desc');
		$(this).attr('class', 'asc');
		addCache("orderway", 'asc')
	};
	addCache("orderby", $(this).attr('ref'));
	submitData()
});
$("#_dataList").hover(function() {},
function() {
	$('#_toolTip').hide()
});
$("#_toolbarShape li").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("shape", $(this).attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("shape", $(this).attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarColor li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("color", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("color", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarClarity li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("clarity", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("clarity", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarCut li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("cut", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("cut", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarPolish li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("polish", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("polish", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarSymmetry li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("symmetry", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("symmetry", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarCert li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("cert", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("cert", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarLocation li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("location", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("location", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_toolbarFluorescence li a").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("fluorescence", $(this).parent().attr('rel'))
	} else {
		$(this).addClass('hover');
		addCache("fluorescence", $(this).parent().attr('rel'))
	};
	$("#_pageIndex").val(1);
	submitData()
});
$("#_btnToManual").bind('click',
function() {
	$(this).removeClass('blur');
	$("#_btnToBlur").addClass('blur');
	$("#_toolbarWeightText").show();
	$("#_toolbarPriceText").show();
	$("#_toolbarWeightSlide").hide();
	$("#_toolbarPriceSlide").hide();
	$("#_btnBlurSubmit").show()
});
$("#_btnToBlur").bind('click',
function() {
	$(this).removeClass('blur');
	$("#_btnToManual").addClass('blur');
	$("#_toolbarWeightText").hide();
	$("#_toolbarPriceText").hide();
	$("#_toolbarWeightSlide").show();
	$("#_toolbarPriceSlide").show();
	$("#_btnBlurSubmit").hide();
	loadSlide()
});
$("#_btnBlurSubmit").bind('click',
function() {
	submitData()
});
$("#_btnBlurReset").bind('click',
function() {
	blurReset()
});
function blurReset() {
	$("#searcKey a").css({"background-color":"#fff"});
	$("#_toolbarShape li").removeClass('hover');
	$("#_toolbar li a").removeClass('hover');
	$("#_textbar dd").removeClass('hover');
	$("#minWeight").val('');
	$("#maxWeight").val('');
	$("#_weight").attr('value', '0;5');
	$("#minPrice").val('');
	$("#maxPrice").val('');
	$("#_price").attr('value', '0;100000');
	loadSlide();
	clearCache();
	submitData()
};
$("#_textbarShape dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("shape", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("shape", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarColor dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("color", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("color", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarClarity dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("clarity", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("clarity", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarCut dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("cut", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("cut", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarPolish dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("polish", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("polish", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarSymmetry dd").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("symmetry", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("symmetry", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarPrice dd").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		$("#minPrice").val('0');
		$("#maxPrice").val('100000')
	} else {
		$("#_textbarPrice dd").removeClass('hover');
		$(this).addClass('hover');
		var price = $(this).attr('ref').split(',');
		if (!price[0]) price[0] = '0';
		//if (!price[1]) price[1] = '100000';
		$("#minPrice").val(price[0]);
		$("#maxPrice").val(price[1])
	};
	submitData()
});
$("#_textbarWeight dd").bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		$("#minWeight").val('0');
		$("#maxWeight").val('10')
	} else {
		$("#_textbarWeight dd").removeClass('hover');
		$(this).addClass('hover');
		var weight = $(this).attr('ref').split(',');
		if (!weight[0]) weight[0] = '0';
		if (!weight[1]) weight[1] = '5';
		$("#minWeight").val(weight[0]);
		$("#maxWeight").val(weight[1])
	};
	submitData()
});
$("#_textbarCert dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("cert", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("cert", $(this).attr('ref'))
	};
	submitData()
});
$("#_textbarLocation dd").not('.eline').bind('click',
function() {
	if ($(this).hasClass('hover')) {
		$(this).removeClass('hover');
		delCache("location", $(this).attr('ref'))
	} else {
		$(this).addClass('hover');
		addCache("location", $(this).attr('ref'))
	};
	submitData()
});
$("#_pageFirst").bind('click',
function() {
	var page = parseInt($("#_pageIndex").val());
	if (page > 1) {
		$("#_pageIndex").val(1);
		submitData()
	}
});
$("#_pagePrev").bind('click',
function() {
	var page = parseInt($("#_pageIndex").val());
	if (page > 1) {
		$("#_pageIndex").val(page - 1);
		submitData()
	}
});
$("#_pageGo").bind('click',
function() {
	submitData()
});
$(".lz_page span a").live('click',
function() {
	var totalpage = parseInt($("#_totalPage").html());
	var page = parseInt($(this).html());
	if (page <= totalpage) {
		$("#_pageIndex").val(page);
		submitData()
	}
});
$("#_pageNext").bind('click',
function() {
	var totalpage = parseInt($("#_totalPage").html());
	var page = parseInt($("#_pageIndex").val());
	if (page < totalpage) {
		$("#_pageIndex").val(page + 1);
		submitData()
	}
});
$("#_pageLast").bind('click',
function() {
	var totalpage = parseInt($("#_totalPage").html());
	var page = parseInt($("#_pageIndex").val());
	if (page < totalpage) {
		$("#_pageIndex").val(totalpage);
		submitData()
	}
});
function submitData() {
	$("#_textLoading").html('<span class="lz_loading">正在为您检索裸钻信息...</span>');
	$("#_mainLoading").show();
	if (parseInt($.browser.version) == 6) {
		$("#_mainLoading").css('height', '680px')
	};
	$.getJSON("/luozuan/ajax.php", buildParams(),
	function(data) {
		$("#_mainLoading").hide();
		$("#_textLoading").html('<span class="filter_price">为您筛选出<b>'+data.total+'</b>颗钻石</span>');
		$("#_dataHead").nextAll().remove();
		$("#_dataHead").after(data.rows);
		$("#_pageIndex").val(data.page);
		$("#_pageSize").html(data.pagesize);
		$("#_totalPage").html(data.totalpage);
		$(".lz_page span").html(data.page_list);
		$("#_dataResult tr").not('.thd').hover(function() {
			$(this).find('td').css('backgroundColor', '#F8C8C5');
			$('#_toolTip').show();
			$("#_tooltipCon").html('<li class="loading"><img src="/luozuan/static/images/loading2.gif" /></li>');
			$('#_toolTip').css('marginTop', '0px');
			var diff = $(this).offset().top - $('.lz_tip').offset().top;
			$('#_toolTip').css('marginTop', (diff - 134) + 'px');
			$.post("/luozuan/ajax.php", {
				action: 'tip',
				goods_id: $(this).attr('ref')
			},
			function(result) {
				$("#_tooltipCon").html(result)
			})
		},
		function() {
			$(this).find('td').css('backgroundColor', '')
		})
	   $("#_dataResult tr").not('.thd').each(function(){
		   $(this).find('td').slice(1,11).addClass('pointer').click(function() {
			window.open("/goods.php?id="+$(this).closest('tr').attr('ref'));
			})
	   });
	});
	
};
function buildParams() {
	var obj = new Object();
	if (getCache('orderway')) obj.orderway = getCache('orderway');
	if (getCache('orderby')) obj.orderby = getCache('orderby');
	if (getCache('shape')) obj.shape = getCache('shape');
	if (getCache('cut')) obj.cut = getCache('cut');
	if (getCache('color')) obj.color = getCache('color');
	if (getCache('clarity')) obj.clarity = getCache('clarity');
	if (getCache('polish')) obj.polish = getCache('polish');
	if (getCache('symmetry')) obj.symmetry = getCache('symmetry');
	if (getCache('cert')) obj.cert = getCache('cert');
	if (getCache('location')) obj.location = getCache('location');
	if (getCache('fluorescence')) obj.fluorescence = getCache('fluorescence');
	if ($("#minWeight").val() && $("#minWeight").val()!='请输入钻重') obj.minweight = $("#minWeight").val();
	if ($("#maxWeight").val() && $("#maxWeight").val()!='请输入钻重') obj.maxweight = $("#maxWeight").val();
	if ($("#minPrice").val() && $("#minPrice").val()!='请输入价格') obj.minprice = $("#minPrice").val();
	if ($("#maxPrice").val() && $("#maxPrice").val()!='请输入价格') obj.maxprice = $("#maxPrice").val();
	if ($("#certNo").val() && $("#certNo").val()!='') obj.certno = $("#certNo").val();
	if ($("#sn").val() && $("#sn").val()!='') obj.sn = $("#sn").val();
	if ($("#_pageIndex").val()) obj.page = $("#_pageIndex").val();
	if (ztid>0) obj.ztid = ztid;
	if (xk) obj.xk = xk;
	return obj
};
$(function(){
	
if(shapes){addCache("shape", shapes)}
submitData();

$("#searcKey a").click(function(){
		clearCache();blurReset();
		$(this).css({"background-color":"#ccc"}).siblings().css({"background-color":"#fff"});
		var query = $.evalJSON(this.getAttribute("rel"));
		var key,values;
		var i = 0;
		var count = 0;
		
		for(key in query)
		{
			values = query[key].split(",");
			
			switch(key)
			{
				case "shape":
				case "color":
				case "clarity":
				case "cut":
				case "polish":
				case "symmetry":
				case "cert":
				case "location":
				{
					i = 0;
					count = values.length;
					for(i;i < count;i++)
					{
						if(values[i] != '')
						{
							if(key == 'shape'){
							$(".bsil-body li[rel='"+values[i]+"']").addClass("hover");
							}else{
							$(".lz_s_detail li[rel='"+values[i]+"'] a").addClass("hover");
							}
							addCache(key, values[i])
						}
					}
				}
				break;
				
				case "weights":
				{
					$("#minWeight").val(values[0]);
					$("#maxWeight").val(values[1]);
				}
				break;
				
				case "prices":
				{
					$("#minPrice").val(values[0]);
					$("#maxPrice").val(values[1]);
				}
				break;
			}
		}
		submitData();
	});
});
