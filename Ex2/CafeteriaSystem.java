import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final IInvoiceStore store;
    private final PricingCalculator calculator;
    private final InvoiceFormatter formatter;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(IInvoiceStore store) {
        this.store = store;
        this.calculator = new PricingCalculator();
        this.formatter = new InvoiceFormatter();
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        
        BillContext context = calculator.calculate(invId, customerType, lines, menu);
        String printable = formatter.format(context);
        
        System.out.print(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}