package project1;

public class indexOutOfBoundException extends Throwable {
    public indexOutOfBoundException(int index){
        super(index + "is out of bound");
    }

}
