import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(String title,String body) {
        // LSP issue: changes meaning by lossy conversion
        body = body.replace("\n", " ").replace(",", " ");
        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}