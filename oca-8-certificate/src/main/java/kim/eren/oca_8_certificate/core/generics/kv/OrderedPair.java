package kim.eren.oca_8_certificate.core.generics.kv;

public class OrderedPair<K, V> implements Pair<K, V> {
	private K key;
	private V value;

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public void setValue(V value) {
		this.value = value;
	}
}
