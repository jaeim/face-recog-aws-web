<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <script type="text/javascript">
		$("#account").click(function() {
			alert("click");

			var human = {
				name : $("#_name").val(),
				tel : $("#_phone").val(),
				email : $("#_email").val(),
				birth : $("#_birth").val()
			};
			console.log(human);
			$.ajax({
				url : "/test/one",
				data : human,
				type : "post",
				dataType : "json",
				async : true,
				success : function(resp) {
					alert("success");
					alert(resp.msg);
					alert(resp.name);

				},
				error : function() {
					alert("error")
				}
			});
		});
	</script>
</head>

<body>
 <button type="button" id="account">account</button>

</body>
</html>