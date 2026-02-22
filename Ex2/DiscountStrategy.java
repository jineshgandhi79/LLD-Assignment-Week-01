import java.util.List;

public interface DiscountStrategy {
    double calculateDiscount(double subtotal, List<OrderLine> lines);
}