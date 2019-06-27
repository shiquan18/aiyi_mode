package zhongqiu.designpattern.struct;

/*���ģʽ��Ϊ�˽��������֮�ҵ�������ϵ�ģ���springһ�������Խ������֮��Ĺ�ϵ���õ������ļ���
�������ģʽ���ǽ����ǵĹ�ϵ����һ��Facade���У�����������֮�����϶ȣ���ģʽ��û���漰���ӿ�

�������û��Computer�࣬��ô��CPU��Memory��Disk����֮�佫���໥����ʵ����������ϵ��
������������ص��������޸�һ���࣬���ܻ������������޸ģ��ⲻ��������Ҫ�����ģ�
����Computer�࣬����֮��Ĺ�ϵ��������Computer������������˽�������ã��⣬�������ģʽ��*/
public class FacadeDemo {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}

	public static class CPU {

		public void startup() {
			System.out.println("cpu startup!");
		}

		public void shutdown() {
			System.out.println("cpu shutdown!");
		}
	}

	public static class Memory {

		public void startup() {
			System.out.println("memory startup!");
		}

		public void shutdown() {
			System.out.println("memory shutdown!");
		}
	}

	public static class Disk {

		public void startup() {
			System.out.println("disk startup!");
		}

		public void shutdown() {
			System.out.println("disk shutdown!");
		}
	}

	public static class Computer {
		private CPU cpu;
		private Memory memory;
		private Disk disk;

		public Computer() {
			cpu = new CPU();
			memory = new Memory();
			disk = new Disk();
		}

		public void startup() {
			System.out.println("start the computer!");
			cpu.startup();
			memory.startup();
			disk.startup();
			System.out.println("start computer finished!");
		}

		public void shutdown() {
			System.out.println("begin to close the computer!");
			cpu.shutdown();
			memory.shutdown();
			disk.shutdown();
			System.out.println("computer closed!");
		}
	}
}
