package com.happykealifornia.hk.Repository;

import com.happykealifornia.hk.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void newCustomer (Customer customer) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into customer values (null, ?, ?, null)");
                ps.setString(1, customer.getCustomerName());
                ps.setString(2, customer.getCustomerContact());
                return ps;
            }
        };
        jdbc.update(psc);
    }



    public List<Customer> findCustomer() {
        String sql = "SELECT * from customer";

        SqlRowSet rs = jdbc.queryForRowSet(sql);
        List<Customer> customerList  = new ArrayList<>();

        try {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("Customer_ID"));
                customer.setCustomerName(rs.getString("C_Name"));
                customer.setCustomerContact(rs.getString("Contact"));
                customerList.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerList;

    }

}

