package zhongqiu.designpattern.create;

import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

//静态工厂模式

/**
 * 总体来说，工厂模式适合：
 * 凡是出现了大量的产品需要创建，
 * 并且具有共同的接口时，
 * 可以通过工厂方法模式进行创建。
 * <p>
 * 在以上的三种模式中，
 * 第一种如果传入的字符串有误，不能正确创建对象，
 * 第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，
 * 我们会选用第三种——静态工厂方法模式。
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
            ////需要实例化工厂对象,如果传入的字符串有误，不能正确创建对象，
            if ("mail".equals(type)) {
                return new MailSender();
            } else if ("sms".equals(type)) {
                return new SmsSender();
            } else {
                System.out.println("请输入正确的类型!");
                return null;
            }
        }
    }

    public class SendFactory1 {//需要实例化工厂对象

        public Sender produceMail() {
            return new MailSender();
        }

        public Sender produceSms() {
            return new SmsSender();
        }
    }

}

