<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Application</title>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 	 <c:url var="ApiUrl" value="/message/get"></c:url>
</head>
<body>
<div >
	<div style="margin-top:80px;display:flex;width:100%;height:80%">
	 <!-- Phần danh sách người dùng -->
            	
            	<div style="overflow-y:scroll;font-family: 'Roboto', sans-serif;width:15%;float: left;margin-top: 20px;height:80%">
            	<div class="p-3">

                  <div class="input-group rounded mb-3">
                    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                      aria-describedby="search-addon" />
                    <span class="input-group-text border-0" id="search-addon">
                      <i class="fas fa-search"></i>
                    </span>
                  </div>
			
                  <div data-mdb-perfect-scrollbar-init style="position: relative; height: 400px">
                    <ul class="list-unstyled mb-0">
                    <c:forEach var="item" items="${customer }">
                      <li class="p-2 border-bottom">
                        <a href="#!" class="d-flex justify-content-between">
                          <div class="d-flex flex-row">
                            <div>
                              <img
                                src="${item.img }"
                                alt="avatar" class="d-flex align-self-center me-3" style="width:50px;height:50px;border-radius:50px; margin-right:20px">
                              <span class="badge bg-success badge-dot"></span>
                            </div>
                            <div class="pt-1">
                              <p class="fw-bold mb-0">${item.customerName }</p>
                            </div>
                          </div>
                          <div class="pt-1">
                           <!--  <p class="small text-muted mb-1">Just now</p> -->
                          </div>
                        </a>
                      </li>
                      </c:forEach>
                    </ul>
                  </div>
				 </div>
            	</div>

	<section style="width:85%;margin-top:20px;margin-bottom:30px">	    	
  	<div class="container ">
            <div class="row">
              <div class="col-md-6 col-lg-5 col-xl-4 mb-4 mb-md-0">
              <!-- Phần danh mục đoạn chat -->
            	
            	<div >
            	<div class="p-3" style="overflow-y:scroll;font-family: 'Roboto', sans-serif;height:70%">

                  <div class="input-group rounded mb-3">
                    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                      aria-describedby="search-addon" />
                    <span class="input-group-text border-0" id="search-addon">
                      <i class="fas fa-search"></i>
                    </span>
                  </div>
			
                  <div data-mdb-perfect-scrollbar-init style="position: relative; height: 400px" style="overflow-y:scroll;font-family: 'Roboto', sans-serif;height:70%">
                    <ul class="list-unstyled mb-0">
                    <c:forEach var="item" items="${conversation }" varStatus="conversation">
                   <!--  nếu người gửi = user => hiển thị người nhận -->
                   		<c:forEach var="userChat" items="${item.user }" >
                   			<c:if test="${userChat.customerId != user.customerId}">	
	                    	  <a href="#!" class="d-flex justify-content-between" id="conversation${conversation.index }" >
	                          <div class="d-flex flex-row">
	                            <div>
	                            <input type="hidden" id="img${conversation.index }" value="${userChat.img }" >
	                              <img
	                                src="${userChat.img }"
	                                alt="avatar" class="d-flex align-self-center me-3" style="width:50px;height:50px;border-radius:50px; margin-right:20px">
	                              <span class="badge bg-success badge-dot"></span>
	                            </div>
	                            <div class="pt-1">
	                               <p id="name${conversation.index }" value="${userChat.customerName }"class="fw-bold mb-0">${userChat.customerName }</p>
	                              <p class="small text-muted">${item.message.content }</p>
	                            </div>
	                          </div>
	                          <div class="pt-1">
	                            <p class="small text-muted mb-1">${item.message.time }</p>
	                            <span class="badge bg-danger rounded-pill float-end">3</span>
	                          </div>
	                        </a>                     
	                   <%--     <input type="hidden" id="Participantid${conversation.index }" value="${item.conversationId }"> --%>
	                    	</c:if>
	                    	
                   		</c:forEach>
                    	 <input type="hidden" id="conversationid${conversation.index }" value="${item.conversationId }">
                    	
                      <li class="p-2 border-bottom">
                      	<%-- <c:param name="received" value=${item.customerId }></c:param>
                      	<c:url var="conversation" value="/">
                      	</c:url> --%>
                        
                      </li>
                      </c:forEach>
                    </ul>
                  </div>
				 </div>
            	</div>
              </div>
			 <div class="col-md-10 col-lg-9 col-xl-8 " >
                <!--   Phần hiển thị tin nhắn mới -->
                  <div class="justify-content-end" style="width:100%;height:100%">
                  	<!-- Phần hiển thị thông tin của user -->
			 		<div id="info" style="display:flex;height:50px">
			 		
			 		</div>
			 		<hr>
                    <div id="messages" style="width:100%;overflow-y:scroll;height:500px">
                    	
                    </div>
                   <div style="width:90%;position: absolute; bottom: 0;">
	                <div class="text-muted d-flex justify-content-start align-items-center pe-3 pt-3 mt-2">
	                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
	                    alt="avatar 3" style="width: 40px; height: 100%;">
	                  <input id="messageInput" type="text" placeholder="Type message" style="border-radius:10px;border:1px dashed #DDDDDD;width:90%;outline:none;padding-left:15px">
	                  <a class="ms-1 text-muted" href="#!"><i class="fas fa-paperclip" style="margin-left:5px"></i></a>
	                  <a class="ms-3 text-muted" href="#!"><i class="fas fa-smile" style="margin-left:5px"></i></a>
	                  <a id="sendButton" class="ms-3" href="#!"><i class="fas fa-paper-plane" style="margin-left:5px"></i></a>
	                </div>
             		</div>	
                  </div>                
               </div>				
			</div>
              </div>
            </div>

          </div>
       
  </section>
  
  <input  type="hidden" id="conversationID" value="">
  <input type="hidden" id="currentUser" value="${user.customerName }">
  <input type="hidden" id="currentUserID" value="${user.customerId }">

