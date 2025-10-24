import java.util.Iterator;
void main(){
Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) { // если первый элемент больше
            return -1; // возвращаем -1 для сортировки по убыванию
        }
        if (o1 < o2) { // если первый элемент меньше
            return 1; // возвращаем 1 для сортировки по убыванию
        }
        return 0; // если элементы равны
    }
};

Queue<Integer> pq = new PriorityQueue<>(comparator);
pq.add(4);
pq.add(3);
pq.add(5);
pq.add(9);
pq.offer(1);

Iterator<Integer> iter = pq.iterator();
while (iter.hasNext()) {
        System.out.println(iter.next());
        }
}