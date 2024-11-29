$(document).ready(function ()
{
    $(document).on('click','#btnOpenLichTrinhEdit',function (e) {
        var tenTour=$('#tenTour').val();
        var giaTour=$('#giaTour').val();
        var complete = true;
        if (tenTour==="") {
            let errorMessages ="Tên tour không được trống";
            $('#errorNameTour').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: 10px;height:40px;padding-top: 10px">\n' +errorMessages+
                '</div>');
            complete=false;
        }
        if ((giaTour==="")||(giaTour<100000)||(giaTour % 1000!==0))
        {
            let errorMessages;
            if (giaTour==="")  errorMessages ="Giá tour không được trống";
            else if (giaTour<100000) errorMessages ="Giá tour phải từ 100.000 VND";
            else errorMessages ="Giá tour là bội số của 1.000 VND";

            $('#errorGiaTour').html('<div class="alert alert-danger" role="alert" style="font-size: medium;margin-top: 10px;height:40px;padding-top: 10px">\n' +errorMessages+
                '</div>');
            complete=false;
        }
        if (complete===true) {
            $('#errorNameTour').html('');
            $('#errorGiaTour').html('');
            $('#thietkeTourModalEdit').modal('hide');

            $('#chitietLichTrinh').modal('show');
            // }
        }
    });
})