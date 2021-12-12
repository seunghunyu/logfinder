package ysh.proxy.pureproxy.proxy.code;

public class CacheProxy implements Subject{
    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target){
        this.target = target;
    }
    @Override
    public String operation() {
        return null;
    }
}
