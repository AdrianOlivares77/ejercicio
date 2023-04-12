package com.project.ejercicio.common.validator;

import com.project.ejercicio.common.enumeration.ExceptionTextEnum;
import com.project.ejercicio.common.exception.ValidationException;
import lombok.SneakyThrows;
import org.passay.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class PasswordConstraintValidator implements ConstraintValidator<ValidatePassword, String> {

    @Override
    public void initialize(final ValidatePassword arg0) {
    }

    @SneakyThrows
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        try{
            Properties props = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("passay.properties");
            try{
                props.load(inputStream);
            } catch (IOException e) {
                return false;
            }
            MessageResolver resolver = new PropertiesMessageResolver(props);
            PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
                    new LengthRule(8, 16),
                    new CharacterRule(EnglishCharacterData.UpperCase, 1),
                    new CharacterRule(EnglishCharacterData.LowerCase, 1),
                    new CharacterRule(EnglishCharacterData.Digit, 2),
                    new WhitespaceRule(),
                    new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                    new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false)
            ));

            RuleResult result = validator.validate(new PasswordData(password));

            if (result.isValid()) {
                return true;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ExceptionTextEnum. MESSAGE_EMAIL_PASSWORD_PATTERN_WRONG.getValue());
            }
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
    }
}