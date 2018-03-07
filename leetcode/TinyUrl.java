public class Codec {
    private Map<String, String> urlToCode = new HashMap<>();
    private Map<String, String> codeToUrl = new HashMap<>();
    private static final int keyLength = 6;
    private static final String BASE_URL = "http://tinyurl.com/";
    private static final String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (!urlToCode.containsKey(longUrl)) {
            char[] chars = new char[keyLength];
            for (int i = 0; i < keyLength; i++) {
                int ran = (int) (Math.random() * charSet.length());
                chars[i] = charSet.charAt(ran);
            }
            
            String key = new String(chars);
            if (!codeToUrl.containsKey(key)) {
                codeToUrl.put(key, longUrl);
                urlToCode.put(longUrl, key);
            }
        } 
        
        return BASE_URL + urlToCode.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return codeToUrl.get(key);   
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
