package org.informatics.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Employee> employees;
    private List<Cashdesk> cashdesks;
    private BigDecimal surChargeGroceries;
    private BigDecimal surChargeNonFood;
    private int daysForSale;
    private double percentage;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getDaysForSale() {
        return daysForSale;
    }

    public void setDaysForSale(int daysForSale) {
        this.daysForSale = daysForSale;
    }

    public BigDecimal getSurChargeGroceries() {
        return surChargeGroceries;
    }

    public void setSurChargeGroceries(BigDecimal surChargeGroceries) {
        this.surChargeGroceries = surChargeGroceries;
    }

    public Store(List<Employee> employees, List<Cashdesk> cashdesks, BigDecimal surChargeGroceries, BigDecimal surChargeNonFood, int daysForSale, double percentage) {
        this.employees = employees;
        this.cashdesks = cashdesks;
        this.surChargeGroceries = surChargeGroceries.divide(BigDecimal.valueOf(100));
        this.surChargeNonFood = surChargeNonFood.divide(BigDecimal.valueOf(100));
        this.daysForSale = daysForSale;
        this.percentage = percentage / 100;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Cashdesk> getCashdesks() {
        return cashdesks;
    }

    public void setCashdesks(List<Cashdesk> cashdesks) {
        this.cashdesks = cashdesks;
    }

    public BigDecimal getSurCharge() {
        return surChargeGroceries;
    }

    public void setSurCharge(BigDecimal surCharge) {
        this.surChargeGroceries = surCharge;
    }

    public BigDecimal getSurChargeNonFood() {
        return surChargeNonFood;
    }

    public void setSurChargeNonFood(BigDecimal surChargeNonFood) {
        this.surChargeNonFood = surChargeNonFood;
    }


    @Override
    public String toString() {
        return "Store{" +
                "employees=" + employees +
                ", cashdesks=" + cashdesks +
                ", surChargeGroceries=" + surChargeGroceries +
                ", surChargeNonFood=" + surChargeNonFood +
                ", daysForSale=" + daysForSale +
                ", percentage=" + percentage +
                '}';
    }
}
