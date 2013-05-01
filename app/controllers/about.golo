module about

import java.util.HashMap
import fast.json.Json

# Try this :
#
# $.getJSON("/infos", function(data){ console.log(data); })

#GET
function about = |request, response| {

    let infos = HashMap()
    infos:put("name", "Fast 2")
    infos:put("author", "k33g_org")
    infos:put("age", 44)

    response:type("application/json")

    return Json.stringify(Json.toJson(infos))
}

#$.ajax({
#  type: "POST",
#  url:"/infos",
#  data:'{"firstName":"John", "lastName":"Doe"}',
#  success: function(data){ console.log(data); },
#  dataType: "json"
#});

#POST
function about_post = |request, response| {

    println(request:body())

    let jsonNode = Json.parse(request:body())
    let hashMap = Json.fromJson(jsonNode, HashMap.class)

    let firstName = hashMap:get("firstName")
    let lastName = hashMap:get("lastName")

    hashMap:put("state","saved")

    println(firstName+" "+lastName)

    response:type("application/json")

    return Json.stringify(Json.toJson(hashMap))

}


#GET
function about_html = |request, response| {
    response:type("text/html")
    return "About : <b>Fast!>>2</b>"
}

#GET
function about_txt = |request, response| {
    response:type("text/plain")
    return "About : <b>Fast!>>2</b>"

}