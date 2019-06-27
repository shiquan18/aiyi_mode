package zhongqiu.designpattern.behavior.classstatus;

//״̬ģʽ
/*����˼����ǣ��������״̬�ı�ʱ��ͬʱ�ı�����Ϊ
����������ԣ�״̬ģʽ���ճ��������õ�ͦ��ģ�
����������վ��ʱ��������ʱϣ�����ݶ����ĳһ���ԣ��������ǵ�һЩ���ܣ�����˵�򵥵�Ȩ�޿��Ƶȡ�*/
public class StateDemo {
	public static class State {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void method1() {
			System.out.println("execute the first opt!");
		}

		public void method2() {
			System.out.println("execute the second opt!");
		}
	}

	/**
	 * ״̬ģʽ���л���
	 */
	public static class Context {

		private State state;

		public Context(State state) {
			this.state = state;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public void method() {
			if (state.getValue().equals("state1")) {
				state.method1();
			} else if (state.getValue().equals("state2")) {
				state.method2();
			}
		}
	}

	public static void main(String[] args) {

		State state = new State();
		Context context = new Context(state);

		// ���õ�һ��״̬
		state.setValue("state1");
		context.method();

		// ���õڶ���״̬
		state.setValue("state2");
		context.method();
	}
}
