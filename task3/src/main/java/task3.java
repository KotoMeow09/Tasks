import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.File;
import java.util.*;

public class task3 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode valuesRoot = mapper.readTree(new File(args[0]));
        Map<Integer, String> valueMap = new HashMap<>();
            for (JsonNode entry : valuesRoot.get("values")) {
                valueMap.put(entry.get("id").asInt(), entry.get("value").asText());}

            JsonNode testsRoot = mapper.readTree(new File(args[1]));
            JsonNode testsArray = testsRoot.get("tests");

            List<JsonNode> l1 = new ArrayList<>();
                if (testsArray.isArray()){
                    testsArray.forEach(l1::add);}

                while (!l1.isEmpty()){
                    JsonNode node = l1.remove(l1.size() - 1);
                if (node.isObject()){
                    ObjectNode obj = (ObjectNode) node;

                if (obj.has("id") && obj.has("value")){
                    Integer id = obj.get("id").asInt();
                    String val = valueMap.get(id);
                    obj.put("value", val);}

                    if (obj.has("values") && obj.get("values").isArray()){
                        obj.get("values").forEach(l1::add);}}

        }DefaultPrettyPrinter pp = new DefaultPrettyPrinter();
            pp.indentObjectsWith(new DefaultIndenter(" ", "\n"));
                pp.indentArraysWith(new DefaultIndenter("", ""));
                    mapper.writer(pp).writeValue(new File(args[2]), testsRoot);
    }
}