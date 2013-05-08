package fast.tools;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * User: k33g_org
 * Date: 5/1/13
 * Time: 10:30 PM
 */
public class Skeleton {

    public static void generate(String applicationDirectory) throws IOException, URISyntaxException {

        //golo application
        Resources.mkdir(applicationDirectory+"/controllers");
        Resources.mkdir(applicationDirectory+"/models");
        Resources.mkdir(applicationDirectory+"/views");
        Resources.mkdir(applicationDirectory+"/core");
        //Resources.mkdir(applicationDirectory+"/core/data");

        Resources.copy("rsrc/skeleton/app/core/route.golo",applicationDirectory+"/core/route.golo");
        //Resources.copy("rsrc/skeleton/app/core/data/redismodel.golo",applicationDirectory+"/core/data/redisdb.golo");
        Resources.copy("rsrc/skeleton/app/parameters.golo",applicationDirectory+"/parameters.golo");
        Resources.copy("rsrc/skeleton/app/boot.golo",applicationDirectory+"/boot.golo");
        Resources.copy("rsrc/skeleton/app/routes.golo",applicationDirectory+"/routes.golo");
        Resources.copy("rsrc/skeleton/app/controllers/about.golo",applicationDirectory+"/controllers/about.golo");

        //static assets
        Resources.mkdir("public/bootstrap");
        Resources.mkdir("public/bootstrap/css");
        Resources.mkdir("public/bootstrap/img");
        Resources.mkdir("public/bootstrap/js");
        Resources.mkdir("public/js");
        Resources.mkdir("public/js/vendors");

        Resources.copy("rsrc/skeleton/public/index.html","public/index.html");
        Resources.copy("rsrc/skeleton/public/js/app.js","public/js/app.js");
        Resources.copy("rsrc/skeleton/public/js/vendors/jquery-1.9.1.min.js","public/js/vendors/jquery-1.9.1.min.js");

        Resources.copy("rsrc/skeleton/public/bootstrap/css/bootstrap.min.css","public/bootstrap/css/bootstrap.min.css");
        Resources.copy("rsrc/skeleton/public/bootstrap/css/bootstrap-responsive.min.css","public/bootstrap/css/bootstrap-responsive.min.css");
        Resources.copy("rsrc/skeleton/public/bootstrap/img/glyphicons-halflings.png","public/bootstrap/img/glyphicons-halflings.png");
        Resources.copy("rsrc/skeleton/public/bootstrap/img/glyphicons-halflings-white.png","public/bootstrap/img/glyphicons-halflings-white.png");

        Resources.copy("rsrc/skeleton/public/bootstrap/js/bootstrap.min.js","public/bootstrap/js/bootstrap.min.js");

        System.out.println("application has been generated.");

    }
}
