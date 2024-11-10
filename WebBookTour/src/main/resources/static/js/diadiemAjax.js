
let listView ="admin/diadiem"

let SinhVienAPI ="admin/api/diadiem"

$(document).ready(function() {
    function loadData(){

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: SinhVienAPI,

            success: function (responseData) {
                console.log(responseData)
                // $("#dataSinhVien").html(responseData)
            }
        })}


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
