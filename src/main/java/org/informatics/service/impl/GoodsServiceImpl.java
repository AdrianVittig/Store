package org.informatics.service.impl;

import org.informatics.data.Goods;
import org.informatics.data.Store;
import org.informatics.exceptions.ExpiredGoods;
import org.informatics.service.GoodsService;
import org.informatics.utils.GoodsType;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        if(goods.getExpirationDate().isBefore(LocalDate.now())){
            throw new ExpiredGoods("Expired goods! You can not buy!");
        }
        return false;
    }

    @Override
    public BigDecimal discountGoods(Goods goods, Store store) throws ExpiredGoods {
        LocalDate expirationDate = goods.getExpirationDate();
        LocalDate discountDay = goods.getExpirationDate().minusDays(store.getDaysForSale());
        if(LocalDate.now().isBefore(expirationDate) && LocalDate.now().isBefore(discountDay)){
            return getSellingPrice(goods, store);
        }
        else if(LocalDate.now().isBefore(expirationDate) && LocalDate.now().isAfter(discountDay)){
            if(goods.getGoodsType().equals(GoodsType.NON_FOODS)){
                return getSellingPrice(goods, store).subtract((getSellingPrice(goods, store).multiply(store.getSurChargeNonFood())));
            }
            return getSellingPrice(goods, store).subtract((getSellingPrice(goods, store).multiply(store.getSurChargeGroceries())));
        }
        throw new ExpiredGoods("Expired goods! You can not buy!");
    }




}
