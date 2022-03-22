package com.pezesha.sampleproducer.configs;

import com.pezesha.sampleproducer.models.PaymentDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JmsProducer {

    private final JmsTemplate jmsTemplate;


    @Value("${active-mq.topic}")
    private String topic;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    //CronJob for Sending Data
    @Scheduled(cron = "*/2 * * * * *")
    public void scheduler() {
        PaymentDetails data = PaymentDetails.builder()
                .amount(500d)
                .name("Sir Njonjo")
                .time(new Date())
                .build();
        sendMessage(data);
    }

    private void sendMessage(PaymentDetails data) {
        try {
            log.info("Attempting Send message to Topic: " + topic);
            jmsTemplate.convertAndSend(topic, data);
        } catch (Exception e) {
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}