class Solution {
public:
	void replaceSpace(char *str,int length) {
        // 空格的数目和修改后字符串的长度
        int spaceNum = 0;
        int newLen = 0;
        int oldLen = 0;
        int i = 0;
        
        while(str[i] != '\0')
        {
            oldLen++;
            if(str[i] == ' ')
                spaceNum ++;
            i++;
        }
        
        newLen = oldLen + 2*spaceNum;

        int k = newLen;
        
        for(int j = oldLen; j >= 0; j-- )
        {
            if(str[j] == ' ')
            {
                str[k--] = '0';
                str[k--] = '2';
                str[k--] = '%';
            }
            else
            {
                str[k--] = str[j];
            }
        }
	}
};