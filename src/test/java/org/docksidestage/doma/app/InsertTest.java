package org.docksidestage.doma.app;

import java.sql.Timestamp;

import org.docksidestage.doma.app.dao.EmployeeDao;
import org.docksidestage.doma.app.dao.EmployeeDaoImpl;
import org.docksidestage.doma.app.domain.Salary;
import org.docksidestage.doma.app.entity.Employee;
import org.docksidestage.doma.app.entity.JobType;
import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class InsertTest {

    @Rule
    public final DbResource dbResource = new DbResource();

    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Test
    public void testInsert() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = new Employee();
            employee.setName("test");
            employee.setAge(50);
            employee.setSalary(new Salary(300));
            employee.setJobType(JobType.PRESIDENT);
            dao.insert(employee);
        });
    }

    @Test
    public void testInsertWithSqlFile() throws Exception {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            Employee employee = new Employee();
            employee.setId(100);
            employee.setName("test");
            employee.setAge(50);
            employee.setSalary(new Salary(300));
            employee.setJobType(JobType.PRESIDENT);
            employee.setInsertTimestamp(new Timestamp(System.currentTimeMillis()));
            employee.setVersion(1);
            dao.insertWithSqlFile(employee);
        });
    }
}
