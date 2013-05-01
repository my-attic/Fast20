

$(function() {
    var templates = {};
    tools.loadTemplates(templates, ['header'], function() {
        console.log(templates);
        $(".page-header").html(templates.header)
    });

    $("body").css("visibility","visible");  /*<body style="visibility:hidden">*/
});



