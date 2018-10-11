package WebScanner;

public class Url {
	
	public static String getAbsoluteUrl(String current, String href) {
		if(href.contains(":")) return href;
		if(href.startsWith("/")) return getBaseUrl(current) + href; 
		if(current.endsWith("/")) return current + href;
		return current + "/" + href;
	}
	
	public static String getBaseUrl(String url) {
		if(!url.contains(":")) return null;
		int iniIndex = url.indexOf("://") + 3;
		int endIndex = url.indexOf("/", iniIndex);
		if(endIndex == -1) endIndex = url.length();
		return url.substring(0, endIndex);
	}
	
	public static String getFileName(String url) {
		url = url.replaceAll("[?]", "%");
		
		if(url.endsWith("/"))
			return "index.html";
		
		url = url.substring(url.lastIndexOf('/') + 1);
		if(url.startsWith("%"))
			return "index.html" + url;
				
		return url;
	}
	
	public static String getFolder(String url) {
		String base = getBaseUrl(url);
		int beginIndex = base.length();
		int endIndex = url.lastIndexOf("/");
		
		return url.substring(beginIndex, endIndex);
	}
	
	public static String getExt(String url) {
		String base = getFileName(url);
		
		if(base.contains("%"))
			base = base.substring(0, base.indexOf("%"));
		
		int dotIndex = base.lastIndexOf(".");
		
		return base.substring(dotIndex + 1);
	}
	
}
