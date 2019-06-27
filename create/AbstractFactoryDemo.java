package zhongqiu.designpattern.create;


import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

//抽象工厂模式

/**
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，
 * 也就是说，如果想要拓展程序，必须对工厂类进行修改，
 * 这违背了闭包原则
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
