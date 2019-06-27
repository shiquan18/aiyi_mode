package zhongqiu.designpattern.create;

import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

//��̬����ģʽ

/**
 * ������˵������ģʽ�ʺϣ�
 * ���ǳ����˴����Ĳ�Ʒ��Ҫ������
 * ���Ҿ��й�ͬ�Ľӿ�ʱ��
 * ����ͨ����������ģʽ���д�����
 * <p>
 * �����ϵ�����ģʽ�У�
 * ��һ�����������ַ������󣬲�����ȷ��������
 * ����������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£�
 * ���ǻ�ѡ�õ����֡�����̬��������ģʽ��
 */
public class StaticFactoryDemo {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = StaticFactoryDemo.produceMail();
        sender.Send();
    }

    public class SendFactory {

        public Sender produce(String type) {
            ////��Ҫʵ������������,���������ַ������󣬲�����ȷ��������
            if ("mail".equals(type)) {
                return new MailSender();
            } else if ("sms".equals(type)) {
                return new SmsSender();
            } else {
                System.out.println("��������ȷ������!");
                return null;
            }
        }
    }

    public class SendFactory1 {//��Ҫʵ������������

        public Sender produceMail() {
            return new MailSender();
        }

        public Sender produceSms() {
            return new SmsSender();
        }
    }

}

