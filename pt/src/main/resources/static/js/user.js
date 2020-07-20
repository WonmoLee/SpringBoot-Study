let index = {
	init: function() {
		$("#btn-save").on("click", ()=> {
			console.log(this);
			this.save();
		});
	},
	
	save: function() {
		let data = {
				userName: $("#userName").val(),
				passWord: $("#passWord").val(),
				email: $("#email").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/spring/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp) {
			if(resp.statusCode == 1) {
				alert("회원가입이 정상적으로 완료되었습니다.");
				location.href="/spring";
			}
			console.log(resp);
		}).fail(function(error) {
			console.log(error);
		})
	},
	
}

index.init();