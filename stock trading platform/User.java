import java.util.Map;
public class User {
    private String name;
    private double balance;
    private Portfolio portfolio;

    public User(String name) {
        this.name = name;
        this.balance = 10000.0;
        this.portfolio = new Portfolio();
    }

    public void buyStock(Stock stock, int qty) {
        boolean success = portfolio.buy(stock, qty, balance);
        if (success) {
            balance -= stock.getPrice() * qty;
            System.out.println("Successfully bought " + qty + " of " + stock.getTicker());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void sellStock(Stock stock, int qty) {
        boolean success = portfolio.sell(stock, qty);
        if (success) {
            balance += stock.getPrice() * qty;
            System.out.println("Sold " + qty + " of " + stock.getTicker());
        } else {
            System.out.println("You don't own enough shares.");
        }
    }

    public void showPortfolio(Map<String, Stock> market) {
        System.out.println("\nUser: " + name);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        portfolio.showHoldings();
        System.out.println("Portfolio Value: $" + String.format("%.2f", portfolio.calculateValue(market)));
    }

    public void showTransactions() {
        portfolio.showTransactions();
    }
}