</div>



 <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script>
    // hàm thao tác xóa tin nhắn detail
    $('#messages').on('click', 'button[id^="delete"]', function () {
    	var messageId=$(this).attr('id').replace('delete', '');
	    var conversationID = $('#conversationID').val();
	    var messageDiv = document.getElementById('divMess'+messageId);
	    var time = document.getElementById('time'+messageId);
	    $.ajax({
	        url: '/SpringMVC2/user/delete',
	        type: 'DELETE',
	        data: JSON.stringify({ idMessenge: messageId, conversationId: conversationID }),
	        contentType: 'application/json',
	        success: function (result, status, xhr) {
	        	 if (xhr.status === 200) {
		            console.log('Message deleted successfully.');        
		            messageDiv.remove();
		            time.remove();
	        	 }
	        }.bind(this), // Bind `this` để có thể sử dụng trong callback
	        error: function (error) {
	            console.log('Delete request failed:', error);
	        }
	    });
	});
   
    // hàm tải tin nhắn
    $('a[id^="conversation"]').click(function name(event) {
    	var chatBox = $('#info'); // Chọn phần tử nơi bạn muốn hiển thị tin nhắn
        chatBox.empty();
    	event.preventDefault();
		var index=$(this).attr('id').replace('conversation', '');
		var conversation=$('#conversationid'+index).val();
		$('#conversationID').val(conversation);
		show({conversationId:conversation})
		
		 // hiển thị thông tin user
		
		const info = document.getElementById('info');
     	const imginfo = document.createElement('img');
     	imginfo.src =$('#img'+index).val();
     	const NameInfo = document.createElement('p'); 
     	NameInfo.textContent=$('#name'+index).text();
     	NameInfo.style.marginLeft='10px';
    	NameInfo.style.marginTop='10px';
     	NameInfo.style.fontWeight='bold';
     	// css cho 2 thành phần
     	imginfo.style.width='50px';
     	imginfo.style.height='50px';
     	imginfo.style.marginLeft='10px';
     	imginfo.style.marginRight='10px';
     	imginfo.style.borderRadius='30px';
     	imginfo.style.objectFit = 'cover'; 
     	// thêm 2 thành phần đó vào bên trong thẻ div
     	info.appendChild(imginfo);
     	info.appendChild(NameInfo);
     	
	});
    function show(data) {
		$.ajax({
			url:'/SpringMVC2/user/message',
			type:'post',
			data: JSON.stringify(data) ,
			contentType :'application/json',
			dataType: 'json',
			success: function (response) {
				console.log(response);
				 displayMessages(response);
			},
			error: function (response) {
				 console.error(response);
			}
		});
}
    function displayMessages(response) {
        var chatBox = $('#messages'); // Chọn phần tử nơi bạn muốn hiển thị tin nhắn
        chatBox.empty(); // Xóa nội dung cũ
		var currentUser=document.getElementById('currentUserID').value;
        // Duyệt qua danh sách tin nhắn và thêm vào chatBox
        response.forEach(function (item) {
        	console.log(item); // Xem cấu trúc của item
            console.log(item.content); // Kiểm tra xem giá trị có đúng không
            var content=item.content;
            console.log(content);
            var messageHtml = '';
            showMessage(item)
        });
      
    }
    //---------------------------------------------------------------------------------
        let stompClient = null; // Khai báo stompClient
