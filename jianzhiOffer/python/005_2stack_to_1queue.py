# coding:utf-8

class Stack2_to_Queue:
    def __init__(self):
        self.stack_1 = []
        self.stack_2 = []

    def push(self, node):
        self.stack_1.append(node)

        
    def pop(self):

        if not self.stack_2:
            while(self.stack_1):
                a = self.stack_1.pop()
                self.stack_2.append(a)
            return self.stack_2.pop()

        return self.stack_2.pop()

def main():
    s = Stack2_to_Queue()
    s.push(2)
    s.push(3)
    print(s.stack_1)

    s.pop()

if __name__ == '__main__':
    main()


