let index = {
	//리스너
	init: function() {
		$("#btn-save").on("click", ()=> {
			//콜백 스택
			console.log(this);
			this.save();
		});
		
		$("#btn-login").on("click", ()=> {
			//콜백 스택
			console.log(this);
			this.login();
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
			alert("회원가입에 실패하였습니다.");
			console.log(error);
		})
	},
	
	login: function() {
		let data = {
				userName: $("#userName").val(),
				passWord: $("#passWord").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/spring/auth/loginProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
				
		}).done(function(resp) {
			if(resp.statusCode == 1) {
				alert("로그인 성공");
				location.href="/spring";
			} else {
				alert("아이디와 패스워드를 다시 입력하세요.");
				console.log(resp);
			}
				
		}).fail(function(error) {
			alert("로그인 실패");
			console.log(error);
		})
	}
	
}

index.init();