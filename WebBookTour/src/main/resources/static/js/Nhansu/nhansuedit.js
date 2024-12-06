$(document).ready(function() {
    $('#btnEditNhansu').on('click', function() {
        const ten = document.getElementById("ten_ns").value.trim();
        const id =this.getAttribute("data-id");
        const diachi = document.getElementById("dc_ns").value.trim();
        const cmnd = document.getElementById("cmnd_ns").value.trim();
        const sdt = document.getElementById("sdt_ns").value.trim();
        const email = document.getElementById("email_ns").value.trim();
        const img=document.getElementById("img_ns").value.trim();
        // Create DTO to send to RestController
        const nhansuDto = {
            id : id,
            ten: ten,
            diaChi : diachi,
            cmnd : cmnd,
            soDienThoai: sdt,
            email : email,
            hinhAnh : img
        };
        $.ajax({
            url: '/api/admin/nhansu/edit',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(nhansuDto),
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
function changePic(){
    const fileInput = document.getElementById('inputGroupFile02');
    const previewImage = document.getElementById('previewImage');

    // Kiểm tra nếu có tệp được chọn
    if (fileInput.files && fileInput.files[0]) {
        const reader = new FileReader();

        // Sự kiện load ảnh
        reader.onload = function (e) {
            previewImage.src = e.target.result; // Cập nhật ảnh
            document.getElementById('img_ns').value=fileInput.files[0].name;
        };

        // Đọc tệp dưới dạng URL data
        reader.readAsDataURL(fileInput.files[0]);
    }
}