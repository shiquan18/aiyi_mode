package zhongqiu.designpattern.behavior.betweenclass;

//����ģʽ
/*�˴�����ò��ģ����һ��������Ĺ��̣��о��ǲ��Ǻ�ˬ��
��ʵJDK�и�����Ҳ������Щ�����Ķ�������һЩ���ģʽ���ټ�һЩ�Ż��ŵ�һ��ģ�
ֻҪ���ǰ���Щ����ѧ���ˣ����պ��ˣ�����Ҳ����д���Լ��ļ����࣬������ܣ�*/
public class IteratorDemo {
	public interface Collection {

		public Iterator iterator();

		/* ȡ�ü���Ԫ�� */
		public Object get(int i);

		/* ȡ�ü��ϴ�С */
		public int size();
	}

	public interface Iterator {
		// ǰ��
		public Object previous();

		// ����
		public Object next();

		public boolean hasNext();

		// ȡ�õ�һ��Ԫ��
		public Object first();
	}

	public static class MyCollection implements Collection {

		public String string[] = { "A", "B", "C", "D", "E" };

		@Override
		public Iterator iterator() {
			return new MyIterator(this);
		}

		@Override
		public Object get(int i) {
			return string[i];
		}

		@Override
		public int size() {
			return string.length;
		}
	}

	public static class MyIterator implements Iterator {

		private Collection collection;
		private int pos = -1;

		public MyIterator(Collection collection) {
			this.collection = collection;
		}

		@Override
		public Object previous() {
			if (pos > 0) {
				pos--;
			}
			return collection.get(pos);
		}

		@Override
		public Object next() {
			if (pos < collection.size() - 1) {
				pos++;
			}
			return collection.get(pos);
		}

		@Override
		public boolean hasNext() {
			if (pos < collection.size() - 1) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object first() {
			pos = 0;
			return collection.get(pos);
		}

	}

	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator it = collection.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
