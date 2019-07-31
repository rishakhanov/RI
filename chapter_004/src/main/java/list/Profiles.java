package list;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(
                task -> task.getAddress()
        ).sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
        return result;
    }
}
