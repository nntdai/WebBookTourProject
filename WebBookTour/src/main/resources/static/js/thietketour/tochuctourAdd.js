$(document).ready(function() {

    $("#ngayKhoiHanhError").hide();
    $("#errorGiaTour").hide();

    $(document).on('click','.tochucpage',function ()
    {

        var idTour=$("#btnAddToChucTour").attr('data-id');
        const pageSelected = $(this).data('page');
        const pagePresent =$('.page-item.active').data('page');
        const totalPage =$('#dataTable').attr('data-id')-1 ;
        var page= 0;
        if ((pageSelected==-1)||(pageSelected==="+1"))
        {
            const pageT = +pagePresent + +pageSelected ;
            if ((pageT>=0)&&(pageT<=totalPage))
                page = pageT ;
            else
                return;
        }
        else if (pageSelected==pagePresent) return;
        else
        {
            page = pageSelected;
        }
        $('#tableToChucTour').html('');
        $.ajax({
            url: '/admin/tourdesign/getpageToChuc',
            type: 'GET',
            contentType: 'application/json',
            data: { idTour: idTour ,
                    page : page},
            success: function (respone) {
                $('#tableToChucTour').html(respone);
            },
            error: function (xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);

            }
        });
    });
    $('#toChucTourModal').on('shown.bs.modal', function () {
        $('#btnThemToChuc').off('click').on('click', function() {
            var ngayKH = $("#ngayKH").val();
            var ngayVe = $("#ngayVe").val();
            var soLuong =$("#soLuong").val();
            var idNhanVien =$("#idNhanSu").val();
            var idTour=$(this).attr('data-id');
            $('#btnThemToChuc').prop('disabled', true);
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
                console.log("ngay vua chon : "+ ngayKH);

                let ngayKHinstant = new Date(ngayKH);


                let utcDateNgayKH = ngayKHinstant.toISOString();

                let ngayVeinstant =  new Date(ngayVe);
                let utcDateNgayVe = ngayVeinstant.toISOString();
                console.log("instant : "+ ngayKHinstant);

                const datChoTourDTO={
                    ngayKH:utcDateNgayKH,
                    ngayVe:utcDateNgayVe,
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
                        if (respone===true)
                        alertSucess("Tổ chức 1 tour mới thành công!");
                        else alertError("Ngày khởi hành đã có trong hệ thống. Vui lòng chọn ngày khác!");
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

                    },
                    complete: function() {
                        // Kích hoạt lại nút sau khi AJAX hoàn tất

                    }

                });

            }
            $('#btnThemToChuc').prop('disabled', false);

        });
    });




});
