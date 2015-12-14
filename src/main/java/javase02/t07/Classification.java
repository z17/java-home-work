package javase02.t07;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
 public @interface Classification {
    String type();
    String date();
}
