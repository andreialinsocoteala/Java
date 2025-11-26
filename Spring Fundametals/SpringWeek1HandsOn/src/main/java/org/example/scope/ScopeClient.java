package org.example.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class ScopeClient {

    private final SingletonBean singletonBean;
    private final ObjectFactory<PrototypeBean> prototypeFactory;

    public ScopeClient(SingletonBean singletonBean,
                       ObjectFactory<PrototypeBean> prototypeFactory) {
        this.singletonBean = singletonBean;
        this.prototypeFactory = prototypeFactory;
    }

    public void testScopes() {
        System.out.println("-- Testing Singleton scope --");
        singletonBean.doWork();
        singletonBean.doWork();

        System.out.println("-- Testing Prototype scope --");
        PrototypeBean p1 = prototypeFactory.getObject();
        p1.doWork();
        PrototypeBean p2 = prototypeFactory.getObject();
        p2.doWork();
    }
}
