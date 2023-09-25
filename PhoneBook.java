import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {

        Map<String, HashSet<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Волков", "111");
        addContact(phoneBook, "Волков", "111");
        addContact(phoneBook, "Аронов", "211");
        addContact(phoneBook, "Аронов", "212");
        addContact(phoneBook, "Аронов", "213");
        addContact(phoneBook, "Аронов", "214");
        addContact(phoneBook, "Аронов", "215");
        addContact(phoneBook, "Аронов", "214");
        addContact(phoneBook, "Иванова", "311");
        addContact(phoneBook, "Иванова", "312");
        addContact(phoneBook, "Иванова", "313");
        addContact(phoneBook, "Иванова", "312");
        addContact(phoneBook, "Скворцов", "411");
        addContact(phoneBook, "Скворцов", "412");
        addContact(phoneBook, "Скворцов", "413");
        addContact(phoneBook, "Петрова", "511");

        //System.out.println(phoneBook.keySet());

        Map<String, Integer> countOfphones = new HashMap<>(); // фамилии + количество телефонов
        ArrayList<Integer> countPhones = new ArrayList<>();
        for (Map.Entry<String, HashSet<String>> element : phoneBook.entrySet()) {
            int count = element.getValue().size();
            countOfphones.put(element.getKey(), count);
            countPhones.add(count);
        }
        //System.out.println(countPhones);
        //System.out.println(countOfphones);
        Set<Integer> set = new HashSet<>(countPhones);
        countPhones.clear();
        countPhones.addAll(set);
        Collections.sort(countPhones, Collections.reverseOrder());
        //System.out.println(countPhones);

        ArrayList<String> listSurnames = new ArrayList<>();  // список фамилий по убыванию телефонов
        for (Integer el : countPhones) {
            for (Map.Entry<String, Integer> element : countOfphones.entrySet()) {
                if (el == element.getValue()) {
                    //System.out.println(element.getKey());
                    listSurnames.add(element.getKey());
                }
            }
        }
        //System.out.println(listSurnames);


        for (String surname : listSurnames) {
            for (Map.Entry<String, HashSet<String>> element : phoneBook.entrySet()) {
                if (surname.equals(element.getKey())) {
                    String contact = element.getKey();
                    HashSet<String> phones = element.getValue();
                    System.out.println(contact + ": ");
                    phones.forEach(phone -> System.out.print(phone + "\n"));
                }
            }
        }
    }
    public static void addContact (Map < String, HashSet < String >> phoneBook, String surname, String phone){
            if (phoneBook.containsKey(surname)) {
                HashSet<String> oldSurname = phoneBook.get(surname);
                oldSurname.add(phone);
            } else {
                HashSet<String> phones = new HashSet<>();
                phones.add(phone);
                phoneBook.put(surname, phones);
            }
        }
    }

