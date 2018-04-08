class Fibonacci:
    def Fibonacci(self, n):
        # write code here
        
        if n == 0:
            return 0
        if n == 1:
            return 1
        
        f0 = 0
        f1 = 1
        i = 1
        while i < n:
            f2 = f0 + f1
            f0 = f1
            f1 = f2
            i += 1
            
        return f2

def main():
    f = Fibonacci()
    result = f.Fibonacci(9)
    print result

if __name__ == '__main__':
    main()