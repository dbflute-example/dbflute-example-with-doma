package org.docksidestage.doma.app;

import java.util.Arrays;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.domain.Salary;
import org.docksidestage.doma.app.entity.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class BatchInsertTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testBatchInsert() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee1 = new Employee();
            employee1.setName("test-1");
            employee1.setAge(30);
            employee1.setSalary(new Salary(300));

            Employee employee2 = new Employee();
            employee2.setName("test-2");
            employee2.setAge(40);
            employee2.setSalary(new Salary(500));

            dao.batchInsert(Arrays.asList(employee1, employee2));
        });
    }
}
