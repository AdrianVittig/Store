package org.informatics.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Employee> employees;
    private List<Cashdesk> cashdesks;
    private BigDecimal surChargeGroceries;
    private BigDecimal surChargeNonFood;

    public Store(List<Employee> employees, List<Cashdesk> cashdesks) {
        this.employees = employees;
        this.cashdesks = cashdesks;
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
                '}';
    }
}
