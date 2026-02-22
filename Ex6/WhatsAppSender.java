public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            throw new RuntimeException("phone must start with + and country code");
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}