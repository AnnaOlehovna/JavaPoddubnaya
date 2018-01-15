package by.itacademy.task1.domein.repository;

import by.itacademy.task1.domein.entity.Money;

public interface MoneyRepository {


     Money get();
     void save(Money money);

     //get(), save(), update(), remove()
}
