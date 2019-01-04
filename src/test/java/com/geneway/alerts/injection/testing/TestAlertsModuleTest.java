package com.geneway.alerts.injection.testing;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.google.inject.Guice;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.nutrinfomics.geneway.shared.testcategory.FastTest;

@Category(value = {FastTest.class})
public class TestAlertsModuleTest {

  @Inject Properties properties;

  @Before
  public void setUp() {
    Guice.createInjector(new TestAlertsModule()).injectMembers(this);
  }

  @Test
  public void testProvideProperties() {
    assertEquals(ServerSetupTest.SMTP.getPort(), properties.get("mail.smtp.port"));
    assertEquals("true", properties.get("mail.smtp.auth"));
    assertEquals(TestAlertsModule.LOCALHOST, properties.get("mail.smtp.host"));
  }
}
