package de.phillippbertram.domain.entities;

import java.util.Date;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
public class Message {

    public enum Status {
        SENDING, SENT, DELIVERED, FAILED
    }

    public static class Details {

        final Date sentAt;

        final Date receivedAt;

        public Details(final Date sentAt, final Date receivedAt) {
            this.sentAt = sentAt;
            this.receivedAt = receivedAt;
        }
    }

    private final String id;

    private final Status status;

    private final String text;

    private final Contact sender;

    private final Details details;

    public Message(final String id, final Status status, final String text, final Contact sender,
            final Details details) {
        this.id = id;
        this.status = status;
        this.text = text;
        this.sender = sender;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public Contact getSender() {
        return sender;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Message message = (Message) o;

        return id != null ? id.equals(message.id) : message.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
