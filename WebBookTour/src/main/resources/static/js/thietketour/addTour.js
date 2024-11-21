
$(document).ready(function() {
    const imgDOM = "imgN";        // Id chung của image src
    $(document).on('change', '.imgInput', function() {
        var file = $(this).prop('files')[0]; // Truy cập tệp đầu tiên được chọn
        const day = $(this).attr('data-id');
        const imgDisplay = imgDOM+day;              // Từ day xác định img src day ví dụ imgN1,imgN2

        console.log(day);
        if (file) {
            var reader = new FileReader();

            reader.onload = function(e) {
                var fileDataUrl = e.target.result; // Data URL của tệp
                $("#" + imgDisplay).attr("src", fileDataUrl);
            };

            reader.readAsDataURL(file); // mấu chốt để thực hiện đoạn trên
        }
    });
   let previousValue = $("#thoiGian").val();
    $("#thoiGian").on("input", function() {
        const day = $("#thoiGian").val();


        if (previousValue < day) {

            $.ajax({
                url: '/admin/tourdesign/addFormTour/' + day,
                type: 'GET',
                contentType: 'application/json',
                success: function(response) {
                    $("#modalBodyLichTrinh").append(response);
                    previousValue = day;
                },
                error: function(xhr, status, error) {
                    console.error("AJAX error: " + error);
                }
            });
        }
        else {
            if (previousValue == 1 && day == 1) {
                console.log("KHong tru");
            } else {
                previousValue = day;
                $("#modalBodyLichTrinh .modal-content").last().remove();

            }
        }


    });
});