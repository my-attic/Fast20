package fast.store;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemoryStore {

    private static HashMap<String,Object> memory = new HashMap<>();

    public static void set(String key, Object objectToStore) {
        memory.put(key, objectToStore);
    }

    public static Object get(String key) {
        return memory.get(key);
    }

    public static void delete(String key) {
        memory.remove(key);
    }

    public static void each(MethodHandle m) {
        Iterator it = memory.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            //System.out.println(entry.getKey() + " : " + entry.getValue());
            try {
                m.invoke(entry.getKey(),entry.getValue());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}


