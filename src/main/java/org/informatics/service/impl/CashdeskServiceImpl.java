package org.informatics.service.impl;

import org.informatics.data.Client;
import org.informatics.data.Employee;
import org.informatics.data.Goods;
import org.informatics.data.Store;
import org.informatics.exceptions.NotEnoughBudgetException;
import org.informatics.service.CashdeskService;
import org.informatics.service.GoodsService;

import java.math.BigDecimal;

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
    public boolean canBuyGoods(Client client) throws NotEnoughBudgetException {
        if(client.getBudget().compareTo(total) >= 0){
            return true;
        }
        else{
            throw new NotEnoughBudgetException("Not enough budget! You can not buy the goods.");
        }
    }
}
