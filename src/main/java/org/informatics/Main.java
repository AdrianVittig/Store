package org.informatics;

import org.informatics.data.*;
import org.informatics.exceptions.ExpiredGoodsException;
import org.informatics.exceptions.NotEnoughBudgetException;
import org.informatics.service.CashdeskService;
import org.informatics.service.GoodsService;
import org.informatics.service.impl.CashdeskServiceImpl;
import org.informatics.service.impl.GoodsServiceImpl;
import org.informatics.utils.GoodsType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Goods bread = new Goods("Bread", BigDecimal.valueOf(1.2), GoodsType.GROCERIES, LocalDate.of(2025, 4, 30));
        Goods shoes = new Goods("Shoes", BigDecimal.valueOf(1.2), GoodsType.NON_FOODS, LocalDate.of(2025, 8, 15));

        GoodsService goodsService = new GoodsServiceImpl();


        Employee employee1 = new Employee("Adrian", BigDecimal.valueOf(1100));
        Employee employee2 = new Employee("Ivan", BigDecimal.valueOf(1200));
        Employee employee3 = new Employee("Martin", BigDecimal.valueOf(1200));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Cashdesk cashdesk1 = new Cashdesk(employee1);
        Cashdesk cashdesk2 = new Cashdesk(employee2);
        Cashdesk cashdesk3 = new Cashdesk(employee3);
        List<Cashdesk> cashdesks = new ArrayList<>();
        cashdesks.add(cashdesk1);
        cashdesks.add(cashdesk2);
        cashdesks.add(cashdesk3);

        Store store1 = new Store(employees, cashdesks, BigDecimal.valueOf(15), BigDecimal.valueOf(20), 10, 5);


        System.out.println(goodsService.getSellingPrice(bread, store1));
        System.out.println(goodsService.getSellingPrice(shoes, store1));

        Client client1 = new Client(BigDecimal.valueOf(2.82));
        List<Goods> goodsToBuy = new ArrayList<>();
        goodsToBuy.add(bread);
        goodsToBuy.add(shoes);
        client1.setGoodsToBuy(goodsToBuy);

        try {
            goodsService.expiredGoods(shoes);
        } catch (ExpiredGoodsException e) {
            throw new RuntimeException(e);
        }

        CashdeskService cashdeskService = new CashdeskServiceImpl();
        System.out.println(cashdeskService.getTotalAmount(store1, employee1, client1));
        try {
            System.out.println(cashdeskService.canBuyGoods(client1));
        } catch (NotEnoughBudgetException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(goodsService.discountGoods(bread, store1));
        } catch (ExpiredGoodsException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(goodsService.discountGoods(shoes, store1));
        } catch (ExpiredGoodsException e) {
            throw new RuntimeException(e);
        }
    }
}