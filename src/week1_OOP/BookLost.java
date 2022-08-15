package week1_OOP;

public class BookLost extends Lost{
    private String bookName;
    private String author;

    public BookLost() { }

    public BookLost(int date, String lostPlace, String getPlace, String bookName, String author) {
        super(date, lostPlace, getPlace);
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "丢失时间:" + getDate() +
                "\t丢失地点: " + getLostPlace() +
                "\t领取地点: " +getGetPlace() +
                "\n书名 :" + bookName +
                "\t作者: " + author;
    }
}
