$(document).on('click', 'a[endpoint]', function (event) {
    var endpoint = $(this).attr('endpoint');
    var divId = $(this).attr('divId');
    if(divId != undefined){
        $("#"+divId).load("/"+endpoint);
    } else{
        $("#content").load("/"+endpoint);
    }
});

$(document).on('click','button[endpoint]', function (event) {
    var endpoint = $(this).attr('endpoint');
    var divId = $(this).attr('divId');
    if(divId != undefined){
        $("#"+divId).load("/"+endpoint);
    } else{
        $("#content").load("/"+endpoint);
    }
});


$(document).on('submit', '.form-ajax', function (event) {
    var form = event.target;
    ajaxSubmitForm(form);
    return false;
});


function ajaxSubmitForm(form) {
    var container = $(form).attr('data-target');
    var containerId = '#' + container;
    var url = $(form).attr('action');

    $.ajax({
        type: "POST",
        url: url,
        data: $(form).serialize(), // serializes the form's elements.
        beforeSend: function (xhr) {

            $.blockUI({
                message: '<i class="fa fa-4x fa-cog fa-spin text-info"> </i>',
                css: {border: 'none', backgroundColor: 'transparent'}
            });

        },
        success: function (data) {
            $(containerId).html(data);
        }
    })

        .fail(function () {

        })
        .always(function () {
            $.unblockUI();
        });
}


