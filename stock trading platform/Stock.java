import java.util.Random;

public class Stock {
    private String ticker;
    private String name;
    private double price;

    public Stock(String ticker, String name, double price) {
        this.ticker = ticker;
        this.name = name;
        this.price = price;
    }

    public void updatePrice() {
        Random rand = new Random();
        double change = (rand.nextDouble() * 0.1) - 0.05; // ±5%
        price = Math.round((price + price * change) * 100.0) / 100.0;
    }

    public String getTicker() { return ticker; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
