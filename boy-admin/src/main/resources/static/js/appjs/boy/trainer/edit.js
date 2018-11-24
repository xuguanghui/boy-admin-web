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
		url : "/boy/trainer/update",
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
                maxlength : 15
            },
            shortDesc : {
                required : true,
                minlength : 1,
                maxlength : 255
            },
            mobile : {
                maxlength : 11,
                digits : true
            }
        },
        messages : {
            name : {
                required : icon + "请输入您的姓名",
                minlength : icon + "姓名必须2个字符以上",
                maxlength : icon + "姓名不超过15个字符"
            },
            shortDesc : {
                required : icon + "请输入简介",
                minlength : icon + "简介至少1位数",
                maxlength : icon + "简介不超过225个字符"
            },
            mobile : {
                required : icon + "号码必选",
                maxlength : icon + "号码不超过11位数",
                digits : icon + "必须是数字"
            }
        }
    })
}