package Sherpa.Module2;
//Jeremy Bayangos

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    //Class sender is used inconjunction with controller for postman to send inputs.
    private static final String TOPIC = "input";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        this.kafkaTemplate.send(TOPIC, message);
    }

    @Bean
    public NewTopic createTopic() {

        return new NewTopic(TOPIC, 3, (short) 1);
    }
}