package jp;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GlobalIPGetter {
	
	public static final String LISTEN_URL = "http://checkip.dyndns.com/";

	/**
	 * http://checkip.dyndns.com/のサイトからIPを取り出す
	 * @param line
	 * @return
	 */
	public static String parseURL(String line) {
		String res = "";
		
		String[] lines = line.split("Current IP Address: ");
		if(lines.length == 1) {
			res = "parse failed";
		}else {
			res = lines[1].split("</body>")[0];
		}
		
		return res;
	}
	
	/**
	 * globalIPの取得
	 * @return
	 */
	public static String getGlobalIP() {
		InputStreamReader in = null;
		BufferedReader br = null;
		
		String res = "";
		try {
			URL url = new URL(LISTEN_URL);
			in = new InputStreamReader(url.openStream());
			br = new BufferedReader(in);
			
			res = parseURL(br.readLine());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = "malformed address.";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = "connection error";
		}finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return res;
	}
	
	public static void main(String[] args){
		String msg = "";
		String port = "";
		
		try {
			FileReader fr = new FileReader(new File("config.conf"));
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while((line = br.readLine()) != null) {
				
				line = line.replaceAll(" ","").replaceAll("　","");
				System.out.println(line);
				String[] lines = line.trim().split("=");
				if("port".equals(lines[0])) {
					port = lines[1];
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "configファイルが存在しません";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "configファイルの読み込みに失敗しました";
		}
		
		String ip = getGlobalIP();
		
		if(ip.split("\\.").length != 4)
			msg = "IPの取得に失敗しました";
		else {
			if(!port.isEmpty()) ip += ":" + port;
			StringSelection ss = new StringSelection(ip);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
			msg = "クリップボードにコピーしました";
		}
		
		System.out.println(ip);
		
		DialogGenerator.generateMessageDialog(350,80,15,ip,msg);
		Toolkit.getDefaultToolkit().beep();
	}
}