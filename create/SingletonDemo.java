package zhongqiu.designpattern.create;

//�������ģʽ
public class SingletonDemo {

    /* ˽�й��췽������ֹ��ʵ���� */
    private SingletonDemo() {
    }

    /*
     * ��Javaָ���д�������͸�ֵ�����Ƿֿ����еģ�Ҳ����˵instance = new Singleton();
     * ����Ƿ�����ִ�еġ�����JVM������֤�������������Ⱥ�˳��Ҳ����˵�п���JVM��Ϊ�µ�Singletonʵ������ռ䣬
     * Ȼ��ֱ�Ӹ�ֵ��instance��Ա��Ȼ����ȥ��ʼ�����Singletonʵ����
     */
    /*
     * ����ģʽʹ���ڲ�����ά��������ʵ�֣�JVM�ڲ��Ļ����ܹ���֤��һ���౻���ص�ʱ�������ļ��ع������̻߳���ġ�
     * ���������ǵ�һ�ε���getInstance��ʱ��JVM�ܹ������Ǳ�֤instanceֻ������һ�Σ�
     * ���һᱣ֤�Ѹ�ֵ��instance���ڴ��ʼ����ϣ��������ǾͲ��õ�����������⡣
     * ͬʱ�÷���Ҳֻ���ڵ�һ�ε��õ�ʱ��ʹ�û�����ƣ������ͽ���˵���������
     */
    /* �˴�ʹ��һ���ڲ�����ά������ */
    private static class SingletonFactory {
        private static SingletonDemo instance = new SingletonDemo();
    }

    /* ��ȡʵ�� */
    public static SingletonDemo getInstance() {
        return SingletonFactory.instance;
    }

    /* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */
    public Object readResolve() {
        return getInstance();
    }

    /*** * * * * * * * * * * * * * * *����ʽ * * * * * * * * * * *
     */
    public static class Singleton {
        private Singleton() {
        }
    }

    public static Singleton instanceS;

    public static Singleton getInstances() {
        if (instanceS == null) {
            synchronized (instanceS) {
                if (instanceS == null) {
                    instanceS = new Singleton();
                }
            }
        }
        return instanceS;
    }
}
