import java.util.*;

public class BillContext {
    private final String invId;
    private double subtotal;
    private final List<OrderLine> lines;
    private double tax;
    private double discount;
    private double total;
    private double taxPct;
    private int invoiceSeq;
    private final DiscountRules discountRules;
    private final TaxRules taxRules;
    private final Map<String, MenuItem> menu;
    private final String customerType;


    public BillContext(List<OrderLine> lines,Map<String, MenuItem> menu,String customerType) {
        this.lines = lines;
        this.invoiceSeq = 1000;
        this.invId = "INV-" + (++invoiceSeq);
        this.subtotal = 0.0;
        this.discountRules = new DiscountRules();
        this.taxRules = new TaxRules();
        this.menu = menu;
        this.customerType = customerType;
        for (OrderLine l : lines) {
            MenuItem item = this.menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            this.subtotal += lineTotal;
        }
        this.taxPct = taxRules.taxPercent(customerType);
        this.tax = subtotal * (taxPct / 100.0);
        this.discount = discountRules.discountAmount(this.customerType, this.subtotal, this.lines.size());
        this.total = subtotal + tax - discount;
    }

    public double getAmount() {
        return this.total;
    }

    public String getInvId() {
        return invId;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTaxPct() {
        return taxPct;
    }

    public List<OrderLine> getLines() {
        return lines;
    }
    
    
    
}
