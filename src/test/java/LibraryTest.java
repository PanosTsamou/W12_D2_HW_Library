import com.codeclan.example.Book;
import com.codeclan.example.Borrower;
import com.codeclan.example.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library myLibrary;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;
    Borrower borrower1;

    @Before
    public void before(){
        ArrayList<Book> booksForLibrary = new ArrayList<>();
        book1 = new Book("Whispers of the Forgotten","Emily Sullivan","Thriller");
        book2 = new Book("The Starborn Legacy","Jacob Harrison", "Fiction");
        book3 = new Book("The Art of Serendipity", "Olivia Mitchell", "Fiction");
        book4 = new Book("Shadows of Redemption", "Benjamin Hayes", "Thriller");
        book5 = new Book("Beyond the Veil", "Harper Bennett", "Romance");
        book6 = new Book("Echoes of Eternity", "Alexander Reed", "Fiction");
        booksForLibrary.add(book1);
        booksForLibrary.add(book2);
        booksForLibrary.add(book3);
        booksForLibrary.add(book4);
        booksForLibrary.add(book5);
        myLibrary = new Library(booksForLibrary);
        borrower1 = new Borrower("Panos");
    }

    @Test
    public void getBookTitle(){
        assertEquals("Whispers of the Forgotten", book1.getTitle());
    }

    @Test
    public void getBookAuthor(){
        assertEquals("Emily Sullivan", book1.getAuthor());
    }

    @Test
    public void getBookGenre(){
        assertEquals("Fiction", book2.getGenre());
    }
    @Test
    public void getTheNumberOfBooksInTheLibrary(){
        assertEquals(5, myLibrary.getTheSize());
    }

    @Test
    public void addBookInTheLibrary(){
        myLibrary.addBookInLibrary(book6);
        assertEquals(6, myLibrary.getTheSize());
    }

    @Test
    public void  customerBorrowsBooks(){
        borrower1.borrowBooksFromLibrary(myLibrary, book2);
        assertEquals(1, borrower1.getHowManyBooksHas());
        assertEquals(4, myLibrary.getTheSize());
    }

    @Test
    public void  findHowManyBooksEachGenreHas(){
        myLibrary.setTrackBooksByGenre();
        assertEquals(2, myLibrary.getTheNumberOfBooksOfGenre("Fiction"));
    }
}
