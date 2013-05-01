window.tools = {

    /*  Asynchronously load templates located in separate .html files
        Refs :
            - https://github.com/ccoenraets/backbone-cellar/blob/master/bootstrap/js/utils.js
            - https://github.com/ccoenraets/backbone-cellar/blob/master/bootstrap/js/main.js
    */

    loadTemplates: function(templatesPkg, views, callback) {

        var deferreds = [];

        $.each(views, function(index, view) {

            deferreds.push($.get('templates/' + view + '.html', function(data) {
                templatesPkg[view] = data;
            }));

        });

        $.when.apply(null, deferreds).done(callback);
    }
}