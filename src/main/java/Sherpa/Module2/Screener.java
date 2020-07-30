package Sherpa.Module2;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.lang.String;
import static Sherpa.Module2.SanctionsScreeningProject.CsvPass;

@Service
public class Screener {
    //Extensively I have tried many functions here to  set up a filter which goes through the list in the best way possible.
    //However, accounting for all types of charcater sequences has proven difficult
    //This function below and the implemented library has proven to be the best one ive tried from all the rest in making the most accurate hit in string comparison.
    //Also holds the best space and time complexity versus all previously tried in executing the screening of the character sequences.

    public String Screen(String input) {
        if(input.isEmpty())
        {
            return "Empty Line";
        }
        Double Holder;
        Double accurate_Hold = 0.0;
        JaroWinklerSimilarity scan = new JaroWinklerSimilarity(); //Measure edit distance between two strings
//        The higher the Jaro distance for two strings is, the more similar the strings are.
//        The score is normalized such that 0 equates to no similarity and 1 is an exact match.
        for (String s : CsvPass) {
            Holder = scan.apply(s, input);
            if (Holder >= accurate_Hold) {
                accurate_Hold = Holder;
            }
        }
        if (accurate_Hold > .75) {
            return "Hit / " + String.format("%.2f",accurate_Hold);
        }
        return "No Hit";
    }

    @KafkaListener(topics = "input", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("-------------------------------");
        System.out.println("Message recieved: " + message);
        System.out.println(Screen(message));
        System.out.println("-------------------------------");
        System.out.println();
    }

}

