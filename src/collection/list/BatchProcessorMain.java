package collection.list;

/**
 * Batch Processor Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-29
 * @version 1.0
 */
public class BatchProcessorMain {

	public static void main(String[] args) {
//		MyArrayList<Integer> list = new MyArrayList<>();
		MyLinkedList<Integer> list = new MyLinkedList<>();

		BatchProcessor processor = new BatchProcessor(list);
		processor.logic(50_000);
	}
}