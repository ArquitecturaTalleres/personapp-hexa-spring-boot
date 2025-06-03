package co.edu.javeriana.as.personapp.terminal.validator;

public interface RequestCliValidator<T> {
    void validate(T request);
}
