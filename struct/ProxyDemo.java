package zhongqiu.designpattern.struct;

/*����ģʽ��Ӧ�ó�����
������еķ�����ʹ�õ�ʱ����Ҫ��ԭ�еķ������иĽ�����ʱ�����ְ취��
1���޸�ԭ�еķ�������Ӧ������Υ���ˡ�����չ���ţ����޸Ĺرա���ԭ��
2�����ǲ���һ�����������ԭ�еķ������ҶԲ����Ľ�����п��ơ����ַ������Ǵ���ģʽ��
ʹ�ô���ģʽ�����Խ����ܻ��ֵĸ��������������ں���ά����*/

/**
 * �ڴ������д������������ʵ��
 * ��װ�����ģʽ��ʵ������
 * ����װ�����л���б�װ�����ʵ��  ���Ǳ�װ���಻����װ�����д���
 */
public class ProxyDemo {
	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}

	public interface Sourceable {
		public void method();
	}

	public static class Source implements Sourceable {

		@Override
		public void method() {
			System.out.println("the original method!");
		}
	}

	public static class Proxy implements Sourceable {

		private Source source;

		public Proxy() {
			super();
			this.source = new Source();
		}

		@Override
		public void method() {
			before();
			source.method();
			atfer();
		}

		private void atfer() {
			System.out.println("after proxy!");
		}

		private void before() {
			System.out.println("before proxy!");
		}
	}
}
