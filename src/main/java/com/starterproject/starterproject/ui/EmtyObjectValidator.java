package com.starterproject.starterproject.ui;

import com.vaadin.flow.data.binder.ErrorLevel;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

public class EmtyObjectValidator implements Validator<Object> {
    @Override
    public ValidationResult apply(Object value, ValueContext context) {
        return new ValidationResult() {
            @Override
            public String getErrorMessage() {
                return "Requiered";
            }

            @Override
            public Optional<ErrorLevel> getErrorLevel() {
                return Optional.empty();
            }

            @Override
            public boolean isError() {
                    return ObjectUtils.isEmpty(value);
            }
        };
    }
}
