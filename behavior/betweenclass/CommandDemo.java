package zhongqiu.designpattern.behavior.betweenclass;

//����ģʽ
/*˾��Ա������ʿ��ȥ�ɼ����飬����������ĽǶ������ǣ�˾��Ա�������ǣ����������������ݣ�������ʿ�������ʿ��ȥִ�С�
������̺��ڣ������໥����κ�һ��������ȥ���������ˣ�ֻ��Ҫ�����Լ����¶����У�˾��ԱҪ���ǽ��������ȥ��ע����ʿ������ôʵ�ֵ�
Invoker�ǵ����ߣ�˾��Ա����Receiver�Ǳ������ߣ�ʿ������MyCommand�����ʵ����Command�ӿڣ����н��ն���
����ܹ���⣬����ģʽ��Ŀ�ľ��Ǵﵽ����ķ����ߺ�ִ����֮����
ʵ�������ִ�зֿ�����ϤStruts��ͬѧӦ��֪����Struts��ʵ����һ�ֽ�����ͳ��ַ���ļ��������б�Ȼ�漰����ģʽ��˼�룡*/
public class CommandDemo {
	public interface Command {
		public void exe();
	}

	public static class MyCommand implements Command {

		private Receiver receiver;

		public MyCommand(Receiver receiver) {
			this.receiver = receiver;
		}

		@Override
		public void exe() {
			receiver.action();
		}
	}

	public static class Receiver {
		public void action() {
			System.out.println("command received!");
		}
	}

	public static class Invoker {

		private Command command;

		public Invoker(Command command) {
			this.command = command;
		}

		public void action() {
			command.exe();
		}
	}

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
