public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
