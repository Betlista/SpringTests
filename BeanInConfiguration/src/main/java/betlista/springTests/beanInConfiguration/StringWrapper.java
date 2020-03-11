package betlista.springTests.beanInConfiguration;

/** Represents a very simple Bean */
public class StringWrapper {

    private String name;

    public StringWrapper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
