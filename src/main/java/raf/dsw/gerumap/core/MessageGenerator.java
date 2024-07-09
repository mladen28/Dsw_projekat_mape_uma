package raf.dsw.gerumap.core;

import raf.dsw.gerumap.ErrorFactory.Error;
import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.Observer.Publisher;

public interface MessageGenerator extends Publisher {
    void generateError(Errors error);
}
