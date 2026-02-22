public abstract class Exporter {
    public abstract ExportResult export(ExportRequest req);

    protected String ensureNotNull(String s) {
        return s == null ? "" : s;
    }
}