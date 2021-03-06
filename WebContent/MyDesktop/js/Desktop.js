/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

/**
 * @class Ext.ux.desktop.Desktop
 * @extends Ext.panel.Panel
 * <p>This class manages the wallpaper, shortcuts and taskbar.</p>
 */
Ext.define('Ext.ux.desktop.Desktop', {
    extend: 'Ext.panel.Panel',
	
    alias: 'widget.desktop',
    uses: [
        'Ext.util.MixedCollection',
        'Ext.menu.Menu',
        'Ext.view.View', // dataview
        'Ext.window.Window',

        'Ext.ux.desktop.TaskBar',
        'Ext.ux.desktop.Wallpaper'
    ],

    activeWindowCls: 'ux-desktop-active-win',
    inactiveWindowCls: 'ux-desktop-inactive-win',
    lastActiveWindow: null,

    border: false,
    html: '&#160;',
    layout: 'fit',

    xTickSize: 1,
    yTickSize: 1,

    app: null,

    /**
     * @cfg {Array|Store} shortcuts
     * The items to add to the DataView. This can be a {@link Ext.data.Store Store} or a
     * simple array. Items should minimally provide the fields in the
     * {@link Ext.ux.desktop.ShorcutModel ShortcutModel}.
     */
    shortcuts: null,

    /**
     * @cfg {String} shortcutItemSelector
     * This property is passed to the DataView for the desktop to select shortcut items.
     * If the {@link #shortcutTpl} is modified, this will probably need to be modified as
     * well.
     */
    shortcutItemSelector: 'div.ux-desktop-shortcut',

    /**
     * @cfg {String} shortcutTpl
     * This XTemplate is used to render items in the DataView. If this is changed, the
     * {@link shortcutItemSelect} will probably also need to changed.
     */
    shortcutTpl: [
        '<tpl for=".">',
            '<div class="ux-desktop-shortcut" id="{text}-shortcut">',
                '<div class="ux-desktop-shortcut-icon style:\"background-image:{bigIcon}\"">',
                    '<img src="{bigIcon}" title="{text}">',
                '</div>',
                '<span class="ux-desktop-shortcut-text">{text}</span>',
            '</div>',
        '</tpl>',
        '<div class="x-clear"></div>'
    ],

    /**
     * @cfg {Object} taskbarConfig
     * The config object for the TaskBar.
     */
    taskbarConfig: null,

    windowMenu: null,

    initComponent: function () {
        var me = this;

        me.windowMenu = new Ext.menu.Menu(me.createWindowMenu());

        me.bbar = me.taskbar = new Ext.ux.desktop.TaskBar(me.taskbarConfig);
        me.taskbar.windowMenu = me.windowMenu;

        me.windows = new Ext.util.MixedCollection();

        me.contextMenu = new Ext.menu.Menu(me.createDesktopMenu());

        me.items = [
            { xtype: 'wallpaper', id: me.id+'_wallpaper' },
            me.createDataView()
        ];

        me.callParent();

        me.shortcutsView = me.items.getAt(1);
        me.shortcutsView.on('itemclick', me.onShortcutItemClick, me);

        var wallpaper = me.wallpaper;
        me.wallpaper = me.items.getAt(0);
        if (wallpaper) {
            me.setWallpaper(wallpaper, me.wallpaperStretch);
        }
    },

    afterRender: function () {
        var me = this;
        me.callParent();
        me.el.on('contextmenu', me.onDesktopMenu, me);
    },

    //------------------------------------------------------
    // Overrideable configuration creation methods

    createDataView: function () {
        var me = this;
        return {
            xtype: 'dataview',
            overItemCls: 'x-view-over',
            trackOver: true,
            itemSelector: me.shortcutItemSelector,
            store: me.shortcuts,
            style: {
                position: 'absolute'
            },
            //换行的改动
             listeners:{
             	 viewready:me.initShortcut,
                 resize:me.initShortcut
             },
            x: 0, y: 0,
            tpl: new Ext.XTemplate(me.shortcutTpl)
        };
    },

    createDesktopMenu: function () {
        var me = this, ret = {
            items: me.contextMenuItems || []
        };

        if (ret.items.length) {
            ret.items.push('-');
        }

        ret.items.push(
                { text: '平铺排放', handler: me.tileWindows, scope: me, minWindows: 1 },
                { text: '折叠排放', handler: me.cascadeWindows, scope: me, minWindows: 1 })

        return ret;
    },

    createWindowMenu: function () {
        var me = this;
        return {
            defaultAlign: 'br-tr',
            items: [
                { text: '显示', handler: me.onWindowMenuRestore, scope: me },
                { text: '最小化', handler: me.onWindowMenuMinimize, scope: me },
                { text: '最大化', handler: me.onWindowMenuMaximize, scope: me },
                '-',
                { text: '关闭', handler: me.onWindowMenuClose, scope: me }
            ],
            listeners: {
                beforeshow: me.onWindowMenuBeforeShow,
                hide: me.onWindowMenuHide,
                scope: me
            }
        };
    },

    //------------------------------------------------------
    // Event handler methods

    onDesktopMenu: function (e) {
        var me = this, menu = me.contextMenu;
        e.stopEvent();
        if (!menu.rendered) {
            menu.on('beforeshow', me.onDesktopMenuBeforeShow, me);
        }
        menu.showAt(e.getXY());
        menu.doConstrain();
    },

    onDesktopMenuBeforeShow: function (menu) {
        var me = this, count = me.windows.getCount();

        menu.items.each(function (item) {
            var min = item.minWindows || 0;
            item.setDisabled(count < min);
        });
    },

    onShortcutItemClick: function (dataView, record) {
    	/**
    	 * 做自己想做的事情，提升速度的关键
    	 */
    	var me = this;
    	var win=null;
    	var desktopUtil=Ext.create("core.util.DesktopUtil");
 		var items={};
 		var id=record.get("id")+"_win";
 		var width=comm.get("resolutionWidth")*0.7;
 		var height=comm.get("resolutionHeight")*0.7;
        if(record.get("nodeInfoType")=="MENU"){
        	id="folderview_win";
        	width=comm.get("resolutionWidth")*0.5;
        	height=comm.get("resolutionHeight")*0.4;
        }
        win=me.getWindow(id);//不再用Ext.getCmp()
        if(win && me.taskbar.getTaskButton(win.taskButton) && record.get("nodeInfoType")=="MENU"){
        	desktopUtil.loadFolderData(record,win,me);
        	return;
        }
        if(!win){
	        items=desktopUtil.getMenuItems(record,me);
        	var options={
				 title: record.data.text,
	             width: width,
	             height: height,
	             icon: record.get("icon"),
	             id:id,
	             border: false,
	             nodeId:record.data.id,
	             hideMode: 'offsets',
	             layout:"fit",
	             items:items
			};
			if(record.get("nodeInfoType")=="MENU"){
				options=Ext.apply(options,{
					tbar:[{
						xtype:"button",
						text:"<b>"+record.data.text+"</b>",
						handler:function(btn){
							while(btn.nextSibling()){
								btn.ownerCt.remove(btn.nextSibling());
							}
							desktopUtil.loadFolderData(record,win,me);
						}
					}]
				})
			}
			win=me.createWindow(options);
        }else if(win){
        	if(record.get("nodeInfoType")=="MENU"){
        		desktopUtil.loadFolderData(record,win,me);
        	}
        }
        if (win) {
        	// 任务栏菜单处理
        	if(!me.taskbar.getTaskButton(win.taskButton)){
        		me.addTaskButton(win);
        	}
        	win.show();
//            me.restoreWindow(win);
        }
    },

    onWindowClose: function(win) {
        var me = this;
//        me.windows.remove(win);
        win.hide();
        me.taskbar.removeTaskButton(win.taskButton);
        me.updateActiveWindow();
    },
    //添加任务菜单
	addTaskButton:function(win){
		var me=this;
		win.taskButton = me.taskbar.addTaskButton(win);
        win.animateTarget = win.taskButton.el;
	},
    //------------------------------------------------------
    // Window context menu handlers

    onWindowMenuBeforeShow: function (menu) {
        var items = menu.items.items, win = menu.theWin;
        items[0].setDisabled(win.maximized !== true && win.hidden !== true); // Restore
        items[1].setDisabled(win.minimized === true); // Minimize
        items[2].setDisabled(win.maximized === true || win.hidden === true); // Maximize
    },

    onWindowMenuClose: function () {
        var me = this, win = me.windowMenu.theWin;

        win.close();
    },

    onWindowMenuHide: function (menu) {
        menu.theWin = null;
    },

    onWindowMenuMaximize: function () {
        var me = this, win = me.windowMenu.theWin;

        win.maximize();
        win.toFront();
    },

    onWindowMenuMinimize: function () {
        var me = this, win = me.windowMenu.theWin;

        win.minimize();
    },

    onWindowMenuRestore: function () {
        var me = this, win = me.windowMenu.theWin;

        me.restoreWindow(win);
    },

    //------------------------------------------------------
    // Dynamic (re)configuration methods

    getWallpaper: function () {
        return this.wallpaper.wallpaper;
    },

    setTickSize: function(xTickSize, yTickSize) {
        var me = this,
            xt = me.xTickSize = xTickSize,
            yt = me.yTickSize = (arguments.length > 1) ? yTickSize : xt;

        me.windows.each(function(win) {
            var dd = win.dd, resizer = win.resizer;
            dd.xTickSize = xt;
            dd.yTickSize = yt;
            resizer.widthIncrement = xt;
            resizer.heightIncrement = yt;
        });
    },

    setWallpaper: function (wallpaper, stretch) {
        this.wallpaper.setWallpaper(wallpaper, stretch);
        return this;
    },

    //------------------------------------------------------
    // Window management methods

    cascadeWindows: function() {
        var x = 0, y = 0,
            zmgr = this.getDesktopZIndexManager();

        zmgr.eachBottomUp(function(win) {
            if (win.isWindow && win.isVisible() && !win.maximized) {
                win.setPosition(x, y);
                x += 20;
                y += 20;
            }
        });
    },
	//创建窗体
    createWindow: function(config, cls) {
        var me = this, win, cfg = Ext.applyIf(config || {}, {
                stateful: false,
                isWindow: true,
                constrainHeader: true,
                minimizable: true,
                maximizable: true,
                closeAction:"hide" //el is null的解决方法
            });

        cls = cls || Ext.window.Window;
        win = me.add(new cls(cfg));
        //windows是键值对集合    id为key，win为value
        me.windows.add(win.id,win);
        win.on({
            activate: me.updateActiveWindow,
            beforeshow: me.updateActiveWindow,
            deactivate: me.updateActiveWindow,
            minimize: me.minimizeWindow,
//            destroy: me.onWindowClose,
            beforeclose:me.onWindowClose,
            scope: me
        });

        win.on({
            boxready: function () {
                win.dd.xTickSize = me.xTickSize;
                win.dd.yTickSize = me.yTickSize;

                if (win.resizer) {
                    win.resizer.widthIncrement = me.xTickSize;
                    win.resizer.heightIncrement = me.yTickSize;
                }
            },
            single: true
        });

        // replace normal window close w/fadeOut animation:
        //取代正常的窗口关闭
//        win.doClose = function ()  {
//            win.doClose = Ext.emptyFn; // dblclick can call again...
//            win.el.disableShadow();
//            win.el.fadeOut({
//                listeners: {
//                	//动画结束之后
//                    afteranimate: function () {
//                        win.destroy();
//                    }
//                }
//            });
//        };
		
        return win;
    },

    getActiveWindow: function () {
        var win = null,
            zmgr = this.getDesktopZIndexManager();

        if (zmgr) {
            // We cannot rely on activate/deactive because that fires against non-Window
            // components in the stack.

            zmgr.eachTopDown(function (comp) {
                if (comp.isWindow && !comp.hidden) {
                    win = comp;
                    return false;
                }
                return true;
            });
        }

        return win;
    },

    getDesktopZIndexManager: function () {
        var windows = this.windows;
        // TODO - there has to be a better way to get this...
        return (windows.getCount() && windows.getAt(0).zIndexManager) || null;
    },

    getWindow: function(id) {
        return this.windows.get(id);
    },

    minimizeWindow: function(win) {
        win.minimized = true;
        win.hide();
    },

    restoreWindow: function (win) {
        if (win.isVisible()) {
            win.restore();
            win.toFront();
        } else {
            win.show();
        }
        return win;
    },

    tileWindows: function() {
        var me = this, availWidth = me.body.getWidth(true);
        var x = me.xTickSize, y = me.yTickSize, nextY = y;

        me.windows.each(function(win) {
            if (win.isVisible() && !win.maximized) {
                var w = win.el.getWidth();

                // Wrap to next row if we are not at the line start and this Window will
                // go off the end
                if (x > me.xTickSize && x + w > availWidth) {
                    x = me.xTickSize;
                    y = nextY;
                }

                win.setPosition(x, y);
                x += w + me.xTickSize;
                nextY = Math.max(nextY, y + win.el.getHeight() + me.yTickSize);
            }
        });
    },

    updateActiveWindow: function () {
        var me = this, activeWindow = me.getActiveWindow(), last = me.lastActiveWindow;
        if (activeWindow === last) {
            return;
        }

        if (last) {
            if (last.el.dom) {
                last.addCls(me.inactiveWindowCls);
                last.removeCls(me.activeWindowCls);
            }
            last.active = false;
        }

        me.lastActiveWindow = activeWindow;

        if (activeWindow) {
            activeWindow.addCls(me.activeWindowCls);
            activeWindow.removeCls(me.inactiveWindowCls);
            activeWindow.minimized = false;
            activeWindow.active = true;
        }

        me.taskbar.setActiveButton(activeWindow && activeWindow.taskButton);
    },
    initShortcut : function() {
         var btnHeight = 64;
         var btnWidth = 64;
         var btnPadding = 30;
         var col = {index : 1,x : btnPadding};
         var row = {index : 1,y : btnPadding};
         var bottom;
         var numberOfItems = 0;
         var taskBarHeight = Ext.query(".ux-taskbar")[0].clientHeight + 40;
         var bodyHeight = Ext.getBody().getHeight() - taskBarHeight;
         var items = Ext.query(".ux-desktop-shortcut");

         for (var i = 0, len = items.length; i < len; i++) {
             numberOfItems += 1;
             bottom = row.y + btnHeight;
             if (((bodyHeight < bottom) ? true : false) && bottom > (btnHeight + btnPadding)) {
                 numberOfItems = 0;
                 col = {index : col.index++,x : col.x + btnWidth + btnPadding};
                 row = {index : 1,y : btnPadding};
             }
             Ext.fly(items[i]).setXY([col.x, row.y]);
             row.index++;
             row.y = row.y + btnHeight + btnPadding;
         }
     }

});
