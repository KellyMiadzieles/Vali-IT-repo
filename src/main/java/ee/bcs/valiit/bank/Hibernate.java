package ee.bcs.valiit.bank;

import javax.persistence.*;

@Table(name="account")
@Entity //seotud andmebaasiga
public class Hibernate {

        @Id
        //juhul kui on auto increment id tulp
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String firstName;
        private String lastName;
        private String accountNumber; //andmebaasis peab olema tulba nimi account_number
        private Double balance;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getAccountNumber() {
                return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
        }

        public Double getBalance() {
                return balance;
        }

        public void setBalance(Double balance) {
                this.balance = balance;
        }
}
