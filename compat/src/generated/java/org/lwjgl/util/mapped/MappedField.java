package org.lwjgl.util.mapped;

import com.koyomiji.dualwjgl.inject.Generated;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Generated
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface MappedField {
	long byteOffset() default -1L;

	long byteLength() default -1L;
}
