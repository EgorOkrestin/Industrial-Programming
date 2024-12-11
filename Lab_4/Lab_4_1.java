// Окрестин, 2 курс 5 группа
// Лаб 4

import java.io.*;
import java.util.*;

class Contact implements Comparable<Contact> {
    private String name;
    private String mobileNumber;
    private String homeNumber;
    private String email;
    private String address;

    public Contact() {
        name = "Unknown";
        mobileNumber = "Unknown";
        homeNumber = "Unknown";
        email = "Unknown";
        address = "Unknown";
    }
    public Contact(String name, String mobileNumber, String homeNumber, String email, String address) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.email = email;
        this.address = address;
    }

    public String getMobileNumber(){
        return mobileNumber;
    }
    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", mobileNumber: " + mobileNumber +
                ", homeNumber: " + homeNumber +
                ", email: " + email +
                ", address: " + address;
    }

    public static Contact fromString(String contactString) {
        String[] arr = contactString.split("; ");
        return new Contact(arr[0], arr[1], arr[2], arr[3], arr[4]);
    }
}

class NameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact contact1, Contact contact2) {
        return contact1.getName().compareTo(contact2.getName());
    }
}

class MobileNumberComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact contact1, Contact contact2) {
        return contact1.getMobileNumber().compareTo(contact2.getMobileNumber());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts_arr = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while((line = br.readLine()) != null){
                contacts_arr.add(Contact.fromString(line));
            }

            System.out.println("Введённые контакты:");
            for (Contact contact : contacts_arr) {
                System.out.println(contact);
            }

            System.out.println("\nВыберите поле, по которому будут сортироваться контакты:" +
                    "\n 1 - имя" +
                    "\n 2 - номер телефона");
            int sortingVariant = Integer.parseInt(reader.readLine());

            if(sortingVariant == 1){
                Collections.sort(contacts_arr, new NameComparator());
                System.out.println("\nКонтакты, отсортированные по именам");
                for (Contact contact : contacts_arr) {
                    System.out.println(contact);
                }
            }
            else if(sortingVariant == 2){
                Collections.sort(contacts_arr, new MobileNumberComparator());
                System.out.println("\nКонтакты, отсортированные по номерам телефонов");
                for (Contact contact : contacts_arr) {
                    System.out.println(contact);
                }
            }
            else{
                System.out.println("\nНекорректный ввод, контакты не были отсортированы");
            }
        }
        catch(IOException e){
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
