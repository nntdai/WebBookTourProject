$(document).ready(function()
{
    $(document).on('click','#addTourDesignModal', function() {
        if (!$('#thietkeTourModalAdd').hasClass('show')) {
            $.ajax({
                url: '/admin/tourdesign/add',
                type: 'GET',
                success: function (data) {
                    $('#modalContainer').html(data);
                    $('#thietkeTourModalAdd').modal('show');
                },
                error: function (xhr, status, error) {
                    console.error("Không thể tải nội dung modal:", error);
                }
            });
        }
    });
});