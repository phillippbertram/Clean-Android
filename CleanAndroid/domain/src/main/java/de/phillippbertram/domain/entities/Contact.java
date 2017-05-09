package de.phillippbertram.domain.entities;

import android.support.annotation.NonNull;

/**
 * @author [PBE] Phillipp Bertram | phillipp.bertram@lmis.de
 */
public final class Contact {

    @NonNull
    private final String username;

    private final String firstName;

    private final String lastName;

    public Contact(@NonNull final String username, final String firstName, final String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Contact contact = (Contact) o;

        if (!username.equals(contact.username)) {
            return false;
        }
        if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) {
            return false;
        }
        return lastName != null ? lastName.equals(contact.lastName) : contact.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
