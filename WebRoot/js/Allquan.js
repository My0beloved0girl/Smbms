layui.config({
    base: 'layui/'
}).extend({
    treeTable:'treeTable'
}).use(['layer','table', 'treeTable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treeTable = layui.treeTable;
        var layer = layui.layer;
        
        // 渲染表格
		var insTb = treeTable.render({
            elem: '#test',
            url: 'http://localhost:8080/Smbms/Quan',
            toolbar: '#btn',
            height: 'full-115',
            tree: {
                iconIndex: 2,           // 折叠图标显示在第几列
                isPidData: true,        // 是否是id、pid形式数据
                idName: 'mid',  // id字段名称
                pidName: 'mfid'    // pid字段名称
            },
            cols: [[
            	{field: 'mid', title: '权限编号',width:10},
                {type: 'radio'},
                {field: 'mname', title: '权限名称'},
               /* {field: 'mbtn', title: '权限标识'},
                {field: 'murl', title: '权限路径'},*/
                {field: 'mtype', width: 80, align: 'center', title: '类型', templet: function (d) {
                        if (d.mtype == 2) {
                            return '<span class="layui-badge layui-bg-orange">按钮</span>';
                        }
                        if (d.mtype == 1) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } if (d.mtype == 0) {
                            return '<span class="layui-badge layui-bg-green">菜单</span>';
                        }
                }}
            ]]
        });
		
		//监听工具栏
		treeTable.on('toolbar(test)', function(obj){
			
		    switch(obj.event){
		      case 'btn-expand':	//全部展开
		    	  insTb.expandAll('#test');
		      break;
		      
		      case 'btn-fold':	//全部折叠
		    	  insTb.foldAll('#test');
		      break;
		      
		      case 'btn-add':	//新增权限
		    	  /*layer.open({
		        		title : "添加权限",
		        		type : 2,
		        		content : "common/pop/menuAdd.jsp",
		        		area:['660px','760px'],
		    	  })*/
		      break;
		      
		      case 'btn-update':	//修改权限
					updataMenu();
		      break;
			        
		      case 'btn-delete':	//删除权限
					delMenu();
		      break;
		    };
		 });
		
	   //---------删除权限-------
		function delMenu(){
	    	var menuid = '';
	    	JSON.stringify(insTb.checkStatus().map(function (d) {
	    		menuid = d.mid;
	        }));
	    	if(menuid == null || menuid == ""){
	    		layer.msg("请选中一个节点进行删除");
	    	}else{
	    		$.ajax({
	    			url:"/Smbms/MenuDelete",
	    			data:{"id":menuid},
	    			type:"post",
	    			dataType:"json",
	    			success:function(data){
	    				alert(data);
	    				var info = eval("("+data+")");
	    				if(data == 1){
	    					layer.msg("删除成功");
	    					insTb.reload();
	    				}else{
	    					layer.msg("删除失败");
	    				}
	    			}
	    		})
	    	}
	    }

		/*
		 * {"id":27,"isdelete":0,"mbtn":"<button type=\"button\" lay-event=\"shangFunc\" class=\"layui-btn layui-btn-radius xz\"><i class=\"layui-icon\"></i>上传</button>","mfatherid":4,"mname":"上传","type":3}
		 */
       /*---------修改权限------*/
        function updataMenu(){
        	var id = '';
        	JSON.stringify(insTb.checkStatus().map(function (d) {
        		id = d.mid;
            }));
        	if(id == null || id==""){
        		layer.msg('请选择一个进行修改');
        	}else{
        		layer.open({
              		 type:2,
              		 title:"修改权限",
              		 area:['800px','700px'],
              		 content:"MenuUpdate.jsp",
              		 success:function(layero, index){
              			 $.post("/Smbms/Echo",{"mid":id},function(data){
              				var info = eval('(' + data + ')');
              				var body = layui.layer.getChildFrame('body', index);
              				body.find("#mid").val(info[0].mid);
              				body.find("#mname").val(info[0].mname);  //权限名
              				body.find("#mfid").val(info[0].mfid);	//请求路径
              				body.find("#murl").val(info[0].murl);
              				var select = 'dd[lay-value='+(info[0].mtype+1)+']';
              				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
              				body.find("#NowbtnType").html(info[0].mbtn);	//按钮
              				body.find("#mbtn").val(info[0].mbtn);		//按钮代码
              				var menuid3 = info[0].mfid;
              				//上级的下拉框
                 			$.post("MenuServlet?action=allMenuById",{"menuid":menuid3},function(res){
                 			   var result = eval('(' + res + ')');
     		                   body.find("#fatherType2").val(result.mname);
                 			})
                 			 
              			 })
                	}
          	    })
        	}
        };
});