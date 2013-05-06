module redisdb

import java.util.HashMap

import fast.json.Json
import fast.data.Redis

function jsonDecode = |requestBody, kind| -> Json.fromJson(Json.parse(requestBody), kind)

function jsonEncode = |something| -> Json.stringify(Json.toJson(something))

#$.ajax({
#  type: "POST",
#  url:"/redis",
#  data:'{"id":"johndoe","firstName":"John", "lastName":"Doe"}',
#  success: function(data){ console.log(data); },
#  dataType: "json"
#});

#POST
function create = |request, response| {

    let hashMap = jsonDecode(request:body(),HashMap.class)
    let id = hashMap:get("id")

    #TODO: try catch -> if redis is off ;)
    Redis.set(id, jsonEncode(hashMap))
    response:type("application/json")
    return jsonEncode(hashMap)

}

# $.getJSON("/redis/johndoe", function(data){ console.log(data); })

#GET
function fetch = |request, response| {

    let key = request:params(":key") #route : /redis/:key
    let jsonNode = Json.parse(Redis.get(key))
    response:type("application/json")
    return Json.stringify(jsonNode)
}
