import com.johan.tesistingwithjava.util.PasswordUtil;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.MEDIUM;
import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.WEAK;
import static com.johan.tesistingwithjava.util.PasswordUtil.SecurityLevel.STRONG;
import static com.johan.tesistingwithjava.util.PasswordUtil.checkPasswordSecurity;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {

    @Test
    public void checkWeakSecurity() {
        assertEquals(checkPasswordSecurity("123446845"), WEAK);
        assertEquals(checkPasswordSecurity("fsdfsdfsdfsd"), WEAK);
        assertEquals(checkPasswordSecurity("dasf48"), WEAK);
        assertEquals(checkPasswordSecurity("45645"), WEAK);
    }

    @Test
    public void checkMediumSecurity() {
        assertEquals(checkPasswordSecurity("dasf123684"), MEDIUM);
    }

    @Test
    public void checkHardSecurity() {
        assertEquals(checkPasswordSecurity("dasf123684!"), STRONG);
    }

    @Test(expected = NoSuchElementException.class)
    public void validateException(){
        PasswordUtil.returnMessage();
    }
}
