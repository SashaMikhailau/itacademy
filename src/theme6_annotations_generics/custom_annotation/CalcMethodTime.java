package theme6_annotations_generics.custom_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/*СонарЛинт подсказал что должен быть RetentionPolicy RUNTIME
чтобы  метод method.isAnnotationPresent() возвращал корректные значения*/
@Retention(RetentionPolicy.RUNTIME)
public @interface CalcMethodTime {
}
