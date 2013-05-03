package fast.data;

import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.Set;
/**
 * User: k33g_org
 * Date: 5/3/13
 * Time: 10:01 PM
 */

public class Redis {

    public static Jedis jedis;

    public static void set(String key, String value) {
        jedis.set(key, value);
    }

    public static String get(String key) {
        return jedis.get(key);
    }

    public static void delete(String key) {
        jedis.del(key);
    }

    public static Set<String> keys(String queryKey) {
        return jedis.keys(queryKey);
    }


    public static LinkedList<String> getAll() {

        LinkedList<String> models = new LinkedList<String>();
        try{

            Set<String> allkeys = Redis.keys("*");

            if(allkeys.size()>0) {
                for(String s : allkeys) {
                    String json = Redis.get(s);
                    models.add(json);
                }
            } else {
                models = null;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return models;
        }
    }

    public static LinkedList<String> getAll(String query) {

        LinkedList<String> models = new LinkedList<String>();
        try{

            Set<String> allkeys = Redis.keys(query);

            if(allkeys.size()>0) {
                for(String s : allkeys) {
                    String json = Redis.get(s);
                    models.add(json);
                }
            } else {
                models = null;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return models;
        }
    }

}
