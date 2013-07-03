package br.unirio.xsoa.endpoint.core;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * @see http://zsoltfabok.com/blog/2012/01/cucumber-jvm-di/
 * @see https://github.com/cucumber/cucumber/wiki/Tags
 */
//@Cucumber.Options(features="classpath:download.feature", tags = {"@download", "@upload"})

@RunWith(Cucumber.class)
public class RunDownloadAcceptanceTest {
}
