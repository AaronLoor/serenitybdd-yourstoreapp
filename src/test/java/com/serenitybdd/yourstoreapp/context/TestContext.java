package com.serenitybdd.yourstoreapp.context;

import net.serenitybdd.screenplay.Actor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Context Manager para mantener estado entre steps
 * Patrón: Context Object + Singleton (Thread-Safe)
 */
public class TestContext {

    private static final ThreadLocal<TestContext> instance = new ThreadLocal<>();
    private final Map<String, Object> context = new ConcurrentHashMap<>();
    private Actor currentActor;

    private TestContext() {}

    public static TestContext getInstance() {
        if (instance.get() == null) {
            instance.set(new TestContext());
        }
        return instance.get();
    }

    public static void reset() {
        instance.remove();
    }

    public void setCurrentActor(Actor actor) {
        this.currentActor = actor;
        put("current_actor", actor);
    }

    public Actor getCurrentActor() {
        if (currentActor == null) {
            throw new IllegalStateException("No hay actor configurado en el contexto actual");
        }
        return currentActor;
    }

    public boolean hasActor() {
        return currentActor != null;
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        Object value = context.get(key);
        if (value == null) {
            return null;
        }
        if (type.isInstance(value)) {
            return (T) value;
        }
        throw new ClassCastException("Value for key '" + key + "' is not of type " + type.getSimpleName());
    }

    public Integer getInteger(String key) {
        return get(key, Integer.class);
    }

    public Boolean getBoolean(String key) {
        return get(key, Boolean.class);
    }

    public void remove(String key) {
        context.remove(key);
    }

    public void clear() {
        context.clear();
        currentActor = null;
    }
}