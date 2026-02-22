public class InvoiceFormatter {
    public String format(BillContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(ctx.invoiceId).append("\n");
        for (String line : ctx.lineDetails) {
            sb.append(line).append("\n");
        }
        sb.append(String.format("Subtotal: %.2f\n", ctx.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", ctx.taxPercent, ctx.taxAmount));
        sb.append(String.format("Discount: -%.2f\n", ctx.discountAmount));
        sb.append(String.format("TOTAL: %.2f\n", ctx.total));
        return sb.toString();
    }
}