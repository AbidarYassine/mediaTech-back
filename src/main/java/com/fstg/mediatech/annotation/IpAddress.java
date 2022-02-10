package com.fstg.mediatech.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IpAddressValidation.class})
public @interface IpAddress {

    String message() default "IpAddress invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
