package annotation.tutorial;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author abdul
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
}





