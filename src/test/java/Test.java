import com.raj.shashi.dao.RedisDaoImpl;
import com.raj.shashi.service.RedisService;
import com.raj.shashi.serviceImpl.RedisServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {

    RedisService redisService;

    public Test(){
        this.redisService  = new RedisServiceImpl(new RedisDaoImpl());
    }

    public void update(){

        this.redisService.update("threadSafeKey");
    }

    public void post(){
        this.redisService.create("threadSafeKey", "1");
    }

    public void get(){
        System.out.println(this.redisService.get("threadSafeKey"));
    }


    public static void main(String [] args){

        int n=100;

        Test ob = new Test();
        ob.post();
        ob.get();

        List<Thread> threadList = new ArrayList<>();
        for(int i=0;i<n;i++){

            threadList.add(new Thread(()->{
                ob.update();
            }));
        }

        threadList.forEach(thread->{
            thread.start();
        });

        threadList.forEach(thread -> {
            try{
                thread.join();
            }
            catch(InterruptedException e){

            }
        });

        ob.get();
    }
}
