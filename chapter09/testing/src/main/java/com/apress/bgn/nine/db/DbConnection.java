package com.apress.bgn.nine.db;

import com.apress.bgn.nine.Account;

import java.util.List;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public interface DbConnection {
    void connect();

    Account insert(Account account);

    Account findByHolder(String holder);

    List<Account> findAll();

    Account update(Account account);

    void delete(String holder);

    void disconnect();

}
