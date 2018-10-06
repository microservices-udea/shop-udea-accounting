package com.udea.edu.co.microservices.accounting;

import com.udea.edu.co.microservices.accounting.Infraestructure.KafkaOrderPaidEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		SpringApplication.run(MainApplication.class, args);
        //KafkaOrderPaidEvent kafkaOrderPaidEvent = new KafkaOrderPaidEvent();
        /*kafkaOrderPaidEvent.processEvent("{\n" +
                "  \"id\": \"47446806-f1247137-47361ba\",\n" +
                "  \"_creationDate\": \"2017-11-23\",\n" +
                "  \"entryDate\": \"2017-11-23 13:07:54.131\",\n" +
                "  \"compensation\": -25.0000,\n" +
                "  \"payout\": 85.0000,\n" +
                "  \"fee\": 5.0000,\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"transactionId\": \"05e8d364-6075-4510-892f-f9028507918a\",\n" +
                "  \"accountId\": \"40f54247\",\n" +
                "  \"productType\": \"Insurance\",\n" +
                "  \"securityId\": \"91ef947a\",\n" +
                "  \"repId\": \"8922b061\",\n" +
                "  \"payeeId\": \"b4407f70\",\n" +
                "  \"contractId\": \"AV_o-gwFQRPbTib8Lrsl\",\n" +
                "  \"compensationPercent\": 100.0000,\n" +
                "  \"effectiveDate\": \"2017-01-02\",\n" +
                "  \"payCloseDate\": null,\n" +
                "  \"ruleId\": \"AV_o5WmzQRPbTib8Lrov\",\n" +
                "  \"readyForPayout\": false,\n" +
                "  \"_eventType\": \"co.edu.udea.microservices.compensations.events.CompensationCreated\",\n" +
                "  \"netPayout\": 505.0000,\n" +
                "  \"payRecordStatus\": \"OPEN\",\n" +
                "  \"_version\": 2\n" +
                "}");*/

	}
}
