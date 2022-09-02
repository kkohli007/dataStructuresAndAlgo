package src.dataStructures.lists;

public class DoublyLinkedListNode
{
        private String data;

        private DoublyLinkedListNode previous;

        private DoublyLinkedListNode next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public DoublyLinkedListNode getNext() {
            return next;
        }

        public void setNext(DoublyLinkedListNode next) {
            this.next = next;
        }

        public DoublyLinkedListNode getPrevious() {
            return previous;
        }

        public void setPrevious(DoublyLinkedListNode previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", previous=" + (previous!=null?previous.getData():null) +
                    ", next=" + (next!=null?next.getData():null) +
                    '}';
        }
}
