package linkedList;

public class Node {
	
	int _id;
	Node next = null;
	
	public Node(int id) {
		_id = id;
	}

	public Node getNext() {
		return next;
	}

	public int getId() {
		return _id;
	}
	
	public String printListFromThisNode(){
		Node aux = this;
		/*while(aux != null){
			System.out.print(aux.getId() + " ");
			aux = aux.getNext();
		}
		System.out.println("");*/
		String list = "";
		while(aux != null){
			list = list + " " + aux.getId();
			aux = aux.getNext();
		}
		//System.out.println("");
		return list;
	}

}
