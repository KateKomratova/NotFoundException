package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repo = new ProductRepository();
    Product book1 = new Book(100, "Garry Potter", 350, "Rowling J.", 320, 2000);
    Product book2 = new Book(15, "Glow", 230, "King S.", 300, 1997);
    Product tShirt1 = new TShirt(234, "Zara", 2999, "blue", "s");
    Product tShirt2 = new TShirt(1084, "Lime", 2599, "red", "m");

    @BeforeEach
    void setUp() {
        repo.save(book1);
        repo.save(book2);
        repo.save(tShirt1);
        repo.save(tShirt2);
    }

    @Test
    void removeById() {
        repo.removeById(15);
        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{book1, tShirt1, tShirt2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById2() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(324);
        });
    }


}