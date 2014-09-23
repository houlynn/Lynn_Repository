Ext.define("core.${dist}.view.${className}Form", {
	extend : "core.app.base.BaseForm",
	alias : "widget.${className?uncap_first}Form",
	items : [ {
		fieldLabel : "主键",
		name : "productId",
		hidden : true
	}, {
		name : "code",
		fieldLabel : "编码"
	}, {
		name : "productName",
		fieldLabel : "参考仓位"
	}, {
		name : "unit",
		fieldLabel : "单位"
	}, , {
		name : "eachBoxBranch",
		fieldLabel : "支/每箱"
	}, {
		name : "maxStore",
		fieldLabel : "最高库存"
	}, {
		name : "eachBoxBranch",
		fieldLabel : "支/每箱"
	}, {
		name : "maxStore",
		fieldLabel : "最高库存"
	}, {
		name : "minStore",
		fieldLabel : "最小库存"
	}, {
		name : "IsStop",
		fieldLabel : "是否停产"
	}, {
		name : "yieldly",
		fieldLabel : "产地"
	}, {
		name : "retailPrice",
		fieldLabel : "零售价"
	}, {
		name : "erPiPrice",
		fieldLabel : "二批价"
	}, {
		name : "direSuppPrice",
		fieldLabel : "直供价"
	}, {
		name : "stockPrice",
		fieldLabel : "进货价"
	}, , {
		name : "MinimumPrice",
		fieldLabel : "最低价"
	}, , {
		name : "CurMarketingPrice",
		fieldLabel : "当前市场价"
	}, , {
		name : "retreatWinePrice",
		fieldLabel : "退酒价"
	}

	]
});