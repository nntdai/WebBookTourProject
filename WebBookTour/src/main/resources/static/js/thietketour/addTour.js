
$(document).ready(function() {
    const imgDOM = "imgN";        // Id chung của image src
    const imgInput ="imgInputN";
    const textTenDom ="tenN";
    const cBSang ="btncheck1N";
    const cBTrua="btncheck2N";
    const cBChieu="btncheck3N";
    const cBToi="btncheck4N";
    const moTa="motaN";
    const errorIMGDom="errorImgN";
    const errorTenDom="errorTenN";
    const errorMotaDom="errorMotaN";



    let previousValue = $("#thoiGian").val();      // Thời gian khi khởi tạo

    $(document).on('click','#btnAddTour',function (){
        // {
        var tenTour=$('#tenTour').val();
        var giaTour=$('#giaTour').val();
        var diaDiemKH =$('#diaDiemKH').val();
        var diaDiemTQ=$('#diaDiemTQ').val();
        var ptDiChuyen=$('#ptDiChuyen option:selected').text();
        var day = $("#thoiGian").val();
        var thoiGian = day +"N" + (day-1) +"Đ";
        // } Các giá trị của các DOM trên form ;

        var complete=true; // Lính canh để validate .
        const lichTrinhList=[];     // Danh sách chi tiết lịch trình DTO


        for (let i=1;i<=day;i++) {
            let tenChiTiet = $("#" + textTenDom + i).val();
            let hinhAnh = $("#" + imgInput + i).prop('files')[0];
            let moTaText = $("#" + moTa + i).val();
            let errorTen = $("#" + errorTenDom + i);
            let errorImg =  $("#" + errorIMGDom + i);
            let errorMota = $("#" + errorMotaDom + i);
            if (tenChiTiet == "") {
                complete = false;
                errorTen.removeClass('fade').show();
                errorTen.text("Tên không được để trống !");
            }
            else
            {
                errorTen.text("");
                errorTen.fadeOut();
            }
            if (hinhAnh == null) {
                complete = false;
                errorImg.removeClass('fade').show();
                errorImg.text("Hình ảnh không được trống");
            }
            else
            {
                errorImg.text("");
                errorImg.fadeOut();
            }
            if (moTaText == "")
            {
                complete = false;
                errorMota.removeClass('fade').show();
                errorMota.text("Mô tả không được trống ");
            }
            else
            {
                errorMota.text("");
                errorMota.fadeOut();
            }
        }

            if (complete===true) {
                var formData = new FormData();
                for (let i=1;i<=day;i++) {

                    formData.append('files',$("#" + imgInput + i).prop('files')[0]);
                    let lichTrinhDTO =
                        {
                            tenChiTiet: $("#" + textTenDom + i).val(),
                            ngayThu: i,
                            buaSang: $("#" + cBSang + i).is(':checked') ? 1 : 0,
                            buaTrua: $("#" + cBTrua + i).is(':checked') ? 1 : 0,
                            buaChieu: $("#" + cBChieu + i).is(':checked') ? 1 : 0,
                            buaToi: $("#" + cBToi + i).is(':checked') ? 1 : 0,
                            mota: $("#" + moTa + i).val()
                        }
                    lichTrinhList.push(lichTrinhDTO);
                }
                let tourDuLichDTO =
                    {
                        ten:tenTour,
                        giaTour:giaTour,
                        thoiGian:thoiGian,
                        diaDiemKH:
                            {
                                id: diaDiemKH
                            },
                        diaDiemThamQuan:
                            {
                                id:diaDiemTQ
                            },
                        phuongTienDiChuyen:ptDiChuyen,
                        chitietlichtrinhs:lichTrinhList,
                        status:1
                    }
                formData.append('tourDuLichDTO',JSON.stringify(tourDuLichDTO))
                $.ajax({
                    url: '/api/admin/toudulich/add',
                    type: 'POST',
                    data: formData,
                    processData: false,  // Không tự động xử lý dữ liệu
                    contentType: false,  // Để ngăn jQuery tự động gán Content-Type
                    success: function(response) {
                        alertSucess("Thêm tour du lịch thành công");
                        setTimeout(function () {
                            location.reload();
                        }, 1000); // 3000ms = 3 giây
                    },
                    error: function(xhr, status, error) {
                        console.error("AJAX error: " + error);
                    }
                });
            }
            else
            {
                alertError("Thông tin nhập không hợp lệ !");
            }



    });
    $(document).on('click','#btnOpenLichTrinh',function (e) {
        var tenTour=$('#tenTour').val();
        var giaTour=$('#giaTour').val();
        var complete = true;
        if (tenTour==="") {
            let errorMessages ="Tên tour không được trống";
            $('#errorNameTour').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: 10px;height:40px;padding-top: 10px">\n' +errorMessages+
                '</div>');
            complete=false;
        }
        if ((giaTour==="")||(giaTour<100000)||(giaTour % 1000!==0))
        {
            let errorMessages;
            if (giaTour==="")  errorMessages ="Giá tour không được trống";
            else if (giaTour<100000) errorMessages ="Giá tour phải từ 100.000 VND";
            else errorMessages ="Giá tour là bội số của 1.000 VND";

            $('#errorGiaTour').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: 10px;height:40px;padding-top: 10px">\n' +errorMessages+
                '</div>');
            complete=false;
        }
        if (complete===true)
        {
            $('#errorNameTour').html('');
            $('#errorGiaTour').html('');
            $('#thietkeTourModalAdd').modal('hide');
            $('#chitietLichTrinh').modal('show');
        }
    });
    $(document).on('change', '.imgInput', function() {
        var file = $(this).prop('files')[0]; // Truy cập tệp đầu tiên được chọn , ở đây chỉ có 1 file
        const day = $(this).attr('data-id');
        const imgDisplay = imgDOM + day; // Biến day xác định img src day ví dụ imgN1,imgN2

        if (file) {
            // Kiểm tra xem file có phải là ảnh hay không
            if (file.type.startsWith('image/')) {
                var reader = new FileReader();

                reader.onload = function(e) {
                    var fileDataUrl = e.target.result; // Data URL của tệp
                    $("#" + imgDisplay).attr("src", fileDataUrl); // Gán ảnh vào thẻ img
                };

                reader.readAsDataURL(file); // Mấu chốt để thực hiện đoạn trên
            } else {
                alertError("Vui lòng chọn một tệp ảnh hợp lệ!");
                $(this).val('');
            }
        }
        else
        {
            $("#" + imgDisplay).attr("src","/img/empty.jpg");
        }
    });

    $("#thoiGian").on("input", function() {
        const day = $("#thoiGian").val();


        if (previousValue < day) {

            $.ajax({
                url: '/admin/tourdesign/addFormTour/' + day,
                type: 'GET',
                contentType: 'application/json',
                success: function(response) {
                    $("#modalBodyLichTrinh").append(response);
                    previousValue = day;
                },
                error: function(xhr, status, error) {
                    console.error("AJAX error: " + error);
                }
            });
        }
        else {
            if (previousValue == 1 && day == 1) {
                console.log("KHong tru");
            } else {
                previousValue = day;
                $("#modalBodyLichTrinh .modal-content").last().remove();

            }
        }


    });
});