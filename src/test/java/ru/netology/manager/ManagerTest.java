package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    private Manager manager = new Manager(new Repository());

    private Book book1 = new Book(1, "iPhone", 500, "автор1");
    private Book book2 = new Book(11, "книга", 700, "автор2");
    private Smartphone smartphone1 = new Smartphone(2, "Honor", 5000, "Korea");
    private Smartphone smartphone2 = new Smartphone(3, "iPhone", 10000, "USA");
    private Product product = new Product(5,"вода", 100);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product);
    }

    @Test
    public void shouldSearchByName() {

        Product[] actual = manager.searchBy("книга");
        Product[] expected ={book2};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldSearchByManufacturer() {

        Product[] actual = manager.searchBy("USA");
        Product[] expected = {smartphone2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthor() {

        Product[] actual = manager.searchBy("автор2");
        Product[] expected = {book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByFindNothing() {

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByDoubleName() {

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = new Product[]{book1, smartphone2};
        assertArrayEquals(actual, expected);

    }
}
