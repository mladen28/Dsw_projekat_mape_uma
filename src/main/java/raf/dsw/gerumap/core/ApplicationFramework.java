package raf.dsw.gerumap.core;


import raf.dsw.gerumap.Logger.ConsoleLogger;

import java.io.Console;

public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected MessageGenerator mg;
    protected ErrorLogger el;
    protected  ErrorLogger el1;
    private Serializer serializer;

    public void run() {
        this.gui.start();
    }

    public void initialise(Gui gui,MapRepository mapRepository, MessageGenerator mg, ErrorLogger el, ErrorLogger el1, Serializer serializer) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.mg = mg;
        this.el = el;
        this.el1 = el1;
        this.serializer = serializer;

    }

    private static ApplicationFramework instance = null;

    private ApplicationFramework(){

    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void setGui(Gui gui) {

        this.gui = gui;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public Gui getGui() {
        return gui;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public ErrorLogger getEl() {
        return el;
    }

    public void setEl(ErrorLogger el) {
        this.el = el;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }
}
