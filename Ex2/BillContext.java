import java.util.*;

public class BillContext {
    public final String invoiceId;
    public final List<String> lineDetails = new ArrayList<>();
    public double subtotal;
    public double taxPercent;
    public double taxAmount;
    public double discountAmount;
    public double total;

    public BillContext(String invoiceId) { this.invoiceId = invoiceId; }
}