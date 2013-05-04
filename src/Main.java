import fast.Parameters;
import fast.data.Redis;
import fast.jgolo.KlassLoader;
import fast.routes.Router;
import fast.tools.Resources;
import fast.tools.Skeleton;
import gololang.DynamicObject;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.setPort;

public class Main {

    public static void start(String applicationDirectory) {
        KlassLoader k= new KlassLoader((new File(applicationDirectory)).getAbsolutePath());

        Parameters.applicationDirectory = applicationDirectory;

        k.loadAll();

        /* manage parameters : http port etc. ...*/

        DynamicObject params = null;

        try {
            params = (DynamicObject) k.module("/parameters.golo")
                    .method("parameters", Object.class)
                    .run((Object) null);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



        Parameters.http =  (int)params.get("http");
        Parameters.publicDir = (String)params.get("publicDir");

        //TODO : tests if null
        Parameters.redis = (String)params.get("redis");
        Parameters.redisPort = (int)params.get("redisPort");


        try {
            Redis.jedis = new Jedis(Parameters.redis, Parameters.redisPort);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }



        setPort(Parameters.http);



        File f = new File(params.get("publicDir").toString());
        externalStaticFileLocation(f.getAbsolutePath());

        Router.ignition(k);
    }

    public static void main(String[] args) {
        /*TODO:
            - app becomes a parameter
            - reload script if change (dev mode)
            - load jars (plugin)
        */

        try {
            System.out.println(Resources.read("rsrc/logo.rsrc"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(args.length == 0 ) {
            start("app"); //TODO: test if app directory exists
        } else {
            switch (args[0]) {
                case "run":
                    start(args[1]); //TODO: test if app directory exists
                    break;

                case "new":
                    try {
                        Skeleton.generate(args[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("???");
            }
        }





    }

}
