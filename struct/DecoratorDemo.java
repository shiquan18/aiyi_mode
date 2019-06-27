package zhongqiu.designpattern.struct;

/*װ����ģʽ��Ӧ�ó�����
1����Ҫ��չһ����Ĺ��ܡ�
2����̬��Ϊһ���������ӹ��ܣ����һ��ܶ�̬���������̳в���������һ�㣬�̳еĹ����Ǿ�̬�ģ����ܶ�̬��ɾ����
ȱ�㣺�����������ƵĶ��󣬲����Ŵ�*/
//װ�ζ���  ����  ��װ�ζ����ʵ��
public class DecoratorDemo {
    public interface Sourceable {
        public void method();
    }

    public static class Source implements Sourceable {//��װ�ζ���

        @Override
        public void method() {
            System.out.println("the original method!");
        }
    }

    public static class Decorator implements Sourceable {//װ�ζ���

        private Sourceable source;

        public Decorator(Sourceable source) {
            super();
            this.source = source;
        }

        @Override
        public void method() {
            System.out.println("before decorator!");
            source.method();
            System.out.println("after decorator!");
        }
    }

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
