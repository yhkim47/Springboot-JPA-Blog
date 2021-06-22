let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},
	
	save: function() {
		//alert("user의 save함수가 호출됨");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		//console.log(data);
		// ajax 통신을 이용해서 data를 JSON으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // 요청 데이터의 타입
			dataType: "json" // 응답 데이터의 타입, 응답데이터는 javascript의 오브젝트로 변경되어 수신된다.
		}).done(function(resp) {
			console.log("resp", resp);
			alert("회원가입완료");
			//location.href = "/blog";
		}).fail(function(error) {
			alert("회원가입실패" + JSON.stringify(error));
		}); 
	}
};

index.init();