package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.Optional;
import java.util.UUID;

public final class BookDB {

    private static BookDB instance;
    private static int countBook = 0;
    private static final int SIZE_DEFAULT = 10;
    private Book[] books;

    private BookDB() {
        books = new Book[SIZE_DEFAULT];
    }

    public static BookDB getInstance() {
        if (instance == null) {
            instance = new BookDB();
        }
        return instance;
    }

    public void create(Book book) {
        book.setId(generateId());
        add(book);
    }


    public void update(Book book)  {
            Book current = findById(book.getId());
            current.setAuthor(book.getAuthor());
            current.setTitle(book.getTitle());
    }

    public void delete(String id) {
        boolean contains = false;
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
                contains = true;
            }
        }
        if (!contains) return;

        Book[] tmp = new Book[books.length - 1];
        int count = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (books[i] != null && books[i].getId().equals(id)) {
                count++;
                tmp[i] = books[++i];

            }
            if (i + count == books.length) break;
            tmp[i] = books[i + count];
        }
        books = tmp;
        countBook--;
    }

    public Book findById(String id) {
        Optional<Book> optionalBook = Optional.empty();
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
               optionalBook = Optional.of(book);
            }
        }

        return optionalBook.orElseThrow();
    }

    public Book[] findAll() {
        return books;
    }


    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }

    private void add(Book book) {
        if (books.length <= countBook) {
            Book[] tmp = new Book[books.length * 2];
            System.arraycopy(books, 0, tmp, 0, books.length);
            books = tmp;
        }
        books[countBook++] = book;

    }
}
