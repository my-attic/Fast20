package fast.plugins;

import fast.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * User: k33g_org
 * Date: 5/8/13
 * Time: 5:38 PM
 */
public class Plugins {

    private static HashMap<String,URLClassLoader> classLoaders = new HashMap<>();

    public static void loadJar(String keyPlugInName, String jarName) throws MalformedURLException {

        String pathToJar = (new File(Parameters.applicationDirectory)).getAbsolutePath()+"/plugins/"+jarName;

        File f = new File(pathToJar);
        URLClassLoader urlCl = new URLClassLoader(new URL[] { f.toURI().toURL() },System.class.getClassLoader());
        classLoaders.put(keyPlugInName, urlCl);
    }

    public static Class getClass(String keyPlugInName, String className) throws ClassNotFoundException {

        return classLoaders.get(keyPlugInName).loadClass(className);
    }


}
