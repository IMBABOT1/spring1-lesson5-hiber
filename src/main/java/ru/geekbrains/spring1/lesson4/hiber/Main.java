package ru.geekbrains.spring1.lesson4.hiber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);

            productDao.saveOrUpdate(new Product(1l, "fasd", 150));
            List<Product> products = productDao.findAll();

            System.out.println(products);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
