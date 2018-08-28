var compare = new Object();
var goodsdata = new Object();
var button_compare = '';

compare = {
	add: function(inputobj, goodsId, goodsName, type) {
		if (inputobj.checked) {
			var count = 0;
			for (var k in goodsdata) {
				if (typeof(goodsdata[k]) == "function") continue;
				if (goodsdata[k].t != type) {
					alert(goodsName+'����ѡ����Ʒ���Ͳ�ͬ�޷����жԱ�');
					return;
				}
				count++;
			}

			if (goodsdata[goodsId]) {
				alert('���Ѿ�ѡ����'+goodsName);
				return;
			} else {
				goodsdata[goodsId] = {
					n: "����" + goodsName,
					t: type
				};
			}

			this.init();
		} else {
			document.getElementById("compareList").removeChild(document.getElementById("wws" + goodsId));
			delete goodsdata[goodsId];
			this.init();
		}
	},
	relocation: function() {
		if (this.compareBox.style.display != "") return;
		var diffY = Math.max(document.documentElement.scrollTop, document.body.scrollTop);

		var percent = .2 * (diffY - this.lastScrollY);
		if (percent > 0) percent = Math.ceil(percent);
		else percent = Math.floor(percent);
		this.compareBox.style.top = parseInt(this.compareBox.style.top) + percent + "px";

		this.lastScrollY = this.lastScrollY + percent;
	},
	init: function() {

		if (!this.compareBox) {
			this.compareBox = document.createElement("DIV");
			var submitBtn = document.createElement("INPUT");
			this.compareList = document.createElement("UL");
			this.compareBox.id = "compareBox";
			this.compareBox.style.display = "none";
			this.compareBox.style.top = "50px";
			this.compareBox.align = "center";
			this.compareList.id = "compareList";
			if (window.innerWidth)
			winWidth = window.innerWidth;
			else if ((document.body) && (document.body.clientWidth))
			winWidth = document.body.clientWidth;

		    this.compareBox.style.left =(winWidth-982)/2-160+'px';
			submitBtn.type = "button";
			submitBtn.value = button_compare;
			this.compareBox.appendChild(this.compareList);
			this.compareBox.appendChild(submitBtn);
			submitBtn.onclick = function() {
				var obj = goodsdata;
				var url = document.location.href;
				//url = url.substring(0,url.lastIndexOf('/')+1) + "compare.php";
				url = "/compare.php";
				var i = 0;
				for (var k in obj) {
					if (typeof(obj[k]) == "function") continue;
					if (i == 0) url += "?goods[]=" + k;
					else url += "&goods[]=" + k;
					i++;
				}
				if (i < 2) {
					alert('��û��ѡ���κ���Ҫ�Ƚϵ���Ʒ���߱Ƚϵ���Ʒ������ 2 ��');
					return;
				}
				document.location.href = url;
			}
			document.body.appendChild(this.compareBox);
		}
		this.compareList.innerHTML = "";

		var self = this;
		for (var key in goodsdata) {
			if (typeof(goodsdata[key]) == "function") continue;
			var li = document.createElement("LI");
			li.id = "wws" + key;
			var span = document.createElement("SPAN");
			span.style.width = "100px";
			span.style.height = "20px";
			span.style.display = "block";
			span.innerHTML = goodsdata[key].n;
			li.appendChild(span);
			li.style.listStyle = "none";
			var delBtn = document.createElement("IMG");
			delBtn.src = "/themes/lzmb/images/drop.gif";
			delBtn.className = key;
			delBtn.onclick = function() {
				document.getElementById("compareList").removeChild(this.parentNode);
				delete goodsdata[this.className];
				self.init();
			}

			li.insertBefore(delBtn, li.childNodes[0]);
			this.compareList.appendChild(li);
		}
		if (this.compareList.childNodes.length > 0) {
			this.compareBox.style.display = "";
			this.timer = window.setInterval(this.relocation.bind(this), 50);
		} else {
			this.compareBox.style.display = "none";
			window.clearInterval(this.timer);
			this.timer = 0;
		}
	},
	lastScrollY: 0
}
//�����
Function.prototype.bind = function(object) {
	var __method = this;
	return function() {
		__method.apply(object, arguments);
	}
}