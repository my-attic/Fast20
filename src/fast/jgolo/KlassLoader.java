package fast.jgolo;

/**
 * User: k33g_org
 * Date: 5/1/13
 * Time: 8:48 AM
 */

import fr.insalyon.citi.golo.compiler.GoloClassLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class KlassLoader {

    public HashMap<String,Class<?>> modules;

    private String pathToParse = null;
    private String extension = ".golo";
    private GoloClassLoader classLoader = new GoloClassLoader();

    private void findGoloScripts(String path) throws IOException {

        File root = new File( path );

        File[] list = root.listFiles(); //filter how to ?

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                findGoloScripts(f.getAbsolutePath());

            }
            else {
                if(f.getAbsoluteFile().getName().endsWith(this.extension)) {

                    System.out.println( "Loading : " + f.getAbsoluteFile() );

                    Class<?> module = classLoader.load(
                            f.getName(),
                            new FileInputStream(f.getAbsoluteFile())
                    );

                    this.modules.put(f.getAbsoluteFile().toString().replaceAll("\\\\", "/").split(this.pathToParse.replaceAll("\\\\", "/"))[1], module);

                    //this.modules.put(f.getAbsoluteFile().toString().split(this.pathToParse)[1], module);
                }
            }
        }
    }


    public Klass module(String modulePathName) {
        return new Klass(this.modules.get(modulePathName));
    }

    //k.modules.get("/scripts/main.golo").getMethod("main", Object.class).invoke(null, params);


    public void loadAll() {
        try {
            this.findGoloScripts(this.pathToParse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public KlassLoader(String pathToParse) {
        this.modules = new HashMap<String, Class<?>>();
        this.pathToParse = pathToParse;

    }
}