  
$(document).ready(
		function() {

			
			$("#user_form").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});
			function ajaxPost() {

				var formData = {
					username : $("#name").val(),
					password : $("#pwd").val(),

				}

			function ajaxGet() {
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "login",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#getResullogtDiv").html(
									"" + result.data.username
											+ " Successfully! <br>" + ""
											+ "</p>");
						} else {
							$("#getResullogtDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})