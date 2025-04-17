package org.informatics;

import org.informatics.data.*;
import org.informatics.exceptions.ExpiredGoods;
import org.informatics.service.CashdeskService;
import org.informatics.service.GoodsService;
import org.informatics.service.impl.CashdeskServiceImpl;
import org.informatics.service.impl.GoodsServiceImpl;
import org.informatics.utils.GoodsType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Goods bread = new Goods("Bread", BigDecimal.valueOf(1.2), GoodsType.GROCERIES, new Date(2025, Calendar.JULY,16));
        Goods shoes = new Goods("Shoes", BigDecimal.valueOf(1.2), GoodsType.NON_FOODS, new Date(2022, Calendar.FEBRUARY,16));
        System.out.println(bread);
        System.out.println(shoes);

        GoodsService goodsService = new GoodsServiceImpl();


        Employee employee1 = new Employee("Adrian", BigDecimal.valueOf(1100));
        Employee employee2 = new Employee("Ivan", BigDecimal.valueOf(1200));
        Employee employee3 = new Employee("Martin", BigDecimal.valueOf(1200));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println(employee1);

        Cashdesk cashdesk1 = new Cashdesk(employee1);
        Cashdesk cashdesk2 = new Cashdesk(employee2);
        Cashdesk cashdesk3 = new Cashdesk(employee3);
        List<Cashdesk> cashdesks = new ArrayList<>();
        cashdesks.add(cashdesk1);
        cashdesks.add(cashdesk2);
        cashdesks.add(cashdesk3);
        System.out.println(cashdesk1);

        Store store1 = new Store(employees, cashdesks);

        store1.setSurCharge(BigDecimal.valueOf(0.2));
        store1.setSurChargeNonFood(BigDecimal.valueOf(0.3));
        System.out.println(store1);

        System.out.println(goodsService.getSellingPrice(bread, store1));
        System.out.println(goodsService.getSellingPrice(shoes, store1));

        Client client1 = new Client(BigDecimal.valueOf(45));
        List<Goods> goodsToBuy = new ArrayList<>();
        goodsToBuy.add(bread);
        goodsToBuy.add(shoes);
        client1.setGoodsToBuy(goodsToBuy);

        try {
            goodsService.expiredGoods(shoes);
        } catch (ExpiredGoods e) {
            throw new RuntimeException(e);
        }

        CashdeskService cashdeskService = new CashdeskServiceImpl();
        System.out.println(cashdeskService.getTotalAmount(store1, employee1, client1));
        System.out.println(cashdeskService.canBuyGoods(client1));
    }
}