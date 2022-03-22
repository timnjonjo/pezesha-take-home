package com.pezesha.sampleconsumer.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pezesha.sampleconsumer.models.PaymentDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQTemporaryQueue;
import org.apache.activemq.artemis.jms.client.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {


    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) message;
            PaymentDetails data=  new ObjectMapper().readValue(activeMQTextMessage.getText(), PaymentDetails.class);
            log.info("Received Message: " + data.toString());
        } catch (Exception e) {
            log.error("Received Exception : " + e.getMessage());
        }
    }
}