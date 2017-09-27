/**
 * 部门管理
 */
$(function(){
	$("#insert").click(function(){
		var departmentname = $("#departmentname").val();
		$.ajax({
			type : "POST",
			url : "InsertDepartmentServlet",
			data : {"departmentname" : departmentname},
			dataType : "json",
			success : function(data) {
				var inhtml = "<caption>所有部门:</caption><tr class='listheader'><th>部门编号</th><th>部门名称</th><th>操作</th></tr>";
				$.each(data,function(index,item){
					inhtml += "<tr><td>"+item.departmentid+"</td><td id='editdname'>"+item.departmentname+"</td><td><a class='clickbutton' id='edit'>编辑</a><a class='clickbutton' style='display:none' id='cancle'>取消</a> <a class='clickbutton' id='delete'>删除</a></td></tr>";
				});
				$(".listtable").html(inhtml);
				$("#departmentname").val("");
			},
			error:function(){
				alert("添加的部门名称有问题");
			}
		});
	});
});

function query(){
	$.ajax({
		type : "POST",
		url : "QueryDepartmentServlet",
		data : {},
		dataType : "json",
		success : function(data) {
			var inhtml = "<caption>所有部门:</caption><tr class='listheader'><th>部门编号</th><th>部门名称</th><th>操作</th></tr>";
			$.each(data,function(index,item){
				inhtml += "<tr><td id='did'>"+item.departmentid+"</td><td id='editdname'>"+item.departmentname+"</td><td><a class='clickbutton' id='edit'>编辑</a><a class='clickbutton' style='display:none' id='cancle'>取消</a> <a class='clickbutton' id='delete'>删除</a></td></tr>";
			});
			$(".listtable").html(inhtml);
			$("#departmentname").val("");
		},
		error:function(){
			alert("出问题啦");
		}
	});
}
$(function(){
	query();
});
//编辑按钮
$(function(){
	$("#edit").live("click",function(){
		var cancle = $(this).next("#cancle");
		var editname = $(this).parents("tr").find("#editdname");
		var oldname = editname.text();
		//判断元素是否隐藏
		if(cancle.is(":hidden")){
			editname.html("<input type='text' id='newdname' value='"+oldname+"'/>");
			cancle.css("display","inline");
		}else{
			var newdname = editname.find("#newdname").val();
			var did = $(this).parents("tr").find("#did").text();
			$.ajax({
				type : "POST",
				url : "UpdateDepartmentServlet",
				data : {"newdname":newdname,"did":did},
				dataType : "json",
				success : function(data) {
					cancle.css("display","none");
					var inhtml = data.departmentname;
					editname.html(inhtml);
					
				},
				error:function(){
					alert("出问题啦");
				}
			});
		}
			
	});
});
//取消按钮
$(function(){
	$("#cancle").live("click",function(){
		var editname = $(this).parents("tr").find("#editdname");
		var cancle = $(this);
		var oldname = editname.find("#newdname").val();
		//判断元素是否显示
		if(cancle.is(":visible")){
			editname.html(oldname);
			cancle.css("display","none");
		}
			
	});
});
//删除按钮
$(function(){
	$("#delete").live("click",function(){
		var did = $(this).parents("tr").find("#did").text();
		$.ajax({
			type : "POST",
			url : "DeleteDepartmentServlet",
			data : {"did":did},
			dataType : "json",
			success : function(data) {
				if(data != 0){
					query();
				}else{
					alert("出问题啦");
				}
				
			},
			error:function(){
				alert("出问题啦");
			}
		});
	});
});



























