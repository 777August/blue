package project1;

public class itemNotFoundException extends Throwable {
    public itemNotFoundException(String s) {
        super(s + " is not exist");
    }
}
