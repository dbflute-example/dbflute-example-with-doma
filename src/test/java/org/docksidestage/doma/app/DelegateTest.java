package org.docksidestage.doma.app;

import static org.junit.Assert.assertEquals;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class DelegateTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testDelegate() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            assertEquals(14, dao.count());
        });
    }

}
