# coding:utf-8

class Min_Rotate:

    """ 二分法  """
    def minNumberInRotateArray(self, rotateArray):
        if not rotateArray:
            return 0
            
        left = 0
        right = len(rotateArray)-1
        while left != right-1:            
            mid = (left + right)/2
            if rotateArray[mid] > rotateArray[right]:
                left = mid
            elif rotateArray[mid] < rotateArray[right]:
                right = mid
                
        return rotateArray[right]

    ''' 顺序 '''
    def minNumberInRotateArray2(self, rotateArray):
        pre = -7e20
        for num in rotateArray:
            if num < pre :
                return num
            pre = num
             
        if len(rotateArray) == 0:
            return 0

        return rotateArray[0]
    
    """ 顺序查找 """
    def minNumberInRotateArray3(self, rotateArray):
        if not rotateArray:
            return 0
        
        for i in range(len(rotateArray)):
            if rotateArray[i+1] < rotateArray[i]:
                return rotateArray[i+1]


def main():
    mr = Min_Rotate()
    result = mr.minNumberInRotateArray3([3,4,5,1,2])
    print result


if __name__ == '__main__':
    main()