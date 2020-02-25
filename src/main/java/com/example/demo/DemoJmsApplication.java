package com.example.demo;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJmsApplication {

	public static void main(String[] args) throws Exception {
		ActiveMQServer activeMQServer=ActiveMQServers.newActiveMQServer(new ConfigurationImpl().
				setPersistenceEnabled(false).setJournalDirectory("target/journal/data").
				setSecurityEnabled(false).
				addAcceptorConfiguration("invn", "vm://0")
				);
		activeMQServer.start();
		SpringApplication.run(DemoJmsApplication.class, args);
	}

}
