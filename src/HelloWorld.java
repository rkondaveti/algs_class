public class HelloWorld {
	public static void main(String[] args){
		System.out.println("Hello World");
		
		WeightedQuickUnionUF UF = new WeightedQuickUnionUF(10);
		System.out.println(UF.count());
	};
	
	
	
}