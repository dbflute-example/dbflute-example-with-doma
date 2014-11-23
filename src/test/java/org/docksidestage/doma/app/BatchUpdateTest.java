package org.docksidestage.doma.app;

import java.util.List;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.domain.Salary;
import org.docksidestage.doma.app.entity.Employee;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class BatchUpdateTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testBatchUpdate() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            List<Employee> list = dao.selectAll();
            for (Employee employee : list) {
                Salary salary = employee.getSalary();
                if (salary != null) {
                    employee.setSalary(salary.add(new Salary(100)));
                }
            }
            dao.batchUpdate(list);
        });
    }
}
