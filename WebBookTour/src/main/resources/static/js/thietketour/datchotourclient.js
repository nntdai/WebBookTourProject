$(document).ready(function()
{
    $(document).on('click','#btnDatTour',
    function()
    {
        var name = $('#name').val();
        var phone=  $('#phone').val();
        var email = $('#email').val();
        let khachhangdto=
            {
                soDienThoai: phone,
                email: email,
                ten : name
            };
        console.log(khachhangdto);
    });

});


