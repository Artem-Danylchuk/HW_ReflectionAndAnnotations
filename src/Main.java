import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        final Class<?> cls = ClassTest.class;
         ClassTest obj = new ClassTest();
        try {
            Method method = cls.getDeclaredMethod("saveText", String.class, String.class);
            if (cls.isAnnotationPresent(SaveTo.class)){
                SaveTo an  = cls.getAnnotation(SaveTo.class);
                Field field = cls.getDeclaredField("text");
                method.invoke(obj, an.fileName(),(String)field.get(obj));
                System.out.println("Done!");
            }
            else {
                System.out.println("Error");
            }

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
