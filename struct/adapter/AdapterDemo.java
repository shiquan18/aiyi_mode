package zhongqiu.designpattern.struct.adapter;

/*���������ģʽ��
��ϣ����һ����ת����������һ���½ӿڵ���ʱ��
����ʹ�����������ģʽ������һ�����࣬�̳�ԭ�е��࣬ʵ���µĽӿڼ��ɡ�*/
public class AdapterDemo extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}
}
