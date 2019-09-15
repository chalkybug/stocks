package stock.DTO;

public class TradeOrder {

    private int id;
    private String Name;
    private int Quantity;
    private int Prices;

    public TradeOrder(int id, String Name, int Quantity, int Prices) {
        this.id = id;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Prices = Prices;
    }

    @Override
    public String toString() {
        return "TradeOrder: " + this.Name + "-" + this.Quantity + "-" + this.Prices + ";";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getPrices() {
        return this.Prices;
    }

    public void setPrices(int Prices) {
        this.Prices = Prices;
    }

}
