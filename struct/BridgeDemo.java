package zhongqiu.designpattern.struct;

/*�Ž�ģʽ����
������������ʵ�ַֿ���ʹ���ǿ��Ը��Զ����ı仯��
�Žӵ������ǣ�
��������ʵ�ֻ����ʹ�ö��߿��Զ����仯��
�����ǳ��õ�JDBC��DriverManagerһ����JDBC�����������ݿ��ʱ��
�ڸ������ݿ�֮������л�����������Ҫ��̫��Ĵ��룬����˿�����ö���ԭ�����JDBC�ṩͳһ�ӿڣ�
ÿ�����ݿ��ṩ���Ե�ʵ�֣���һ���������ݿ������ĳ������ŽӾ����ˡ�
��������ͨ����Bridge��ĵ��ã�ʵ���˶Խӿ�Sourceable��ʵ����SourceSub1��SourceSub2�ĵ��á�*/
public class BridgeDemo {
	public static void main(String[] args) {

		Bridge bridge = new MyBridge();

		/* ���õ�һ������ */
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();

		/* ���õڶ������� */
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}

	public interface Sourceable {
		public void method();
	}

	public static class SourceSub1 implements Sourceable {

		@Override
		public void method() {
			System.out.println("this is the first sub!");
		}
	}

	public static class SourceSub2 implements Sourceable {

		@Override
		public void method() {
			System.out.println("this is the second sub!");
		}
	}

	public static abstract class Bridge {
		private Sourceable source;

		public void method() {
			source.method();
		}

		public Sourceable getSource() {
			return source;
		}

		public void setSource(Sourceable source) {
			this.source = source;
		}
	}

	public static class MyBridge extends Bridge {
		public void method() {
			getSource().method();
		}
	}
}
