package org.informatics.service.impl;

import org.informatics.data.Client;
import org.informatics.data.Employee;
import org.informatics.data.Goods;
import org.informatics.data.Store;
import org.informatics.service.CashdeskService;
import org.informatics.service.GoodsService;

import java.math.BigDecimal;
import java.util.List;

public class CashdeskServiceImpl implements CashdeskService {
    GoodsService goodsService = new GoodsServiceImpl();
    BigDecimal total = BigDecimal.ZERO;
    @Override
    public BigDecimal getTotalAmount(Store store, Employee employee, Client client) {
        for(Goods goods : client.getGoodsToBuy()){
            total = total.add(goodsService.getSellingPrice(goods, store));
        }
        return total;
    }

    @Override
    public boolean canBuyGoods(Client client) {
        return client.getBudget().compareTo(total) > 0;
    }

}
