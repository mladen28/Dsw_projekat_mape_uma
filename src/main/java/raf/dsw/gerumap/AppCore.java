package raf.dsw.gerumap;


import raf.dsw.gerumap.Logger.ConsoleLogger;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.Logger.FIleLogger;
import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.mapRepository.MapRepositoryImplementation;
import raf.dsw.gerumap.serializer.GsonSerializer;

public class AppCore {


    public static void main(String[] args) {

        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImplementation();
        ErrorLogger cl = new ConsoleLogger();
        ErrorLogger fl = new FIleLogger();
        MessageGenerator mg = new MessageGeneratorImplementation();
        Serializer serializer = new GsonSerializer();
        appCore.initialise(gui, mapRepository,mg,cl, fl, serializer);
        appCore.run();
    }

}
