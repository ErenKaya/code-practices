package kim.eren.code_practices.tpoint.iteratordp;

public class NameRepository implements Container {

	public String names[] = { "Eren", "Ahmet", "Sezgin", "Mücahit", "Rüştü", "Hasan" };

	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		int index;

		public boolean hasNext() {
			if (index < names.length) {
				return true;
			}
			return false;
		}

		public Object next() {
			if (hasNext()) {
				return names[index++];
			}
			return null;
		}

	}

}
