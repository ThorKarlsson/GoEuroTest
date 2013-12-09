import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Toggi
 * Date: 8.12.2013
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class CSVCreator {

    public static void createCSVFileFromLocations(Collection<Location> locations, String query) throws IOException {
        File locationFile = new File(query+".csv");
        if(!locationFile.exists()){
            locationFile.createNewFile();
        }

        FileWriter writer = new FileWriter(locationFile);
        for(Location location : locations){
            writer.write(location.get_type()+",");
            writer.write(location.get_id()+",");
            writer.write(location.getName()+",");
            writer.write(location.getType()+",");
            writer.write(String.valueOf(location.getGeo_position().getLatitude())+",");
            writer.write(String.valueOf(location.getGeo_position().getLongitude())+"\n");
        }

        writer.close();
    }
}
