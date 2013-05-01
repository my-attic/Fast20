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

    return DynamicObject()
            :restVerb(restVerb)
            :url(url)
            :controller(controller)
            :method(method)
}




