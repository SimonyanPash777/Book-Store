package am.itspace.bookstore.service;

import am.itspace.bookstore.entity.Book;
import am.itspace.bookstore.entity.User;
import am.itspace.bookstore.exception.DublicateResourceException;
import am.itspace.bookstore.repository.BookRepository;
import am.itspace.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final UserRepository userRepository;

    private final BookRepository bookRepository;

    private void save(Book book) throws DublicateResourceException {
        bookRepository.save(book);
    }

    public List<Book> findLast20Books(){
        return bookRepository.findTop20ByOrderByIdDesc();
    }

}
