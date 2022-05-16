import com.google.zxing.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ZxingPAFTest {

    private ZxingPAF zxingPAF;

   @BeforeEach
    void setUp() {
       zxingPAF = new ZxingPAF();
    }

    @Test()
    void decodeQR() {
        String path = "src/test/resources";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String requiredString = "MZA2MTI3LDIUMDASMZMWLJAWLDAUMDASMCWWLCDBJW";
//        String imagePath = String.format("%s/Picture1.jpg", absolutePath);
//        System.out.println(imagePath);
        String decodedString = null;
        try {
            decodedString = zxingPAF.decodeQR(absolutePath);
        } catch (IOException | NotFoundException e) {
            throw new RuntimeException(e);
        }
        assertEquals(requiredString, decodedString);
    }
}