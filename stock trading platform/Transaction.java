import java.time.LocalDateTime;

public class Transaction {
    private String type; // BUY or SELL
    private String ticker;
    private int quantity;
    private double price;
    private LocalDateTime timestamp;

    public Transaction(String type, String ticker, int quantity, double price) {
        this.type = type;
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " | " + type + " " + quantity + " of " + ticker + " @ " + price;
    }
}
