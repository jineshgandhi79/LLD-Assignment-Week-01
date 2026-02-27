public class StudentDiscount implements IDiscount {
    public double discountAmount(double subtotal, int distinctLines) {
        if (subtotal >= 180.0) return 10.0;
        return 0.0;
    }
}
