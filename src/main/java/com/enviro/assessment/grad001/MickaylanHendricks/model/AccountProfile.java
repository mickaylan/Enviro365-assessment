package com.enviro.assessment.grad001.MickaylanHendricks.model;

import jakarta.persistence.*;

import java.net.URI;

@Entity
@Table(name= "ACCOUNT_PROFILETB")
public class AccountProfile {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String accountHolderName;
        private String accountHolderSurname;
        private URI httpImageLink;

        public AccountProfile() {
        }

        public AccountProfile(String accountHolderName, String accountHolderSurname, URI httpImageLink) {
                this.accountHolderName = accountHolderName;
                this.accountHolderSurname = accountHolderSurname;
                this.httpImageLink = httpImageLink;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getAccountHolderName() {
                return accountHolderName;
        }

        public void setAccountHolderName(String accountHolderName) {
                this.accountHolderName = accountHolderName;
        }

        public String getAccountHolderSurname() {
                return accountHolderSurname;
        }

        public void setAccountHolderSurname(String accountHolderSurname) {
                this.accountHolderSurname = accountHolderSurname;
        }

        public URI getHttpImageLink() {
                return httpImageLink;
        }

        public void setHttpImageLink(URI httpImageLink) {
                this.httpImageLink = httpImageLink;
        }
}
