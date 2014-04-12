Ext.onReady(function(){

	Ext.BLANK_IMAGE_URL = 'scripts/ext-3.1.1/resources/images/default/s.gif';
	
    var Product = Ext.data.Record.create([
	{name: 'id'},
    {
        name: 'name',
        type: 'string'
    }, {
        name: 'productId',
        type: 'string'
    }, {
        name: 'price',
        type: 'string'
    }, {
        name: 'date',
        type: 'date',
        dateFormat: 'm/d/Y'
    }]);
    
    var proxy = new Ext.data.HttpProxy({
        api: {
            read : 'ajax/getSalesOrderJSON.action',
            create : 'ajax/ajaxsaveSalesOrderJSON.action',
            update: 'ajax/ajaxsaveSalesOrderJSON.action',
            destroy: 'ajax/ajaxsaveSalesOrderJSON.action'
        }
    });
    
    var reader = new Ext.data.JsonReader({
        totalProperty: 'total',
        successProperty: 'success',
        idProperty: 'id',
        root: 'data',
        messageProperty: 'message'  // <-- New "messageProperty" meta-data
    }, 
    Product);

 // The new DataWriter component.
    var writer = new Ext.data.JsonWriter({
        encode: true,
        writeAllFields: false
    });
    
 // Typical Store collecting the Proxy, Reader and Writer together.
    var store = new Ext.data.Store({
        id: 'user',
        proxy: proxy,
        reader: reader,
        writer: writer,  // <-- plug a DataWriter into the store just as you would a Reader
        autoSave: false // <-- false would delay executing create, update, destroy requests until specifically told to do so with some [save] buton.
    });

    //read the data from simple array
    store.load();
    
    Ext.data.DataProxy.addListener('exception', function(proxy, type, action, options, res) {
    	Ext.Msg.show({
    		title: 'Saved',
    		msg: res.message,
    		icon: Ext.MessageBox.ERROR,
    		buttons: Ext.Msg.OK
    	});
    });

    
    var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
    });
    

    // create grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {header: "PRODUCT NAME",
             width: 170,
             sortable: true,
             dataIndex: 'name',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }},
            {header: "PRODUCT ID",
             width: 150,
             sortable: true,
             dataIndex: 'productId',
             editor: {
                 xtype: 'textfield',
                 allowBlank: false
            }},
            {header: "PRICE",
             width: 150,
             sortable: true,
             dataIndex: 'price',
             editor: {
                xtype: 'textfield',
                allowBlank: false
            }},
            {header: "DATE",
             width: 100,
             sortable: true,
             dataIndex: 'date',
             renderer: Ext.util.Format.dateRenderer('m/d/Y'),
             editor: new Ext.form.DateField ({
                allowBlank: false,
                format: 'm/d/Y',
                maxValue: (new Date())
            })}
        ],
        plugins: [editor,Ext.ux.grid.DataDrop],
        title: 'SALES ORDER',
        height: 300,
        width:610,
		frame:true,
		tbar: [{
            iconCls: 'icon-user-add',
            text: 'Add Sales Order',
            handler: function(){
                var e = new Product({
                    name: 'Product A',
                    productId: '123456',
                    price: '123',
                    date: '01/01/2014'
                });
                editor.stopEditing();
                store.insert(0, e);
                grid.getView().refresh();
                grid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },{
            iconCls: 'icon-user-delete',
            text: 'Remove Sales Order',
            handler: function(){
                editor.stopEditing();
                var s = grid.getSelectionModel().getSelections();
                for(var i = 0, r; r = s[i]; i++){
                    store.remove(r);
                }
            }
        },{
            iconCls: 'icon-user-save',
            text: 'Save All Modifications',
            handler: function(){
                grid.getView().refresh();
                store.save();
            }
        }]
    });

    //render to DIV
    grid.render('crud-grid');
});