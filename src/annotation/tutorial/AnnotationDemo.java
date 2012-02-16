package annotation.tutorial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 
 * @author abdul
 *
 */
@MyAnnotation(value = "Class Annotation")
public class AnnotationDemo  {

    public static void main(String[] args) {
        AnnotationDemo demo = new AnnotationDemo();
        Class<? extends AnnotationDemo> clazz = demo.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation Type: " + annotation.annotationType());
        }
        MyAnnotation annotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        System.out.println("Anno Value  : " + annotation.value());

        try {
            Method m = clazz.getMethod("method1");

            annotation = m.getAnnotation(MyAnnotation.class);
            System.out.println("Anno Value  : " + annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        demo.method2();
    }

    @MyAnnotation(value = "Method1 Annotation")
    public void method1() {
    }

    @MyAnnotation(value = "Method2 Annotation")
    public void method2() {
        try {
            Method m = getClass().getMethod("method2");
            MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
            System.out.println("Anno Value  : " + annotation.value() );
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}