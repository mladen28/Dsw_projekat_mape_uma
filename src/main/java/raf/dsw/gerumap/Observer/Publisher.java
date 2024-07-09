package raf.dsw.gerumap.Observer;

public interface Publisher
{
    void addSubscriber(Subscriber sub);
    void removeSubscriber(Subscriber sub);
    void notify(Object notification);
}
