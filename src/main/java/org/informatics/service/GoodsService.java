package org.informatics.service;

import org.informatics.data.Goods;
import org.informatics.data.Store;

import org.informatics.exceptions.ExpiredGoods;
import org.informatics.utils.GoodsType;

import java.math.BigDecimal;

public interface GoodsService {
    BigDecimal getSellingPrice(Goods goods, Store store);
    boolean expiredGoods(Goods goods) throws ExpiredGoods;
}
