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
		$.ajax().done().fail(); // ajax 통신을 이용해서 data를 JSON으로 변경하여 insert 요청
	}
};

index.init();