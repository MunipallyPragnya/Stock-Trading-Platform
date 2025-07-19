import java.util.*;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public boolean buy(Stock stock, int qty, double balance) {
        double cost = stock.getPrice() * qty;
        if (cost > balance) return false;

        holdings.put(stock.getTicker(), holdings.getOrDefault(stock.getTicker(), 0) + qty);
        transactions.add(new Transaction("BUY", stock.getTicker(), qty, stock.getPrice()));
        return true;
    }

    public boolean sell(Stock stock, int qty) {
        int owned = holdings.getOrDefault(stock.getTicker(), 0);
        if (owned < qty) return false;

        holdings.put(stock.getTicker(), owned - qty);
        transactions.add(new Transaction("SELL", stock.getTicker(), qty, stock.getPrice()));
        return true;
    }

    public double calculateValue(Map<String, Stock> market) {
        double total = 0;
        for (String ticker : holdings.keySet()) {
            int qty = holdings.get(ticker);
            Stock stock = market.get(ticker);
            if (stock != null) {
                total += qty * stock.getPrice();
            }
        }
        return total;
    }

    public void showHoldings() {
        System.out.println("Your Holdings:");
        holdings.forEach((ticker, qty) -> System.out.println(ticker + ": " + qty + " shares"));
    }

    public void showTransactions() {
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
