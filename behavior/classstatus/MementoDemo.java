package zhongqiu.designpattern.behavior.classstatus;

//����¼ģʽ
/*Original����ԭʼ�࣬��������Ҫ���������value������һ������¼�࣬��������valueֵ��
Memento���Ǳ���¼�࣬Storage���Ǵ洢����¼���࣬����Memento���ʵ����
�������£��½�ԭʼ��ʱ��value����ʼ��Ϊegg���󾭹��޸ģ���value��ֵ��Ϊniu��������ڶ��н��лָ�״̬������ɹ��ָ��ˡ�
��ʵ�Ҿ������ģʽ�С�����-�ָ���ģʽ������*/
public class MementoDemo {
	public static class Original {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Original(String value) {
			this.value = value;
		}

		public Memento createMemento() {
			return new Memento(value);
		}

		public void restoreMemento(Memento memento) {
			this.value = memento.getValue();
		}
	}

	public static class Memento {  
	      
	    private String value;  
	  
	    public Memento(String value) {  
	        this.value = value;  
	    }  
	  
	    public String getValue() {  
	        return value;  
	    }  
	  
	    public void setValue(String value) {  
	        this.value = value;  
	    }  
	}  

	public static class Storage {

		private Memento memento;

		public Storage(Memento memento) {
			this.memento = memento;
		}

		public Memento getMemento() {
			return memento;
		}

		public void setMemento(Memento memento) {
			this.memento = memento;
		}
	}

	public static void main(String[] args) {

		// ����ԭʼ��
		Original origi = new Original("egg");

		// ��������¼
		Storage storage = new Storage(origi.createMemento());

		// �޸�ԭʼ���״̬
		System.out.println("��ʼ��״̬Ϊ��" + origi.getValue());
		origi.setValue("niu");
		System.out.println("�޸ĺ��״̬Ϊ��" + origi.getValue());

		// �ظ�ԭʼ���״̬
		origi.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" + origi.getValue());
	}
}
