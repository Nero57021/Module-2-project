package Sherpa.Module2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller { //disregard warning about class not being used. It is utilized by Postman to send the input.
    //At request of any message needing to be publish/sent, this will handle.
    private final Sender producer;

    @Autowired
    public Controller(Sender producer) {
        this.producer = producer;
    }

    @PostMapping("/Send")
    public void messageToTopic(@RequestParam("input") String message) {
        this.producer.sendMessage(message);
    }
}