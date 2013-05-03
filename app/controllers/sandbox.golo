module sandbox

import java.util.HashMap
import fast.json.Json

function Test = |request, response| {
    return DynamicObject()
        :hello(|this,request, response|{
            response:type("application/json")

            return Json.stringify(Json.toJson(
                HashMap():add("message","hello"):add("status","cool")
            ))

        })
        :hi(|this,request, response|{

           let jsonNode = Json.parse(request:body())
           let hashMap = Json.fromJson(jsonNode, HashMap.class)

           response:type("application/json")

           return Json.stringify(Json.toJson(
               hashMap
           ))

        })
}


