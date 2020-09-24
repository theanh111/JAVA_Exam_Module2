import model.Customer;
import service.CustomerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void display(List<Customer> customers) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

//    static void displayByName(List<Customer> customers) {
//        Iterator<Customer> iterator = customers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        System.out.println("=====Find All====");
        List<Customer> customers;
        customers = customerService.findAll();
        display(customers);
//
//        System.out.println("=====Add model.Customer====");
//        System.out.println("Input ID: ");
//        Long idForAdd = input.nextLong();
//        System.out.println("Name: ");
//        input.nextLine();
//        String addNewName = input.nextLine();
//        System.out.println("Address: ");
//        String addNewAddress = input.nextLine();
//        Customer addNew = new Customer(idForAdd, addNewName, addNewAddress);
//        customerService.add(addNew);
//        customers = customerService.findAll();
//        display(customers);
//
//        System.out.println("=====Edit model.Customer====");
//        System.out.println("Input ID: ");
//        Long idForEdit = input.nextLong();
//        System.out.println("Name: ");
//        input.nextLine();
//        String newName = input.nextLine();
//        System.out.println("Address: ");
//        String newAddress = input.nextLine();
//        Customer editNew = new Customer(idForEdit, newName, newAddress);
//        customerService.update(idForEdit, editNew);
//        customers = customerService.findAll();
//        display(customers);
//
//        System.out.println("=====Delete model.Customer====");
//        System.out.println("Input ID: ");
//        Long idForDelete = input.nextLong();
//        customerService.delete(idForDelete);
//        customers = customerService.findAll();
//        display(customers);

        System.out.println("=====Find By ID model.Customer====");
        System.out.println("Input ID: ");
        Long idToFind = input.nextLong();
        System.out.println(customerService.findById(idToFind));

        System.out.println("=====Find By Name model.Customer====");
        List<Customer> customersByName = new ArrayList<>();
//        System.out.println("Input Name: ");
//        String nameToFind = input.nextLine();
        customersByName = customerService.findByName("A");
        display(customersByName);
    }
}