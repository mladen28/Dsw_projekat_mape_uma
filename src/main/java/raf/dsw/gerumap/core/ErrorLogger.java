package raf.dsw.gerumap.core;

import raf.dsw.gerumap.ErrorFactory.Error;
import raf.dsw.gerumap.Observer.Subscriber;

public interface ErrorLogger extends Subscriber {

        void log(String error);


}
