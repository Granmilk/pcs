$(document).on('click', 'a[endpoint]', function (event) {
    var endpoint = $(this).attr('endpoint');
    var divId = $(this).attr('divId');
    if (divId != undefined) {
        $("#" + divId).load("/" + endpoint);
    } else {
        $("#content").load("/" + endpoint);
    }
});

$(document).on('click', 'button[endpoint]', function (event) {
    var endpoint = $(this).attr('endpoint');
    var divId = $(this).attr('divId');
    if (divId != undefined) {
        $("#" + divId).load("/" + endpoint);
    } else {
        $("#content").load("/" + endpoint);
    }
});

$(document).on('keyup', '.busca-navbar', function (event) {
    var form = $('#form-navbar');
    ajaxSubmitForm(form);
    return false;
});

$(document).on('keyup', '.busca-veiculo-cliente', function (event) {
    var form = $('#input-busca-veiculo-cliente');
    ajaxSubmitForm(form);
    return false;
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
        success: function (data) {
            $(containerId).html(data);
        }
    })

        .fail(function () {
        });
}


