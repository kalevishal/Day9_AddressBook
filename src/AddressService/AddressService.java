package AddressService;

import java.util.ArrayList;
import java.util.Scanner;

import AddressModel.Address;
//
public class AddressService {
    static ArrayList<Address> addressBookModels = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    // Add contact to addressbook
    public static void createPerson() {
        Address addressBookModel = new Address();

        System.out.println("Enter Your First Name");
        String firstName = scanner.next();
        addressBookModel.setFirstName(firstName);
        uniquePerson(firstName);
        System.out.println("Enter Your Last Name");
        String lastName = scanner.next();
        System.out.println("Enter Your city Name");
        String city = scanner.next();
        System.out.println("Enter Your state Name");
        String state = scanner.next();
        System.out.println("Enter Your phone Number");
        int phoneNumber = scanner.nextInt();
        System.out.println("Enter Your zip");
        int zip = scanner.nextInt();
        System.out.println("Enter Your email");
        String email = scanner.next();

        addressBookModel.setLastName(lastName);
        addressBookModel.setCity(city);
        addressBookModel.setEmail(email);
        addressBookModel.setPhoneNo(phoneNumber);
        addressBookModel.setState(state);
        addressBookModel.setZip(zip);

        addressBookModels.add(addressBookModel);

    }

    // Edit contact
    public void updatePerson(String name) {
        int flag = 0;
        for (Address model : addressBookModels) {
            if (model.getFirstName().equals(name)) {
                flag = 1;
                System.out.println("Enter what to update(city/state/phone/zip):");
                String update = scanner.next();
                switch (update) {
                    case "city":
                        System.out.println("Enter city name to update:");
                        String city = scanner.next();
                        model.setCity(city);

                        break;
                    case "state":
                        System.out.println("Enter state name to update:");
                        String state = scanner.next();
                        model.setState(state);
                        break;
                    case "phone":
                        System.out.println("Enter phone number to update:");
                        int phNo = scanner.nextInt();
                        model.setPhoneNo(phNo);
                        break;
                    case "zip":
                        System.out.println("Enter Your zip");
                        int zip = scanner.nextInt();
                        model.setZip(zip);
                        break;
                    default:
                        System.out.println("Enter valid field");
                        break;
                }
            }
        }
        if (flag == 0)
            System.out.println("Person Not Found");
        else
            System.out.println("Updated Successfully");

    }

    static public Address getContact(String name) {
        for (Address cont : addressBookModels) {
            if (cont.getFirstName().equals(name)) {
                return cont;
            } else {
                System.out.println("Invalid name");
            }

        }
        return null;
    }

    public void deletePerson(String name) // Delete Person
    {
        addressBookModels.remove(getContact(name));
    }

    // Unique Person
    static public String uniquePerson(String name) {
        for (Address addressBookModel : addressBookModels) {
            if (addressBookModel.getFirstName().equals(name)) {
                System.out.println("Person already exist");
                createPerson();
            }
        }
        return null;
    }

    // Print addressbook
    public void print() {
        for (Address items : addressBookModels) {
            System.out.println(items);
        }
    }

}