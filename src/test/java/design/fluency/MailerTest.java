package design.fluency;

import org.junit.Test;

public class MailerTest {

    @Test
    public void shouldSendMessage() {
        Mailer mailer = new Mailer();
        mailer.setTo("World");
        mailer.setFrom("Delaru");
        mailer.setSubject("Hello");
        mailer.setBody("Hello World!");
        mailer.send();
    }

    @Test
    public void shouldSendMessageChainingMethods() {
        new MailBuilder()
                .to("World")
                .from("Delaru")
                .subject("Hello")
                .body("Hello World!")
                .send();
    }

    @Test
    public void shouldSendMessageUsingFluentAPI() {
        FluentMailer.send(fluentMailer -> fluentMailer
                .to("World")
                .from("Delaru")
                .subject("Hello")
                .body("Hello World!")
        );
    }
}
