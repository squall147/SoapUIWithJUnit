import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class SoapUIRunner {

    public void testRunner() throws Exception
    {
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
        runner.setProjectFile( "src/resources/ExampleAPIEndpoint-soapui-project.xml" );
        runner.run();
    }

}
