$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/boy/school/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
        rules : {
            name : {
                required : true,
                minlength : 2,
                maxlength :50
            }, address : {
                required : true,
                minlength : 2,
                maxlength :125
            }
        },
        messages : {
            name : {
                required : icon + "请输入分校名称",
                minlength : icon + "最少2字符",
                maxlength : icon + "最多50字符"
            },
            address : {
                required : icon + "请输入分校地址",
                minlength : icon + "最少2字符",
                maxlength : icon + "最多125字符"
            }
        }
	})
}