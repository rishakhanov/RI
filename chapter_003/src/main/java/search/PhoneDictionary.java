package search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person per : persons) {
            if ((per.getAddress().contains(key)) || (per.getName().contains(key))
               || (per.getPhone().contains(key)) || (per.getSurname().contains(key))) {
               result.add(per);
            }
        }
        return result;
    }
}
