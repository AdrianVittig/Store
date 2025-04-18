package org.informatics.service;

import org.informatics.data.Client;
import org.informatics.data.Employee;
import org.informatics.data.Goods;
import org.informatics.data.Store;
import org.informatics.exceptions.NotEnoughBudgetException;

import java.math.BigDecimal;
import java.util.List;

public interface CashdeskService {
    BigDecimal getTotalAmount(Store store, Employee employee, Client client);
    boolean canBuyGoods(Client client) throws NotEnoughBudgetException;
}
