package bfp.stackoverflowclient.common;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseObservable<ListenerType> {
    // thread-safe set of listeners
    private final Set<ListenerType> mListeners = Collections.newSetFromMap(
            new ConcurrentHashMap<ListenerType, Boolean>(1)
    );


    public final void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    public final void unregisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    protected final Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
