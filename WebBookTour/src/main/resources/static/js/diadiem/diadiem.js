
$(document).ready(function() {
    $(document).on('click','.page-item',function ()
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
        $('#tableDiaDiem').html('');
        $.ajax({
            url: '/admin/diadiem/' + page,
            type: 'POST',
            contentType: 'application/json',
            success: function (respone) {
                $('#tableDiaDiem').html(respone);
            },
            error: function (xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });
    $(document).on('click','.btnEdit', function() {
        const id = $(this).attr('data-id');


        if (!$('#editModalLocation').hasClass('show')) {

            $.ajax({
                url: '/admin/diadiem/edit/' + id,
                type: 'GET',
                contentType: 'application/json',
                success: function (respone) {
                    $('#modalContainer').html(respone);
                    $('#editModalLocation').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });
    $(document).on('shown.bs.modal','#deleteModal',function (event)
    {
        const button = event.relatedTarget;
        const id = button.getAttribute('data-id');
        const buttonConfirmDelete = document.getElementById("btnCDelete");
        buttonConfirmDelete.setAttribute('data-id',id);
    });
    $(document).on('click','#btnCDelete',function ()
    {
        const attributeValue = $(this).attr('data-id');
        $.ajax({
            url: '/api/admin/diadiem/delete',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(attributeValue),
            success: function (respone) {
                location.reload();

            },
            error: function (xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });

    $(document).on('hidden.bs.modal', '#exampleModal', function () {
        $('#modalContainer').html('');
    });
    $(document).on('hidden.bs.modal', '#editModalLocation', function () {
        $('#modalContainer').html('');
    });
    $(document).on('click','#addLocationButton', function() {
        if (!$('#exampleModal').hasClass('show')) {
            $.ajax({
                url: '/admin/diadiem/add',
                type: 'GET',
                success: function (data) {
                    $('#modalContainer').html(data);
                    $('#exampleModal').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });

});
