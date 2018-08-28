function ListTable()
{
	this.filter = new Object();
	this.url;
	this.pageSize;
	this.pageSizeText;
	this.pageCount;
	this.listID;
	this.resultFun;
	this.loadFun;
	var LT=this;

	this.SortOrder = function(sort_by,sort_order)
	{
		if (this.filter.sort_by == sort_by)
		{
			this.filter.sort_order = this.filter.sort_order == "DESC" ? "ASC" : "DESC";
		}
		else
		{
			this.filter.sort_order = "DESC";
		}
		this.filter.sort_by = sort_by;
		this.filter.page_size = this.GetPageSize();
		
		this.LoadList();
	}
	
	this.GetPageSize = function()
	{
		pageSize = document.getElementById(this.pageSize);
		
		if (pageSize)
			return Utils.isInt(pageSize.value) ? pageSize.value : 20;
		else
			return this.filter.page_size;
	}
	
	this.GotoPage = function(page)
	{
		if(page != null)
			this.filter['page'] = page;
	
		if (this.filter['page'] > this.pageCount)
			this.filter['page'] = 1;
	
		this.filter['page_size'] = this.GetPageSize();

		this.LoadList();
	}
	
	this.LoadList = function()
	{
		if(this.loadFun)
		   this.loadFun.call(this);

		jQuery.ajax({
			url: this.url,
			cache: false,
			data:{"filter":this.filter},
			dataType:'json',
			ajaxStart:function(){},
			success:function(data){
				LT.filter = data.filter;
				LT.pageCount = data.page_count;
				
				if(LT.resultFun)
				{
				   LT.resultFun.call(LT,data);
				}
			}
		});
	}
	
	this.GotoPageFirst = function()
	{
		if (this.filter.page > 1)
		{
			this.GotoPage(1);
		}
	}
	
	this.GotoPagePrev = function()
	{
		if (this.filter.page > 1)
		{	
			this.GotoPage(this.filter.page - 1);
		}
	}
	
	this.GotoPageNext = function()
	{
		if (this.filter.page < this.pageCount)
		{
			this.GotoPage(parseInt(this.filter.page) + 1);
		}
	}
	
	this.GotoPageLast = function()
	{
		if (this.filter.page < this.pageCount)
		{
			this.GotoPage(this.pageCount);
		}
	}
	
	this.ChangePageSize = function(e)
	{
		var evt = Utils.fixEvent(e);
		if (evt.keyCode == 13)
		{
			this.GotoPage();
			return false;
		};
	}
}
