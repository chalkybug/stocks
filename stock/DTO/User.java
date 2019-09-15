package stock.DTO;

public class User implements Comparable<User> {

    private int id;
    private String Name;
    private double Balance;
    private String Pass;

    public User() {
    }

    public User(int id, String Name, double Balance, String Pass) {
        this.id = id;
        this.Name = Name;
        this.Balance = Balance;
        this.Pass = Pass;
    }

    @Override
    public boolean equals(Object obj) {

        User other = (User) obj;
        if (other.getId() == id) {
            return true;
        }

        return false;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    @Override
    public int compareTo(User o) {

        return o.getId() - id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User: " + this.Name + "-" + this.id + ",";
    }
}
