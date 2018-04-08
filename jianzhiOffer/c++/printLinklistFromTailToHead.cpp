#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
	int val;
	struct ListNode *next;

	ListNode(int x) : 
		val(x), next(NULL) {
	}
};

class List {
private:
	ListNode *head;

public:
	List() {
		head = new ListNode(0);
	}

	void insert(int val) {
		ListNode *node = new ListNode(val);

		node->next = head->next;
		head->next = node;
	}

	vector <int> printLinkFromTailToHead()
	{
		vector <int> vec;
		ListNode* current = head->next;

		while(current != NULL) {
			vec.insert(vec.begin(), current->val);
			current = current->next;
		}

		return vec;
	}
};

int main() {

	List list = List();

	list.insert(12);
	list.insert(43);
	list.insert(61);
	list.insert(9);
	list.insert(35);
	list.insert(72);

	vector <int> vec = list.printLinkFromTailToHead();

	vector <int>::iterator it;
	for(it = vec.begin(); it != vec.end(); it++)
		cout << *it << endl;

	return 0;
}