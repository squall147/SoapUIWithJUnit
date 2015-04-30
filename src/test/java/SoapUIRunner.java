import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoapUIRunner {

    private final static String SOAP_PROJECT_XML = "src/resources/ExampleAPIEndpoint-soapui-project.xml";

    @Test
    public void testRunner() throws Exception
    {
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
        runner.setProjectFile( SOAP_PROJECT_XML );
        runner.run();
    }

    @Test
    public void testTestCaseRunner() throws Exception
    {
        WsdlProject project = new WsdlProject( SOAP_PROJECT_XML );
        TestSuite testSuite = project.getTestSuiteByName( "Test Suite" );
        TestCase testCase = testSuite.getTestCaseByName( "Test Conversions" );

        // create empty properties and run synchronously
        TestRunner runner = testCase.run( new PropertiesMap(), false );
        assertEquals( TestRunner.Status.FINISHED, runner.getStatus() );
    }

}
