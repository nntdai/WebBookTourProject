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
(() => {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
})()