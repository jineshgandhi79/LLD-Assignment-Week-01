import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String body = ensureNotNull(req.body);
        if (body.length() > 20) {
            throw new RuntimeException("PDF cannot handle content > 20 chars");
        }
        
        String fakePdf = "PDF(" + ensureNotNull(req.title) + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}