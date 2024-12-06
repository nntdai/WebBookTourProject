package com.example.WebBookTour.API.Zalopay;
// Java version "1.8.0_201"
import com.example.WebBookTour.dto.DatchotourDto;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair; // https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject; // https://mvnrepository.com/artifact/org.json/json
import com.example.WebBookTour.API.Zalopay.vn.zalopay.crypto.HMACUtil; // tải về ở mục DOWNLOADS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class ZaloPayService {

//    private static final Map<String, String> config = new HashMap<String, String>() {{
//        put("appid", "554");
//        put("key1", "8NdU5pG5R2spGHGhyO99HN1OhD8IQJBn");
//        put("key2", "uUfsWgfLkRLzq6W2uNXTCxrfxs51auny");
//        put("endpoint", "https://sandbox.zalopay.com.vn/v001/tpe/createorder");
//    }};
private static final Map<String, String> config = new HashMap<String, String>() {{
    put("appid", "");
    put("key1", "");
    put("key2", "");
    put("endpoint", "https://sandbox.zalopay.com.vn/v001/tpe/createorder");
}};


    public static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }

    public int checkPaymentStatus(String apptransid) throws Exception {
        // URL của API ZaloPay kiểm tra trạng thái giao dịch
        String checkStatusEndpoint = "https://sandbox.zalopay.com.vn/v001/tpe/getstatusbyapptransid";

        // Tạo chữ ký (MAC) cho yêu cầu kiểm tra trạng thái
        String data = config.get("appid") + "|" + apptransid + "|" + config.get("key1"); // appid|apptransid|key1
        String mac = HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, config.get("key1"), data);

        // Thêm tham số vào URL
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("appid", config.get("appid")));
        params.add(new BasicNameValuePair("apptransid", apptransid));
        params.add(new BasicNameValuePair("mac", mac));

        URIBuilder uri = new URIBuilder(checkStatusEndpoint);
        uri.addParameters(params);

        // Tạo HTTP client và gửi yêu cầu
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet get = new HttpGet(uri.build());
            try (CloseableHttpResponse res = client.execute(get)) {
                // Kiểm tra trạng thái HTTP
                if (res.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                    throw new IOException("Lỗi khi gọi API: " + res.getStatusLine().getStatusCode());
                }

                // Đọc kết quả từ API
                BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
                StringBuilder resultJsonStr = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    resultJsonStr.append(line);
                }

                // Chuyển đổi kết quả sang JSONObject
                JSONObject result = new JSONObject(resultJsonStr.toString());
                System.out.println("Kết quả API trả về: " + result.toString());

                // Kiểm tra và trả về mã returncode
                if (!result.has("returncode")) {
                    throw new Exception("API không trả về trường 'returncode'");
                }

                // Trả về returncode dưới dạng int
                return result.getInt("returncode");
            }
        }
    }

    public JSONObject createOrder(DatchotourDto datTourDto) throws Exception
    {
        Random rand = new Random();
        int random_id = rand.nextInt(1000000);
        final Map<String, Object> embed_data = new HashMap<String, Object>() {{
            put("merchantinfo", "embeddata123");
            put("redirecturl", "http://localhost:8080/success");
        }};


//        final Map<String, Object>[] item = new Map[] {
//                new HashMap<String, Object>() {{
//                    put("item_id", "2523");
//                    put("item_name", "kim nguyen bao");
//                    put("item_price", 9990);
//                    put("item_quantity", 1);
//                }}
//        };
        final Map<String, Object>[] item = new Map[] {
                new HashMap<String, Object>() {{
                    put("itemid", "2523");
                    put("itemname", datTourDto.getSdtKhachHang().getTen());
                    put("itemprice", datTourDto.getTongTien());
                    put("itemquantity", 1);
                }}
        };
        String apptransid = getCurrentTimeString("yyMMdd") + "_" + UUID.randomUUID();
        // Đơn hàng
        Map<String, Object> order = new HashMap<String, Object>() {{
            put("appid", config.get("appid"));
            put("apptransid",apptransid); // mã giao dich có định dạng yyMMdd_xxxx
            put("apptime", System.currentTimeMillis()); // Thời gian hiện tại tính theo milliseconds
            put("appuser", "demo");
            put("amount", 50000);
            put("description", "ZaloPay Integration Demo");
            put("bankcode", ""); // Bank code rỗng
            put("item", new JSONObject(item).toString()); // Danh sách item dưới dạng JSON
            put("embeddata", new JSONObject(embed_data).toString()); // Embed data dưới dạng JSON

        }};

        // Tạo chữ ký (MAC)
        String data = order.get("appid") + "|" + order.get("apptransid") + "|" + order.get("appuser") + "|" + order.get("amount")
                + "|" + order.get("apptime") + "|" + order.get("embeddata") + "|" + order.get("item");
        order.put("mac", HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, config.get("key1"), data));

        // Tạo HTTP client và gửi yêu cầu
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(config.get("endpoint"));

        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, Object> e : order.entrySet()) {
            params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
        }

        // Content-Type: application/x-www-form-urlencoded
        post.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse res = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
        StringBuilder resultJsonStr = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            resultJsonStr.append(line);
        }

        JSONObject result = new JSONObject(resultJsonStr.toString());
        result.put("apptransid", apptransid);
        for (String key : result.keySet()) {
            System.out.format("%s = %s\n", key, result.get(key));
        }
        return result;
    }
}

