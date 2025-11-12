import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@interface CodeAuthor {
    String name();
    int version() default 1;
    String edited() default "01/01/1970";
    String[] asisstants();
}