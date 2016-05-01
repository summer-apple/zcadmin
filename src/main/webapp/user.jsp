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
</style>

</head>
<body>

<div class="container-fluid">


   <nav class="navbar navbar-light bg-faded">
      <ul class="nav navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="user.jsp">用户管理</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="project.jsp">项目管理</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="order.jsp">订单管理</a>
        </li>
        <li class="nav-item" style="float: right;">
          <a class="nav-link" href="login.jsp">退出</a>
        </li>
      </ul>
  </nav>


   <div class="row">
    <div class="col-xl-12">
    	<table class="goods-table table table-bordered table-hover">
		  <thead>
		    <tr>
		      	<th>ID</th>
		      	<th>头像</th>
		      	<th>用户名</th>
		      	<th>性别</th>
		      	<th>邮箱</th>
		      	<th>手机</th>
		      	<th>真实姓名</th>
		      	<th>地址</th>
		      	<th>操作</th>
		    </tr>
		  </thead>
		  <tbody>
		   
		  </tbody>
		</table>
    </div>
  </div>

	<div class="row">
		<div class="col-sm-12">
			<div class="pagination"></div>
		</div>				
	</div>


</div>



<script type="text/javascript">
	$().ready(function(){

//第一次载入标志

var $firstLoadFlag = true;

qry(0,true);

//查询方法
		function qry(pageNo,initPageFlag){


            $.ajax({
                url:'user/qry-all',
                data: {'pageNo':pageNo,'pageSize':20},
                type:'post',
                dataType:'json',
                success:function(data){
                    $(".goods-table tbody").empty();
                    
                	$.each(data.list, function(i, item) {
                		 $(".goods-table tbody").append(
                		'<tr>'+
                		'	<td>'+item.userId+'</td>'+
						'	<td><img src="'+item.userAvatar+'"></td>'+
						'	<td>'+item.userName+'</td>'+
						'	<td>'+item.userSex+'</td>'+
						'	<td>'+item.userEmail+'</td>'+
						'	<td>'+item.userPhone+'</td>'+
						'	<td>'+item.userTrueName+'</td>'+
						'	<td>'+item.userAddressProvince+' '+item.userAddressCity+'</td>'+
						'	<td><a onclick="del('+item.userId+')">删除</a></td>'+
						'</tr>'
                		 );
	
                  	});

                    if(initPageFlag){
                        $(".pagination").pagination(data.amount, { 
                          prev_text: '&laquo;', 
                          next_text: '&raquo;',
                          ellipse_text:"...", 
                          items_per_page: 1, 
                          num_display_entries: 6, 
                          current_page: 0, 
                          num_edge_entries: 2,
                          link_to:"javascript:void(0);",
                          callback:pageSelectCallback
                            
                        });
                    }
                }
            });
            
            
		}


//点击页码查询

		function pageSelectCallback(current_page, aa){
			 qry(current_page+1,false);
		}




	//删除

	window.del = function(id){
		$.ajax({
            url:'user/delete?id='+id,
            type:'post',
            dataType:'json',
            success:function(data){
            	if (data==true) {
                	alert("删除成功...");
               		qry(0,true);
                }else{
                	alert("无法删除...");

                }
               
            }
        });	
	}

	



//日期转换方法
(function($) {
    $.extend({
        myTime: {
            /**
             * 当前时间戳
             * @return <int>        unix时间戳(秒)  
             */
            CurTime: function(){
                return Date.parse(new Date())/1000;
            },
            /**              
             * 日期 转换为 Unix时间戳
             * @param <string> 2014-01-01 20:20:20  日期格式              
             * @return <int>        unix时间戳(秒)              
             */
            DateToUnix: function(string) {
                var f = string.split(' ', 2);
                var d = (f[0] ? f[0] : '').split('-', 3);
                var t = (f[1] ? f[1] : '').split(':', 3);
                return (new Date(
                        parseInt(d[0], 10) || null,
                        (parseInt(d[1], 10) || 1) - 1,
                        parseInt(d[2], 10) || null,
                        parseInt(t[0], 10) || null,
                        parseInt(t[1], 10) || null,
                        parseInt(t[2], 10) || null
                        )).getTime() / 1000;
            },
            /**              
             * 时间戳转换日期              
             * @param <int> unixTime    待时间戳(秒)              
             * @param <bool> isFull    返回完整时间(Y-m-d 或者 Y-m-d H:i:s)              
             * @param <int>  timeZone   时区              
             */
            UnixToDate: function(unixTime, isFull, timeZone) {
                if (typeof (timeZone) == 'number')
                {
                    unixTime = parseInt(unixTime) + parseInt(timeZone) * 60 * 60;
                }
                var time = new Date(unixTime * 1000);
                var ymdhis = "";
                ymdhis += time.getUTCFullYear() + "-";
                ymdhis += (time.getUTCMonth()+1) + "-";
                ymdhis += time.getUTCDate();
                if (isFull === true)
                {
                    ymdhis += " " + time.getUTCHours() + ":";
                    ymdhis += time.getUTCMinutes() + ":";
                    ymdhis += time.getUTCSeconds();
                }
                return ymdhis;
            }
        }
    });
})(jQuery);


	function transTime(object,isFull){
		if (object!=null) {
			return $.myTime.UnixToDate(object/1000,isFull,8);
		}else{
			return "--";
		}
	}




	});
</script>
</body>
</html>