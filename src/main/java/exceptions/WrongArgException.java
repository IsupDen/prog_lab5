package exceptions;

import static util.TextFormat.errText;

public class WrongArgException extends RuntimeException{
    public WrongArgException() {
        super(errText("Command arguments entered incorrectly!"));
    };
}
