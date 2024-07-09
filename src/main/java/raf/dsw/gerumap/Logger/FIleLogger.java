package raf.dsw.gerumap.Logger;

import raf.dsw.gerumap.ErrorFactory.Error;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.core.MessageGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FIleLogger implements ErrorLogger
{

    public FIleLogger ()
    {
        MessageGeneratorImplementation.getInstance().addSubscriber(this);
    }

    @Override
    public void update(Object notification) {
        Error err = (Error) notification;
        log(err.getPoruka());
    }

    @Override
    public void log(String error) {
        FileWriter myWriter = null;
        try {
            File toChange = new File("src/main/resources/file.txt");
            myWriter = new FileWriter(toChange);
            myWriter.write(error);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
