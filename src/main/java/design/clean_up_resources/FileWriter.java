package design.clean_up_resources;

import java.io.IOException;

public class FileWriter implements AutoCloseable{

    private final java.io.FileWriter fileWriter;

    public FileWriter(String fileName) throws IOException {
        this.fileWriter = new java.io.FileWriter(fileName);
    }

    public void write(String text) throws IOException {
        fileWriter.write(text);
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }
}
