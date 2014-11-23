package org.docksidestage.doma.app;

import java.util.List;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.entity.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class BatchDeleteTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testBatchDelete() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            List<Employee> list = dao.selectAll();
            dao.batchDelete(list);
        });
    }
}
