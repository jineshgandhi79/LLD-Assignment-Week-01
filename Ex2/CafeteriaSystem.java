import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu;
    private final FileStore store;

    CafeteriaSystem() {
        this.menu = new LinkedHashMap<>();
        this.store = new FileStore();
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }
    
    public void checkout(String customerType, List<OrderLine> lines) {

        BillContext bill = new BillContext(lines,menu,customerType);
        InvoiceFormatter invoiceFormatter = new InvoiceFormatter(bill, menu);

        String printable = invoiceFormatter.generateFormat();
        System.out.print(printable);

        store.save(bill.getInvId(), printable);
        System.out.println("Saved invoice: " + bill.getInvId() + " (lines=" + store.countLines(bill.getInvId()) + ")");
    }
}