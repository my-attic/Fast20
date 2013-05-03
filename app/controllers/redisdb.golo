module redisdb

#import java.util.Map
import java.util.HashMap
#import java.util.LinkedList
#import java.util.UUID

import fast.json.Json
import fast.data.Redis

#$.ajax({
#  type: "POST",
#  url:"/redis",
#  data:'{"id":"johndoe","firstName":"John", "lastName":"Doe"}',
#  success: function(data){ console.log(data); },
#  dataType: "json"
#});

#POST
function create = |request, response| {

    println(request:body())

    let jsonNode = Json.parse(request:body())
    let hashMap = Json.fromJson(jsonNode, HashMap.class)

    let id = hashMap:get("id")

    println(id)

    Redis.set(id, Json.stringify(Json.toJson(hashMap)))

    response:type("application/json")

    return Json.stringify(Json.toJson(hashMap))

}

# $.getJSON("/redis/johndoe", function(data){ console.log(data); })

#GET
function fetch = |request, response| {

    let key = request:params(":key")

    let jsonNode = Json.parse(Redis.get(key))

    response:type("application/json")

    return Json.stringify(jsonNode)
}
