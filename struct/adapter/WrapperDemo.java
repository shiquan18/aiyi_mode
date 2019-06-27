package zhongqiu.designpattern.struct.adapter;

/*�����������ģʽ��
��ϣ����һ������  ת���� ������һ���½ӿڵĶ���ʱ��
���Դ���һ��Wrapper�࣬����ԭ���һ��ʵ������Wrapper��ķ����У�����ʵ���ķ������С�*/
public class WrapperDemo implements Targetable {

	private Source source;

	public WrapperDemo(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

	@Override
	public void method1() {
		source.method1();
	}
}
