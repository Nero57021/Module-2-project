package Sherpa.Module2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SanctionsScreeningProjectTests {

	@Autowired
	Screener test = new Screener();
	@Test
	public void emptyLine() {
		assertThat(test.Screen(""),equalTo("Empty Line"));

	}
	@Test
	public void WordNotInList() {
		assertThat(test.Screen("Christoper colombus"), equalTo("No Hit"));
	}

	@Test
	public void AllHitTypes() {
		String [] blank = new String[0];
		SanctionsScreeningProject.main(blank);
		assertThat(test.Screen("Iceland"), equalTo("Hit / 1.00")); //Regular full hit
		assertThat(test.Screen("1celand"), equalTo("Hit / 0.90")); //Number mixed in sequence
		assertThat(test.Screen("Jama!ca"), equalTo("Hit / 0.94")); //Special Characters
		assertThat(test.Screen("Jama!c4"), equalTo("Hit / 0.89")); //Numbers and special characters
		assertThat(test.Screen("Tan zania"), equalTo("Hit / 0.97")); //Spaces involved
		assertThat(test.Screen("Tan Za_nia"), equalTo("Hit / 0.90"));//Spaces and underscores involved
		assertThat(test.Screen("iCeland"), equalTo("Hit / 0.81"));//UpperCase vs lowerCase involved
		assertThat(test.Screen("1Cela#d_"), equalTo("No Hit"));//All Mix combined
	}
}