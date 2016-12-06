package com.mt.patterns.builder;
import com.google.common.base.MoreObjects;
/**
 * Created by max on 05/12/16.
 * <p>
 * Example of the builder pattern if there are too many similar parameters and calling constructor is tricky.
 */
public final class ComplexPerson {

    private final String title;
    private final String name;
    private final String middlename;
    private final String surname;
    private final String login;
    private final String email;
    private final String address;

    private ComplexPerson(String title, String name, String middlename, String surname, String login, String email, String address) {
        this.title = title;
        this.name = name;
        this.middlename = middlename;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("name", name)
                .add("middlename", middlename)
                .add("surname", surname)
                .add("login", login)
                .add("email", email)
                .add("address", address)
                .toString();
    }

    public static final class Builder {

        private String title;
        private String name;
        private String middlename;
        private String surname;
        private String login;
        private String email;
        private String address;

        public Builder title(String theTitle) {
            this.title = theTitle;
            return this;
        }

        public Builder name(String theName) {
            this.name = theName;
            return this;
        }

        public Builder middlename(String theMiddlename) {
            this.middlename = theMiddlename;
            return this;
        }

        public Builder surname(String theSurname) {
            this.surname = theSurname;
            return this;
        }

        public Builder login(String theLogin) {
            this.login = theLogin;
            return this;
        }


        public Builder email(String theEmail) {
            this.email = theEmail;
            return this;
        }

        public Builder address(String theAddress) {
            this.address = theAddress;
            return this;
        }

        public ComplexPerson build() {
            return new ComplexPerson(title, name, middlename, surname, login, email, address);
        }
    }

}
