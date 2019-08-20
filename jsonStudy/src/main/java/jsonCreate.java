import org.json.JSONObject;

public class jsonCreate {

    public String createJsonString(String key, Object value){
        String jsonString = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,value);
        jsonString = jsonObject.toString();

        return jsonString;
    }
}
