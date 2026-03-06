public class StaffDiscount implements IDiscount {
    public double discountAmount(double subtotal, int distinctLines) {
        if (distinctLines >= 3) return 15.0;
        return 5.0;
    }
}
