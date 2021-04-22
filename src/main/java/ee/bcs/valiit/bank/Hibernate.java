package ee.bcs.valiit.bank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="account")
@Entity
public class Hibernate {

        @Id
        private Integer id;
        private String firstName;
        private String lastName;
        private String accountNumber;
        private Integer balance;

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

        public Integer getBalance() {
                return balance;
        }

        public void setBalance(Integer balance) {
                this.balance = balance;
        }
}
