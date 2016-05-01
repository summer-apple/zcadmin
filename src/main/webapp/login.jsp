<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DRARTISAN</title>
<link rel="stylesheet" type="text/css" href="resources/js/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.pagination.js"></script>
<style type="text/css">
    body{
        margin:50px;
    }
    table img {
      width: 50px;
    }
        nav{
      margin-bottom: 30px;
    }
    .confirm-warp{
    	width:300px;
    	height:200px;
    	margin-top:200px;
    	margin-left:auto;
    	margin-right:auto;
    	text-align:center;
    	display:none;
    }
    form{
    width: 400px;
    margin-left: auto;
    margin-right: auto;
    margin-top: 100px;
    padding: 25px;
    border-radius: 10px;
    border: 1px solid #DDD;
    }
</style>

</head>
<body>

<div class="container-fluid">


  


   <div class="row">
    <div class="col-xl-12">
    <h4>Dashboard</h4>
    	<form class="login-form">
    		 <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" class="form-control" id="username" placeholder="Username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="password" placeholder="Password">
  </div>

  <a id="login-btn" class="btn btn-default">Login</button>
    	</form>
    </div>
  </div>

	


</div>



<script type="text/javascript">
	$().ready(function(){
	$("#login-btn").click(function(){
		var u = $("#username").val();
		var p = $("#password").val();

		if(u == "admin" && p == "admin"){
			window.location.href="user.jsp";
		}else{
			alert("用户名或密码错误！");
		}
	});

	});
</script>
</body>
</html>