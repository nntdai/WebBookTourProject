$(document).ready(function()
{
    $(document).on('click','.thietketour',function ()
    {

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
        $('#tableTourDesign').html('');
        $.ajax({
            url: '/admin/tourdesign/' + page,
            type: 'GET',
            contentType: 'application/json',
            success: function (respone) {
                $('#tableTourDesign').html(respone);
            },
            error: function (xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);

            }
        });
    });
    $(document).on('hidden.bs.modal', '#addTourDesignModal', function () {
        $('#modalContainer').html('');
    });
    $(document).on('click','#addTourDesignModal', function() {
        if (!$('#thietkeTourModalAdd').hasClass('show')) {
            $.ajax({
                url: '/admin/tourdesign/add',
                type: 'GET',
                success: function (data) {
                    $('#modalContainer').html(data);
                    $('#thietkeTourModalAdd').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });
    $(document).on('hidden.bs.modal', '#toChucTourModal', function () {
        $('#modalContainer').html('');
    });

    $(document).on('click','.btnAddToChuc', function() {
        var idTour = this.getAttribute("data-id");
        var day =this.getAttribute("data-dto")
        $('#modalContainer').html('');
        if (!$('#toChucTourModal').hasClass('show')) {
            console.log("Nút Mở To Chức");
            $.ajax({
                url: '/admin/tourdesign/getToChucTour',
                type: 'GET',
                data: {
                    idTour: idTour,
                    day: day
                },
                success: function (data) {
                    $('#modalContainer').html(data);
                    $('#toChucTourModal').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });

    $(document).on('click','.btnEdit', function() {
        const tourDTOJson = this.getAttribute("data-dto");    // Tour Du Lịch DTO Json
        if (!$('#thietkeTourModalEdit').hasClass('show')) {
            $.ajax({
                url: '/admin/tourdesign/edit',
                type: 'POST',
                contentType: 'application/json',
                data:tourDTOJson,
                success: function (data) {
                    $('#modalContainer').html(data);
                    $('#thietkeTourModalEdit').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });
});