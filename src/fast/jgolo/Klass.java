package fast.jgolo;

/**
 * User: k33g_org
 * Date: 5/1/13
 * Time: 8:45 AM
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Klass {

    private Class<?> module = null;
    private Method method = null;

    public Klass method(String methodName, Class<?>... parametersTypes) throws NoSuchMethodException {
        this.method = this.module.getMethod(methodName, parametersTypes);
        return this;
    }

    public Object run(Object... params) throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(null, params);
    }

    public Klass(Class<?> module) {
        this.module = module;
    }
}

//k.modules.get("/scripts/main.golo").getMethod("main", Object.class).invoke(null, params);
