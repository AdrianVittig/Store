package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Store;
import org.informatics.exceptions.ExpiredGoods;
import org.informatics.service.GoodsService;
import org.informatics.utils.GoodsType;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public BigDecimal getSellingPrice(Goods goods, Store store) {
        if(goods.getGoodsType().equals(GoodsType.GROCERIES)){
            return goods.getManufacturerPrice().add(goods.getManufacturerPrice().multiply(store.getSurCharge()));
        }
        else if(goods.getGoodsType().equals(GoodsType.NON_FOODS)){
            return goods.getManufacturerPrice().add(goods.getManufacturerPrice().multiply(store.getSurChargeNonFood()));
        }
        return goods.getManufacturerPrice();
    }

    @Override
    public boolean expiredGoods(Goods goods) throws ExpiredGoods {
        if(goods.getExpirationDate().before(new Date())){
            throw new ExpiredGoods("Expired goods! You can not buy!");
        }
        return false;
    }
}
