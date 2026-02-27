public class DiscountRules {

    private IDiscount dis;

    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        if(customerType == "student") {
            this.dis = new StudentDiscount();
        }
        else if(customerType == "staff") {
            this.dis = new StaffDiscount();
        }
        return dis.discountAmount(subtotal, distinctLines);
    }
}