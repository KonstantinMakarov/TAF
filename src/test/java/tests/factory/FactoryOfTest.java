package tests.factory;

import org.testng.annotations.Factory;

public class FactoryOfTest {

    @Factory
    public Object[] runFactoryOfTests() {
        return new Object[]{ new FactoryExampleCaseTest(), new FactoryExampleCaseTest("0520")};
    }
}
