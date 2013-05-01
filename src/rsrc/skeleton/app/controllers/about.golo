module about

import java.util.HashMap
import fast.json.Json

# Try this :
#
# $.getJSON("/infos", function(data){ console.log(data); })

#GET
function about = |request, response| {

    let infos = HashMap()
    infos:put("name", "Fast 2.0")
    infos:put("author", "k33g_org")


    response:type("application/json")

    return Json.stringify(Json.toJson(infos))
}
