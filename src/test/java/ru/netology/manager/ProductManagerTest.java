package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductManager productManager;

    private Product first = new Book(1, "Poems", 250, "Pushkin");
    private Product second = new Book(2, "Prose", 250,  "Chekhov");
    private Product third = new Smartphone(3, "Apple", 50000, "USA");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
    }

    @Test
    public void checkSearchSmartphoneName() {
        Product[] returned = new Product[] {first,second,third};
        doReturn(returned).when(productRepository).findAll();

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchSmartphoneMade() {
        Product[] returned = new Product[] {first,second,third};
        doReturn(returned).when(productRepository).findAll();

        Product[] expected = new Product[]{third};
        Product[] actual = productManager.searchBy("USA");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchBookName() {
        Product[] returned = new Product[] {first,second,third};
        doReturn(returned).when(productRepository).findAll();

        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy("Prose");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchBookAuthor() {
        Product[] returned = new Product[] {first,second,third};
        doReturn(returned).when(productRepository).findAll();

        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy("Pushkin");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void checkSearchProductWhichIsNot() {
        Product[] returned = new Product[] {first,second,third};
        doReturn(returned).when(productRepository).findAll();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("Russia");

        assertArrayEquals(expected, actual);
    }

}
