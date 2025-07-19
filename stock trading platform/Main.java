import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulated market
        Map<String, Stock> market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", "Apple", 190.5));
        market.put("GOOG", new Stock("GOOG", "Google", 2700.0));
        market.put("TSLA", new Stock("TSLA", "Tesla", 800.0));

        User user = new User("Alice");

        while (true) {
            System.out.println("\n=== STOCK TRADING PLATFORM ===");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Update Prices");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Market Data:");
                    for (Stock s : market.values()) {
                        System.out.println(s.getTicker() + ": $" + s.getPrice());
                    }
                }
                case 2 -> {
                    System.out.print("Enter stock ticker: ");
                    String ticker = scanner.next().toUpperCase();
                    System.out.print("Enter quantity to buy: ");
                    int qty = scanner.nextInt();
                    if (market.containsKey(ticker)) {
                        user.buyStock(market.get(ticker), qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter stock ticker: ");
                    String ticker = scanner.next().toUpperCase();
                    System.out.print("Enter quantity to sell: ");
                    int qty = scanner.nextInt();
                    if (market.containsKey(ticker)) {
                        user.sellStock(market.get(ticker), qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                }
                case 4 -> user.showPortfolio(market);
                case 5 -> user.showTransactions();
                case 6 -> {
                    for (Stock s : market.values()) {
                        s.updatePrice();
                    }
                    System.out.println("Prices updated.");
                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
