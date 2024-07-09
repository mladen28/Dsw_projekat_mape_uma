package raf.dsw.gerumap.Logger;

import raf.dsw.gerumap.ErrorFactory.Error;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.core.MessageGenerator;

public class ConsoleLogger implements ErrorLogger {
    public ConsoleLogger(){
        MessageGeneratorImplementation.getInstance().addSubscriber(this);
    }

    @Override
    public void log(String error) {
        System.out.println(error);
    }

    @Override
    public void update(Object notification) {
        Error err = (Error) notification;
        log(err.getPoruka());
    }
}
