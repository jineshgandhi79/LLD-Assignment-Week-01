import java.util.*;

public class PricingCalculator {
    public BillContext calculate(String invId, String customerType, List<OrderLine> lines, Map<String, MenuItem> menu) {
        BillContext context = new BillContext(invId);
        
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            context.subtotal += lineTotal;
            context.lineDetails.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }

        context.taxPercent = getTaxPercent(customerType);
        context.taxAmount = context.subtotal * (context.taxPercent / 100.0);
        context.discountAmount = getDiscount(customerType, context.subtotal, lines);
        context.total = context.subtotal + context.taxAmount - context.discountAmount;

        return context;
    }

    private double getTaxPercent(String type) {
        if ("student".equalsIgnoreCase(type)) return 5.0;
        if ("staff".equalsIgnoreCase(type)) return 2.0;
        return 8.0;
    }

    private double getDiscount(String type, double subtotal, List<OrderLine> lines) {
        if ("student".equalsIgnoreCase(type)) {
            return (subtotal >= 180.0) ? 10.0 : 0.0;
        }
        if ("staff".equalsIgnoreCase(type)) {
            return (lines.size() >= 3) ? 15.0 : 5.0;
        }
        return 0.0;
    }
}