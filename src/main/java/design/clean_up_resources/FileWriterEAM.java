package design.clean_up_resources;

import java.io.IOException;

/**
 * Class implementing the Execute Around Method pattern
 * that encapsulates the closing of the FileWriter resource
 */
public class FileWriterEAM {

    private final FileWriter fileWriter;

    private FileWriterEAM(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public static void writeInto(String fileName, UseInstance<FileWriterEAM, IOException> block) throws IOException {
        FileWriterEAM fileWriterEAM = new FileWriterEAM(fileName);

        try{
            block.use(fileWriterEAM);
        }finally {
            fileWriterEAM.close();
        }
    }

    public void write(final String text) throws IOException {
        fileWriter.write(text);
    }

    private void close() throws IOException {
        fileWriter.close();
    }
}
