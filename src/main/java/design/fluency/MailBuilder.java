package design.fluency;

public class MailBuilder {

    private String to;
    private String from;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public MailBuilder to(String to) {
        this.to = to;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public MailBuilder from(String from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public MailBuilder body(String body) {
        this.body = body;
        return this;
    }

    public void send() {
        System.out.format("Sending Message from %s to %s\n %s\n %s", from, to, subject, body);
    }
}
