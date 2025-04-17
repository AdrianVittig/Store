package org.informatics.data;

import java.util.Date;
import java.util.List;

public class Receipt {
    private long id;
    private Employee employeeIssued;
    private Date date;
    private List<Goods> goodsOnReceipt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployeeIssued() {
        return employeeIssued;
    }

    public void setEmployeeIssued(Employee employeeIssued) {
        this.employeeIssued = employeeIssued;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Goods> getGoodsOnReceipt() {
        return goodsOnReceipt;
    }

    public void setGoodsOnReceipt(List<Goods> goodsOnReceipt) {
        this.goodsOnReceipt = goodsOnReceipt;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", employeeIssued=" + employeeIssued +
                ", date=" + date +
                ", goodsOnReceipt=" + goodsOnReceipt +
                '}';
    }
}