// hàm kết nối và đăng kí nhận tin nhắn
        function connect() {
        	var userId=$('#currentUserID').val();
        	var full='/queue/'+userId;
        	console.log(full);
        	userId = userId.toString(); 
            const socket = new SockJS('/SpringMVC2/chat'); // Kết nối đến WebSocket
            stompClient = Stomp.over(socket); // Khởi tạo stompClient
            stompClient.connect({}, function (frame) {
                stompClient.subscribe(full, function (message) {// nhận tin nhắn với đường dẫn
                	console.log('Received message:', message.body);
                   showMessage(JSON.parse(message.body)); // Hiển thị tin nhắn 
                });
	            },function (error) {
	                console.error('Error connecting: ', error);
	            }
            );
        }

        function sendMessage() {
        	// lấy user hiện tại currentUser
        	var currentUser=document.getElementById('currentUserID').value;
        	var conversationID = $('#conversationID').val();
            const Content = document.getElementById('messageInput').value;
            if (!Content) {
                alert('Please enter a message!');
                return; // Ngừng thực hiện nếu không có nội dung
            }
			var sender={
					customerId:currentUser
			}
            const MessageDTO = {
				sender:sender , // ID người gửi
				content:Content,
				conversationId:conversationID
            };
			console.log(JSON.stringify(MessageDTO));
            stompClient.send('/app/send', {}, JSON.stringify(MessageDTO)); // Gửi tin nhắn đến server
            $('#messageInput').val('');
        }

        function showMessage(message) {
        	var currentUser=document.getElementById('currentUserID').value;
        	// Lấy các thông tin từ object tin nhắn
            const sendName = message.sender.customerName; // Tên người gửi
            const senderID=message.sender.customerId;
            const content = message.content; // Nội dung tin nhắn
            const time=message.time;
          	var imgUser=null;
            var Receiver=message.receiver;
            var img=null;
            var name=null
          	var idMess=message.idMessenge;
            Receiver.forEach(function (item) {
            	if(item.customerId ==currentUser){
            		imgUser=item.img;
            		name=item.customerName;
            	}
            	else{
            		img=item.img;
            	}
            });
         	
        /*     Phần hiển thị cho tin nhắn */
            const messagesDiv = document.getElementById('messages'); // Lấy phần tử chứa tin nhắn
            const div = document.createElement('div'); // Tạo thẻ p cho tên người gửi
            const divMess = document.createElement('div'); // 
            const Elementimg = document.createElement('img');// avt
            const newMessage = document.createElement('textarea'); // Nội dung tin nhắn
            newMessage.value  = content; // Thiết lập nội dung tin nhắn
            // nút xóa
            const detail = document.createElement('button');
            // nút edit
            const edit = document.createElement('button');
           
            // tạo id cho divMess
            div.id='divMess'+idMess;
            // tạo id cho button xóa
            detail.id='delete'+idMess;
            // tạo id cho button edit
            edit.id='edit'+idMess;
            // thêm nội dung vào xóa
            detail.innerHTML = '<i class="fa fa-trash" aria-hidden="true"></i>';
            // thêm nội dung vào delete
            edit.innerHTML='<i class="fa fa-pencil" aria-hidden="true"></i>';
            const trashIcon = detail.querySelector('.fa-trash');// lấy ra phần tử đó
            trashIcon.style.color = '#bfc9ca'; // Chỉnh thành màu  cho kí tự xóa
            const trashIconEdit = edit.querySelector('.fa-pencil');// lấy ra phần tử đó
            trashIconEdit.style.color = '#bfc9ca'; // Chỉnh thành màu  cho kí tự eidt
            const Elementtime=document.createElement('p');// tạo hiển time
            // tạo id cho phần time
            Elementtime.id='time'+idMess;
            // thêm nội dung cho phần hiển thị thời gian
            Elementtime.textContent=time;
            // thêm tên div
            div.className = 'div';
            divMess.className='divMess';
        //    newMessage.className = 'message'; // Thêm lớp CSS để dễ dàng định dạng
         	// css cho phần tử div
         	div.style.display='flex';
        	div.style.width='95%';
        	divMess.style.width='95%';
        	// css cho phần tử hình ảnh
        	Elementimg.style.width='50px';
        	Elementimg.style.height='50px';
        	Elementimg.style.marginLeft='10px';
        	Elementimg.style.marginRight='10px';
        	Elementimg.style.borderRadius='30px';
        	Elementimg.style.objectFit = 'cover'; 
			// css cho từng phần tử tin nhắn
			 newMessage.style.padding='10px';
			//  newMessage.style.width='50%';
			 newMessage.style.borderRadius='10px';
			 newMessage.style.display = 'block';	
			 newMessage.style.border='none';
			 newMessage.style.outline='none';
			 newMessage.readOnly = true; // thêm ràng buộc chỉ đọc
			
			 // điều chỉnh css cho nút xóa(detail)
			  detail.style.margin='10px';
			  detail.style.border='0px';
			  detail.style.backgroundColor = 'rgba(255, 255, 255, 0)'; 
			  // css cho nút edit
			  edit.style.marginTop='10px';
			  edit.style.marginLeft='3px';
			  edit.style.border='0px';
			  edit.style.backgroundColor = 'rgba(255, 255, 255, 0)'; 
			  //điều chỉnh css cho thời gian
			  Elementtime.style.color='#cacfd2';	    
			 // điều chỉnh css cho phần người gửi
			// sendTime.style.clear= 'both';
            // Kiểm tra xem tin nhắn là của người gửi hiện tại hay không
			if (senderID == currentUser) {
				// điều chỉnh css cho phần tin nhắn
			    newMessage.style.backgroundColor = '#d1e7dd'; // Ví dụ: Thay đổi màu nền của tin nhắn đã gửi
			    newMessage.style.color = '#000'; // Ví dụ: Thay đổi màu chữ của tin nhắn đã gửi
			    newMessage.style.float='right';
			    Elementtime.style.display='block';
			    Elementtime.style.float='right';
			    Elementtime.style.marginRight='100px';
			    Elementimg.style.float='right';
			    Elementimg.src = imgUser; // Đường dẫn ảnh
			   // div.appendChild(Elementtime);
			    // điều chỉnh phần css cho phần button chi tiết
			    detail.style.float='right';
			    edit.style.float='right';
			    newMessage.setAttribute('data-messId',content)
			    div.appendChild(divMess);
			    divMess.appendChild(newMessage); // thêm tin nhắn vào khối div
			    divMess.appendChild(detail);
			    divMess.appendChild(edit);
			    div.appendChild(Elementimg);// thêm hình ảnh vào cho khối div
			    
			} else {
			    newMessage.classList.add('message-received'); // Thêm lớp CSS cho tin nhắn đã nhận
			    newMessage.style.backgroundColor = '#f8d7da'; // Ví dụ: Thay đổi màu nền của tin nhắn đã nhận
			    newMessage.style.color = '#000'; // Ví dụ: Thay đổi màu chữ của tin nhắn đã nhận
			    newMessage.style.textAlign = 'left'; // Canh lề tin nhắn đã nhận
			    //newMessage.style.display = 'block';
			    newMessage.style.float='left';
			    // điều chỉnh css cho phần người gửi
			    Elementtime.style.marginLeft='70px';
			    detail.style.float='left';
			    edit.style.float='left';
			    Elementimg.src = img; // Đường dẫn ảnh
			    div.appendChild(Elementimg);// thêm hình ảnh vào cho khối div
			    div.appendChild(newMessage); // thêm tin nhắn vào khối div
			    div.appendChild(detail);
			    div.appendChild(edit);
			    	   
			}
			
			 messagesDiv.appendChild(div); // Thêm div vào bên trong khối tin nhắn	  
			 messagesDiv.appendChild(Elementtime); // Thêm tên người gửi vào phần tử chứa tin nhắn
			 
        }

        document.getElementById('sendButton').onclick = sendMessage; // Gán sự kiện cho nút gửi

        // Kết nối WebSocket khi trang được tải
        window.onload = connect;
        
    </script>

</body>
</html>