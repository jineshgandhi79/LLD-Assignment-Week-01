import java.util.Map;

public class InvoiceFormatter {
    // pointless wrapper (smell)
    private final BillContext bill;
    private final Map<String, MenuItem> menu;
    
    public InvoiceFormatter(BillContext bill, Map<String, MenuItem> menu) {
        this.bill = bill;
        this.menu = menu;
    }


    public String generateFormat() {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(bill.getInvId()).append("\n");
        for (OrderLine l : bill.getLines()) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        out.append(String.format("Subtotal: %.2f\n", bill.getSubtotal()));
        out.append(String.format("Tax(%.0f%%): %.2f\n", bill.getTaxPct(), bill.getTax()));
        out.append(String.format("Discount: -%.2f\n", bill.getDiscount()));
        out.append(String.format("TOTAL: %.2f\n", bill.getAmount()));
        return out.toString();
    }
}
