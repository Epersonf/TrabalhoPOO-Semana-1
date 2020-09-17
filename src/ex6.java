public class ex6 {
	
	private static int maximum = 500;
	public static int[] createVector(int n) {
		int[] vector = new int[n];
		
		for (int i = 0; i < n; i++)
			vector[i] = (int) Math.floor(Math.random() * maximum);
		
		return vector;
	}
	
	@FunctionalInterface
	public interface SortMode {
		int evaluate(int a, int b);
	}
	
	public static int clamp(int v, int min, int max) {
		if (v >= max) return max;
		if (v <= min) return min;
		return v;		
	}
	
	public static void sort(int[] vec, SortMode sortMode) {
		for (int i = 1; i < vec.length; i++) {
			if (sortMode.evaluate(vec[i - 1], vec[i]) >= 0) continue;
			
			//swap
			int temp = vec[i - 1];
			vec[i - 1] = vec[i];
			vec[i] = temp;
			
			i = clamp(i - 2, 0, vec.length);
		}
	}
	
	public static class Queue {
		int index;
		int[] vector;
		boolean reachedEnd = false;
		
		Queue(int[] vector) {
			index = 0;
			this.vector = vector.clone();
		}
		
		public boolean reachedEnd() {return reachedEnd;}
		public int getValue() {
			if (reachedEnd) return 0;
			return vector[this.index];
		}
		public void setIndex(int v) {
			if (v == vector.length) {
				reachedEnd = true;
				this.index = v;
				return;
			}
			this.index = v;
		}
		public int getIndex() {return this.index;}
	}
	
	public static int[] mix(int[] v1, int[] v2, SortMode sortMode) {
		
		int[] toReturn = new int[v1.length + v2.length];
		
		Queue q1 = new Queue(v1);
		Queue q2 = new Queue(v2);
		
		for (int i = 0; i < toReturn.length; i++) {
			Queue qAdd = (sortMode.evaluate(q1.getValue(), q2.getValue()) >= 0) ? q1 : q2;
			if (q1.reachedEnd) qAdd = q2;
			if (q2.reachedEnd) qAdd = q1;
			toReturn[i] = qAdd.getValue();
			qAdd.setIndex(qAdd.getIndex() + 1);
		}
		
		return toReturn;
	}
	
	public static void printVector(int[] vec) {
		for (int i : vec)
			System.out.print(i + " ");
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		int[] n1 = createVector(50);
		int[] n2 = createVector(50);
		
		sort(n1, (int a, int b) -> b - a);
		sort(n2, (int a, int b) -> b - a);
		
		int[] mix = mix(n1, n2, (int a, int b) -> b - a);
		
		printVector(mix);
	}
}