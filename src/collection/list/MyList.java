package collection.list;

/**
 * My List
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-29
 * @version 1.0
 */
public interface MyList<E> {

	int size();

	void add(E e);

	void add(int index, E e);

	E get(int index);

	E set(int index, E element);

	E remove(int index);

	int indexOf(E o);
}