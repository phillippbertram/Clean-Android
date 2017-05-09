package de.phillippbertram.domain.entities;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */

public class Chat {

    public enum Status {
        ACTIVE, ARCHIVED
    }

    private final String id;

    private final Status status;

    public Chat(final String id, final Status status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
