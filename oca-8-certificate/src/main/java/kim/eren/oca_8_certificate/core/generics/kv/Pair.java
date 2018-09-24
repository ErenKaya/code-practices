package kim.eren.oca_8_certificate.core.generics.kv;

public interface Pair<K, V> {

	public void setKey(K k);

	public K getKey();

	public void setValue(V v);

	public V getValue();

}
