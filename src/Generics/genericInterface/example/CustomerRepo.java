package Generics.genericInterface.example;

public class CustomerRepo implements Repository<Customer> {


    @Override
    public void save(Customer type) {
        System.out.println("Customer is Saved");
    }
}
