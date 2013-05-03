module core.router

import java.util.ArrayList

function Routes = |routes...|{
    let routesList = ArrayList()
    foreach(route in atoList(routes)) {
        routesList:add(route)
        #println(route:restVerb()+" "+route:url()+" "+route:controller())
    }
    return routesList
}

function Route = |restVerb, url, controller, method| {

    let route = DynamicObject()
                    :restVerb(restVerb)
                    :url(url)
                    :controller(controller)
                    :method(method)

    if method: contains("::") {
        route:method(method:split("::"):get(0)):dynoMethod(method:split("::"):get(1))
    }

    return route


}
