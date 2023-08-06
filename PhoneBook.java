import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PhoneBook {

    private static HashMap<String, ArrayList> contacts = new HashMap();

    public static void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            ArrayList phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
        else {
            ArrayList phoneNumbers = new ArrayList();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public static void printContacts() {
        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        
        for (Map.Entry<String, ArrayList> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printContactsSortedByName() {
        ArrayList<Map.Entry<String, ArrayList<String>>> list = new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, ArrayList<String>> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void saveContactsToFile(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ArrayList<Map.Entry<String, ArrayList<String>>> list = new ArrayList(contacts.entrySet());

            for (Map.Entry<String, ArrayList<String>> entry : list) {
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

    public static void searchContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println(name + ": " + contacts.get(name));
        } else {
            System.out.println("No contact found for " + name);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("\nPlease choose an action: add, print, printSorted, save, search, or quit");
            action = scanner.nextLine();

            switch (action) {
                case "add":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    addContact(name, phoneNumber);
                    break;
                case "print":
                    printContacts();
                    break;
                case "printSorted":
                    printContactsSortedByName();
                    break;
                case "save":
                    System.out.println("Enter filename:");
                    String filename = scanner.nextLine();
                    saveContactsToFile(filename);
                    break;
                case "search":
                    System.out.println("Enter name:");
                    String searchName = scanner.nextLine();
                    searchContact(searchName);
                    break;
                case "quit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }
}