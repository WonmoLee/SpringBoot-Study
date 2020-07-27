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
		
		$("#btn-delete").on("click", ()=> {
			//콜백 스택
			console.log(this);
			this.deleteById();
		});
	},
	
	save: function() {
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
				userId: $("#userId").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
		}).done(function(resp) {
			if(resp.statusCode == 1) {
				alert("글쓰기 성공");
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error) {
			alert("글쓰기 실패");
			console.log(error);
		})
	},
	
	deleteById: function() {
		let data = {
				id: $("#id").val(),
		};
		
		$.ajax({
			type: "DELETE",
			url: "/post/"+data.id,
			dataType: "json"
		}).done(function(resp) {
			console.log(resp);
			alert("삭제 성공");
			location.href="/";
		}).fail(function(error) {
			alert("삭제 실패");
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
			url: "/auth/loginProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"
				
		}).done(function(resp) {
			if(resp.statusCode == 1) {
				alert("로그인 성공");
				location.href="/";
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