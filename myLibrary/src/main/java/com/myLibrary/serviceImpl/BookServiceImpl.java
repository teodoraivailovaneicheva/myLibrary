package com.myLibrary.serviceImpl;

import com.myLibrary.entity.Book;
//import com.myLibrary.repository.BookRepository;
import com.myLibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookServiceImpl implements BookService {

    private static final Map<Integer, Book> BOOK_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger BOOK_ID = new AtomicInteger();

    @Override
    public Book create(Book book) {
        final int bookId = BOOK_ID.incrementAndGet();
        book.setId(bookId);
        return BOOK_REPOSITORY_MAP.put(bookId, book);
    }

    @Override
    public Book findBookById(int id) {

        return BOOK_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Book> findAllBooks() {

        return new ArrayList<>(BOOK_REPOSITORY_MAP.values());
    }

    @Override
    public boolean updateBookById(Book book, int id) {
        if (BOOK_REPOSITORY_MAP.containsKey(id)){
            book.setId(id);
            BOOK_REPOSITORY_MAP.put(id, book);
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteBookById(int id) {

        return BOOK_REPOSITORY_MAP.remove(id) != null;
    }
}
