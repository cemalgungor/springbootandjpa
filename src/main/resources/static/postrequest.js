$(document).ready(
		function() {

			$("#reg_form").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				var formData = {
					username : $("#name").val(),
					password : $("#pwd").val(),

				}

				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "registiration",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.username
											+ " Successfully! <br>" + ""
											+ "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
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