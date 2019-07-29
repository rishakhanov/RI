package list;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(
                task -> task.getAddress()
        ).collect(Collectors.toList());
        return result;
    }
}
