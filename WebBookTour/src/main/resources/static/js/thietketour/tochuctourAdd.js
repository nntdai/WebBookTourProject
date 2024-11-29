$(document).ready(function() {
    $("#ngayKhoiHanhError").hide();
    $("#errorGiaTour").hide();
    $(document).on('click','#btnAddToChucTour',function(){
        var ngayKH = $("#ngayKH").val();
        var ngayVe = $("#ngayVe").val();
        var soLuong =$("#soLuong").val();
        var idNhanVien =$("#idNhanSu").val();
        var idTour=$(this).attr('data-id');
        var complete =true;
        if (ngayKH==="")
        {
            $("#ngayKhoiHanhError").html("Vui lòng chọn ngày khởi hành !");
            $("#ngayKhoiHanhError").show();
            complete=false;
        }
        else
        {
            $("#ngayKhoiHanhError").html("");
            $("#ngayKhoiHanhError").hide();
        }

        if (soLuong==="")
        {

            $("#errorGiaTour").html("Vui lòng nhập số chỗ !");
            $("#errorGiaTour").show();
            complete=false;
        }
        else if (soLuong<1)
        {
            $("#errorGiaTour").html("Số chỗ phải là 1 số nguyên dương !");
            $("#errorGiaTour").show();
            complete=false;
        }
        else
        {
            $("#errorGiaTour").html("");
            $("#errorGiaTour").hide();
        }
        if (complete==true)
        {
            ngayKH = ngayKH + ":00Z";
            ngayVe = ngayVe + ":00Z";
            const datChoTourDTO={
                ngayKH:ngayKH,
                ngayVe:ngayVe,
                soCho:soLuong,
                soChoCon:soLuong,
                idTourDuLich :
                    {
                        id:idTour
                    },
                idHDV:
                    {
                        id:idNhanVien
                    }
            }

            $.ajax({
                url: '/api/admin/toudulich/addToChucTour',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(datChoTourDTO),
                success: function(respone) {
                    alertSucess(respone);
                    $.ajax({
                        url: '/admin/tourdesign/getToChucTour/reload',
                        type: 'GET',
                        contentType: 'application/json',
                        data: { idTour: idTour },
                        success: function(data) {
                            $("#tableToChucTour").html(data);
                        },
                        error: function(xhr) {

                        }
                    });
                },
                error: function(xhr) {

                }
            });

        }

    });



});
