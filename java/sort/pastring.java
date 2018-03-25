//Longest-Common-Subsequence , LCS

class paString
{
	public String str;

	public paString(String _str)
	{
		str = _str;
	}

	public String revStr()
	{
		String reStr = "";
		int len = str.length();

		for(int i = len-1; i >= 0; i--)
			reStr += str.charAt(i);

		return reStr;
	}

	public int lcsStr(String str1, String str2)
	{
		int lenStr1 = str1.length();
		int lenStr2 = str2.length();
		int lcs = 0;

		if(lenStr1 == 0 && lenStr2 == 0)
			lcs = 0;

		if(lenStr1 > 0 && lenStr2 > 0 && str1.charAt(lenStr1-1) == str2.charAt(lenStr2-1))
			lcs = lcsStr(str1.substring(0, lenStr1-1), str2.substring(0, lenStr2-1)) + 1;

		if(lenStr1 > 0 && lenStr2 > 0 && str1.charAt(lenStr1-1) != str2.charAt(lenStr2-1))
			lcs = Math.max(lcsStr(str1.substring(0, lenStr1-1), str2.substring(0, lenStr2)), lcsStr(str1.substring(0, lenStr1), str2.substring(0, lenStr2-1)));

		return lcs;
	}

	public int deleNum()
	{
		String reStr = revStr();
		int lcs = lcsStr(str, reStr);
		int dele = str.length() - lcs;

		return dele;
	}
}

class paStrApp
{
	public static void main(String [] args)
	{
		paString str = new paString("abcda");

		int num = str.deleNum();

		System.out.println(num);
	}
}