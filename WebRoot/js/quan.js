layui.use(['form','layer','laydate','table','laytpl','dtree'],function(){
		var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        form = layui.form,
        dtree = layui.dtree, layer = layui.layer, $ = layui.jquery,
        table = layui.table;
	

	window.Fen=function(userid){//分配权限
	//alert(userid);
		layui.layer.open({
			shade:0,
			title : "分配权限",
			type : 1,
			content : $('#fenpei'),
			area:['400px','450px'],
			success:function(){
				dtree.render({
					elem: "#demoTree",
					url: "/Smbms/Fen",
					dataStyle: "layuiStyle",  //使用layui风格的数据格式
					dataFormat: "list",  //配置data的风格为list
					response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
					checkbar:true,
					line: true,  // 显示树线
					done: function(res, $ul, first){
						$.ajax({
							url:"/Smbms/Quan",
							type:"post",
							data:{"userid":userid},
							success:function(res){
								var cs = eval('(' + res + ')');
								$.each(cs,function(index,rows){
									dtree.chooseDataInit("demoTree",[rows.menuid]); // 初始化选中
								})
							}
						})
					}
				});//dtree
			},
			btn:['分配权限'],
			yes: function(index, layero){
				var params = dtree.getCheckbarNodesParam("demoTree");
				var infos = JSON.stringify(params);
				var cs = eval('(' + infos + ')');
				var mList = new Array();	//所有选中值的权限id
				$.each(cs,function(index,row){
					mList[index] = row.nodeId;
				})
				$.ajax({
					url:"/Smbms/FenPei",
					data:{"arrayid":mList,"userid":userid},
					type:"post",
					traditional:true,
					success:function(data){
						//alert(data);
						var demo = eval('(' + data + ')');
						if(demo != 0){
							
							layer.msg("分配成功");
							layer.close("iframe")
							 setTimeout(function () {
								 parent.location.reload();
							}, 500);
						
						}else{
							layer.msg("分配失败");
						}// if
					}// yes - ajax - success
				})// yes - ajax
			}// yes
			
		});// layui.layer.open
	}// function


});