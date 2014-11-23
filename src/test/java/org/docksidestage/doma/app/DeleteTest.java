package org.docksidestage.doma.app;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.entity.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class DeleteTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testDelete() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = dao.selectById(1);
            dao.delete(employee);
        });
    }

    @Test
    public void testDeleteWithSqlFile() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = dao.selectById(1);
            dao.deleteWithSqlFile(employee);
        });
    }
}
