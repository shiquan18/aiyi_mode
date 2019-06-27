package zhongqiu.designpattern.behavior.betweenclass;

import java.util.Enumeration;
import java.util.Vector;

//�۲���ģʽ
/*�����֮��Ĺ�ϵ�����漰���̳�
��һ������仯ʱ�����������ö���Ķ��󶼻��յ�֪ͨ���������ű仯������֮����һ��һ�Զ�Ĺ�ϵ��*/
public class ObserverDemo {
	public interface Observer {
		public void update();
	}

	public static class Observer1 implements Observer {

		@Override
		public void update() {
			System.out.println("observer1 has received!");
		}
	}

	public static class Observer2 implements Observer {

		@Override
		public void update() {
			System.out.println("observer2 has received!");
		}
	}

	public interface Subject {

		/* ���ӹ۲��� */
		public void add(Observer observer);

		/* ɾ���۲��� */
		public void del(Observer observer);

		/* ֪ͨ���еĹ۲��� */
		public void notifyObservers();

		/* ����Ĳ��� */
		public void operation();
	}

	public abstract static class AbstractSubject implements Subject {

		private Vector<Observer> vector = new Vector<Observer>();

		@Override
		public void add(Observer observer) {
			vector.add(observer);
		}

		@Override
		public void del(Observer observer) {
			vector.remove(observer);
		}

		@Override
		public void notifyObservers() {
			Enumeration<Observer> enumo = vector.elements();
			while (enumo.hasMoreElements()) {
				enumo.nextElement().update();
			}
		}
	}

	public static class MySubject extends AbstractSubject {

		@Override
		public void operation() {
			System.out.println("update self!");
			notifyObservers();
		}

	}

	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());

		sub.operation();
	}
}
