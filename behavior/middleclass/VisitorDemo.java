package zhongqiu.designpattern.behavior.middleclass;

//������ģʽ
/*������ģʽ�Ƕ������Ϊģʽ��������ģʽ��Ŀ���Ƿ�װһЩʩ����ĳ�����ݽṹԪ��֮�ϵĲ�����
һ����Щ������Ҫ�޸ĵĻ�������������������ݽṹ����Ա��ֲ��䡣
��ģʽ���ó��������������Ϊһ�����е��������¹��ܣ����ò����Ǽ������飺
1���¹��ܻ᲻�������й��ܳ��ּ��������⣿2���Ժ�᲻������Ҫ��ӣ�3������಻�����޸Ĵ�����ô�죿
�����Щ���⣬��õĽ����������ʹ�÷�����ģʽ��������ģʽ���������ݽṹ����ȶ���ϵͳ�������ݽṹ���㷨����*/
public class VisitorDemo {
	// ���й�̨�����Ժ�����Ҫ����ҵ��ֻ��Ҫ����һ����ʵ������ӿھͿ����ˡ�
	interface Service {

		public void accept(Visitor visitor);
	}

	// ����ҵ����ˣ�������Լ���Ȩ�޿��Ƶȵ�
	static class Visitor {

		public void process(Service service) {
			// ����ҵ��
			System.out.println("����ҵ��");
		}

		public void process(Saving service) {
			// ���
			System.out.println("���");
		}

		public void process(Draw service) {
			// ���
			System.out.println("���");
		}

		public void process(Fund service) {
			System.out.println("����");
			// ����
		}

	}

	static class Saving implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	static class Draw implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	static class Fund implements Service {

		public void accept(Visitor visitor) {
			visitor.process(this);

		}
	}

	public static void main(String[] args) {
		Service saving = new Saving();
		Service fund = new Fund();
		Service draw = new Draw();
		Visitor visitor = new Visitor();
		Visitor guweiwei = new Visitor();
		fund.accept(guweiwei);
		saving.accept(visitor);
		fund.accept(visitor);
		draw.accept(visitor);
	}
}
