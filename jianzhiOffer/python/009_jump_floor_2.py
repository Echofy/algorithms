# -*- coding:utf-8 -*-
class JumpFloor2:
    def jumpFloorII(self, number):
        # write code here
        if number == 0:
            return 0
        if number == 1:
            return 1
        
        f_list = [0,1]
        i = 1
        while i < number:
            f_sum = 0    
            for f in f_list:
                f_sum += f
            f_list.append(f_sum+1)
            i += 1
            
        return f_list[number]

def main():
    jf = JumpFloor2()
    result = jf.jumpFloorII(12)
    print result

if __name__ == '__main__':
    main()