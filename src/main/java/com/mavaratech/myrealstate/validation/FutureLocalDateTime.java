package com.mavaratech.myrealstate.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull
@Future
@ReportAsSingleViolation
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FutureLocalDateTimeValidator.class)
public @interface FutureLocalDateTime {

    String message() default "Date should be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
