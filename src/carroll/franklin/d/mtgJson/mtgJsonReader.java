package carroll.franklin.d.mtgJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Class reads in JSON files representing the MTG Gatherer database.
 *
 * Created by Franklin Carroll on 12/2/2014.
 */
public class mtgJsonReader {
    private static final JSONParser PARSER = new JSONParser();

    public static JSONObject read(String filename) {
        StringBuilder data = new StringBuilder();
        File file = new File(filename);
        JSONObject jsonObject = new JSONObject();

        try(Scanner in = new Scanner(file)) {

            while(in.hasNext()) {
                data.append(in.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            jsonObject = (JSONObject)PARSER.parse(data.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static void main(String args[]) {
        String filename = "c:" + File.separator + "AllSets.json";

        JSONObject object = mtgJsonReader.read(filename);

        JSONObject alpha = (JSONObject)object.get("LEA");

        JSONArray cards = (JSONArray)alpha.get("cards");

        List<JSONObject> cds = null;

        try {
            cds = (List<JSONObject>) PARSER.parse(cards.toString());

            for(JSONObject obj : cds) {
                System.out.println(obj.get("name"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}

