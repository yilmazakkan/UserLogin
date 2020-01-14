package com.yilmazakkan.UserAccount.model;

import javax.persistence.*;

@Entity
@Table(name = "user_accunt" )
    public class User  {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "username", length = 100, unique = true)
        private String username;

        @Column(name = "pwd", length = 200)
        private String password;

        @Column(name = "name_surname", length = 200)
        private String nameSurname;

        @Column(name = "email", length = 100)
        private String email;

        public User(){}

        public User(String username, String password, String nameSurname, String email) {
            this.username = username;
            this.password = password;
            this.nameSurname = nameSurname;
            this.email = email;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNameSurname() {
            return nameSurname;
        }

        public void setNameSurname(String nameSurname) {
            this.nameSurname = nameSurname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", nameSurname='" + nameSurname + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
