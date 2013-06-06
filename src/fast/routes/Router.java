package fast.routes;

import fast.jgolo.KlassLoader;
import gololang.DynamicObject;
import spark.Request;
import spark.Response;
import spark.Route;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static spark.Spark.*;

/**
 * User: k33g_org
 * Date: 5/1/13
 * Time: 10:34 AM
 */
public class Router {

    public static Object defineRoute(KlassLoader k, DynamicObject dyno, Request request, Response response) {
        Object ret = null;

        try {
            ret = k.module(dyno.get("controller").toString())
                    .method(dyno.get("method").toString(), Object.class, Object.class)
                    .run(request, response);

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return ret;
        }
    }

    public static Object ifDyno(DynamicObject dyno, Object o, Request request, Response response) {
        if(dyno.get("dynoMethod")!=null) {
            try {
                o = ((MethodHandle) ((DynamicObject)o).get(dyno.get("dynoMethod").toString())).invoke(o,request, response) ;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                return o;
            }
        } else {
            return o;
        }
    }



    public static void ignition(final KlassLoader k) {

        /* build routes arrayList from /app/routes/routes.golo */
        Object params = null;
        ArrayList<DynamicObject> dynos =null;
        try {
            dynos = (ArrayList<DynamicObject>) k.module("/routes.golo")
                    .method("router", Object.class)
                    .run(params);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        /* create routes */
        for(final DynamicObject dyno : dynos) {

            System.out.println(
                    "Create route : " + dyno.get("restVerb") +" "+
                            dyno.get("url") + " " +
                            dyno.get("controller") + " " +
                            dyno.get("method") + "()"
            );

            /*=== GET ===*/
            if(dyno.get("restVerb").equals("GET")) {

                get(new Route(dyno.get("url").toString()) {
                    @Override
                    public Object handle(Request request, Response response) {

                        Object o = defineRoute(k, dyno, request, response);
                        return ifDyno(dyno, o, request, response);
                        //return defineRoute(k, dyno, request, response);
                    }
                });
            }

            /*=== POST ===*/
            if(dyno.get("restVerb").equals("POST")) {
                post(new Route(dyno.get("url").toString()) {
                    @Override
                    public Object handle(Request request, Response response) {
                        Object o = defineRoute(k, dyno, request, response);
                        return ifDyno(dyno, o, request, response);
                        //return defineRoute(k, dyno, request, response);
                    }
                });
            }

            /*=== PUT ===*/
            if(dyno.get("restVerb").equals("PUT")) {
                put(new Route(dyno.get("url").toString()) {
                    @Override
                    public Object handle(Request request, Response response) {
                        Object o = defineRoute(k, dyno, request, response);
                        return ifDyno(dyno, o, request, response);
                        //return defineRoute(k, dyno, request, response);
                    }
                });
            }

            /*=== DELETE ===*/
            if(dyno.get("restVerb").equals("DELETE")) {
                delete(new Route(dyno.get("url").toString()) {
                    @Override
                    public Object handle(Request request, Response response) {
                        Object o = defineRoute(k, dyno, request, response);
                        return ifDyno(dyno, o, request, response);
                        //return defineRoute(k, dyno, request, response);
                    }
                });
            }
        }
    }

}
