package codeRes.leetCodeProj.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceString {
	
	public static void main(String[] args) throws IOException {
		//���ļ�
//		StringBuffer buffer = new StringBuffer();
//		BufferedReader bf = new BufferedReader(new FileReader("D:\\file.txt"));
//		String s = null;
//		while((s=bf.readLine())!=null) {
//			buffer.append(s.trim()+"\n");
//		}
//		String str = buffer.toString();
//
//		String[][] replaceRegular = {
//				{"<[a-zA-Z]+ column=\"",""},
//				{"\" property=\"","|"},
//				{"\" jdbcType=\"[a-zA-Z]+\" />",""}
//		};
//		for (int i=0;i<replaceRegular.length;i++) {
//			String regu = replaceRegular[i][0];
//			String repChar = replaceRegular[i][1];
//			str = str.replaceAll(regu, repChar);
//		}
//		
//		System.out.println(str.substring(0,str.length()-2));
		
		//���ļ�
		StringBuffer buffer = new StringBuffer();
		BufferedReader bf = new BufferedReader(new FileReader("D:\\file.txt"));
		List<String> lineStr = new ArrayList<String>();
		String s = null;
		while((s=bf.readLine())!=null) {
			lineStr.add(s.trim());
		}
		for (String string : lineStr) {
			System.out.println(ReplaceString.saleChannelFormat(string));
		}
		

		
	}
	
    public static String saleChannelFormat(String saleChannel){
        List<String> result = Arrays.asList(saleChannel.split(","));
        String resString = "";
        boolean otherIsAdd = false;//��ӹ���������ֹ��Ӷ������
        int index = 0;
        Map<String,String> map = new HashMap<String,String>();
        for (String eveStr : result) {
            String nowAdd ="";
            switch (eveStr) {
                case "1"://���й�̨
                    nowAdd="01";//����
                    break;
                case "2"://��������
                    nowAdd="02";//����
                    break;
                case "5"://��ҵ����
                    nowAdd="02";//����
                    break;
                case "7"://�ֻ��ͻ���
                    nowAdd="05";//�ֻ�
                    break;
                default:
                    nowAdd ="06";//����
                    break;
            }
            map.put(nowAdd,nowAdd);
            index++;
        }
	   Collection<String> valueColle =   map.values();
	   List<String> valueList = new ArrayList<String>(valueColle);
	   for (String string : valueList) {
		   resString+=string + ",";
	   }
	   resString = resString.substring(0, resString.length()-1);
        return resString;
    }
    
	
	
}
