package hello;

import java.util.List;

public class Greeting {

    private final long id;
    private final String content;
    private Address address;
    private List<String> teammembers;
    public Greeting(long id, String content,Address address,List<String>teammembers) {
        this.id = id;
        this.content = content;
        this.address = address;
        this.teammembers= teammembers;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getTeammembers() {
        return teammembers;
    }

    public void setTeammembers(List<String> teammembers) {
        this.teammembers = teammembers;
    }
}
