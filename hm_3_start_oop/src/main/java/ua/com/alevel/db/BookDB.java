package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.Optional;
import java.util.UUID;

public final class BookDB {
    private static BookDB instance;
    private static int countBook = 0;
    private Book[] books;

    private BookDB() {
        books = new Book[10];
    }

    public static BookDB getInstance() {
        if (instance == null) {
            instance = new BookDB();
        }
        return instance;
    }

    public static void main(String[] args) {
        new BookDB().delete("four");
    }

    public void create(Book book) {
        book.setId(generateId());
        add(book);
    }

    public void update(Book book) {
        Book current = findById(book.getId());
        current.setAuthor(book.getAuthor());
        current.setTitle(book.getTitle());
        current.setPrice(book.getPrice());
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
    }

    public Book findById(String id) {
        for (Book book : books) {
            if (book != null && book.getId().equals(id)) {
                return book;
            }
        }
        Optional<Book> optionalBook = Optional.ofNullable(null);
        return optionalBook.get();
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
            System.out.println(countBook);
            Book[] tmp = new Book[books.length * 2];
            System.arraycopy(books, 0, tmp, 0, books.length);
            books = tmp;
        } else {
            books[countBook++] = book;
        }
    }
}
