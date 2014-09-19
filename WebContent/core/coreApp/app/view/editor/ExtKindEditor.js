Ext.define("core.app.view.editor.ExtKindEditor",{
		extend : 'Ext.form.field.TextArea',
		alias : 'widget.extkindeditor',
		initComponent : function() {
			this.html = "<textarea id='" + this.getId() + "-input' name='" + this.name + "'></textarea>";
			this.callParent(arguments);
			var self=this;
			this.inputEL = Ext.get(this.getId() + "-input");
			this.on("boxready", function(t) {
				this.inputEL = Ext.get(this.getId() + "-input");
				this.editor = KindEditor.create('textarea[name="' + this.name + '"]', {
					width : t.getWidth()+4,
					height : t.getHeight()-4,
					cssPath : '../plugins/code/prettify.css',
					uploadJson : '../jsp/upload_json.jsp',
					fileManagerJson : '../jsp/file_manager_json.jsp',
					allowFileManager : true,
					afterCreate : function() {
					}
			
					/*items : ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste', 'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'flash', 'media', 'table', 'hr', 'emoticons', 'pagebreak', 'anchor', 'link', 'unlink']*/
				});
			});
			this.on("resize",function(t,w,h){
				this.editor.resize(w+4,h-4)
				
			});
		},
		setValue : function(value) {
			if (this.editor) {
				this.editor.html(value);
			}
		},
		reset : function() {
			if (this.editor) {
				this.editor.html('');
			}
		},
		setRawValue : function(value) {
			if (this.editor) {
				this.editor.text(value);
			}
		},
		getValue : function() {
			if (this.editor) {
				return this.editor.html();
			} else {
				return ''
			}
		},
		getRawValue : function() {
			if (this.editor) {
				return this.editor.text();
			} else {
				return ''
			}
		}
	
	});

;