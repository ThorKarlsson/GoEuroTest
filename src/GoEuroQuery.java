import java.io.IOException;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Toggi
 * Date: 6.12.2013
 * Time: 20:03
 * To change this template use File | Settings | File Templates.
 */
public class GoEuroQuery {

    public static void main(String args[]) {
        try {
            if (args.length < 1) {
                outputHelpAndExit();
            }
            executeQuery(args[0]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeQuery(String location) throws IOException {
        Collection<Location> locationList = GoEuroLocationGateway.queryLocation(location);
        CSVCreator.createCSVFileFromLocations(locationList, location);
    }

    private static void outputHelpAndExit() {
        System.out.println("USAGE: GoEuroTest <STRING>");
        System.exit(1);
    }
}
