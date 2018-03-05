package basic;
import java.io.*;
import java.util.*;

public class TwinStrings {

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
	static String[] twins(String[] a, String[] b) 
    {
		String[] result = new String[a.length];
		
		for(int si = 0; si<a.length; si++) {
			String str = a[si];
			
			StringBuilder evenStr = new StringBuilder("");
			StringBuilder oddStr = new StringBuilder("");
			for(int i=0; i<str.length(); i++) {
				if(i%2 != 0) {
					evenStr.append(str.charAt(i));
				} else {
					oddStr.append(str.charAt(i));
				}
			}
			
			StringBuilder tempStr = new StringBuilder("");
			int ei = evenStr.length() - 1; 
			int oi = oddStr.length() - 1;
			for(int i=0; i<str.length(); i++) {
				if(i%2 != 0) {
					// SwapEven
					tempStr.append(evenStr.charAt(ei));
					ei--;
				} else {
					// SwapOdd
					tempStr.append(oddStr.charAt(oi));
					oi--;
				}
			}
			a[si] = tempStr.toString();
			result[si] = a[si].equals(b[si]) ? "Yes" : "No";
		}
		
		return result;
    }
	
	/**
     * DO NOT MODIFY THIS METHOD!
     */
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _a_size = 0;
        System.out.print("1st List Size: ");
        _a_size = Integer.parseInt(in.nextLine().trim());
        String[] _a = new String[_a_size];
        String _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            try {
            	System.out.print("Value " + (_a_i + 1) + ": ");
                _a_item = in.nextLine();
            } catch (Exception e) {
                _a_item = null;
            }
            _a[_a_i] = _a_item;
        }
        
        
        int _b_size = 0;
        System.out.print("2nd List Size: ");
        _b_size = Integer.parseInt(in.nextLine().trim());
        String[] _b = new String[_b_size];
        String _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            try {
            	System.out.print("Value " + (_b_i + 1) + ": ");
                _b_item = in.nextLine();
            } catch (Exception e) {
                _b_item = null;
            }
            _b[_b_i] = _b_item;
        }
        
        res = twins(_a, _b);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println("Twin Item " + (res_i +1) + ": " + String.valueOf(res[res_i]));
        }
        
        in.close();
	}

}