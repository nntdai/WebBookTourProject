$(document).ready(function(){
    $(document).on('click','.page-item', function (){
        $('#loading').hide();
        const pageSelected = $(this).data('page');
        const pagePresent =$('.page-item.active').data('page');
        const totalPage =$('#dataTable').attr('data-id')-1;
        var page=0;
        if((pageSelected==-1)||(pageSelected==="+1")){
            const pageT = +pagePresent + +pageSelected;
            if((pageT>=0)&&(pageT<=totalPage))
                page=pageT;
            else
                return;
        }else if(pageSelected==pagePresent) return;
        else
            page=pageSelected;
        $('#tableDatchotour').html('');
        $.ajax({
            url :'/admin/datchotour/' + page,
            type :'GET',
            contentType :'application/json',
            success: function (respone){
                $('#tableDatchotour').html(respone);
            },
            error: function (xhr, status, error){
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    });
    $(document).on('click','.btnView', function (){
        // alert("hi");
        const id=$(this).attr('data-id');
        if(!$('#ViewModal').hasClass('show')){
            $.ajax({
                url: '/admin/datchotour/view/'+id,
                type:'GET',
                contentType: 'application/json',
                success: function (respone){
                    $('#modalContainer').html(respone);
                    $('#ViewModal').modal('show');
                },
                error: function (xhr, status, error){
                    console.error("Không thể tải nội dung modal:",error);
                }
            });
        }
    });
    $(document).on('hidden.bs.modal', '#ViewModal', function () {
        $('#modalContainer').html('');
    });
    $(document).on('click', '#btnSearch', function (){
        const value=$('#Search_text').val();
        alert(value);
        $('#loading').hide();
        const pageSelected = $(this).data('page');
        const pagePresent =$('.page-item.active').data('page');
        const totalPage =$('#dataTable').attr('data-id')-1;
        var page=0;
        if((pageSelected==-1)||(pageSelected==="+1")){
            const pageT = +pagePresent + +pageSelected;
            if((pageT>=0)&&(pageT<=totalPage))
                page=pageT;
            else
                return;
        }else if(pageSelected==pagePresent) return;
        else
            page=pageSelected;
        $('#tableDatchotour').html('');
        $.ajax({
            url :'/admin/datchotour/search',
            type :'GET',
            data:{
                keyword : value,
            },
            contentType :'application/json',
            success: function (respone){
                console.log(respone);
                $('#tableDatchotour').html(respone);
            },
            error: function (xhr, status, error){
                console.error("Không thể tải nội dung modal:", error);
                console.error("keyword: ", { keyword: value, page: page, size: 10 })
            }
        });
    });
    $(document).on('click', '#SearchButton', function (){
        $('#SearchModal').modal('show');
    })
})