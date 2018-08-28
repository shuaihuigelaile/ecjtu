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
	$("#_pageIndex").val(1);
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
	$("#minWeight").val('0.2');
	$("#maxWeight").val('1.2');
	$("#_weight").attr('value', '0;5');
	$("#minPrice").val('0');
	$("#maxPrice").val('100000');
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
	$(".auto font").html('...');
	$("#_mainLoading").show();
	if (parseInt($.browser.version) == 6) {
		$("#_mainLoading").css('height', '680px')
	};
	$.getJSON("/ajax.php", buildParams(),
	function(data) {
		$("#_mainLoading").hide();
		$(".auto font").html(data.total);
		$("#_dataHead").nextAll().remove();
		$("#_dataHead").after(data.rows);
		$("#_pageIndex").val(data.page);
		$("#_pageSize").html(data.pagesize);
		$("#_totalPage").html(data.totalpage);
		$(".lz_page span").html(data.page_list);

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
	if (goodsID>0) obj.goodsid = goodsID;

	return obj
};
$(function(){

submitData();

});
