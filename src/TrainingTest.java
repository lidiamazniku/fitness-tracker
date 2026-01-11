import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingTest {

    @Test
    void testGetters() {
        // Arrange: Trainingsobjekt erstellen
        Training training = new Training(
                "Laufen",
                300.5,
                45,
                "Mittel"
        );

        // Assert: Getter-Werte prüfen
        assertEquals("Laufen", training.getTrainigsArt());
        assertEquals(300.5, training.getKalorien());
        assertEquals(45, training.getDauer());
        assertEquals("Mittel", training.getIntensitaet());
    }
}
