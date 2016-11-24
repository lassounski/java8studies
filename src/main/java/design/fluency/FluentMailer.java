package design.fluency;

import java.util.function.Consumer;

public class FluentMailer {

    private FluentMailer() {
    }

    private String to;
    private String from;
    private String subject;
    private String body;

    public FluentMailer to(String to) {
        this.to = to;
        return this;
    }

    public FluentMailer from(String from) {
        this.from = from;
        return this;
    }

    public FluentMailer subject(String subject) {
        this.subject = subject;
        return this;
    }

    public FluentMailer body(String body) {
        this.body = body;
        return this;
    }

    public static void send(Consumer<FluentMailer> fluentMailerConsumer) {
        FluentMailer mailer = new FluentMailer();

        fluentMailerConsumer.accept(mailer);
    }

    private void log() {
        System.out.format("Sending Message from %s to %s\n %s\n %s", from, to, subject, body);
    }
}
