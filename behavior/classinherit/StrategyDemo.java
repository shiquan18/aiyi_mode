package zhongqiu.designpattern.behavior.classinherit;

//����ģʽ
/*����ģʽ������һϵ���㷨������ÿ���㷨��װ������ʹ���ǿ����໥�滻�����㷨�ı仯����Ӱ�쵽ʹ���㷨�Ŀͻ���
��Ҫ���һ���ӿڣ�Ϊһϵ��ʵ�����ṩͳһ�ķ��������ʵ����ʵ�ָýӿڣ����һ�������ࣨ���п��ޣ����ڸ����ࣩ���ṩ����������
����ģʽ�ľ���Ȩ���û���ϵͳ�����ṩ��ͬ�㷨��ʵ�֣���������ɾ���㷨���Ը����㷨����װ��
��ˣ�����ģʽ�������㷨����ϵͳ�У��ⲿ�û�ֻ��Ҫ�������ĸ��㷨���ɡ�*/
public class StrategyDemo {
	public interface ICalculator {
		public int calculate(String exp);
	}

	public static abstract class AbstractCalculator {

		public int[] split(String exp, String opt) {
			String array[] = exp.split(opt);
			int arrayInt[] = new int[2];
			arrayInt[0] = Integer.parseInt(array[0]);
			arrayInt[1] = Integer.parseInt(array[1]);
			return arrayInt;
		}
	}

	public static class Plus extends AbstractCalculator implements ICalculator {

		@Override
		public int calculate(String exp) {
			int arrayInt[] = split(exp, "\\+");
			return arrayInt[0] + arrayInt[1];
		}
	}

	public static class Minus extends AbstractCalculator implements ICalculator {

		@Override
		public int calculate(String exp) {
			int arrayInt[] = split(exp, "-");
			return arrayInt[0] - arrayInt[1];
		}

	}

	public static class Multiply extends AbstractCalculator implements ICalculator {

		@Override
		public int calculate(String exp) {
			int arrayInt[] = split(exp, "\\*");
			return arrayInt[0] * arrayInt[1];
		}
	}

	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println(result);
	}
}
