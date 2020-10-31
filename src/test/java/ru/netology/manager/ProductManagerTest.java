package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductManager productManager;

    private Product first = new Book(1, "recipes", 500, "Korea");
    private Product second = new Book(2, "notebook", 250,  "Agatha Christie");
    private Product third = new Smartphone(3, "Apple", 50000, "USA");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
    }
}
