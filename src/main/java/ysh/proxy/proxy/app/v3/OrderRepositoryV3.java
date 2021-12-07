package ysh.proxy.proxy.app.v3;

public class OrderRepositoryV3 {
    public void save(String itemId){
        //저장로직
        if(itemId.equals("ex")){
           throw new IllegalStateException("예외발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
