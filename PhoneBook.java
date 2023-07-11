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

    public static void main(String[] args) {
        addContact("Kafka", "123-45-67");
        addContact("Blade", "111-11-11");
        addContact("Blade", "222-22-22");
        addContact("Silver Wolf", "333-33-33");
        addContact("Trailblazer", "987-65-43");
        
        printContacts();
    }
}