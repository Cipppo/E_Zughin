package stage.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainFilesLoader {
    
    public InputStream load(String resourceName) {
        try (var fileIn = MainFilesLoader.class.getResourceAsStream(File.separator + resourceName)) {
            return fileIn;
        } catch (IOException e1) {
            return new ByteArrayInputStream(("/" + resourceName).getBytes());
        }
    }
}
