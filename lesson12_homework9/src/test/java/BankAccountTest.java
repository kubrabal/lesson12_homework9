import com.github.kubrabal.AccountFrozenException;
import com.github.kubrabal.BankAccount;

import com.github.kubrabal.InsufficientBalanceException;
import com.github.kubrabal.InvalidAccountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testCheckBalanceWithValidAccount() {
        BankAccount account = new BankAccount();
        try {
            double balance = account.checkBalance(123456);
            assertEquals(1000.0, balance);
        } catch (Exception e) {
            fail("Beklenmeyen bir hata oluştu: " + e.getMessage());
        }
    }

    @Test
    public void testCheckBalanceWithInvalidAccount() {
        BankAccount account = new BankAccount();
        assertThrows(InvalidAccountException.class, () -> account.checkBalance(999999));
    }

    @Test
    public void testCheckBalanceWithInsufficientBalance() {
        BankAccount account = new BankAccount();
        try {
            account.withdraw(900.0);
            assertThrows(InsufficientBalanceException.class, () -> {
                account.checkBalance(123456);
            });
        } catch (Exception e) {
            fail("Beklenmeyen bir hata oluştu: " + e.getMessage());
        }
    }

    @Test
    public void testCheckBalanceWithFrozenAccount() {
        BankAccount account = new BankAccount();
        // Hesabı dondur
        account.freezeAccount(123456);

        assertThrows(AccountFrozenException.class, () -> {
            account.checkBalance(123456);
        });
    }
}
