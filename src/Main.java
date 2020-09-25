import model.Customer;
import service.CustomerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        // Display list:
        System.out.println("=====Find All====");
        List<Customer> customers = new ArrayList<>();
        customers = customerService.findAll();
        display(customers);

        // Add a new element to list:
        System.out.println("=====Add model.Customer====");
        System.out.println("Input ID: ");
        Long idForAdd = input.nextLong();
        System.out.println("Name: ");
        input.nextLine();
        String addNewName = input.nextLine();
        System.out.println("Address: ");
        String addNewAddress = input.nextLine();
        Customer addNew = new Customer(idForAdd, addNewName, addNewAddress);
        customerService.add(addNew);
        customers = customerService.findAll();
        display(customers);

        // Edit a element in list by ID, Name, Address:
        System.out.println("=====Edit model.Customer====");
        System.out.println("Input ID: ");
        Long idForEdit = input.nextLong();
        System.out.println("Name: ");
        input.nextLine();
        String editName = input.nextLine();
        System.out.println("Address: ");
        String editAddress = input.nextLine();
        Customer editNew = new Customer(idForEdit, editName, editAddress);
        customerService.update(idForEdit, editNew);
        customers = customerService.findAll();
        display(customers);

        // Delete a element in list by ID:
        System.out.println("=====Delete model.Customer====");
        System.out.println("Input ID: ");
        Long idToDelete = input.nextLong();
        customerService.delete(idToDelete);
        customers = customerService.findAll();
        display(customers);

        // Find a element in list by ID:
        System.out.println("=====Find By ID model.Customer====");
        System.out.println("Input ID: ");
        Long idToFind = input.nextLong();
        System.out.println(customerService.findById(idToFind));

        // Find element(s) in list by Name:
        System.out.println("=====Find By Name model.Customer====");
        List<Customer> customersByName = new ArrayList<>();
        System.out.println("Input Name: ");
        String nameToFind = input.next();
        customersByName = customerService.findByName(nameToFind);
        display(customersByName);
    }

    // Display list method:
    static void display(List<Customer> customers) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}