package util;
/** 
* @author : yao
* @date ����ʱ�䣺2017��7��11�� ����4:35:12 
* @version 1.0 
* �ļ����� �ࣺ��ȡ����������µ��ϴ����ļ���
*/
public class FileUtil {
	public static String getFileName(String header) {
		/**
		 * String[] tempArr1 =
		 * header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1���������������������
		 * �������google������£�
		 * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * �������google������£�tempArr2={filename,"snmp4j--api.zip"}
		 * IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// ��ȡ�ļ��������ݸ����������д��
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}
}

