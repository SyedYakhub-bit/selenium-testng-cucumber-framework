package Framework.Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataReader {

	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(System.getProperty("user.dir") + filePath), new TypeReference<>() {
		});
	}
}
