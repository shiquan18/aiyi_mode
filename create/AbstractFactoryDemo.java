package zhongqiu.designpattern.create;


import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

//���󹤳�ģʽ

/**
 * ��������ģʽ��һ��������ǣ���Ĵ������������࣬
 * Ҳ����˵�������Ҫ��չ���򣬱���Թ���������޸ģ�
 * ��Υ���˱հ�ԭ��
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }

    public interface Provider {
        public Sender produce();
    }

    public static class SendMailFactory implements Provider {

        @Override
        public Sender produce() {
            return new MailSender();
        }
    }

    public static class SendSmsFactory implements Provider {

        @Override
        public Sender produce() {
            return new SmsSender();
        }
    }
}
