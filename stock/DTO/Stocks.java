package stock.DTO;

public class Stocks {

    private int id;
    private String Name;
    private int Prices;

    public Stocks(int id, String Name, int Prices) {
        this.id = id;
        this.Name = Name;
        this.Prices = Prices;

    }

    public Stocks() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrices(int Prices) {
        this.Prices = Prices;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return Name;
    }

    public int getPrices() {
        return Prices;
    }

    @Override
    public String toString() {
        return "Stocks: " + Name + "-" + Prices + "-" + id ;
    }

    @Override
    public boolean equals(Object obj) {
        Stocks other = (Stocks) obj;
        if (other.getName().equals(Name)) {
            return true;
        }
        return false;
    }
}
