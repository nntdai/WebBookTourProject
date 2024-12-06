$(document).ready(function() {
    $(document).on('click', '.page-item', function () {
        $('#loading').hide();
        const pageSelected = $(this).data('page');
        const pagePresent = $('.page-item.active').data('page');
        const totalPage = $('#dataTable').attr('data-id') - 1;
        var page = 0;
        if ((pageSelected == -1) || (pageSelected === "+1")) {
            const pageT = +pagePresent + +pageSelected;
            if ((pageT >= 0) && (pageT <= totalPage))
                page = pageT;
            else
                return;
        } else if (pageSelected == pagePresent) return;
        else
            page = pageSelected;
        $('#tableNhanSu').html('');
        $.ajax({
            url: '/admin/nhansu/' + page,
            type: 'GET',
            contentType: 'application/json',
            success: function (respone) {
                $('#tableNhanSu').html(respone);
            },
            error: function (xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });
    $(document).on('click', '.btnEdit', function () {
        const id=$(this).attr('data-id');
        if(!$('#ViewModal').hasClass('show')){
            $.ajax({
                url: '/admin/nhansu/edit/'+id,
                type:'GET',
                contentType: 'application/json',
                success: function (respone){
                    $('#modalContainer').html(respone);
                    $('#ViewNSModal').modal('show');
                },
                error: function (xhr, status, error){
                    console.error("Không thể tải nội dung modal:",error);
                }
            });
        }
    });
    $(document).on('click', '#addButton', function () {
        $('#AddNSModal').modal('show');
        // if(!$('#ViewModal').hasClass('show')){
        //     $.ajax({
        //         url: '/admin/nhansu/add/',
        //         type:'GET',
        //         contentType: 'application/json',
        //         success: function (respone){
        //             $('#modalContainer').html(respone);
        //             $('#AddNSModal').modal('show');
        //         },
        //         error: function (xhr, status, error){
        //             console.error("Không thể tải nội dung modal:",error);
        //         }
        //     });
        // }
    });
})