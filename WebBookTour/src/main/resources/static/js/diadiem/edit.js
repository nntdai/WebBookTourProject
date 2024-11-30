$(document).ready(function() {
    $('#btnEditLocation').on('click', function() {
        const ten = document.getElementById("ten").value.trim();
        const id =this.getAttribute("data-id");
        const vungMien = document.getElementById("vungMien").value

        // Create DTO to send to RestController
        const diadiemDto = {
            id:id,
            ten: ten,
            idVungMien: {
                id: vungMien,
            }
        };
        $.ajax({
            url: '/api/admin/diadiem/edit',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(diadiemDto),
            success: function(respone) {
                alertSucess("Sửa địa điểm mới thành công !");
                setTimeout(function () {
                    location.reload();
                }, 500); // 3000ms = 3 giây
            },
            error: function(xhr) {
                var errorMessages = xhr.responseText;
                $('#errorNameEdit').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: -12px;height:40px;padding-top: 10px">\n' +errorMessages+
                    '</div>');
            }
        });
    });
});