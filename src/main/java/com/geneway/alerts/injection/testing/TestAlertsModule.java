package com.geneway.alerts.injection.testing;

import java.util.Properties;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;


/**
 * A testing helper for the alerts module. To override the {@code AlertsModule}
 * behavior use:
 * {@code Modules.override(new AlertsModule()).with(new TestAlertsModule())}
 * @author firas1
 *
 */
public class TestAlertsModule extends AbstractModule {
	public static final GreenMail MAIL_SERVER = new GreenMail(ServerSetupTest.SMTP);
	public static final String LOCALHOST = "127.0.0.1";

	
	@Provides
	protected Properties provideProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", LOCALHOST);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", ServerSetupTest.SMTP.getPort());
		return properties;
	}

	
	@Override
	protected void configure() {
		//Binding provided through provides methods
	}
}
