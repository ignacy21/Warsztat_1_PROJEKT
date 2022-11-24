public class Person {

    private String name;
    private String surname;
    private Integer counter;
    private boolean isVIP;

    public Person(String name, String surname, Integer counter) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
    }
    public Person(String name, String surname, Integer counter, boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVIP = isVip;
    }

    @Override
    public String toString() {
        if (isVIP) {
            return  name + "_" + surname +
                    "_" + counter + "_VIP";
        }
        return  name + "_" + surname +
                "_" + counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!surname.equals(person.surname)) return false;
        return getCounter().equals(person.getCounter());
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + getCounter().hashCode();
        return result;
    }
}
