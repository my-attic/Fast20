

$(function() {

    $.getJSON("/infos", function(data){
        console.log(data);
        $(".page-header").html("<h1>"+data.name+" by "+data.author+"</h1>")
    })

    $("body").css("visibility","visible");  /*<body style="visibility:hidden">*/
});



