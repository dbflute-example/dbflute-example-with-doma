package org.docksidestage.doma.app;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.entity.Employee;
import org.docksidestage.doma.app.entity.JobType;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class UpdateTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testUpdate() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = dao.selectById(1);
            employee.setName("hoge");
            employee.setJobType(JobType.PRESIDENT);
            dao.update(employee);
        });
    }

    @Test
    public void testUpdateWithSqlFile() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = dao.selectById(1);
            employee.setName("hoge");
            employee.setJobType(JobType.PRESIDENT);
            dao.updateWithSqlFile(employee);
        });
    }
}
