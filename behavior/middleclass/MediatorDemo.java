package zhongqiu.designpattern.behavior.middleclass;

//�н���ģʽ
/*ֻ����ĺ�Mediator��Ĺ�ϵ����������֮��Ĺ�ϵ�����Ƚ���Mediator���У����е���spring���������á�
User��ͳһ�ӿڣ�User1��User2�ֱ��ǲ�ͬ�Ķ��󣬶���֮���й���������������н���ģʽ������Ҫ�����໥�������ã��������ߵ���϶Ⱥܸߣ�
Ϊ�˽��������Mediator�࣬�ṩͳһ�ӿڣ�MyMediatorΪ��ʵ���࣬�������User1��User2��ʵ����
����ʵ�ֶ�User1��User2�Ŀ��ơ�����User1��User2���������໥������
����ֻ��Ҫ���ֺú�Mediator֮��Ĺ�ϵ���У�ʣ�µ�ȫ��MyMediator����ά����*/
public class MediatorDemo {
	public interface Mediator {
		public void createMediator();

		public void workAll();
	}

	public static class MyMediator implements Mediator {

		private User user1;
		private User user2;

		public User getUser1() {
			return user1;
		}

		public User getUser2() {
			return user2;
		}

		@Override
		public void createMediator() {
			user1 = new User1(this);
			user2 = new User2(this);
		}

		@Override
		public void workAll() {
			user1.work();
			user2.work();
		}
	}

	public static abstract class User {

		private Mediator mediator;

		public Mediator getMediator() {
			return mediator;
		}

		public User(Mediator mediator) {
			this.mediator = mediator;
		}

		public abstract void work();
	}

	public static class User1 extends User {

		public User1(Mediator mediator) {
			super(mediator);
		}

		@Override
		public void work() {
			System.out.println("user1 exe!");
		}
	}

	public static class User2 extends User {

		public User2(Mediator mediator) {
			super(mediator);
		}

		@Override
		public void work() {
			System.out.println("user2 exe!");
		}
	}

	public static void main(String[] args) {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
