
$(document).ready(function() {
    $('#btnAdd').on('click', function() {
        alert("Hi")
        const ten = document.getElementById("ten").value;
        const vungMien = document.getElementById("vungMien").value;

        // Tạo đối tượng DTO để gửi lên server
        const diadiemDto = {
            ten: ten,
            idVungMien: {
                id: vungMien,  // Chỉ gửi ID của vùng miền

            }
        };
        $.ajax({
            url: '/api/admin/diadiem/add',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(diadiemDto),
            success: function(respone) {
                // Đặt nội dung của modal vào một container, ví dụ là #modalContainer
               alert("Thành công");
                location.reload();
            },
            error: function(xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });


    $('#addLocationButton').on('click', function() {
        // Gửi yêu cầu AJAX tới server để lấy nội dung của modal
        $.ajax({
            url: '/admin/diadiem/add',
            type: 'GET',
            success: function(data) {
                // Đặt nội dung của modal vào một container, ví dụ là #modalContainer
                $('#modalContainer').html(data);

                // Kích hoạt modal sau khi nội dung được tải
                $('#exampleModal').modal('show');
            },
            error: function(xhr, status, error) {
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });
    $(document).on('hidden.bs.modal', '#exampleModal', function () {
        // Xóa nội dung modal để tránh xung đột
        $('#modalContainer').html('');
    });
});
