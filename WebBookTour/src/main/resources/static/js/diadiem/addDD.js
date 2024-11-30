$(document).ready(function() {
    $('#btnAdd').on('click', function() {
        const ten = document.getElementById("ten").value.trim();
        const vungMien = document.getElementById("vungMien").value;

        // Create DTO to send to RestController
        const diadiemDto = {
            ten: ten,
            idVungMien: {
                id: vungMien,
            }
        };
        $.ajax({
            url: '/api/admin/diadiem/add',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(diadiemDto),
            success: function(respone) {
                alertSucess("Thêm địa điểm mới thành công !");
                setTimeout(function () {
                    location.reload();
                }, 500); // 3000ms = 3 giây
            },
            error: function(xhr) {
                var errorMessages = xhr.responseText;
                $('#errorName').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: -12px;height:40px;padding-top: 10px">\n' +errorMessages+
                    '</div>');
            }
        });
    });
});