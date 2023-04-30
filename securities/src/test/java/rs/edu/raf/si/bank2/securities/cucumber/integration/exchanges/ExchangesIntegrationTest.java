package rs.edu.raf.si.bank2.securities.cucumber.integration.exchanges;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/exchange-integration/exchange.feature")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "rs.edu.raf.si.bank2.securities.cucumber.integration.exchanges")
public class ExchangesIntegrationTest {}
