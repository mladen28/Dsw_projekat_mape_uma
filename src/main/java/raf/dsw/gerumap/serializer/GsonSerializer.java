package raf.dsw.gerumap.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import raf.dsw.gerumap.core.Serializer;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddLinkCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddTermCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.DeleteCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.MoveCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.*;

import java.io.*;

public class GsonSerializer implements Serializer {


    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            System.out.println("jasamjasam");
            RuntimeTypeAdapterFactory<MapNode> shapeAdapterFactory = RuntimeTypeAdapterFactory.of(MapNode.class, "type");

            shapeAdapterFactory.registerSubtype(Project.class);
            shapeAdapterFactory.registerSubtype(MindMap.class);
            shapeAdapterFactory.registerSubtype(Element.class);

            Gson gson = new GsonBuilder().registerTypeAdapterFactory(shapeAdapterFactory).create();

            return gson.fromJson(fileReader, new TypeToken<Project>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFileName())) {
            System.out.println("CCCCCCCCCCC");
            Gson gson = new Gson();
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
