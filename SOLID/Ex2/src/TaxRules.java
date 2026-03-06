public class TaxRules {
    private ITaxes tax;
    public double taxPercent(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            this.tax = new StudentTaxes();
            return tax.taxPercent();
        }
        else if ("staff".equalsIgnoreCase(customerType)) {
            this.tax = new StaffTaxes();
            return tax.taxPercent();
        }
        return 8.0;
    }
}