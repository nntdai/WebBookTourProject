$(document).ready(function()
{

    var varHoTen = "hoTen";       // các quy tắc đặt tên của thông tin khách hàng
    var gioiTinh ="gioiTinh";
    var ngaySinhDom = "ngaySinh";



    $("#name").on("input",checkName);
    $("#phone").on("input",checkSdt);
    $("#email").on("input",checkEmail);

    function checkName()
    {
        var name = $('#name').val().trim();
        if (name==="") {

            $("#ErrorName").html("Tên không được để trống !");
            $("#ErrorName").show();
            return false;
        }

            $("#ErrorName").html("");
            $("#ErrorName").hide();
            return name;
    }
    function checkSdt()
    {
        var phone=  $('#phone').val().trim();
        if (phone.length<10)
        {

            $("#ErrorPhone").html("Số điện thoại phải từ đủ 10 số trở lên ! ");
            $("#ErrorPhone").show();
            return false;
        }

            $("#ErrorPhone").html(" ");
            $("#ErrorPhone").hide();
            return phone;
    }
    function checkEmail()
    {
        var email = $('#email').val().trim();
        var regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (email==="")
        {

            $("#ErrorEmail").html("Vui lòng nhập Email hợp lệ để nhận mã đặt chỗ !");
            $("#ErrorEmail").show();
            return false;
        }
        if (!regex.test(email)) {
            $("#ErrorEmail").html("Email không hợp lệ! Vui lòng kiểm tra lại.");
            $("#ErrorEmail").show();
            return false;
        }

            $("#ErrorEmail").html("");
            $("#ErrorEmail").hide();
            return email;
    }



    $(document).on('click','#btnDatTour',
    function()
    {
        let DsHanhKhach =[];
        var sLNguoiLon = parseInt($("#adults").val(), 10);
        var sLTreEm = parseInt($("#children").val(), 10);
        var tongSoLuong = sLNguoiLon+sLTreEm;
        var soLuongConLai =soChoCon()-tongSoLuong;
        var complete =true;
        var name =checkName();
        var phone =checkSdt();
        var email =checkEmail();

        if (name===false) complete = false;
        if (phone===false) complete = false;
        if (email===false) complete = false;

        for (var i = 1;i<=sLNguoiLon ;i++ )
        {

                var tenHanhKhach=$("#"+ varHoTen + i).val();

                var ngaySinh = $("#"+ ngaySinhDom + i).val();
                console.log(ngaySinh);

                if ((tenHanhKhach=="")||(ngaySinh==""))
                {
                    complete = false;
                }


        }
        for (var i = 1;i<=sLTreEm ;i++ )
        {

                var tenHanhKhach = $("#"+ varHoTen+"TreEm"+ i).val().trim();
                var  ngaySinh = $("#"+ ngaySinhDom+"TreEm" + i).val();
            if ((tenHanhKhach=="")||(ngaySinh==""))
            {
                complete = false;
            }
        }


        if (complete ===true)
        {

            const now = new Date();



            const date = now.toISOString();

            for (var i = 1;i<=sLNguoiLon ;i++ )
            {
                let thongtinNguoiLon = {
                    tenHanhKhach:$("#"+ varHoTen + i).val(),
                    gioiTinh:$("#"+ gioiTinh + i).val(),
                    ngaySinh : $("#"+ ngaySinhDom + i).val(),
                    nhomTuoi :
                        {
                            id : 0
                        }
                }
                DsHanhKhach.push(thongtinNguoiLon);
            }
            for (var i = 1;i<=sLTreEm ;i++ )
            {
                let thongtinTreEm = {
                    tenHanhKhach:$("#"+ varHoTen+"TreEm"+ i).val().trim(),
                    gioiTinh:$("#"+ gioiTinh+"TreEm" + i).val(),
                    ngaySinh : $("#"+ ngaySinhDom+"TreEm" + i).val(),
                    nhomTuoi :
                        {
                            id : 1
                        }
                }
                DsHanhKhach.push(thongtinTreEm);
            }

        let khachhangdto=
            {
                soDienThoai: phone,
                ten : name,
            };


        let datTourDto={
            diemTLCong:0,
            diemTLDung:0,
            tongTien:tongTien() ,
            sdtKhachHang:khachhangdto,
            idToChucTour:
                {
                    id : idToChucTour ,
                    soChoCon :soLuongConLai
                },
            email:email,
            ngayDatCho:date,
            thongtinhanhkhachs: DsHanhKhach,
            status :1
        }
        console.log(datTourDto);
            $.ajax({
                url: '/api/user/datchotour/add',
                type: 'POST',
                data: JSON.stringify(datTourDto),
                contentType: 'application/json',
                success: function(response) {
                    alertSucess("Thêm tour thành công ! " + response);


                },
                error: function(xhr, status, error) {
                    console.error("AJAX error: " + error);
                }
            });


    }
        else
        {
            alertError("Vui lòng nhập đầy đủ thông tin !");
        }
});
});


