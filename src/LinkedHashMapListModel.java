import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapListModel<K,V> extends AbstractListModel<V> {

    private LinkedHashMap<K, V> delegate = new LinkedHashMap<>();

    public int getSize() {
        return delegate.size();
    }

    public V getElementAt(int index) {
        return (V) delegate.values().toArray()[index];
    }

    public int size() {
        return delegate.size();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public boolean contains(Object elem) {
        return delegate.containsKey(elem);
    }

    public String toString() {
        return delegate.toString();
    }

    public V get(K key) {
        return delegate.get(key);
    }

    public void put(K key, V value) {
        if (delegate.containsKey(key)) {
            int index = new ArrayList(delegate.keySet()).indexOf(key);
            delegate.put(key, value);
            fireContentsChanged(this, index, index);
        } else {
            delegate.put(key, value);
            fireContentsChanged(this, delegate.size() - 1, delegate.size() - 1);
        }
    }

    public void remove(K key) {
        int index = new ArrayList(delegate.keySet()).indexOf(key);
        delegate.remove(key);
        fireIntervalRemoved(this, index, index);
    }

    public Set<K> keySet() {
        return delegate.keySet();
    }

    public Collection<V> values() {
        return delegate.values();
    }
}
