package test;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BaiduAPI {
	//设置APPID/AK/SK
	public static final String APP_ID = "10278895";
	public static final String API_KEY = "MehZak5Ru3CueB71BWrPQZkS";
	public static final String SECRET_KEY = "YvrfxVMOuRLWHjBGgaZ768AXyLqldMUU";

	public static void main(String[] args) {
		// 初始化一个AipFace
		AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//		client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//		client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

		// 调用接口
//		String path = "test.jpg";
//		JSONObject res = client.detect(path, new HashMap<String, String>());
//		System.out.println(res.toString(2));

		String imagePath1 = "D:\\webproject\\simpleSSM\\Anna_Kournikova_0002.jpg";
		String imagePath2 = "D:\\webproject\\simpleSSM\\Anna_Kournikova_0004.jpg";
		ArrayList<String> pathArray = new ArrayList<String>();
		pathArray.add(imagePath1);
		pathArray.add(imagePath2);
		JSONObject response = client.match(pathArray, new HashMap<String, String>());
		System.out.println(response.toString());

	}
}
