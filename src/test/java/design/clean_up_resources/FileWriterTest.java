package design.clean_up_resources;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileWriterTest {

    private static final String TEXT = "Hello World";
    private static final String FILE_NAME = "test_file.txt";

    private FileWriter fileWriter;

    @Before
    public void setUp() throws IOException {
        FileUtils.deleteQuietly(new File(FILE_NAME));
        fileWriter = new FileWriter(FILE_NAME);
    }

    @After
    public void tearDown() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
    }

    @Test
    public void shouldWriteTextIntoFileAndCloseIt() throws Exception {
        fileWriter.write(TEXT);
        fileWriter.close();

        assertThat(new File(FILE_NAME)).exists();
        assertThat(new File(FILE_NAME)).hasContent(TEXT);
        assertThatThrownBy(() -> fileWriter.write(TEXT))
                .isInstanceOf(IOException.class);
    }

    @Test
    public void shouldWriteTextIntoFileAndCloseItUsingTryWithResource() throws Exception {
        //not good because everyone using the API has to remember to writeInto ARM
        try (final FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            fileWriter.write(TEXT);
            this.fileWriter = fileWriter;
        }

        assertThat(new File(FILE_NAME)).exists();
        assertThat(new File(FILE_NAME)).hasContent(TEXT);
        assertThatThrownBy(() -> fileWriter.write(TEXT))
                .isInstanceOf(IOException.class);
    }

    @Test
    public void shouldWriteTextIntoFileAndCloseItUsingEAMPattern() throws IOException {
        FileWriterEAM.writeInto(FILE_NAME, instance -> instance.write(TEXT));

        assertThat(new File(FILE_NAME)).exists();
        assertThat(new File(FILE_NAME)).hasContent(TEXT);
    }
}