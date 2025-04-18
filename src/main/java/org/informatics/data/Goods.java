package org.informatics.data;

import org.informatics.utils.GoodsType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Goods {
    private long id;
    private String name;
    private BigDecimal manufacturerPrice;
    private GoodsType goodsType;
    private LocalDate expirationDate;
    private static long nextId = 1000;

    public Goods(String name, BigDecimal manufacturerPrice, GoodsType goodsType, LocalDate expirationDate) {
        this.id = ++nextId;
        this.name = name;
        this.manufacturerPrice = manufacturerPrice;
        this.goodsType = goodsType;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getManufacturerPrice() {
        return manufacturerPrice;
    }

    public void setManufacturerPrice(BigDecimal manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static long getNextId() {
        return nextId;
    }

    public static void setNextId(long nextId) {
        Goods.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturerPrice=" + manufacturerPrice +
                ", goodsType=" + goodsType +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
