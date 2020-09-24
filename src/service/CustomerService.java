package service;

import model.Customer;
import service.IService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerService implements IService<Customer> {
    static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "The Anh", "Ha Noi"));
        customers.add(new Customer(2L, "Quan", "Ha Noi"));
        customers.add(new Customer(3L, "Khanh", "Ha Noi"));
    }

    @Override
    public void add(Customer object) {
        boolean flag = true;
        for (int i = 0; i < customers.size(); i++) {
            if (object.getId() == customers.get(i).getId()) {
                flag = false;
                break;
            }
        }
        if (flag)
            customers.add(object);

    }

    @Override
    public void update(Long id, Customer newObject) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.set(i, newObject);
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.remove(i);
            }
        }
    }

    @Override
    public Customer findById(Long id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                return customers.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (name == customers.get(i).getName()) {
                customerList.add(customers.get(i));
            } else {
                return null;
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            customerList.add(iterator.next());
        }
        return customerList;
    }
}