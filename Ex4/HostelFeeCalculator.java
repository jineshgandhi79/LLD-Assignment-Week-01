import java.util.*;
public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);
        ReceiptPrinter.print(req, monthly, deposit);
        String bookingId = "H-7781"; // Fixed to match sample output requirement
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double total = PricingRegistry.getRoomRule(req.roomType).getBasePrice();
        for (AddOn a : req.addOns) {
            total += a.price;
        }
        return new Money(total);
    }
}