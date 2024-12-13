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
    // $(document).on('hidden.bs.modal', '#ViewModal', function () {
    //     $('#modalContainer').html('');
    // });
    $(document).on('click', '#btnSearch', function (){
        const value=$('#Search_text').val();
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
            url :'/admin/datchotour/searchall',
            type :'GET',
            data:{
                keyword : value,
            },
            contentType :'application/json',
            success: function (respone){
                $('#tableDatchotour').html(respone);
            },
            error: function (xhr, status, error){
            }
        });
    });
    $(document).on('click', '#SearchButton', function (){
        if(!$('#SearchModal').hasClass('show')){
            $.ajax({
                url :'/admin/datchotour/search',
                type : 'GET',
                contentType: 'application/json',
                success: function (respone){
                    $('#modalContainer').html(respone);
                    $('#SearchModal').modal('show');
                },
                error: function (xhr, status, error){
                    console.error("Không thể tải nội dung modal:",error);
                }
            });
        }
    });
    $(document).on('click', '#Acceptbtn', function(){
        const madattour = $('#madattour').val().toString();
        const tourdulich=$('#tourdl').val().toString();
        const sdtKH=$('#sdtKH').val().toString();

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
            url :'/admin/datchotour/filter',
            type :'GET',
            data:{
                matour : madattour,
                tourdl : tourdulich,
                sdt : sdtKH
            },
            contentType :'application/json',
            success: function (respone){
                $('#tableDatchotour').html(respone);
            },
            error: function (xhr, status, error){
                console.error("Không thể tải nội dung modal:", error);
            }
        });
    })
    $(document).on('click', '#detailbtn', function (){
        $('#ViewModal').modal('hide');
        $('#ChiTietModal').modal('show');
    });
    $(document).on('click', '#Backbtn', function (){
        $('#ChiTietModal').modal('hide');
        $('#ViewModal').modal('show');
    })
})