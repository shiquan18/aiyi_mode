package zhongqiu.designpattern.behavior.betweenclass;

//������ģʽ
/*�ж������ÿ��������ж���һ����������ã������ͻ��γ�һ������
�������������ϴ��ݣ�ֱ��ĳһ����������������
���Ƿ����߲���������������Ǹ�����ᴦ����������ԣ�������ģʽ����ʵ�֣��������ͻ��˵�����£���ϵͳ���ж�̬�ĵ�����
�˴�ǿ��һ����ǣ������ϵ����������һ������������һ��������������һ������
ģʽ����Լ���������Ҫ�����Լ�ȥʵ�֣�ͬʱ����һ��ʱ�̣�����ֻ������һ�����󴫸���һ�����󣬶����������������*/
public class ChainDemo {
	public interface Handler {
		public void operator();
	}

	public static abstract class AbstractHandler {

		private Handler handler;

		public Handler getHandler() {
			return handler;
		}

		public void setHandler(Handler handler) {
			this.handler = handler;
		}

	}

	public static class MyHandler extends AbstractHandler implements Handler {

		private String name;

		public MyHandler(String name) {
			this.name = name;
		}

		@Override
		public void operator() {
			System.out.println(name + "deal!");
			if (getHandler() != null) {
				getHandler().operator();
			}
		}
	}

	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");

		h1.setHandler(h2);
		h2.setHandler(h3);

		h1.operator();
	}
}
