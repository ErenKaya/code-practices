package kim.eren.oca_8_certificate.oca_study_guide.chapter1;

/**
 * <b>Identifier</b>
 * <ul>
 * <li>1- You cannot use a number in variables first letter</li>
 * <li>2- You cannot use reserver keyword such as
 * public,static,abstract,this</li>
 * <li>3- @ and * are not digit,letter,_,$ so you cannot use one of them</li>
 * <li>4- You can't use $ symbol in class name because compiler uses this symbol
 * some files</li>
 * </ul>
 */
public class Identifier {

	// int 3ashdas; // Compiler Error (1)
	// int this; // Compiler Error (2)
	// int *free; // Compiler Error (3)
	// int @free; // Compiler Error (3)
	// class $Some{
	//
	// }
	static int i;

	public static void main(String[] args) {
		Identifier fi = new Identifier();
	}

}
