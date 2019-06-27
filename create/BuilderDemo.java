package zhongqiu.designpattern.create;

import zhongqiu.designpattern.create.util.MailSender;
import zhongqiu.designpattern.create.util.Sender;
import zhongqiu.designpattern.create.util.SmsSender;

import java.util.ArrayList;
import java.util.List;

//������ģʽ
/*������ģʽ����ǰ����󹤳�ģʽ������Test��������õ���
������ģʽ���ܶ๦�ܼ��ɵ�һ������������Դ�����Ƚϸ��ӵĶ�����
�����빤��ģʽ��������ǣ�����ģʽ��ע���Ǵ���������Ʒ����������ģʽ���ע�������϶��󣬶�����֡�
��ˣ���ѡ�񹤳�ģʽ���ǽ�����ģʽ����ʵ�����������*/
public class BuilderDemo {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public void sender() {
        for (Sender sender : list) {
            sender.Send();
        }
    }

    public static void main(String[] args) {
        BuilderDemo builder = new BuilderDemo();
        builder.produceMailSender(10);
        System.out.println(builder.list.size());
        builder.sender();
    }
}
