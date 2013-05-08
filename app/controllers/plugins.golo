module plugins

import java.util.HashMap

import fast.plugins.Plugins
import fast.json.Json

#http://localhost:8080/42
function tests = |request, response| {

    #load jar and add it to plugins list -> do that in boot.golo
    #plugins are located to `<your_app>/plugins` directory
    Plugins.loadJar("42", "fourtyTwo.jar")

    #see sample source code : `/app/plugins/H2G2.java`

    #get plugin by key, load class, get instance of it
    let H2G2 = Plugins.getClass("42", "org.fortytwo.H2G2"):newInstance()

    #use it :
    let TheResponse = HashMap()
    TheResponse:put("answer1", H2G2:theAnswerToLifeTheUniverseAndEverything("???"))
    TheResponse:put("answer2", H2G2:theAnswerToLifeTheUniverseAndEverything())

    response:type("application/json")

    return Json.stringify(Json.toJson(TheResponse))
}

