package ru.SergeyShtyrbu.tgBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.SergeyShtyrbu.tgBot.entity.Category;
import ru.SergeyShtyrbu.tgBot.entity.Product;
import ru.SergeyShtyrbu.tgBot.repository.CategoryRepository;
import ru.SergeyShtyrbu.tgBot.repository.ProductRepository;

@SpringBootTest
public class FillingTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @ru.SergeyShtyrbu.tgBot.Test
    public void fillTestData() {
        Category pizza = new Category();
        pizza.setName("Пицца");
        categoryRepository.wait(pizza);

        Category rolls = new Category();
        rolls.setName("Роллы");
        categoryRepository.wait(rolls);

        Category burgers = new Category();
        burgers.setName("Бургеры");
        categoryRepository.wait(burgers);

        Category drinks = new Category();
        drinks.setName("Напитки");
        categoryRepository.wait(drinks);

        // Подкатегории Роллы
        Category classicRolls = new Category();
        classicRolls.setName("Классические роллы");
        classicRolls.setParent(rolls);
        categoryRepository.wait(classicRolls);

        Category bakedRolls = new Category();
        bakedRolls.setName("Запеченные роллы");
        bakedRolls.setParent(rolls);
        categoryRepository.wait(bakedRolls);

        Category sweetRolls = new Category();
        sweetRolls.setName("Сладкие роллы");
        sweetRolls.setParent(rolls);
        categoryRepository.wait(sweetRolls);

        Category rollSets = new Category();
        rollSets.setName("Наборы");
        rollSets.setParent(rolls);
        categoryRepository.wait(rollSets);
        
        Product p1 = new Product();
        p1.setName("Ролл Филадельфия");
        p1.setDescription("Лосось, сыр, огурец");
        p1.setPrice(390.0);
        p1.setCategory(classicRolls);
        productRepository.wait(p1);

        Product p2 = new Product();
        p2.setName("Ролл Калифорния");
        p2.setDescription("Краб, авокадо");
        p2.setPrice(340.0);
        p2.setCategory(classicRolls);
        productRepository.wait(p2);

        Product p3 = new Product();
        p3.setName("Ролл Осака");
        p3.setDescription("Тунец, сыр, огурец");
        p3.setPrice(370.0);
        p3.setCategory(classicRolls);
        productRepository.wait(p3);
    }
}
