package org.informatics.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private BigDecimal budget;
    private List<Goods> goodsToBuy;


    public Client(BigDecimal budget) {
        this.budget = budget;
        this.goodsToBuy = new ArrayList<>();
    }

    public List<Goods> getGoodsToBuy() {
        return goodsToBuy;
    }

    public void setGoodsToBuy(List<Goods> goodsToBuy) {
        this.goodsToBuy = goodsToBuy;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Client{" +
                "budget=" + budget +
                ", goodsToBuy=" + goodsToBuy +
                '}';
    }
}
