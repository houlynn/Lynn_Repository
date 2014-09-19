Ext.define("core.rbac.role.view.MainLayout",{
	extend:"Ext.panel.Panel",
	alias : 'widget.role.mainlayout',
	layout : 'border',
	items : [{		
		width:comm.get("clientWidth")*0.18,
		region:"west",
		items:[{
			xtype:"role.roletree",
			height:comm.get("resolutionHeight")*0.3
		},{
			xtype:"role.moduletree",
			height:comm.get("resolutionHeight")*0.4
		}]
	},{
		xtype:"role.centerlayout",
		region:"center"
	}]
})