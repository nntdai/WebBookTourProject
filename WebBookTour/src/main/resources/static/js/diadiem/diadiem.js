
$(document).ready(function() {
    $('.btnEdit').on('click', function() {
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
    $('#deleteModal').on('shown.bs.modal',function (event)
    {
        const button = event.relatedTarget;
        const id = button.getAttribute('data-id');
        const buttonConfirmDelete = document.getElementById("btnCDelete");
        buttonConfirmDelete.setAttribute('data-id',id);
    });
    $('#btnCDelete').on('click',function ()
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
    $('#addLocationButton').on('click', function() {
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
