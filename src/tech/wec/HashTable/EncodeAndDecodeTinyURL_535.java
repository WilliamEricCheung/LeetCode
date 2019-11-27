package tech.wec.HashTable;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL_535 {
    public class Codec {

        Map<Integer, String> map = new HashMap<>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(longUrl.hashCode(), longUrl);
            return "http://pornhub.com/"+longUrl.hashCode();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://pornhub.com/", "")));
        }
    }
}
