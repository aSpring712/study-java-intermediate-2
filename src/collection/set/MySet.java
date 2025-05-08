package collection.set;

/**
 * My Set
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public interface MySet<E> {
	boolean add(E element);
	boolean remove(E value);
	boolean contains(E value);
}