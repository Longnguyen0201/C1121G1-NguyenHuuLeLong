package ss21_design_patterns.thuc_hanh.singleton;

public class BookBorrower {
    private BookSingleton borrowerBook;
    private boolean haveBook = false;

    public void borrowBook(){
        borrowerBook = BookSingleton.borrowBook();
        if (borrowerBook==null){
            haveBook = false;
        }else {
            haveBook = true;
        }
    }

    public String getAuthorAndTitle(){
        if (haveBook){
            return borrowerBook.getAuthorAndTitle();
        }
        return "I don't have book";
    }

    public void returnBook(){
        borrowerBook.returnBook(borrowerBook);
    }
}
