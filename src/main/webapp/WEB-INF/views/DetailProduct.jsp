<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="CartUrl" value="/api/cart/add" />
<c:url var="ApiUrl" value="/user/reply/add" />
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        #addToCart:hover {
            background-color: blue !important;
            /* Màu nền thay đổi */
            color: yellow !important;
            /* Màu chữ thay đổi */
        }
    </style>
</head>

<body>
    <section class="ftco-section">

        <div class="container">
            <div class="row">
                <div class="col-lg-6 mb-5 ftco-animate">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${product.image }" class="d-block w-100" alt="...">
                            </div>
                            <c:forEach var="image" items="${ product.listImage }" varStatus="status">
                                <div class="carousel-item">
                                    <img src="${image }" class="d-block w-100" alt="...">
                                </div>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                            data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                            data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                    <h3>${product.productName }</h3>
                    <div class="rating d-flex">
                        <p class="text-left mr-4">
                            <a href="#" class="mr-2">5.0</a>
                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                        </p>
                        <p class="text-left mr-4">
                            <a href="#" class="mr-2" style="color: #000;">100 <span
                                    style="color: #bbb;">Rating</span></a>
                        </p>
                        <p class="text-left">
                            <a href="#" class="mr-2" style="color: #000;">${product.sold } <span
                                    style="color: #bbb;">Sold</span></a>
                        </p>
                    </div>
                    <p class="price"><span>${product.prince }</span></p>
                    <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It
                        is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                    <p>On her way she met a copy. The copy warned the Little Blind Text, that where it came from it
                        would have been rewritten a thousand times and everything that was left from its origin would be
                        the word "and" and the Little Blind Text should turn around and return to its own, safe country.
                        But nothing the copy said could convince her and so it didn’t take long until a few insidious
                        Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their
                        agency, where they abused her for their.</p>
                    <div class="row mt-4">
                        <div class="col-md-9">
                            <div class="form-group d-flex">
                                <div style="display:inline-block; width: 100%;">
                                    <div class="select-wrap" style="display:inline-block; width: 45%;">
                                        <div style="display:inline-block; width: 5%;" class="icon"><span
                                                class="ion-ios-arrow-down"></span></div>
                                        <select name="size" id="size100" class="form-control"
                                            style="display:inline-block; width: 95%;border-radius: 5px">
                                            <option selected>Chọn size</option>
                                            <c:forEach var="size" items="${product.listSize }">
                                                <option value="${size }">${size }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="select-wrap" style="display:inline-block; width: 50%;">
                                        <div style="display:inline-block; width: 5%;" class="icon"><span
                                                class="ion-ios-arrow-down"></span></div>
                                        <select name="color" id="color100" class="form-control"
                                            style="display:inline-block; width: 95%;border-radius: 5px">
                                            <option selected>Chọn màu</option>
                                            <c:forEach var="color" items="${product.listColor }">
                                                <option value="${color }">${color }</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="input-group col-md-6 d-flex">
                            <label style="width:70%;display:inline-block;margin-top:5px" class="control-label"
                                for="filebutton">CHỌN SỐ LƯỢNG:</label>
                            <input style="width:15%;display:inline-block; border-radius: 5px" type="number"
                                id="quantity100" name="quantity" class="quantity form-control input-number" value="1"
                                min="1" max="100">
                        </div>
                        <div class="w-100"></div>
                        <div class="col-md-12">
                            <p style="color: #000;">${product.quantity } piece available</p>
                        </div>
                    </div>
                    <input type="hidden" id="idProduct100" value="${product.productId }">
                    <button type="submit" id="addToCart100" class="btn"
                        style="background-color: black;border-radius:30px; color:black;width:150px;padding:10px">Add to
                        Cart</button>
                    <button type="submit" id="buyNow" class="btn btn-primary"
                        style="background-color: black;border-radius:30px; color:black;width:150px;height:70px">Buy
                        now</button>

                    <!-- <p><a href="cart.html" class="btn btn-black py-3 px-5 mr-2">Add to Cart</a><a href="cart.html" class="btn btn-primary py-3 px-5">Buy now</a></p> -->
                </div>
            </div>

        </div>
    </section>
    <!--  phần các sản phẩm liên quan -->
    <section class="py-5 bg-light">
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4">Related products</h2>
            <div class="row">

                <c:forEach var="item" items="${Related }" varStatus="status">
                    <div class="col-sm-12 col-md-6 col-lg-3 ftco-animate d-flex">
                        <div class="product d-flex flex-column">
                            <a href="#" class="img-prod"><img class="img-fluid" src="${item.image }"
                                    alt="Colorlib Template">
                                <span class="status">50% Off</span>
                                <div class="overlay"></div>
                            </a>
                            <div class="text py-3 pb-4 px-3">
                                <div class="d-flex">
                                    <div class="cat">
                                        <span>Lifestyle</span>
                                    </div>
                                    <div class="rating">
                                        <p class="text-right mb-0">
                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                        </p>
                                    </div>
                                </div>
                                <h3>
                                    <c:url var="detail" value="/public/product/detail">
                                        <c:param name="id" value="${item.productId }"></c:param>
                                        <c:param name="caterogyId" value="${item.categoryId }"></c:param>
                                    </c:url>
                                    <a href='${ detail}'>${item.productName }</a>
                                </h3>
                                <div class="pricing">
                                    <p class="price"><span class="mr-2 price-dc">$120.00</span><span
                                            class="price-sale">${item.prince }</span></p>
                                </div>
                                <p class="bottom-area d-flex px-6">
                                    <div class="btn-group custom-dropdown">
                                        <button style="width:220px; text-align:center" type="button"
                                            class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                            Chọn
                                        </button>
                                        <div class="dropdown-menu"
                                            style="min-width: 14rem;border-radius: 10px;top:35px;left:2px">
                                            <!-- Dropdown for Size -->
                                            <div class="form-group" style="padding-left:10px;padding-right:10px;">
                                                <label for="size">Chọn kích thước</label>
                                                <select
                                                    style="border-radius: 10px;height:35px ;width:100%;font-size: 14px;padding-left:20px"
                                                    class="size" id="size${status.index }" name="size">
                                                    <option selected>Kích thước</option>
                                                    <c:forEach var="sizeItem" items="${item.listSize}">
                                                        <option value="${sizeItem}">${sizeItem}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <!-- Dropdown for Color -->
                                            <div class="form-group" style="padding-left:10px;padding-right:10px;">
                                                <label for="color">Chọn màu sắc</label>
                                                <select
                                                    style="border-radius: 10px;height:35px;width:100%;font-size: 14px;padding-left:20px"
                                                    class="color" aria-label="Default select example"
                                                    id="color${status.index }" name="color">
                                                    <option selected>Màu sắc</option>
                                                    <c:forEach var="colorItem" items="${item.listColor}">
                                                        <option value="${colorItem}">${colorItem}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group" style="padding-left:10px;padding-right:10px;">
                                                <label for="filebutton">SỐ LƯỢNG:</label>
                                                <input
                                                    style="border-radius:10px;height:35px;width:50%;font-size: 14px;padding-left:20px"
                                                    type="number" id="quantity${status.index }" name="quantity"
                                                    class="quantity input-number" value="1" min="1" max="100">
                                            </div>
                                            <!-- Add to Cart Button -->
                                            <div class="card-footer p-10 pt-0 border-top-0 bg-transparent">
                                                <div class="text-center">
                                                    <button style="width:150px; margin:10px" type="submit"
                                                        class="btn btn-primary" id="addToCart${status.index }">ADD TO
                                                        CART</button>
                                                </div>

                                                <div class="text-center">
                                                    <button style="width:150px; margin:10px" type="submit"
                                                        class="btn btn-primary" id="buyNow">BUY NOW</button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                </p>
                                <p class="bottom-area d-flex px-3">
                                    <!-- <a href="#" id="AddToCart" class="add-to-cart text-center py-2 mr-1"><span>Add to cart <i class="ion-ios-add ml-1"></i></span></a>
    							<a href="#" class="buy-now text-center py-2">Buy now<span><i class="ion-ios-cart ml-1"></i></span></a> -->
                                </p>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="idProduct${status.index }" name="product" value="${item.productId  }">
                </c:forEach>
            </div>
        </div>
        <div class="col-md-12 nav-link-wrap">
            <div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link ftco-animate mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1"
                    role="tab" aria-controls="v-pills-1" aria-selected="false">Description</a>

                <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2"
                    role="tab" aria-controls="v-pills-2" aria-selected="false">Comment</a>

                <a class="nav-link ftco-animate active " id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3"
                    role="tab" aria-controls="v-pills-3" aria-selected="true">Reviews</a>

            </div>
        </div>
        <!--  feedback -->

        <div class="tab-content bg-light" id="v-pills-tabContent">

            <div class="tab-pane fade " id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                <div class="p-4">
                    <h3 class="mb-4">Nike Free RN 2019 iD</h3>
                    <p>On her way she met a copy. The copy warned the Little Blind Text, that where it came from it
                        would have been rewritten a thousand times and everything that was left from its origin would be
                        the word "and" and the Little Blind Text should turn around and return to its own, safe country.
                        But nothing the copy said could convince her and so it didn’t take long until a few insidious
                        Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their
                        agency, where they abused her for their.</p>
                </div>
            </div>
            <!-- 	Phần bình luận(hỏi đáp về sản phẩm) -->
            <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
                <div class="p-4">
                    <div style="display:flex;">
                        <img style="width:40px;height:40px;border-radius:30px;border:1px dashed  #888888;margin-right: 20px"" alt="" src="/SpringMVC2/uploads/Screenshot
                            2024-09-06 221054.png">
                        <h4>
                            <span style="font-weight: bold;" class="text-left">${user.customerName }</span>
                        </h4>
                    </div>
                    <div style="position: relative; display: inline-block;width:100%">
                        <input type="text" value="" placeholder="Nhập bình luận" id="editreply"
                            style="margin:10px 0px 10px 60px; border:1px dashed #888888 ;background: transparent;outline:none;width:50%;border-radius:10px;padding-left:15px">
                    </div>
                    <button id="comment" type="button" class="btn btn-primary" style="margin: 10px 0px 10px 60px">Gửi
                        bình luận</button>
                    <button id="" type="button" class="btn btn-primary"
                        style="margin-top:10px;margin-left:20px;">Hủy</button>

                </div>
            </div>
            <!--    Phần feedback -->
            <div class="tab-pane fade show active" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-day-3-tab">
                <div class="row p-4">
                    <div class="col-md-7">
                        <h3 class="mb-4">23 Reviews</h3>
                        <c:forEach var="item" items="${feedback }" varStatus="status">
                            <div class="review">
                                <div class="user-img">
                                    <img style="width:50px;height:50px;border-radius:30px;border:1px dashed  #888888;"
                                        alt="" src="/SpringMVC2/uploads/Screenshot 2024-09-06 221054.png">
                                </div>
                                <div class="desc">
                                    <h4>
                                        <span style="font-weight: bold;" class="text-left">${item.customer }</span>
                                        <span class="text-right">${item.date }</span>
                                    </h4>
                                    <p class="star">
                                        <c:forEach var="i" begin="1" end="${item.star}">
                                            <i style="color: #e7ec7a;" class="fa fa-star"></i>
                                        </c:forEach>
                                    </p>
                                    <p>${item.description }</p>
                                    <p>
                                        <!-- khi ấn vào thẻ a sẽ hiển khung để bình luận -->
                                        <a class="nav-link" id="pills-profile-tab${item.reviewId }" data-toggle="pill"
                                            href="#pills-profile${item.reviewId }" role="tab"
                                            aria-controls="pills-profile" aria-selected="false"><i
                                                class="icon-reply"></i> Trả lời</a>
                                        <!-- 	Phần sẽ hiển thị phần bình luận khi ấn vào thẻ a -->
                                        <div class="tab-content" id="pills-tabContent${item.reviewId }">
                                            <div class="tab-pane fade" id="pills-profile${item.reviewId }"
                                                role="tabpanel" aria-labelledby="pills-profile-tab">
                                                <textarea placeholder="Nhập câu hỏi của bạn" class="form-control"
                                                    id="content${item.reviewId }" name="description"
                                                    style="border-radius:20px;border:1px dashed #DDDDDD"></textarea>
                                                <button id="ok${item.reviewId }" type="button" class="btn btn-primary"
                                                    style="margin-top:10px">Gửi câu hỏi</button>
                                                <button id="Cancel${item.reviewId }" type="button"
                                                    class="btn btn-secondary" data-dismiss="modal"
                                                    style="margin-top:10px">Hủy</button>
                                            </div>
                                        </div>
                                        <!------------------------------>
                                    </p>
                                    <p>
                                        <!-- 	ấn vào thẻ a dạng data-toggle="pill" sẽ hiển thị phần nọi dung -->
                                        <a class="nav-link" id="pills-profile-tab-reply${item.reviewId }"
                                            data-toggle="pill" href="#pills-profile-reply${item.reviewId }" role="tab"
                                            aria-controls="pills-profile" aria-selected="false"><i
                                                class="icon-reply"></i> Xem các câu trả lời khác</a>
                                        <!-- Nội dung của các tab sau khi ấn thẻ a sẽ hiển thị-->
                                        <div class="tab-content" id="pills-tabContent-reply${item.reviewId }">
                                            <div class="tab-pane fade" id="pills-profile-reply${item.reviewId }"
                                                role="tabpanel" aria-labelledby="pills-profile-tab">
                                                <div id="DivReply${item.reviewId }">
                                                    <c:forEach var="reply" items="${item.reply }"
                                                        varStatus="replyStatus">
                                                        <div style="display:flex;">
                                                            <img style="width:40px;height:40px;border-radius:30px;border:1px dashed  #888888;margin-right: 20px"
                                                                alt=""
                                                                src="/SpringMVC2/uploads/Screenshot 2024-09-06 221054.png">

                                                            <h4>
                                                                <span style="font-weight: bold;"
                                                                    class="text-left">${reply.customer.customerName
                                                                    }</span>
                                                                <span class="text-right"
                                                                    id="time${item.reviewId }${reply.replyId }">${reply.date
                                                                    }</span>
                                                            </h4>
                                                        </div>
                                                        <div
                                                            style="position: relative; display: inline-block;width:100%">
                                                            <input type="text" value="${reply.content}"
                                                                id="editreply${item.reviewId }${reply.replyId }"
                                                                style="margin-left:60px; border:0px;background: transparent;outline:none;width:90%;"
                                                                readonly>
                                                            <a id="edit${item.reviewId }${reply.replyId }"
                                                                style="position: absolute; right: 25px; top: 50%; transform: translateY(-50%); color: #dbcc8f; cursor: pointer;display: none;">
                                                                <i class="fa fa-paper-plane"></i>
                                                            </a>
                                                        </div>
                                                        <c:if
                                                            test="${reply.customer.customerName == user.customerName  }">
                                                            <div style="display:flex">
                                                                <a id="clickEdit${item.reviewId }${reply.replyId }"
                                                                    style="margin-left:60px;color:#dbcc8f;cursor: pointer;"
                                                                    onclick="editReply(this)"></i>Chỉnh sửa</a>
                                                                <a id="delete${item.reviewId }${reply.replyId }"
                                                                    style="margin-left:20px;color:#dbcc8f;cursor: pointer;">Xóa</a>
                                                            </div>
                                                        </c:if>
                                                        <input type="hidden" value="${reply.replyId }"
                                                            id="repyId${item.reviewId }${reply.replyId }">
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                        <!----------------------------------------- -->
                                    </p>
                                </div>
                            </div>
                            <input type="hidden" id="feedbackId${item.reviewId }" value="${item.reviewId }">
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <input type="hidden" id="customer" value="${user.customerName }">
    <script type="text/javascript">
        // hàm lưu bình luận( không bao gồm feedback)

        /* hàm hiển thị phần chỉnh sửa */
        function editReply(element) {
            var index = $(element).attr('id').replace('clickEdit', '');

            // Lấy ô input
            var inputField = document.getElementById("editreply" + index);

            // Bỏ thuộc tính readonly để người dùng có thể chỉnh sửa
            inputField.removeAttribute("readonly");

            // Đặt focus vào ô input
            inputField.focus();

            // Thay đổi CSS cho ô input
            inputField.style.border = "1px dashed #888888"; // Thay đổi viền
            inputField.style.padding = "10px"; // Thay đổi padding
            inputField.style.borderRadius = "10px"; // Thay đổi bo góc
            // Lấy ID của thẻ <a>
            var editLinkId = "edit" + index;
            // hiển thị nút mũi tên để gửi bình luận đi bằng ID và hiển thị nó
            var editLink = document.getElementById(editLinkId);
            editLink.style.display = "inline-block";
        };
        // hàm thêm cmt
        $('button[id^="ok"]').click(function () {
            var index = $(this).attr('id').replace('ok', '');
            var feedbackId = $('#feedbackId' + index).val();
            var customerName = $('#customer').val();
            var content = $('#content' + index).val();
            var customer = {
                customerName: customerName
            }
            addReply({
                content: content,
                customer: customer,
                feedback: feedbackId
            })
        });

        function addReply(data) {
            $.ajax({
                url: '${ApiUrl}',
                type: 'post',
                data: JSON.stringify(data),
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                    // trả về response => hiển thị cmt vừa được thêm 
                    // lấy khối div cần thêm vào DivReply
                    var divReply = document.getElementById("DivReply" + result.feedback); // div cấp 1
                    // tạo div cho phần avt và tên
                    const divAvtName = document.createElement('div'); // div cấp 2
                    // css cho thẻ div
                    divAvtName.style.display = "flex";
                    // tạo hình ảnh
                    const Avt = document.createElement('img'); // cấp 3
                    Avt.src = "/SpringMVC2/uploads/Screenshot 2024-09-06 221054.png";
                    // tạo css cho thẻ này 
                    Avt.style.width = "40px";
                    Avt.style.height = "40px";
                    Avt.style.borderRadius = "30px";
                    Avt.style.border = "1px dashed #888888";
                    Avt.style.marginRight = "20px";
                    // phần tên và thời gian 
                    const customerNameSpan = document.createElement('span'); // cấp 3
                    const dateSpan = document.createElement('span'); // cấp 3
                    dateSpan.id = "time" + result.feedback + result.replyId;
                    // Gán nội dung cho các phần tử
                    customerNameSpan.textContent = result.customer.customerName;
                    dateSpan.textContent = result.date;
                    // Thêm class cho các phần tử
                    customerNameSpan.classList.add('text-left');
                    dateSpan.classList.add('text-right');
                    // Sử dụng style để áp dụng CSS trực tiếp
                    customerNameSpan.style.fontWeight = 'bold';
                    // add cấp 3 vào cấp 2
                    divAvtName.appendChild(Avt);
                    divAvtName.appendChild(customerNameSpan);
                    divAvtName.appendChild(dateSpan);
                    // Tạo phần tử <div> cha
                    const divContainer = document.createElement('div'); // cấp 2
                    divContainer.style.position = 'relative';
                    divContainer.style.display = 'inline-block';
                    divContainer.style.width = '100%';

                    // Tạo phần tử <input>
                    const input = document.createElement('input');
                    input.type = 'text';
                    input.value = result.content;
                    input.id = 'editreply' + result.feedback + result.replyId;
                    input.readOnly = true;
                    input.style.marginLeft = '60px';
                    input.style.border = '0px';
                    input.style.background = 'transparent';
                    input.style.outline = 'none';
                    input.style.width = '90%';

                    // Tạo phần tử <a>
                    const anchor = document.createElement('a');
                    anchor.id = 'edit' + result.feedback + result.replyId;
                    anchor.style.position = 'absolute';
                    anchor.style.right = '25px';
                    anchor.style.top = '50%';
                    anchor.style.transform = 'translateY(-50%)';
                    anchor.style.color = '#dbcc8f';
                    anchor.style.cursor = 'pointer';
                    anchor.style.display = 'none';

                    // Tạo phần tử <i> cho icon
                    const icon = document.createElement('i');
                    icon.classList.add('fa', 'fa-paper-plane');
                    // Gắn <i> vào <a>
                    anchor.appendChild(icon);

                    // Gắn <input> và <a> vào <div> cha
                    divContainer.appendChild(input);
                    divContainer.appendChild(anchor);
                    // tạo 1 div bao quanh nút chỉnh sửa và xóa
                    const divEditDelete = document.createElement('div');
                    divEditDelete.style.dispaly = "flex";
                    // tạo các nút sửa (kích hoạt thẻ input hoạt động) 
                    const Edit = document.createElement('a');
                    Edit.textContent = 'Chỉnh sửa';
                    Edit.id = "clickEdit" + result.feedback + result.replyId;
                    Edit.style.marginLeft = "60px";
                    Edit.style.color = "#dbcc8f";
                    Edit.style.cursor = "pointer";
                    Edit.setAttribute('onclick', 'editReply(this)')
                    divEditDelete.appendChild(Edit);
                    // tạo thẻ input ẩn để xác định id của reply <input type="hidden" value="${reply.replyId }" id="repyId${item.reviewId }${reply.replyId }"> 		 
                    const replyId = document.createElement('input');
                    replyId.type = "hidden";
                    replyId.id = "repyId" + result.feedback + result.replyId;
                    replyId.value = result.replyId;
                    // gán cấp 2 vào cấp 1
                    divReply.appendChild(divAvtName);
                    divReply.appendChild(divContainer);
                    divReply.appendChild(divEditDelete);
                    divReply.appendChild(replyId);
                    // xóa cmt đã nhập 
                    var cmt = document.getElementById("content" + result.feedback);
                    cmt.value = "";
                },
                error: function (error) {
                    //showToast("Edit request failed","danger");
                    window.location.href = window.location.href;
                    console.log(error);
                }
            });
        };
        //phần chỉnh sửa cmt
        // vì phần cmt sẽ được thêm động vào DOM nên các phần tử đó sẽ không thể gọi trực tiếp $('a[id^="edit"]').click(function () {
        // => cần sử dụng event delegation thông qua một phần tử cha( document hoặc có thể hay bằng phần tử cha gần nhất) đã có sẵn từ đầu 
        $(document).on('click', 'a[id^="edit"]', function () {
            var index = $(this).attr('id').replace('edit', '');
            var content = $('#editreply' + index).val();
            var customerName = $('#customer').val();
            var customer = {
                customerName: customerName
            }
            var replyId = $('#repyId' + index).val();
            /* sendEditReply({content:content,customer:customer,replyId:replyId}) */
            $.ajax({
                url: '${ApiUrl}',
                type: 'post',
                data: JSON.stringify({
                    content: content,
                    customer: customer,
                    replyId: replyId
                }),
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                    // lấy ô nhập đó trả về readonly và thay đổi bằng giá trị mơis
                    var content = document.getElementById("editreply" + index);
                    content.textContent = result.content;
                    var time = document.getElementById("time" + index);
                    time.textContent = result.date;
                    content.readOnly = true;
                    // bỏ khung bỏ viền
                    // Thay đổi CSS cho ô input
                    content.style.border = "0px"; // ẩn viền
                    content.style.padding = "0px"; // Thay đổi padding
                    // Lấy ID của thẻ <a>
                    var editLinkId = "edit" + index;
                    // ẩn nút mũi tên để gửi bình luận đi bằng ID và hiển thị nó
                    var editLink = document.getElementById(editLinkId);
                    editLink.style.display = "none";
                },
                error: function (error) {
                    //showToast("Edit request failed","danger");
                    console.log(error);
                }
            });
        });

        // hàm thêm vào giỏ hàng
        $('button[id^="addToCart"]').click(function () {
            var index = $(this).attr('id').replace('addToCart', '');
            var productId = $('#idProduct' + index).val();
            var sl = $('#quantity' + index).val();
            var color = $('#color' + index).val();
            var size = $('#size' + index).val();
            add({
                productId: productId,
                soLuong: sl,
                color: color,
                size: size
            })
        });

        function add(data) {
            $.ajax({
                url: '${CartUrl}',
                type: 'post',
                data: JSON.stringify(data),
                contentType: 'application/json',
                dataType: 'json',
                success: function (result) {
                    window.location.href = window.location.href;
                },
                error: function (error) {
                    //showToast("Edit request failed","danger");
                    window.location.href = window.location.href;
                    console.log(error);
                }
            });
        }
        $(document).ready(function () {
            $('.dropdown-menu ').click(function () {
                event.stopPropagation();
            });
        });
    </script>
</body>

</html>